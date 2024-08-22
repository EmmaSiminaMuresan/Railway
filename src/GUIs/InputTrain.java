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

import DataObjects.DataTrain;
import DataOnly.Train;
import Utilities.DataOverNetwork;

public class InputTrain extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputTrain frame = new InputTrain();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputTrain() {
        setTitle("Supervisor - Create Train");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 210);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtNumber = new JTextPane();
        txtNumber.setText("Train Number");
        txtNumber.setToolTipText("");
        txtNumber.setBounds(10, 10, 270, 20);
        contentPane.add(txtNumber);

        JTextPane txtLength = new JTextPane();
        txtLength.setText("Train Length");
        txtLength.setBounds(10, 40, 270, 20);
        contentPane.add(txtLength);

        JTextPane txtTargets = new JTextPane();
        txtTargets.setToolTipText("");
        txtTargets.setText("targets");
        txtTargets.setBounds(10, 70, 270, 20);
        contentPane.add(txtTargets);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("Station: A / B / C");
        txtPort.setBounds(10, 100, 270, 20);
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

                    // Create Train Data
                    DataTrain dataTrain = new DataTrain();
                    String[] targetsArray = txtTargets.getText().split(",");
                    Train t = new Train(Integer.parseInt(txtLength.getText()), txtNumber.getText(), targetsArray);
                    dataTrain.SetValue(t);
                    dataTrain.SetName(getPlaceNameTrain(port));

                    // Set dataTrain as the petriObject
                    DataToSend.petriObject = dataTrain;
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

            private String getPlaceNameTrain(int port) {
                switch (port) {
                    case 1080:
                        return "Train_A";
                    case 1091:
                        return "Train_B";
                    case 1092:
                        return "Train_C";
                    default:
                        return "Unknown";
                }
            }
        });
        btnSend.setBounds(10, 130, 270, 30);
        contentPane.add(btnSend);
    }
}
