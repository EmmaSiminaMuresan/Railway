package GUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import DataObjects.DataLocalTime;
import Utilities.DataOverNetwork;

public class InputDepTime extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputDepTime frame = new InputDepTime();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputDepTime() {
        setTitle("Supervisor - Set Departure Time");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 150); // Adjusted the window size
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtDepTime = new JTextPane();
        txtDepTime.setText("Departure Time : HH:MM:SS");
        txtDepTime.setBounds(10, 10, 270, 20); // Adjusted bounds
        contentPane.add(txtDepTime);

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

                    // Create Departure Time Data
                    DataLocalTime depTime = new DataLocalTime();
                    depTime.SetValue(LocalTime.parse(txtDepTime.getText()));
                    depTime.SetName(getPlaceNameDepTime(port));

                    // Set depTime as the petriObject
                    DataToSend.petriObject = depTime;
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

            private String getPlaceNameDepTime(int port) {
                switch (port) {
                    case 1080:
                        return "Dep_Time_A";
                    case 1091:
                        return "Dep_Time_B";
                    case 1092:
                        return "Dep_Time_C";
                    default:
                        return "Unknown";
                }
            }
        });
        btnSend.setBounds(10, 70, 270, 30); // Adjusted bounds
        contentPane.add(btnSend);
    }
}
