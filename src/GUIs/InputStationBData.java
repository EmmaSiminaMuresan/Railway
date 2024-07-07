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

public class InputStationBData extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputStationBData frame = new InputStationBData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputStationBData() {
        setTitle("Station B Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("1080");
        txtPort.setBounds(10, 20, 285, 20);
        contentPane.add(txtPort);

        JTextPane txtB1Length = new JTextPane();
        txtB1Length.setText("B1_Length");
        txtB1Length.setBounds(10, 50, 285, 20);
        contentPane.add(txtB1Length);

        JTextPane txtB2Length = new JTextPane();
        txtB2Length.setText("B2_Length");
        txtB2Length.setBounds(10, 80, 285, 20);
        contentPane.add(txtB2Length);

        JTextPane txtB3Length = new JTextPane();
        txtB3Length.setText("B3_Length");
        txtB3Length.setBounds(10, 110, 285, 20);
        contentPane.add(txtB3Length);

        JTextPane txtB4Length = new JTextPane();
        txtB4Length.setText("B4_Length");
        txtB4Length.setBounds(10, 140, 285, 20);
        contentPane.add(txtB4Length);

        JTextPane txtSpeedOnPlatform = new JTextPane();
        txtSpeedOnPlatform.setText("Speed_On_Platform");
        txtSpeedOnPlatform.setBounds(10, 170, 285, 20);
        contentPane.add(txtSpeedOnPlatform);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s;
                try {
                    s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Send Lengths
                    DataInteger B1_Length = new DataInteger();
                    B1_Length.SetName("B1_Length");
                    B1_Length.SetValue(Integer.parseInt(txtB1Length.getText()));
                    DataToSend.petriObject = (PetriObject) B1_Length;
                    oos.writeObject(DataToSend);

                    DataInteger B2_Length = new DataInteger();
                    B2_Length.SetName("B2_Length");
                    B2_Length.SetValue(Integer.parseInt(txtB2Length.getText()));
                    DataToSend.petriObject = (PetriObject) B2_Length;
                    oos.writeObject(DataToSend);

                    DataInteger B3_Length = new DataInteger();
                    B3_Length.SetName("B3_Length");
                    B3_Length.SetValue(Integer.parseInt(txtB3Length.getText()));
                    DataToSend.petriObject = (PetriObject) B3_Length;
                    oos.writeObject(DataToSend);

                    DataInteger B4_Length = new DataInteger();
                    B4_Length.SetName("B4_Length");
                    B4_Length.SetValue(Integer.parseInt(txtB4Length.getText()));
                    DataToSend.petriObject = (PetriObject) B4_Length;
                    oos.writeObject(DataToSend);

                    // Send Speed on Platform
                    DataInteger speedOnPlatform = new DataInteger();
                    speedOnPlatform.SetName("Speed_On_Platform");
                    speedOnPlatform.SetValue(Integer.parseInt(txtSpeedOnPlatform.getText()));
                    DataToSend.petriObject = (PetriObject) speedOnPlatform;
                    oos.writeObject(DataToSend);

                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSend.setBounds(10, 200, 285, 44);
        contentPane.add(btnSend);
    }
}
