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

public class InputRailwaySpeed extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InputRailwaySpeed frame = new InputRailwaySpeed();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InputRailwaySpeed() {
        setTitle("Railway Speed Input");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 320);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTextPane txtPort = new JTextPane();
        txtPort.setText("1083");
        txtPort.setBounds(10, 20, 285, 20);
        contentPane.add(txtPort);

        JTextPane txtIn7 = new JTextPane();
        txtIn7.setText("Speed on Segment 7");
        txtIn7.setBounds(10, 50, 285, 20);
        contentPane.add(txtIn7);

        JTextPane txtIn8 = new JTextPane();
        txtIn8.setText("Speed on Segment 8");
        txtIn8.setBounds(10, 80, 285, 20);
        contentPane.add(txtIn8);

        JTextPane txtIn9 = new JTextPane();
        txtIn9.setText("Speed on Segment 9");
        txtIn9.setBounds(10, 110, 285, 20);
        contentPane.add(txtIn9);

        JTextPane txtIn10 = new JTextPane();
        txtIn10.setText("Speed on Segment 10");
        txtIn10.setBounds(10, 140, 285, 20);
        contentPane.add(txtIn10);

        JTextPane txtIn11 = new JTextPane();
        txtIn11.setText("Speed on Segment 11");
        txtIn11.setBounds(10, 170, 285, 20);
        contentPane.add(txtIn11);

        JTextPane txtIn12 = new JTextPane();
        txtIn12.setText("Speed on Segment 12");
        txtIn12.setBounds(10, 200, 285, 20);
        contentPane.add(txtIn12);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Socket s;
                try {
                    s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Send in7
                    DataInteger in7 = new DataInteger();
                    in7.SetName("in7");
                    in7.SetValue(Integer.parseInt(txtIn7.getText()));
                    DataToSend.petriObject = (PetriObject) in7;
                    oos.writeObject(DataToSend);

                    // Send in8
                    DataInteger in8 = new DataInteger();
                    in8.SetName("in8");
                    in8.SetValue(Integer.parseInt(txtIn8.getText()));
                    DataToSend.petriObject = (PetriObject) in8;
                    oos.writeObject(DataToSend);

                    // Send in9
                    DataInteger in9 = new DataInteger();
                    in9.SetName("in9");
                    in9.SetValue(Integer.parseInt(txtIn9.getText()));
                    DataToSend.petriObject = (PetriObject) in9;
                    oos.writeObject(DataToSend);

                    // Send in10
                    DataInteger in10 = new DataInteger();
                    in10.SetName("in10");
                    in10.SetValue(Integer.parseInt(txtIn10.getText()));
                    DataToSend.petriObject = (PetriObject) in10;
                    oos.writeObject(DataToSend);

                    // Send in11
                    DataInteger in11 = new DataInteger();
                    in11.SetName("in11");
                    in11.SetValue(Integer.parseInt(txtIn11.getText()));
                    DataToSend.petriObject = (PetriObject) in11;
                    oos.writeObject(DataToSend);

                    // Send in12
                    DataInteger in12 = new DataInteger();
                    in12.SetName("in12");
                    in12.SetValue(Integer.parseInt(txtIn12.getText()));
                    DataToSend.petriObject = (PetriObject) in12;
                    oos.writeObject(DataToSend);

                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSend.setBounds(10, 230, 285, 44);
        contentPane.add(btnSend);
    }
}
