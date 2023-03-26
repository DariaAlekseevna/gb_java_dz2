/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;
import java.util.logging.*;

public class task2 {
    public static void main(String[] args) throws IOException {
    
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);


        logger.info("Creare an array of integers.");        
        int[] arr = new int[] {4, 1, 72, 73, 2, 3, 11, 9, 22, 33, 7};
        logger.info("Call bubble sort function.");  
        arr = BubbleSort(arr, logger);
        logger.info("The sorted array is output to the terminal.");  
        for (int i : arr) {
            System.out.printf("%d ",i);
        }
    }

    private static int[] BubbleSort(int[] arr, Logger logger) {
        logger.info("Creare a temporary and an array length variable.");  
        int temp = 0;
        logger.info("temp = " + temp);  
        int arrLength = arr.length;
        logger.info("arrLength = " + arrLength);
        logger.info("Created cycle for bubble sorting.");  
        for (int i = 0; i < arrLength-1; i++) {
            logger.info("i = " + i + "temp = " + temp);
            if(arr[i] > arr[i+1]) {
                logger.info("Neighboring elements are swapped with each other.");
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }

            if (i == arrLength-2) {
                logger.info("Reduce array length and counter(i) start from the beginning. arrlength = " + arrLength);
                arrLength--;
                i = -1; 
            }
        }
        logger.info("Returned sorted array.");
        return arr;
    }
}
