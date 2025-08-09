import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel implements ActionListener, KeyListener {

    private int birdY = 250; // Bird's Y position
    private int birdVelocity = 0; // Bird's velocity
    private final int GRAVITY = 1; // Gravity applied to the bird
    private final int FLAP_STRENGTH = -15; // Flap strength when key is pressed
    private boolean isFlapping = false; // Flag to check if the bird is flapping
    private Timer timer;
    private int score = 0; // Player score

    public Main() {
        setPreferredSize(new Dimension(400, 600));
        setBackground(Color.cyan);
        addKeyListener(this);
        setFocusable(true);

        timer = new Timer(20, this); // Timer to refresh the screen every 20ms
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw bird
        g.setColor(Color.red);
        g.fillRect(50, birdY, 20, 20); // Draw the bird as a rectangle

        // Draw ground
        g.setColor(Color.green);
        g.fillRect(0, getHeight() - 50, getWidth(), 50);

        // Draw score
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Score: " + score, 20, 30);

        // Check for game over
        if (birdY >= getHeight() - 50 || birdY < 0) {
            gameOver(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update bird position
        if (isFlapping) {
            birdVelocity = FLAP_STRENGTH; // Apply flap
            isFlapping = false;
        } else {
            birdVelocity += GRAVITY; // Apply gravity
        }

        birdY += birdVelocity;

        // Increase score over time (simulating distance traveled)
        score++;

        // Repaint the screen
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            isFlapping = true; // Bird flaps when the space key is pressed
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this simple game
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this simple game
    }

    private void gameOver(Graphics g) {
        // Display Game Over message
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Game Over", 100, 250);
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        g.drawString("Press R to Restart", 120, 300);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bird Fly Game");
        Main gamePanel = new Main();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);
        frame.pack();
        frame.setVisible(true);

        // Listen for key events to restart the game
        gamePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    gamePanel.resetGame(); // Restart the game when 'R' is pressed
                }
            }
        });
    }

    // Reset the game after game over
    private void resetGame() {
        birdY = 250;
        birdVelocity = 0;
        score = 0;
        repaint();
    }
}
