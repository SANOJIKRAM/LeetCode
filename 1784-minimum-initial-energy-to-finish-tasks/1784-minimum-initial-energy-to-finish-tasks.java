import java.util.Arrays;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int initialEnergy = 0, currentEnergy = 0;
        for (int[] task : tasks) {
            int actual = task[0], minimum = task[1];
            if (currentEnergy < minimum) {
                initialEnergy += minimum - currentEnergy;
                currentEnergy = minimum;
            }
            currentEnergy -= actual;
        }
        return initialEnergy;
    }
}