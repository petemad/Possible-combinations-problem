import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    static ArrayList<Integer> result = new ArrayList<>();
    static int window = 0;
    public static void main(String [] args){
        int [] input = {2,3,5};
        int n = input.length;
        Stack<Integer> myStack = new Stack<>();
        for (int i=0; i<n; i++){
            myStack.push(input[i]);
        }

        for(int i=0; window<n; i++){
            if(i+1 == n){
                i = 0;
                window++;
            }
            if (i + window > n){break;}
            int value = getValue(window, input, i);
            multPop(myStack, value,n-(window+i));

            if(window == 0){
                window++;
                if(window == 1){result.add(input[0]);}
                i = -1;
            }
        }
        System.out.println(result);

    }
    static void multPop(Stack<Integer> s, int value, int pops){
        if (window == 0){result.add(0);}
        else {
            Stack<Integer> tempStack = (Stack<Integer>) s.clone();
            int v = 1;
            for (int i = 0; i < pops; i++) {
                v = value * tempStack.pop();
                result.add(v);
            }
        }
    }

    static int getValue(int window, int [] arr, int index){
        if(window == 0){return 0;}
        int out=1;
        for (int i=0; i<window;i++){
            out=arr[index+i]*out;
        }
        return out;
    }

}
