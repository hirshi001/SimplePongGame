import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyCanvas extends Canvas implements KeyListener {

    public Paddle p1;
    public Paddle p2;

    public Ball ball;

    public MyCanvas(){
        addKeyListener(this);
    }

    public void setup(){
        p1 = new Paddle(10, 100, 10, 200, 10);
        p2 = new Paddle(getWidth()-20, 100, 10, 200, 10);
        ball = new Ball(getWidth()/2-15,getHeight()/2-15, 30, 30);
        repaint();
        try{
            Thread.sleep(1000);
        } catch (Exception e){}
    }

    public void update(){
        p1.update();
        p2.update();
        ball.update(p1, p2, getWidth(), getHeight());

        if(ball.isGameOver){
            setup();
        }
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(), getHeight());

        g.setColor(Color.WHITE);
        int lineWidth = 4;

        g.fillRect(getWidth()/2-lineWidth/2,0, lineWidth, getHeight());

        p1.draw(g);
        p2.draw(g);

        ball.draw(g);

    }



    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {


        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){
            p1.moveUp = false;
        }
        if(keyCode == KeyEvent.VK_S){
            p1.moveDown = false;
        }

        if(keyCode == KeyEvent.VK_UP){
            p2.moveUp = false;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            p2.moveDown = false;
        }



    }


    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_W){
            p1.moveUp = true;
        }
        if(keyCode == KeyEvent.VK_S){
            p1.moveDown = true;
        }

        if(keyCode == KeyEvent.VK_UP){
            p2.moveUp = true;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            p2.moveDown = true;
        }
    }
}
