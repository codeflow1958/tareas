import java.util.*;

public class MinOperationsBoxes {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        // Primer recorrido de izquierda a derecha
        int count = 0, ops = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1') count++;
            ops += count;
        }
        
        // Segundo recorrido de derecha a izquierda
        count = 0;
        ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += ops;
            if (boxes.charAt(i) == '1') count++;
            ops += count;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
}
