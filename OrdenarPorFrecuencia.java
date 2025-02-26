import java.util.Arrays;

public class OrdenarPorFrecuencia {
    public static int[] sortByFrequency(int[] nums) {
        // Encontrar el valor máximo en el arreglo para definir el tamaño de los contadores
        int max = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[max + 1]; // Arreglo para contar la frecuencia de cada número
        int[] firstIndex = new int[max + 1]; // Arreglo para almacenar la primera aparición de cada número
        Arrays.fill(firstIndex, -1); // Inicializamos con -1 indicando que aún no ha aparecido
        
        // Contar las apariciones de cada número y registrar la primera posición
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++; // Incrementamos el contador de frecuencia
            if (firstIndex[nums[i]] == -1) { // Si es la primera vez que aparece, registramos su índice
                firstIndex[nums[i]] = i;
            }
        }

        // Ordenar usando el algoritmo de burbuja para cumplir con las restricciones
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                // Si la frecuencia de nums[j] es menor que la de nums[j + 1], intercambiamos
                if (count[nums[j]] < count[nums[j + 1]] || 
                   (count[nums[j]] == count[nums[j + 1]] && firstIndex[nums[j]] > firstIndex[nums[j + 1]])) {
                    // Intercambio de valores en el arreglo para ordenarlos correctamente
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        
        return nums; // Retornamos el arreglo ordenado por frecuencia
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6, 3, 4, 4, 6}; // Ejemplo de entrada
        System.out.println(Arrays.toString(sortByFrequency(nums))); // Llamamos al método y mostramos el resultado
    }
}
