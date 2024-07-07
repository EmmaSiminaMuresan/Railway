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

        JTextPane txtC1Length = new JTextPane();
        txtC1Length.setText("C1_Length");
        txtC1Length.setBounds(10, 50, 285, 20);
        contentPane.add(txtC1Length);

        JTextPane txtC2Length = new JTextPane();
        txtC2Length.setText("C2_Length");
        txtC2Length.setBounds(10, 80, 285, 20);
        contentPane.add(txtC2Length);

        JTextPane txtC3Length = new JTextPane();
        txtC3Length.setText("C3_Length");
        txtC3Length.setBounds(10, 110, 285, 20);
        contentPane.add(txtC3Length);

        JTextPane txtC4Length = new JTextPane();
        txtC4Length.setText("C4_Length");
        txtC4Length.setBounds(10, 140, 285, 20);
        contentPane.add(txtC4Length);

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
                    DataInteger C1_Length = new DataInteger();
                    C1_Length.SetName("C1_Length");
                    C1_Length.SetValue(Integer.parseInt(txtC1Length.getText()));
                    DataToSend.petriObject = (PetriObject) C1_Length;
                    oos.writeObject(DataToSend);

                    DataInteger C2_Length = new DataInteger();
                    C2_Length.SetName("C2_Length");
                    C2_Length.SetValue(Integer.parseInt(txtC2Length.getText()));
                    DataToSend.petriObject = (PetriObject) C2_Length;
                    oos.writeObject(DataToSend);

                    DataInteger C3_Length = new DataInteger();
                    C3_Length.SetName("C3_Length");
                    C3_Length.SetValue(Integer.parseInt(txtC3Length.getText()));
                    DataToSend.petriObject = (PetriObject) C3_Length;
                    oos.writeObject(DataToSend);

                    DataInteger C4_Length = new DataInteger();
                    C4_Length.SetName("C4_Length");
                    C4_Length.SetValue(Integer.parseInt(txtC4Length.getText()));
                    DataToSend.petriObject = (PetriObject) C4_Length;
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
