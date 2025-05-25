package Backtracting;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;
        List<String> steps = new ArrayList<>();
        solveHanoi(n, 1, 3, 2, steps);

        System.out.println("Total moves: " + steps.size());
        for (String step : steps) {
            System.out.println(step);
        }
    }

    public static void solveHanoi(int n, int from, int to, int aux, List<String> steps) {
        if (n == 1) {
            steps.add("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }

        solveHanoi(n - 1, from, aux, to, steps);
        steps.add("Move disk " + n + " from rod " + from + " to rod " + to);
        solveHanoi(n - 1, aux, to, from, steps);
    }
}
