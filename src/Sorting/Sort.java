package Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sort {

    public static void selSort(int[] ints){
        for(int i = 0; i < ints.length; i++){
            int lowestI = i;
            for(int a = i + 1; a < ints.length; a++){
                if(ints[a] < ints[lowestI]) {
                    lowestI = a;
                }
            }

            swap(ints, i, lowestI);
        }
    }

    public static boolean selSortStep(int[] ints, int step){
        int lowestI = step;

        if(step > ints.length - 1) return true;

        for(int a = step; a < ints.length; a++){
            if(ints[a] < ints[lowestI]) {
                lowestI = a;
            }
        }
        swap(ints, step, lowestI);

        return false;
    }


    public static void quickSort(int[] i){
        quickSort(i, 0, i.length - 1);
    }
    public static void quickSort(int [] i, int low, int high){
        if(high - low == 1) return;

        int pivotIndex = ThreadLocalRandom.current().nextInt(low , high);
        int pivot = i[pivotIndex];

        int l = low, h = high;

        while(l <= h){
            while(i[l] < pivot){
                l++;
            }
            while (i[h] > pivot){
                h--;
            }

            if(l <= h) {
                swap(i, l, h);
                l++;
                h--;
            }
        }
        if(low < h){
            quickSort(i, low, h);
        }

        if (l < high){
            quickSort(i, l, high);
        }

    }


    public static void swap(int[] i, int f, int s){
        int temp = i[f];
        i[f] = i[s];
        i[s] = temp;
    }

    public static int getMean(int[] i, int low, int high) {
        int range = high - low;
        int part = range / 5;
        int[] means = new int[5];

        try {
            for(int a = 0; a < 5; a++){
                means[a] = i[ThreadLocalRandom.current().nextInt(low + part * a, low +part * (a + 1))];
            }
        } catch (IllegalArgumentException e) {
            return i[ThreadLocalRandom.current().nextInt(low , high)];
        }

        Arrays.sort(means);



        return means[2];
    }
}
