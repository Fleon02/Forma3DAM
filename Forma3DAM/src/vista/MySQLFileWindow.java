package vista;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import javax.swing.TransferHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import javax.swing.TransferHandler.TransferSupport;

public class MySQLFileWindow extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> fileList;
    private JButton uploadButton;
    private JButton downloadButton;

    // Datos de conexión a la base de datos MySQL
    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/practicas";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWORD = "";

    public MySQLFileWindow() {
        super("MySQL File Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        listModel = new DefaultListModel<>();
        fileList = new JList<>(listModel);
        fileList.setDragEnabled(true); // Permitir que el JList acepte arrastrar y soltar
        fileList.setTransferHandler(new FileTransferHandler(this));
        JScrollPane scrollPane = new JScrollPane(fileList);

        uploadButton = new JButton("Subir Archivo");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(MySQLFileWindow.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    uploadFile(selectedFile);
                }
            }
        });

        downloadButton = new JButton("Descargar Archivo");
        downloadButton.setEnabled(false);
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedFile = fileList.getSelectedValue();
                if (selectedFile != null) {
                    downloadFile(selectedFile);
                }
            }
        });

        // Agregar ListSelectionListener para habilitar el botón de descarga cuando se selecciona un archivo
        fileList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!fileList.isSelectionEmpty()) {
                    downloadButton.setEnabled(true);
                } else {
                    downloadButton.setEnabled(false);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(uploadButton);
        buttonPanel.add(downloadButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Actualizar la lista de archivos al iniciar la aplicación
        updateFileList();
    }

    // Método para subir archivo a la base de datos MySQL
    private void uploadFile(File file) {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String sql = "INSERT INTO prueba (nombreArchivo, archivo) VALUES (?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, file.getName());
                FileInputStream fis = new FileInputStream(file);
                pstmt.setBinaryStream(2, fis, (int) file.length());
                pstmt.executeUpdate();
                updateFileList();
            }
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al subir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para descargar archivo desde la base de datos MySQL
    private void downloadFile(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(filename)); // Establecer el nombre de archivo predeterminado
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
                String sql = "SELECT archivo FROM prueba WHERE nombreArchivo = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, filename);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            Blob blob = rs.getBlob("archivo");
                            byte[] data = blob.getBytes(1, (int) blob.length());
                            Files.write(selectedFile.toPath(), data);
                            JOptionPane.showMessageDialog(this, "Archivo descargado exitosamente.");
                        }
                    }
                }
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al descargar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para actualizar la lista de archivos desde la base de datos MySQL
    private void updateFileList() {
        try (Connection conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD)) {
            String sql = "SELECT nombreArchivo FROM prueba";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    listModel.clear();
                    while (rs.next()) {
                        listModel.addElement(rs.getString("nombreArchivo"));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al obtener la lista de archivos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase para manejar el arrastre y soltar de archivos al JList
    private class FileTransferHandler extends TransferHandler {

        private MySQLFileWindow parentWindow;

        public FileTransferHandler(MySQLFileWindow parentWindow) {
            this.parentWindow = parentWindow;
        }

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();
            try {
                List<File> fileList = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                for (File file : fileList) {
                    parentWindow.uploadFile(file);
                }
                return true;
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySQLFileWindow window = new MySQLFileWindow();
            window.setVisible(true);
        });
    }
}
