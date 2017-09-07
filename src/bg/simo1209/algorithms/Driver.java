package bg.simo1209.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(5,2,9,1,4,8,3,7,6));

        MergeSort.sort(list,0,list.size());
        System.out.println(list.toString());
    }
}
