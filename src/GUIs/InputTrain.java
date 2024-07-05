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
import DataObjects.DataString;
import DataObjects.DataInteger;
import DataOnly.TrainDetails;
import Interfaces.PetriObject;
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtNumber = new JTextPane();
        txtNumber.setText("number");
        txtNumber.setToolTipText("");
        txtNumber.setBounds(10, 20, 285, 20);
        contentPane.add(txtNumber);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("1080");
        txtPort.setBounds(10, 50, 285, 20);
        contentPane.add(txtPort);

        JTextPane txtLength = new JTextPane();
        txtLength.setText("length");
        txtLength.setBounds(10, 80, 285, 20);
        contentPane.add(txtLength);

        JTextPane txtTargets = new JTextPane();
        txtTargets.setToolTipText("");
        txtTargets.setText("targets");
        txtTargets.setBounds(10, 110, 285, 20);
        contentPane.add(txtTargets);

        JTextPane txtPlace = new JTextPane();
        txtPlace.setText("P");
        txtPlace.setBounds(10, 140, 285, 20);
        contentPane.add(txtPlace);

        JTextPane txtDepartureTime = new JTextPane();
        txtDepartureTime.setText("departure time");
        txtDepartureTime.setBounds(10, 170, 285, 20);
        contentPane.add(txtDepartureTime);

        JTextPane txtPlatform = new JTextPane();
        txtPlatform.setText("platform");
        txtPlatform.setBounds(10, 200, 285, 20);
        contentPane.add(txtPlatform);

        JTextPane txtA1Length = new JTextPane();
        txtA1Length.setText("A1_Length");
        txtA1Length.setBounds(10, 230, 285, 20);
        contentPane.add(txtA1Length);

        JTextPane txtA2Length = new JTextPane();
        txtA2Length.setText("A2_Length");
        txtA2Length.setBounds(10, 260, 285, 20);
        contentPane.add(txtA2Length);

        JTextPane txtA3Length = new JTextPane();
        txtA3Length.setText("A3_Length");
        txtA3Length.setBounds(10, 290, 285, 20);
        contentPane.add(txtA3Length);

        JTextPane txtA4Length = new JTextPane();
        txtA4Length.setText("A4_Length");
        txtA4Length.setBounds(10, 320, 285, 20);
        contentPane.add(txtA4Length);

        JTextPane txtSpeedOnPlatform = new JTextPane();
        txtSpeedOnPlatform.setText("Speed_On_Platform");
        txtSpeedOnPlatform.setBounds(10, 350, 285, 20);
        contentPane.add(txtSpeedOnPlatform);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s;
                try {
                    s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    DataTrain dataTrain = new DataTrain();
                    String[] targetsArray = txtTargets.getText().split(",");
                    Train t = new Train(Integer.parseInt(txtLength.getText()), txtNumber.getText(), targetsArray);
                    dataTrain.SetValue(t);
                    dataTrain.SetName(txtPlace.getText());

                    DataString departureTime = new DataString();
                    departureTime.SetName("Departure_Time");
                    departureTime.SetValue(txtDepartureTime.getText());

                    DataString platform = new DataString();
                    platform.SetName("Platform");
                    platform.SetValue(txtPlatform.getText());

                    DataInteger A1_Length = new DataInteger();
                    A1_Length.SetName("A1_Length");
                    A1_Length.SetValue(Integer.parseInt(txtA1Length.getText()));

                    DataInteger A2_Length = new DataInteger();
                    A2_Length.SetName("A2_Length");
                    A2_Length.SetValue(Integer.parseInt(txtA2Length.getText()));

                    DataInteger A3_Length = new DataInteger();
                    A3_Length.SetName("A3_Length");
                    A3_Length.SetValue(Integer.parseInt(txtA3Length.getText()));

                    DataInteger A4_Length = new DataInteger();
                    A4_Length.SetName("A4_Length");
                    A4_Length.SetValue(Integer.parseInt(txtA4Length.getText()));

                    DataInteger speedOnPlatform = new DataInteger();
                    speedOnPlatform.SetName("Speed_On_Platform");
                    speedOnPlatform.SetValue(Integer.parseInt(txtSpeedOnPlatform.getText()));

                    TrainDetails trainDetails = new TrainDetails(dataTrain, departureTime, platform,
                            A1_Length, A2_Length, A3_Length, A4_Length, speedOnPlatform);

                    DataToSend.petriObject = (PetriObject) trainDetails;
                    DataToSend.NetWorkPort = Integer.parseInt(txtPort.getText());

                    oos.writeObject(DataToSend);
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSend.setBounds(10, 380, 285, 44);
        contentPane.add(btnSend);
    }
}
