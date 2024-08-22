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

public class InputPlatformSpeed extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane txtSpeed;
    private JTextPane txtStation;
    private boolean isFirstSend = true;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputPlatformSpeed frame = new InputPlatformSpeed();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputPlatformSpeed() {
        setTitle("Platform Speed Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 310, 150);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtSpeed = new JTextPane();
        txtSpeed.setText("Enter Speed");
        txtSpeed.setBounds(10, 10, 270, 20);
        contentPane.add(txtSpeed);

        txtStation = new JTextPane();
        txtStation.setText("Station: A / B / C");
        txtStation.setBounds(10, 40, 270, 20);
        contentPane.add(txtStation);

        JButton btnSend = new JButton("Send (Press twice)");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String speedText = txtSpeed.getText();
                    String station = txtStation.getText().trim().toUpperCase();

                    if (isValidStation(station)) {
                        DataInteger speedData = new DataInteger();
                        speedData.SetName("Speed_On_Platform");
                        speedData.SetValue(Integer.parseInt(speedText));

                        if (isFirstSend) {
                            sendDataToSupervisor(station, speedData);
                            isFirstSend = false;
                            System.out.println("Data sent to Supervisor. Press Send again to send to Station.");
                        } else {
                            sendDataToStation(station, speedData);
                            isFirstSend = true;
                            System.out.println("Data sent to Station. You can enter new data now.");
                            resetFields();
                        }
                    } else {
                        System.err.println("Invalid station input!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private boolean isValidStation(String station) {
                return station.equals("A") || station.equals("B") || station.equals("C");
            }

            private void sendDataToSupervisor(String station, DataInteger speedData) throws IOException {
                int port = getSupervisorPort(station);
                sendSpeedData(port, speedData);
            }

            private void sendDataToStation(String station, DataInteger speedData) throws IOException {
                int port = getStationPort(station);
                sendSpeedData(port, speedData);
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

            private void sendSpeedData(int port, DataInteger speedData) throws IOException {
                Socket s = new Socket(InetAddress.getByName("localhost"), port);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                DataOverNetwork DataToSend = new DataOverNetwork();
                DataToSend.petriObject = (PetriObject) speedData;

                oos.writeObject(DataToSend);
                oos.close();
                s.close();
            }

            private void resetFields() {
                txtSpeed.setText("Enter Speed");
                txtStation.setText("Station: A / B / C");
            }
        });
        btnSend.setBounds(10, 70, 270, 30);
        contentPane.add(btnSend);
    }
}
