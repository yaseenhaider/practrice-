import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class App extends JPanel implements ActionListener, KeyListener {

    private int bikeX, bikeY;
    private final int bikeWidth = 40, bikeHeight = 60;
    private final int obstacleWidth = 50, obstacleHeight = 50;
    private int obstacleX, obstacleY;
    private int score = 0;
    private boolean gameOver = false;

    // Timer for game loop
    private Timer gameTimer;

    public App() {
        // Initial positions
        bikeX = 100;
        bikeY = 300;

        obstacleX = 300;
        obstacleY = 100;

        // Set up the game panel
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
        addKeyListener(this);
        setFocusable(true);

        // Start the game loop
        gameTimer = new Timer(20, this); // 50 FPS
        gameTimer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over!", 250, 250);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("Score: " + score, 330, 300);
            return;
        }

        // Draw the bike (a simple rectangle for now)
        g.setColor(Color.BLUE);
        g.fillRect(bikeX, bikeY, bikeWidth, bikeHeight);

        // Draw the obstacle
        g.setColor(Color.RED);
        g.fillRect(obstacleX, obstacleY, obstacleWidth, obstacleHeight);

        // Draw the score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Score: " + score, 20, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        // Move the obstacle down
        obstacleY += 5;
        if (obstacleY > getHeight()) {
            obstacleY = -obstacleHeight;
            obstacleX = (int) (Math.random() * (getWidth() - obstacleWidth)); // Random new position
            score++;
        }

        // Check for collision
        Rectangle bikeRect = new Rectangle(bikeX, bikeY, bikeWidth, bikeHeight);
        Rectangle obstacleRect = new Rectangle(obstacleX, obstacleY, obstacleWidth, obstacleHeight);

        if (bikeRect.intersects(obstacleRect)) {
            gameOver = true;
        }

        // Repaint the panel to update the game state
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) return;

        // Control the bike using arrow keys
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            bikeY -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            bikeY += 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            bikeX -= 10;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            bikeX += 10;
        }

        // Prevent the bike from going out of bounds
        bikeX = Math.max(0, Math.min(getWidth() - bikeWidth, bikeX));
        bikeY = Math.max(0, Math.min(getHeight() - bikeHeight, bikeY));
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        // Create the game window and add the game panel
        JFrame frame = new JFrame("Bike Racing Game");
        App gamePanel = new App();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
