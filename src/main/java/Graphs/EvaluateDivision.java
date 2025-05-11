package Graphs;

import java.util.*;

public class EvaluateDivision {

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>(Arrays.asList(
                Arrays.asList("x1","x2"),
                Arrays.asList("x2","x3"),
                Arrays.asList("x3","x4"),
                Arrays.asList("x4","x5")
        ));
        double[] values = new double[]{3.0,4.0,5.0,6.0};
        List<List<String>> queries = new ArrayList<>(Arrays.asList(
                Arrays.asList("x1","x5"),
                Arrays.asList("x5","x2"),
                Arrays.asList("x2","x4"),
                Arrays.asList("x2","x2"),
                Arrays.asList("x2","x9"),
                Arrays.asList("x9","x9")
        ));

        double[] expectedResult = new double[]{360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000};

        EvaluateDivision evaluateDivision=new EvaluateDivision();

        double[] actualResult = evaluateDivision.calcEquation(equations, values, queries);

        for (double value : actualResult){
            System.out.print(value + ",");
        }

    }

    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();

        for (int i=0; i<equations.size(); i++){
            List<String> equation = equations.get(i);
            String divident = equation.get(0);
            String divisor = equation.get(1);

            if(!graph.containsKey(divident))
                graph.put(divident, new HashMap<String, Double>());
            if (! graph.containsKey(divisor))
                graph.put(divisor, new HashMap<String,Double>());

            graph.get(divident).put(divisor, values[i]);
            graph.get(divisor).put(divident, 1/values[i]);
        }
        double[] results = new double[queries.size()];

        for(int i = 0; i< queries.size(); i++){
            List<String> query = queries.get(i);
            String divident = query.get(0);
            String divisor = query.get(1);
            if (!graph.containsKey(divident) || !graph.containsKey(divisor)){
                results[i] = -1.0;
            } else if (divident.equals(divisor)) {
                results[i] = 1.0;
            } else {
                List<String> visited = new ArrayList<>();
                double actProduct = 1.0;
                results[i] = findPath(graph, divident, divisor, visited, actProduct);
            }

        }
        return results;

    }

    private double findPath(HashMap<String, HashMap<String, Double>> graph, String divident, String divisor,
                                List<String> visited, double actProduct){
        visited.add(divident);
        HashMap<String, Double> neighbours = graph.get(divident);
        double net = -1.0;
        if (neighbours.containsKey(divisor)){
            return actProduct*neighbours.get(divisor);
        }else {
            for (Map.Entry<String, Double> neighbour : neighbours.entrySet()){
                if (visited.contains(neighbour.getKey())){
                    continue;
                } else {
                    net = findPath(graph, neighbour.getKey(), divisor, visited, actProduct * neighbour.getValue());
                }
                if (net != -1)
                    break;

            }
        }


        return net;
    }
}
