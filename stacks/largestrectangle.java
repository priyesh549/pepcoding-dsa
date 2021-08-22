package stacks;
import java.util.*;
import java.io.*;

public class largestrectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,1,5,6,2,3};

        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>1 && arr[i]<arr[st.peek()]){
                int idx = st.pop();
                int width = i - st.peek() - 1;
                ans = Math.max(arr[idx]*width,ans);
            }
            st.push(i);
        }
        while(st.size() > 1){
            int idx = st.pop();
            int width = arr.length-st.peek()-1;
            ans = Math.max(arr[idx]*width,ans);
        }
        System.out.println(ans);
    }
}
