import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JPanel labelPanel;
    private JPanel textPanel;
    private JPanel filePathPanel;
    private JPanel sendPanel;
    private JTextField tIP;
    private JTextField tPort;
    private JTextField tFilePath;
    private JButton bFilePath;
    private JButton bSend;
    private JLabel lIP;
    private JLabel lPort;


    public MainGUI(String title) throws HeadlessException {
        super(title);
        this.setLayout(new GridLayout(4,1,20,20));
        labelPanel = new JPanel(new GridLayout(1,2,20,20));
        textPanel = new JPanel(new GridLayout(1,2,20,20));
        filePathPanel = new JPanel(new GridLayout(1,2,20,20));
        sendPanel = new JPanel(new GridLayout(1,1,20,20));
        tIP = new JTextField();
        tPort = new JTextField();
        tFilePath = new JTextField();
        tFilePath.setEnabled(false);
        bFilePath = new JButton("Select File");
        bFilePath.setFont(new Font(bFilePath.getFont().getFontName(),Font.PLAIN,22));
        bSend = new JButton("Send");
        bSend.setFont(new Font(bSend.getFont().getFontName(),Font.PLAIN,22));
        lIP = new JLabel("IP Address");
        lIP.setVerticalAlignment(SwingConstants.BOTTOM);
        lIP.setHorizontalAlignment(SwingConstants.CENTER);
        lIP.setFont(new Font(lIP.getFont().getFontName(),Font.PLAIN,30));
        lPort = new JLabel("Port Number");
        lPort.setVerticalAlignment(SwingConstants.BOTTOM);
        lPort.setHorizontalAlignment(SwingConstants.CENTER);
        lPort.setFont(new Font(lPort.getFont().getFontName(),Font.PLAIN,30));
        labelPanel.add(lIP);
        labelPanel.add(lPort);
        textPanel.add(tIP);
        textPanel.add(tPort);
        filePathPanel.add(tFilePath);
        filePathPanel.add(bFilePath);
        sendPanel.add(bSend);
        this.getContentPane().add(labelPanel);
        this.getContentPane().add(textPanel);
        this.getContentPane().add(filePathPanel);
        this.getContentPane().add(sendPanel);
    }

    public void addController(ActionListener ctr){
        bSend.addActionListener(ctr);
        bSend.setActionCommand("Send");
        bFilePath.addActionListener(ctr);
        bFilePath.setActionCommand("Open File");
    }

    public JTextField gettIP() {
        return tIP;
    }

    public JTextField gettPort() {
        return tPort;
    }

    public JTextField gettFilePath() {
        return tFilePath;
    }
}
