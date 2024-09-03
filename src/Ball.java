import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import java.util.Random;

public class Ball {

    public int width, height, vx, vy;
    public float x, y;
    public boolean isGameOver = false;

    float speed = 1;

    public Ball(int bx, int by, int bwidth, int bheight){
        x = bx;
        y = by;
        width = bwidth;
        height = bheight;
        Random random = new SecureRandom();
        vx = (random.nextInt(3)+2);
        if(random.nextBoolean()){
            vx = -vx;
        }
        vy = random.nextInt(6)-3;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(Math.round(x), Math.round(y), width, height);
    }

    public void update(Paddle p1, Paddle p2, int stageWidth, int stageHeight){

        x = x + vx*speed;
        y = y + vy*speed;

        if(y<0){
            vy = -vy;
            y=0;
        }

        if(y+height>stageHeight){
            vy = -vy;
            y=stageHeight-height;
        }

        if(x<0){
            x=0;
            vx = 0;
            vy = 0;
            isGameOver = true;
            System.out.println("Player 2 Won");
        }

        if(x+width>stageWidth){
            x=stageWidth-width;
            vx = 0;
            vy = 0;
            isGameOver = true;
            System.out.println("Player 1 Won");
        }

        Random random = new SecureRandom();
        boolean bounced = false;
        if(isTouching(p1)){
            x = p1.x+p1.width;
            vx = random.nextInt(3)+2;
            vy = random.nextInt(6)-3;
            bounced = true;
        }

        if(isTouching(p2)){
            x = p2.x-width;
            vx = -(random.nextInt(3)+2);
            vy = random.nextInt(6)-3;
            bounced = true;
        }

        if(bounced){
            if(random.nextInt(10)<5){
                speed = speed + 0.05f;
            }
        }
    }


    public boolean isTouching(Paddle p){
        if(oneDimensionOverlap(p.x, p.x+p.width, x, x+width) && oneDimensionOverlap(p.y, p.y+p.height, y, y+height)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean oneDimensionOverlap(double x1, double x2, double y1, double y2){
        if(x1<y2 && x2>y1){
            return true;
        }else{
            return false;
        }
    }



}
