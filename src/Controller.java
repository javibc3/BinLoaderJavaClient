import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller implements ActionListener {

    private MainGUI gui;

    public Controller(MainGUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch (actionEvent.getActionCommand()){
            case "Send": sendFile();break;
            case "Open File": getFilePath();break;
        }
    }

    private void getFilePath() {
        JFileChooser selectFile = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("BIN and ELF files","bin","elf");
        selectFile.setFileFilter(fileFilter);
        int returnValue = selectFile.showOpenDialog(gui);
        if(returnValue == JFileChooser.APPROVE_OPTION){
            gui.gettFilePath().setText(selectFile.getSelectedFile().getPath());
        }
    }

    private void sendFile() {
        SwingWorker<Void,Void> worker = new SwingWorker<>(){
            @Override
            protected Void doInBackground() {
                try {
                    BinLoaderConnection.sendFile(gui.gettIP().getText(), gui.gettPort().getText(), gui.gettFilePath().getText());
                    JOptionPane.showMessageDialog(gui.getContentPane(),"File send correctly","Successful",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NullPointerException | NumberFormatException n){
                    JOptionPane.showMessageDialog(gui.getContentPane(),"Fill the IP Address and/o the port Number and/o choose a file to send","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException i){
                    JOptionPane.showMessageDialog(gui.getContentPane(),"Enter a valid port number between 0 and 65535","Error",JOptionPane.ERROR_MESSAGE);
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(gui.getContentPane(),"An error occurred while sending the file","Error",JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }
        };
        worker.execute();
    }
}
