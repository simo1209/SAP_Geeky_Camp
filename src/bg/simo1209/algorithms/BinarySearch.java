package bg.simo1209.algorithms;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    private static <T extends Comparable<T>> boolean search(List<T> list, T el, int left, int right){
        if (left-right!=0){
            int mid = (left+right)/2;
            if (list.get(mid).compareTo(el)==0)return true;
            else if (list.get(mid).compareTo(el)==-1) return search(list,el,mid+1,right);
            else if (list.get(mid).compareTo(el)==1) return search(list,el,left,mid);
        }
        return false;

    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,10,11,12,13,14,17,18);

        int el = 10;

        System.out.println(search(list,el,0,list.size()));
    }
}
