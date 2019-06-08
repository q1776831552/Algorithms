package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
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
                textArea.append("小明" + ":  " + info + "\r\n");
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
            ServerSocket ss = new ServerSocket(3000);
            s = ss.accept();
            InputStreamReader reader = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(reader);
            pw = new PrintWriter(s.getOutputStream(), true);

            while (true) {
                String info = br.readLine();
                textArea.append("小王" + ":  " + info + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().init();
    }
}
