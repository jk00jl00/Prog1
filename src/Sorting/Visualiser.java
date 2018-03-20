package Sorting;

import javax.swing.*;
import java.awt.*;

public class Visualiser extends JPanel{

    int[] ints = new int[0];
    double[] doubles = new double[0];
    String[] strings = new String[0];

    int currentLow = 1;

    int width = 100;
    int height = 720;
    int coullums;
    int hNum = 1920;

    private int lowest = -1;
    private int current = -1;
    private int loop = -1;
    private int pivot = -1;
    private int low = -1;
    private int high = -1;


    public Visualiser(int height){
        super();
        this.height = height;
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintArray((Graphics2D)g);
    }

    private void paintArray(Graphics2D g) {
        if(ints.length > 0) {
            for(int i = 0; i < ints.length; i++){
                g.setColor(Color.gray);
                if(i == lowest) g.setColor(Color.blue);
                else if(i == current) g.setColor(Color.GREEN);
                else if(ints[i] == pivot) g.setColor(Color.RED);
                else if(i == high) g.setColor(Color.ORANGE);
                else if(i == low) g.setColor(Color.cyan);

                if(i < loop) g.setColor(Color.RED);
                g.fillRect(i * width, height - (int)(ints[i] *(double)height/(double)hNum), width, (int)(ints[i] *(double)height/(double)hNum));
            }
            if(pivot > 0){
                g.setColor(Color.BLACK);
                g.fillRect(0, height - (int) (pivot * (double)height/(double)hNum) ,this.getWidth(), 1);
            }
        } else if(doubles.length > 0){

        } else{

        }
    }


    public void setInts(int[] ints) {
        this.ints = ints;
        this.coullums = ints.length;
        this.width = (int) Math.round((double) this.getWidth() / (double) coullums);
    }

    public void setLowest(int lowest) {
        this.lowest = lowest;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public void setPivot(int pivot) {
        this.pivot = pivot;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setHigh(int high) {
        this.high = high;
    }




}
