import java.util.*;

public class ConvertArrayToMatrix {
    // Método para convertir un arreglo en una matriz 2D siguiendo las condiciones dadas
    public static List<List<Integer>> convertToMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // Lista de listas para almacenar la matriz resultante
        Map<Integer, List<Integer>> map = new HashMap<>(); // Mapa para agrupar elementos únicos
        
        // Recorremos el array nums
        for (int num : nums) {
            // Si el número no está en el mapa, lo añadimos con una nueva lista
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            // Agregamos el número a su respectiva lista en el mapa
            map.get(num).add(num);
        }
        
        // Agregamos cada grupo del mapa a la matriz resultante
        for (List<Integer> group : map.values()) {
            result.add(group);
        }
        
        return result; // Retornamos la matriz 2D
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1}; // Ejemplo de entrada
        System.out.println(convertToMatrix(nums)); // Llamamos al método y mostramos el resultado
    }
}