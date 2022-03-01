package Game.GameFirst;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;

@SuppressWarnings("serial")
public class Window extends JFrame {
    public Window(int width, int height, String title, GameInit game) {

        try {
            game.serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("¡El juego ya comenzó!");
            System.exit(0);
        }

        setTitle(title);
        pack();
        setSize (width + getInsets().left + getInsets().right, height + getInsets().top + getInsets().bottom);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        add(game);
        game.start();
    }
}
