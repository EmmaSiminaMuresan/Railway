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

public class InputStationCData extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputStationCData frame = new InputStationCData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputStationCData() {
        setTitle("Station C Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort1 = new JTextPane();
        txtPort1.setText("1090");
        txtPort1.setBounds(10, 20, 285, 20);
        contentPane.add(txtPort1);

        JTextPane txtPort2 = new JTextPane();
        txtPort2.setText("1092");
        txtPort2.setBounds(10, 50, 285, 20);
        contentPane.add(txtPort2);

        JTextPane txtC1Length = new JTextPane();
        txtC1Length.setText("C1_Length");
        txtC1Length.setBounds(10, 80, 285, 20);
        contentPane.add(txtC1Length);

        JTextPane txtC2Length = new JTextPane();
        txtC2Length.setText("C2_Length");
        txtC2Length.setBounds(10, 110, 285, 20);
        contentPane.add(txtC2Length);

        JTextPane txtC3Length = new JTextPane();
        txtC3Length.setText("C3_Length");
        txtC3Length.setBounds(10, 140, 285, 20);
        contentPane.add(txtC3Length);

        JTextPane txtC4Length = new JTextPane();
        txtC4Length.setText("C4_Length");
        txtC4Length.setBounds(10, 170, 285, 20);
        contentPane.add(txtC4Length);

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
                    sendDataToPort(port1, txtC1Length.getText(), txtC2Length.getText(), txtC3Length.getText(), txtC4Length.getText(), txtSpeedOnPlatform.getText());
                    sendDataToPort(port2, txtC1Length.getText(), txtC2Length.getText(), txtC3Length.getText(), txtC4Length.getText(), txtSpeedOnPlatform.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void sendDataToPort(int port, String c1Length, String c2Length, String c3Length, String c4Length, String speedOnPlatform) throws IOException {
                Socket s = new Socket(InetAddress.getByName("localhost"), port);
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                DataOverNetwork DataToSend = new DataOverNetwork();

                // Send Lengths
                DataInteger C1_Length = new DataInteger();
                C1_Length.SetName("C1_Length");
                C1_Length.SetValue(Integer.parseInt(c1Length));
                DataToSend.petriObject = (PetriObject) C1_Length;
                oos.writeObject(DataToSend);

                DataInteger C2_Length = new DataInteger();
                C2_Length.SetName("C2_Length");
                C2_Length.SetValue(Integer.parseInt(c2Length));
                DataToSend.petriObject = (PetriObject) C2_Length;
                oos.writeObject(DataToSend);

                DataInteger C3_Length = new DataInteger();
                C3_Length.SetName("C3_Length");
                C3_Length.SetValue(Integer.parseInt(c3Length));
                DataToSend.petriObject = (PetriObject) C3_Length;
                oos.writeObject(DataToSend);

                DataInteger C4_Length = new DataInteger();
                C4_Length.SetName("C4_Length");
                C4_Length.SetValue(Integer.parseInt(c4Length));
                DataToSend.petriObject = (PetriObject) C4_Length;
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
