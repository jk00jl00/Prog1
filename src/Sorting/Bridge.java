package Sorting;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Bridge{

    Thread thread;
    Gui gui;
    boolean isSorting = false;
    private int qSortDelay = 1;


    public Bridge(){
        init();
    }


    private void init(){
        gui = new Gui();
    }

    private void instSelSort(int[] i){
        Sort.selSort(i);
        for(int a : i){
            System.out.println(a);
        }
        gui.setInts(i);
    }

    public void selSort(int[] i){
        int step = 0;
        while (!Sort.selSortStep(i, step)){
            gui.setInts(i);

            step++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.setInts(i);

        isSorting = false;
    }

    public void fancySelSort(int[] i){
        gui.setInts(i);

        for(int a = 0; a < i.length; a++){
            gui.setLoop(a);
            int lowest = a;
            gui.setLowest(a);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int b = a + 1; b < i.length; b++){
                //gui.setCurrent(b);
                //
                if(i[b] < i[lowest]){
                    lowest = b;
                    gui.setLowest(b);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            Sort.swap(i, a, lowest);
            gui.setLowest(a);
            gui.setInts(i);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.setLoop(0);

    }


    public void fancyQuickSort(int[] i){
        fancyQuickSort(i, 0, i.length -1);
    }
    public void fancyQuickSort(int[] i, int low, int high){
        gui.setInts(i);
        gui.setLow(low);
        gui.setHigh(high);
        int pivot = Sort.getMean(i, low, high);
        gui.setPivot(pivot);

        try {
            Thread.sleep(qSortDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int l = low, h = high;
        while (l <= h){

            while (i[l] < pivot){
                l++;
                gui.setLowest(l);

                try {
                    Thread.sleep(qSortDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (i[h] > pivot){
                h--;
                gui.setCurrent(h);

                try {
                    Thread.sleep(qSortDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(l <= h){
                Sort.swap(i, l, h);
                l++;
                h--;
                gui.setCurrent(h);
                gui.setLowest(l);

                try {
                    Thread.sleep(qSortDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if(l < high){
            fancyQuickSort(i, l, high);
        }

        if(h > low){
            fancyQuickSort(i, low, h);
        }

    }

    public void shuffleArray(int[] array) {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
            gui.setInts(array);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void start(){
        gui.startDrawing();
    }
    public void stop(){
        gui.stopDrawing();
    }
}
