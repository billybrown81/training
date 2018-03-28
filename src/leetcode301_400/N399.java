package leetcode301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class N399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> pairValues = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                pairValues.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                pairValues.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            pairValues.get(equation[0]).add(values[i]);
            pairValues.get(equation[1]).add(1/values[i]);
		}
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
			String[] query = queries[i];
			result[i] = DFSHelper(query[0], query[1], pairs, pairValues, new HashSet<String>(), 1.0);
			if (result[i] == 0.0) result[i] = -1.0;
		}
        return result;
    }

	private double DFSHelper(String start, String end, Map<String, ArrayList<String>> pairs,
		Map<String, ArrayList<Double>> pairValues, HashSet<String> set, double value) {
		if (set.contains(start)) return 0.0;
		if (!pairs.containsKey(start)) return 0.0;
		if (start.equals(end)) return value;
		set.add(start);
		
		ArrayList<String> slList = pairs.get(start);
		ArrayList<Double> vList = pairValues.get(start);
		double tmp = 0.0;
		for (int i = 0; i < slList.size(); i++) {
			tmp = DFSHelper(slList.get(i), end, pairs, pairValues, set, value * vList.get(i));
			if (tmp != 0.0) break;
		}
		return tmp;
	}
}
