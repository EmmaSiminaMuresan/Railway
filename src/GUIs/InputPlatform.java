package GUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import DataObjects.DataString;
import Utilities.DataOverNetwork;

public class InputPlatform extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputPlatform frame = new InputPlatform();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputPlatform() {
        setTitle("Supervisor - Set Platform");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 150); // Adjusted the window size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPlatform = new JTextPane();
        txtPlatform.setText("Platform Name");
        txtPlatform.setBounds(10, 10, 270, 20); // Adjusted bounds
        contentPane.add(txtPlatform);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("Station: A / B / C");
        txtPort.setBounds(10, 40, 270, 20); // Adjusted bounds
        contentPane.add(txtPort);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s = null;
                ObjectOutputStream oos = null;
                try {
                    int port = getPort(txtPort.getText());
                    if (port == -1) {
                        System.err.println("Invalid port input!");
                        return;
                    }

                    s = new Socket(InetAddress.getByName("localhost"), port);
                    oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Create Platform Data
                    DataString platform = new DataString();
                    platform.SetValue(txtPlatform.getText());
                    platform.SetName(getPlaceNamePlatform(port));

                    // Set platform as the petriObject
                    DataToSend.petriObject = platform;
                    DataToSend.NetWorkPort = port;

                    // Send DataToSend object
                    oos.writeObject(DataToSend);
                    oos.flush(); // Ensure data is sent immediately

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (oos != null) {
                        try {
                            oos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (s != null) {
                        try {
                            s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            private int getPort(String portText) {
                switch (portText.trim().toUpperCase()) {
                    case "A":
                        return 1080;
                    case "B":
                        return 1091;
                    case "C":
                        return 1092;
                    default:
                        return -1;
                }
            }

            private String getPlaceNamePlatform(int port) {
                switch (port) {
                    case 1080:
                        return "Platform_A";
                    case 1091:
                        return "Platform_B";
                    case 1092:
                        return "Platform_C";
                    default:
                        return "Unknown";
                }
            }
        });
        btnSend.setBounds(10, 70, 270, 30); // Adjusted bounds
        contentPane.add(btnSend);
    }
}
