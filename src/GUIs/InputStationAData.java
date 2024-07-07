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
        setBounds(100, 100, 350, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("1080");
        txtPort.setBounds(10, 20, 285, 20);
        contentPane.add(txtPort);

        JTextPane txtA1Length = new JTextPane();
        txtA1Length.setText("A1_Length");
        txtA1Length.setBounds(10, 50, 285, 20);
        contentPane.add(txtA1Length);

        JTextPane txtA2Length = new JTextPane();
        txtA2Length.setText("A2_Length");
        txtA2Length.setBounds(10, 80, 285, 20);
        contentPane.add(txtA2Length);

        JTextPane txtA3Length = new JTextPane();
        txtA3Length.setText("A3_Length");
        txtA3Length.setBounds(10, 110, 285, 20);
        contentPane.add(txtA3Length);

        JTextPane txtA4Length = new JTextPane();
        txtA4Length.setText("A4_Length");
        txtA4Length.setBounds(10, 140, 285, 20);
        contentPane.add(txtA4Length);

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
                    DataInteger A1_Length = new DataInteger();
                    A1_Length.SetName("A1_Length");
                    A1_Length.SetValue(Integer.parseInt(txtA1Length.getText()));
                    DataToSend.petriObject = (PetriObject) A1_Length;
                    oos.writeObject(DataToSend);

                    DataInteger A2_Length = new DataInteger();
                    A2_Length.SetName("A2_Length");
                    A2_Length.SetValue(Integer.parseInt(txtA2Length.getText()));
                    DataToSend.petriObject = (PetriObject) A2_Length;
                    oos.writeObject(DataToSend);

                    DataInteger A3_Length = new DataInteger();
                    A3_Length.SetName("A3_Length");
                    A3_Length.SetValue(Integer.parseInt(txtA3Length.getText()));
                    DataToSend.petriObject = (PetriObject) A3_Length;
                    oos.writeObject(DataToSend);

                    DataInteger A4_Length = new DataInteger();
                    A4_Length.SetName("A4_Length");
                    A4_Length.SetValue(Integer.parseInt(txtA4Length.getText()));
                    DataToSend.petriObject = (PetriObject) A4_Length;
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
