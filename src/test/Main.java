package test;
// 하~중
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<> ll = new LinkedList()<>;
        ll.re
    }
}


class Solution {
    public int solution(String[] ingredients, String[] items) {
        //ingredients = new String[]{"1", "2"};
        //items = new String[]{"1"};

        int left = 0;
        int right = items.length-1;
        LinkedList<String> ingredlist = new LinkedList<>(Arrays.asList(ingredients));
        LinkedList<String> itemList = new LinkedList<>(Arrays.asList(items));

        // System.out.printf("left: %d, right: %d\n",left, right);
        return check(items, ingredList, itemList, left, right);
    }

    // left부터 right까지 영역을 구하고, 모든 ingred가 그 안에 속하는지를 파악한다음, true이면 구간의 길이를 리턴
    public int check(String[] items, LinkedList<String> ingredList, LinkedList<String> itemList, int left, int right){
        boolean containsLeft = ingredlist.contains(items[left]);
        boolean containsRight = ingredList.contains(items[right]);

        while(!(containsLeft && containsRight) || left <= right){
            // System.out.printf("left: %d, right: %d, containsLeft: %b, containsRight: %b\n",left,right, containsLeft, containsRight);
            if(containsLeft){
                containsRight = igredList.contains(items[--right]);
                itemList.deleteLast();
            } else if (containsRight){
                containsLeft = igredList.contains(items[++left]);
                itemList.deleteFirst();
            } else {
                containsRight = igredList.contains(items[--right]);
                containsLeft = igredList.contains(items[++left]);
                itemList.deleteLast();
                itemList.deleteFirst();
            }
        }

        if(left > right){
            return 0;
        }

        boolean check = true;
        for(int i=0; i<left; i++){
            if(!itemList.contains(ingredList.get(i))){
                check=false;
                break;
            }
        }

        if(check){
            int hoksi1 = check(items, ingredList, itemList, left+1, right);
            int hoksi2 = check(items, ingredList, itemList, left, right-1);
            if(Math.max(hoksi1, hoksi2) == 0){
                return right-left+1;
            } else {
                return Math.max(hoksi1, hoksi2);
            }
        } else {
            return 0;
        }
    }
}

// ingrediet가 모두 포함된 가장 짧은 배열의 구간을 출력
