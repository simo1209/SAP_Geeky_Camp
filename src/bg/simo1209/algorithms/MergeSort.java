package bg.simo1209.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeSort {
    public static void sort(List<Integer> list, int from, int to){
        if (to-from < 2){
            return;
        }
        if (to-from == 2){
            if (list.get(from) > list.get(from + 1)){
                Collections.swap(list,from,from+1);
            }
            return;
        }

        int mid = (from+to)/2;

        sort(list,from,mid);
        sort(list,mid,to);

        merge(list,from,mid,to);
    }

    private static void merge(List<Integer> list, int from, int mid, int to){
        int pin1 = from;
        int pin2 = mid;

        ArrayList<Integer> merged = new ArrayList<>();

        while (pin1 < mid && pin2 < to) {
            if (list.get(pin1)<list.get(pin2)){
                merged.add(list.get(pin1++));
            }else {
                merged.add(list.get(pin2++));
            }
        }

        while (pin1<mid){
            merged.add(list.get(pin1++));
        }

        while (pin2<to){
            merged.add(list.get(pin2++));
        }

        for (int i = from; i < to; i++) {
//            list.set(i-from,me)
        }

    }
}
