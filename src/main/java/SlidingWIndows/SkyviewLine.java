package SlidingWIndows;

import java.util.*;

public class SkyviewLine {
    public static void main(String[] args) {
        SkyviewLine skylineSolver = new SkyviewLine();

        // Sample input: each building is [left, right, height]
        int[][] buildings = {
                {1, 6, 5},
                {2, 6, 4},
                {3, 6, 7},
                {4, 6, 2},
                {5, 6, 1}
        };

        List<List<Integer>> skyline = skylineSolver.getSkyline(buildings);

        // Print the result
        for (List<Integer> point : skyline) {
            System.out.println(point);
        }
    }
    public List<List<Integer>> getSkyLine(int[][] buildings) {
        List<List<Integer>> events = new ArrayList<>();

        for(int[] building : buildings){
            events.add(Arrays.asList(building[0],-building[2]));
            events.add(Arrays.asList(building[1], building[2]));
        }
        events.sort((a,b) -> {
            if (a.get(0) != b.get(0)) return Integer.compare(a.get(0), b.get(0));
            else return Integer.compare(a.get(1),b.get(1));
        });

        List<List<Integer>> result = new ArrayList<>();
        int previousHeight =0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);

        for(List<Integer> event : events){
            if (event.get(1) < 0) maxHeap.add(-event.get(1));
            else maxHeap.remove(event.get(1));

            int currentHeight = maxHeap.peek();

            if (currentHeight != previousHeight){
                result.add(Arrays.asList(event.get(0), currentHeight));
                previousHeight = currentHeight;
            }
        }

        return result;
    }public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for(int[] building : buildings){
            events.add(new int[]{building[0],-building[2]});
            events.add(new int[]{building[1], building[2]});
        }
        events.sort((a,b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1],b[1]);
        });

        List<List<Integer>> result = new ArrayList<>();
        int previousHeight =0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);
        for(int[] event : events){
            if (event[1] < 0) maxHeap.add(-event[1]);
            else maxHeap.remove(event[1]);

            int currentHeight = maxHeap.peek();

            if (currentHeight != previousHeight){
                result.add(Arrays.asList(event[0], currentHeight));
                previousHeight = currentHeight;
            }
        }

        return result;
    }
}

