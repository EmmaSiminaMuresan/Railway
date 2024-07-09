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

public class InputSensors extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputSensors frame = new InputSensors();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputSensors() {
        setTitle("Input Train Speeds");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("1083");
        txtPort.setBounds(10, 10, 285, 20);
        contentPane.add(txtPort);

        JTextPane txtIn7 = new JTextPane();
        txtIn7.setText("Speed in section 7");
        txtIn7.setBounds(10, 50, 285, 20);
        contentPane.add(txtIn7);

        JTextPane txtIn8 = new JTextPane();
        txtIn8.setText("Speed in section 8");
        txtIn8.setBounds(10, 90, 285, 20);
        contentPane.add(txtIn8);

        JTextPane txtIn9 = new JTextPane();
        txtIn9.setText("Speed in section 9");
        txtIn9.setBounds(10, 130, 285, 20);
        contentPane.add(txtIn9);

        JTextPane txtIn10 = new JTextPane();
        txtIn10.setText("Speed in section 10");
        txtIn10.setBounds(10, 170, 285, 20);
        contentPane.add(txtIn10);

        JTextPane txtIn11 = new JTextPane();
        txtIn11.setText("Speed in section 11");
        txtIn11.setBounds(10, 210, 285, 20);
        contentPane.add(txtIn11);

        JTextPane txtIn12 = new JTextPane();
        txtIn12.setText("Speed in section 12");
        txtIn12.setBounds(10, 250, 285, 20);
        contentPane.add(txtIn12);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s;
                try {
                    s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Send Speed Data for each section
                    sendSpeedData(oos, DataToSend, "in7", txtIn7.getText(), txtPort.getText());
                    sendSpeedData(oos, DataToSend, "in8", txtIn8.getText(), txtPort.getText());
                    sendSpeedData(oos, DataToSend, "in9", txtIn9.getText(), txtPort.getText());
                    sendSpeedData(oos, DataToSend, "in10", txtIn10.getText(), txtPort.getText());
                    sendSpeedData(oos, DataToSend, "in11", txtIn11.getText(), txtPort.getText());
                    sendSpeedData(oos, DataToSend, "in12", txtIn12.getText(), txtPort.getText());

                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSend.setBounds(10, 300, 285, 44);
        contentPane.add(btnSend);
    }

    private void sendSpeedData(ObjectOutputStream oos, DataOverNetwork DataToSend, String name, String value, String port) throws IOException {
        DataInteger speed = new DataInteger();
        speed.SetName(name);
        speed.SetValue(Integer.parseInt(value));
        DataToSend.petriObject = (PetriObject) speed;
        DataToSend.NetWorkPort = Integer.parseInt(port);
        oos.writeObject(DataToSend);
    }
}
