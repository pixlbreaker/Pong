package pongjava;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Racket {
    
    // Varaibles
    private static final int WIDTH = 10, HEIGHT = 60;
    private Pong game;
    private int up, down;
    private int x;
    private int y, ya;

    /**
     * Constructor for a racket
     * @param game
     * @param up
     * @param down
     * @param x 
     */
    public Racket(Pong game, int up, int down, int x) {
        this.game = game;
        this.x = x;
        y = game.getHeight() / 2;
        this.up = up;
        this.down = down;
    }

    /**
     * Racket Update function
     */
    public void update() {
        if (y > 0 && y < game.getHeight() - HEIGHT - 29)
            y += ya;
        else if (y == 0)
            y++;
        else if (y == game.getHeight() - HEIGHT - 29)
            y--;
    }

    /**
     * Pressed a Key
     * @param keyCode 
     */
    public void pressed(int keyCode) {
        if (keyCode == up)
            ya = -1;
        else if (keyCode == down)
            ya = 1;
    }

    /**
     * Released the Key
     * @param keyCode 
     */
    public void released(int keyCode) {
        if (keyCode == up || keyCode == down)
            ya = 0;
    }

    /**
     * Bounds for the Racket
     * @return 
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    /**
     * Paint Function
     * @param g 
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}