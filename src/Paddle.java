import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

    public int width, height, x, y, speed;
    public boolean moveUp, moveDown;

    public Paddle(int px, int py, int pwidth, int pheight, int pspeed){
        x = px;
        y = py;
        width = pwidth;
        height = pheight;
        speed = pspeed;
    }

    public void update(){
        if(moveUp){
            y = y-speed;
        }
        if(moveDown){
            y = y+speed;
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
    }



}
