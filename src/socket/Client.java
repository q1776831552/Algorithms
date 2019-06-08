package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    JFrame f = new JFrame("聊天程序");
    private JTextArea textArea;
    private TextField textField;
    private JButton sendButton;
    private PrintWriter pw;
    private Socket s;

    public void init() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setBounds(600, 300, 700, 500);
        textArea = new JTextArea();
        textField = new TextField();
        textArea.setEditable(false);
        f.add(new JScrollPane(textArea));
        JToolBar toolBar = new JToolBar();
        f.add(toolBar, "South");
        toolBar.add(textField);
        sendButton = new JButton("发送");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = textField.getText();
                textArea.append("小王" + ":  " + info + "\r\n");
                textField.setText("");
                pw.println(info);
            }
        });
        toolBar.add(sendButton);
        f.setVisible(true);
        socket();

    }

    private void socket() {
        try {
            s = new Socket("122.204.142.120", 3000);
            InputStreamReader reader = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            pw = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                String info = br.readLine();
                System.out.println(info);
                textArea.append("小明" + ":  " + info + "\r\n");
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().init();
    }

}
