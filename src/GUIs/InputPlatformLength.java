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

import DataObjects.DataInteger;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;

public class InputPlatformLength extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane txtLength;
    private JTextPane txtStation;
    private JTextPane txtPlatform;
    private boolean isFirstSend = true;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputPlatformLength frame = new InputPlatformLength();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputPlatformLength() {
        setTitle("Platform Length Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 190);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtLength = new JTextPane();
        txtLength.setText("Enter Length");
        txtLength.setBounds(10, 10, 270, 20);
        contentPane.add(txtLength);

        txtStation = new JTextPane();
        txtStation.setText("Station: A / B / C");
        txtStation.setBounds(10, 40, 270, 20);
        contentPane.add(txtStation);

        txtPlatform = new JTextPane();
        txtPlatform.setText("Platform: 1 / 2 / 3 / 4");
        txtPlatform.setBounds(10, 70, 270, 20);
        contentPane.add(txtPlatform);

        JButton btnSend = new JButton("Send (Press twice)");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String length = txtLength.getText();
                    String station = txtStation.getText().trim().toUpperCase();
                    String platform = txtPlatform.getText().trim();

                    if (isValidStation(station) && isValidPlatform(platform)) {
                        if (isFirstSend) {
                            sendDataToSupervisor(station, platform, length);
                            isFirstSend = false;
                            System.out.println("Data sent to Supervisor. Press Send again to send to Station.");
                        } else {
                            sendDataToStation(station, platform, length);
                            isFirstSend = true;
                            System.out.println("Data sent to Station. You can enter new data now.");
                            resetFields();
                        }
                    } else {
                        System.err.println("Invalid station or platform input!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private boolean isValidStation(String station) {
                return station.equals("A") || station.equals("B") || station.equals("C");
            }

            private boolean isValidPlatform(String platform) {
                return platform.equals("1") || platform.equals("2") || platform.equals("3") || platform.equals("4");
            }

            private void sendDataToSupervisor(String station, String platform, String length) throws IOException {
                int port = getSupervisorPort(station);
                switch (platform) {
                    case "1":
                        sendLengthData(port, length, station + "1_Length");
                        break;
                    case "2":
                        sendLengthData(port, length, station + "2_Length");
                        break;
                    case "3":
                        sendLengthData(port, length, station + "3_Length");
                        break;
                    case "4":
                        sendLengthData(port, length, station + "4_Length");
                        break;
                    default:
                        System.err.println("Invalid platform input!");
                }
            }

            private void sendDataToStation(String station, String platform, String length) throws IOException {
                int port = getStationPort(station);
                switch (platform) {
                    case "1":
                        sendLengthData(port, length, station + "1_Length");
                        break;
                    case "2":
                        sendLengthData(port, length, station + "2_Length");
                        break;
                    case "3":
                        sendLengthData(port, length, station + "3_Length");
                        break;
                    case "4":
                        sendLengthData(port, length, station + "4_Length");
                        break;
                    default:
                        System.err.println("Invalid platform input!");
                }
            }

            private int getSupervisorPort(String station) {
                switch (station) {
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

            private int getStationPort(String station) {
                switch (station) {
                    case "A":
                        return 1081;
                    case "B":
                        return 1089;
                    case "C":
                        return 1090;
                    default:
                        return -1;
                }
            }

            private void sendLengthData(int port, String length, String dataName) throws IOException {
                Socket s = new Socket(InetAddress.getByName("localhost"), port);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                DataOverNetwork DataToSend = new DataOverNetwork();

                DataInteger lengthData = new DataInteger();
                lengthData.SetName(dataName);
                lengthData.SetValue(Integer.parseInt(length));
                DataToSend.petriObject = (PetriObject) lengthData;

                oos.writeObject(DataToSend);
                oos.close();
                s.close();
            }

            private void resetFields() {
                txtLength.setText("Enter Length");
                txtStation.setText("Station: A / B / C");
                txtPlatform.setText("Platform: 1 / 2 / 3 / 4");
            }
        });
        btnSend.setBounds(10, 100, 270, 30);
        contentPane.add(btnSend);
    }
}
