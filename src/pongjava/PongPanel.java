package pongjava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener, KeyListener {
    
    // Varaibles for the game, ball, and players
    private Pong game;
    private Ball ball;
    private Racket player1, player2;
    private int score1, score2;

    /**
     * Constructor for the Panel
     * @param game 
     */
    public PongPanel(Pong game) {
        setBackground(Color.BLACK);
        this.game = game;
        ball = new Ball(game);
        player1 = new Racket(game, KeyEvent.VK_UP, KeyEvent.VK_DOWN, game.getWidth() - 36);
        player2 = new Racket(game, KeyEvent.VK_W, KeyEvent.VK_S, 20);
        Timer timer = new Timer(5, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    /**
     * Gets the specific player
     * @param playerNo
     * @return 
     */
    public Racket getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }

    /**
     * Increases the Score
     * @param playerNo 
     */
    public void increaseScore(int playerNo) {
        if (playerNo == 1)
            score1++;
        else
            score2++;
    }
    
    /**
     * Resets the Score to Zero
     */
    public void resetScore(){
        score1 = 0;
        score2 = 0;
    }

    /**
     * Get Score for the specific player number
     * @param playerNo
     * @return 
     */
    public int getScore(int playerNo) {
        if (playerNo == 1)
            return score1;
        else
            return score2;
    }

    /**
     * Update for the ball, player1, player2
     */
    private void update() {
        ball.update();
        player1.update();
        player2.update();
    }

    
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    /**
     * KeyPressed
     * @param e 
     */
    public void keyPressed(KeyEvent e) {
        player1.pressed(e.getKeyCode());
        player2.pressed(e.getKeyCode());
    }

    /**
     * KeyReleased
     * @param e 
     */
    public void keyReleased(KeyEvent e) {
        player1.released(e.getKeyCode());
        player2.released(e.getKeyCode());
    }

    /**
     * Paint Component, for the ball, and both players
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(game.getPanel().getScore(1) + " : " + game.getPanel().getScore(2), game.getWidth() / 2, 10);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }
    
    public void keyTyped(KeyEvent e) {
    }
}