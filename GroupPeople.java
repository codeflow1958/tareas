import java.util.*;

public class GroupPeople {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[groupSizes.length];
        
        for (int i = 0; i < groupSizes.length; i++) {
            if (!visited[i]) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < groupSizes.length; j++) {
                    if (!visited[j] && groupSizes[j] == groupSizes[i]) {
                        group.add(j);
                        visited[j] = true;
                        if (group.size() == groupSizes[i]) break;
                    }
                }
                result.add(group);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        System.out.println(groupThePeople(groupSizes));
    }
}