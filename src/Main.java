import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainGUI gui = new MainGUI("BinLoader Client");
                Controller ctr = new Controller(gui);
                gui.addController(ctr);
                gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                gui.setMinimumSize(new Dimension(600,400));
                gui.setResizable(false);
                gui.setVisible(true);
                gui.pack();
            }
        });

    }
}
