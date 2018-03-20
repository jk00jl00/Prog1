package Sorting;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame implements Runnable{
    Visualiser v;
    JPanel firstPanel;


    private Thread thread;
    public boolean drawing;

    public Gui(){
        super();

        v = new Visualiser(720);
        v.setPreferredSize(new Dimension(1440, 720));
        v.setFocusable(true);

        firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(600,  600));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setContentPane(v);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setInts(int[] i){
        v.setInts(i);
        v.setPreferredSize(new Dimension(i.length * v.width, 720));
        this.pack();
    }

    public void repaint(){
        super.repaint();
        v.repaint();
    }

    public void setLowest(int lowest) {
        v.setLowest(lowest);
    }

    public void setCurrent(int current) {
        v.setCurrent(current);
    }

    public void setLoop(int loop) {
        v.setLoop(loop);
    }

    public void setPivot(int pivot) {
        v.setPivot(pivot);
    }

    public void setLow(int low) {
        v.setLow(low);
    }

    public void setHigh(int high) {
        v.setHigh(high);
    }

    public void startDrawing(){
        start();
    }
    public void stopDrawing(){
        drawing = false;
    }


    private synchronized void start(){
        drawing = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() throws InterruptedException {
        thread.join();
    }

    @Override
    public void run() {
        while(drawing) {
            this.repaint();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
