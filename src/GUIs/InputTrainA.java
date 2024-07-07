package GUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import DataObjects.DataLocalTime;
import DataObjects.DataTrain;
import DataOnly.Train;
import DataObjects.DataString;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;

public class InputTrainA extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputTrainA frame = new InputTrainA();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputTrainA() {
        setTitle("Supervisor A - Create Train");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 300);
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

        JTextPane txtDepartureTime = new JTextPane();
        txtDepartureTime.setText("departure time");
        txtDepartureTime.setBounds(10, 140, 285, 20);
        contentPane.add(txtDepartureTime);

        JTextPane txtPlatform = new JTextPane();
        txtPlatform.setText("platform");
        txtPlatform.setBounds(10, 170, 285, 20);
        contentPane.add(txtPlatform);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s;
                try {
                    s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Send Train Data
                    DataTrain dataTrain = new DataTrain();
                    String[] targetsArray = txtTargets.getText().split(",");
                    Train t = new Train(Integer.parseInt(txtLength.getText()), txtNumber.getText(), targetsArray);
                    dataTrain.SetValue(t);
                    dataTrain.SetName("Train_A");
                    DataToSend.petriObject = (PetriObject) dataTrain;
                    DataToSend.NetWorkPort = Integer.parseInt(txtPort.getText());
                    oos.writeObject(DataToSend);

                    // Send Departure Time
                    DataLocalTime departureTime = new DataLocalTime();
                    departureTime.SetName("Dep_Time_A");
                    try {
                        LocalTime time = LocalTime.parse(txtDepartureTime.getText(), DateTimeFormatter.ofPattern("[HH:mm][HH:mm:ss]"));
                        departureTime.SetValue(time);
                    } catch (DateTimeParseException e) {
                        e.printStackTrace();
                    }
                    DataToSend.petriObject = (PetriObject) departureTime;
                    oos.writeObject(DataToSend);

                    // Send Platform
                    DataString platform = new DataString();
                    platform.SetName("Platform_A");
                    platform.SetValue(txtPlatform.getText());
                    DataToSend.petriObject = (PetriObject) platform;
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
