import java.util.*;

public class MonotonicStack {

    public static void main(String[] args) {
        decreasingStack(new int[] { 1, 2, 3, 4, 5 });
        increasingStack(new int[] { 5, 2, 3, 4, 7, 9, 1, 2 });
    }

    public static void decreasingStack(int[] arr) {
        Stack<Integer> st = new Stack();
        int[] prevLarger = new int[arr.length];
        int[] nextLarger = new int[arr.length];
        prevLarger[0] = -1;
        nextLarger[arr.length - 1] = -1;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(st.toString());
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                int ind = st.pop();
                if (!st.isEmpty())
                    prevLarger[ind] = st.peek();
                else
                    prevLarger[ind] = -1;
                nextLarger[ind] = i;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            nextLarger[st.pop()] = -1;
        }

        System.out.println("Previous Larger value for index i: " + Arrays.toString(prevLarger));
        System.out.println("Next Larger value for index i: " + Arrays.toString(nextLarger));

    }

    public static void increasingStack(int[] arr) {

    }
}
