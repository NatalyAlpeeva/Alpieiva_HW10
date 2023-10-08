import java.util.Arrays;

public class ReverseArray {
        static void reverseArray(String strArray[], int size)
        {
            int i;
            String temp;
            for (i = 0; i < size / 2; i++) {
                temp = strArray[i];
                strArray[i] = strArray[size - i - 1];
                strArray[size - i - 1] = temp;
            }

            System.out.println("Reversed Array: \n" + Arrays.toString(strArray));
        }

    public static void main(String[] args)
    {
        String [] strArray = {"cat","dog","lion","monkey","puma","bear"};

        System.out.println("Original Array: \n" + Arrays.toString(strArray));

        reverseArray(strArray, strArray.length);
    }
}
