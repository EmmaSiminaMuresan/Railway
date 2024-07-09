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

public class InputStationAData extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputStationAData frame = new InputStationAData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputStationAData() {
        setTitle("Station A Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort1 = new JTextPane();
        txtPort1.setText("1080");
        txtPort1.setBounds(10, 20, 285, 20);
        contentPane.add(txtPort1);

        JTextPane txtPort2 = new JTextPane();
        txtPort2.setText("1081");
        txtPort2.setBounds(10, 50, 285, 20);
        contentPane.add(txtPort2);

        JTextPane txtA1Length = new JTextPane();
        txtA1Length.setText("A1_Length");
        txtA1Length.setBounds(10, 80, 285, 20);
        contentPane.add(txtA1Length);

        JTextPane txtA2Length = new JTextPane();
        txtA2Length.setText("A2_Length");
        txtA2Length.setBounds(10, 110, 285, 20);
        contentPane.add(txtA2Length);

        JTextPane txtA3Length = new JTextPane();
        txtA3Length.setText("A3_Length");
        txtA3Length.setBounds(10, 140, 285, 20);
        contentPane.add(txtA3Length);

        JTextPane txtA4Length = new JTextPane();
        txtA4Length.setText("A4_Length");
        txtA4Length.setBounds(10, 170, 285, 20);
        contentPane.add(txtA4Length);

        JTextPane txtSpeedOnPlatform = new JTextPane();
        txtSpeedOnPlatform.setText("Speed_On_Platform");
        txtSpeedOnPlatform.setBounds(10, 200, 285, 20);
        contentPane.add(txtSpeedOnPlatform);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int port1 = Integer.parseInt(txtPort1.getText());
                    int port2 = Integer.parseInt(txtPort2.getText());
                    sendDataToPort(port1, txtA1Length.getText(), txtA2Length.getText(), txtA3Length.getText(), txtA4Length.getText(), txtSpeedOnPlatform.getText());
                    sendDataToPort(port2, txtA1Length.getText(), txtA2Length.getText(), txtA3Length.getText(), txtA4Length.getText(), txtSpeedOnPlatform.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void sendDataToPort(int port, String a1Length, String a2Length, String a3Length, String a4Length, String speedOnPlatform) throws IOException {
                Socket s = new Socket(InetAddress.getByName("localhost"), port);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                DataOverNetwork DataToSend = new DataOverNetwork();

                // Send Lengths
                DataInteger A1_Length = new DataInteger();
                A1_Length.SetName("A1_Length");
                A1_Length.SetValue(Integer.parseInt(a1Length));
                DataToSend.petriObject = (PetriObject) A1_Length;
                oos.writeObject(DataToSend);

                DataInteger A2_Length = new DataInteger();
                A2_Length.SetName("A2_Length");
                A2_Length.SetValue(Integer.parseInt(a2Length));
                DataToSend.petriObject = (PetriObject) A2_Length;
                oos.writeObject(DataToSend);

                DataInteger A3_Length = new DataInteger();
                A3_Length.SetName("A3_Length");
                A3_Length.SetValue(Integer.parseInt(a3Length));
                DataToSend.petriObject = (PetriObject) A3_Length;
                oos.writeObject(DataToSend);

                DataInteger A4_Length = new DataInteger();
                A4_Length.SetName("A4_Length");
                A4_Length.SetValue(Integer.parseInt(a4Length));
                DataToSend.petriObject = (PetriObject) A4_Length;
                oos.writeObject(DataToSend);

                // Send Speed on Platform
                DataInteger speed = new DataInteger();
                speed.SetName("Speed_On_Platform");
                speed.SetValue(Integer.parseInt(speedOnPlatform));
                DataToSend.petriObject = (PetriObject) speed;
                oos.writeObject(DataToSend);

                s.close();
            }
        });
        btnSend.setBounds(10, 230, 285, 44);
        contentPane.add(btnSend);
    }
}
