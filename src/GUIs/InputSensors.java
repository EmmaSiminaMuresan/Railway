package GUIs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DataObjects.DataInteger;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;

public class InputSensors extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextPane txtSpeed;
    private JTextPane txtPort;
    private int currentSection = 7;

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
        setBounds(100, 100, 350, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtPort = new JTextPane();
        txtPort.setText("1083");
        txtPort.setBounds(10, 10, 285, 20);
        contentPane.add(txtPort);

        txtSpeed = new JTextPane();
        txtSpeed.setText("Enter Speed for section " + currentSection);
        txtSpeed.setBounds(10, 50, 285, 20);
        contentPane.add(txtSpeed);

        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Socket s = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(txtPort.getText()));
                    ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                    DataOverNetwork DataToSend = new DataOverNetwork();

                    // Send Speed Data for current section
                    sendSpeedData(oos, DataToSend, "in" + currentSection, txtSpeed.getText(), txtPort.getText());

                    // Close the socket after sending data
                    oos.close();
                    s.close();

                    // Update for next section
                    currentSection++;
                    if (currentSection > 12) {
                        currentSection = 7;
                    }
                    txtSpeed.setText("Enter Speed for section " + currentSection);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSend.setBounds(10, 90, 285, 44);
        contentPane.add(btnSend);
    }

    private void sendSpeedData(ObjectOutputStream oos, DataOverNetwork DataToSend, String name, String value, String port) throws IOException {
        try {
            // Validate input as an integer
            int speedValue = Integer.parseInt(value);

            // Prepare and send the data
            DataInteger speed = new DataInteger();
            speed.SetName(name);
            speed.SetValue(speedValue);
            DataToSend.petriObject = (PetriObject) speed;
            DataToSend.NetWorkPort = Integer.parseInt(port);
            oos.writeObject(DataToSend);
        } catch (NumberFormatException e) {
            // Display an error message if input is not a valid integer
            JOptionPane.showMessageDialog(this, "Please enter a valid integer for speed.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            // Handle any IO errors
            JOptionPane.showMessageDialog(this, "Error sending data: " + e.getMessage(), "Communication Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


}
