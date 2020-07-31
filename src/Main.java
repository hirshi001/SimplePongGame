import javax.swing.JFrame;
import java.awt.GraphicsConfiguration;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);

        MyCanvas canvas = new MyCanvas();
        frame.add(canvas);

        frame.setVisible(true);

        canvas.setup();

        while(true){

            canvas.update();
            canvas.repaint();

            try{
                Thread.sleep(5);
            } catch(Exception e) {}


        }



    }


}
