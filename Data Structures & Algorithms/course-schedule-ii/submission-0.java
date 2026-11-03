class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pair : prerequisites) {
            map.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
        }
        List<Integer> cycle = new ArrayList<>();
        List<Integer> visit = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, map, cycle, visit, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < output.size(); i++) {
            result[i] = output.get(i);
        }
        return result;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> map, List<Integer> cycle,
        List<Integer> visit, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }
        cycle.add(course);

        for (int pre : map.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, map, cycle, visit, output)) {
                return false;
            }
        }
        cycle.remove((Integer) course);
        visit.add(course);
        output.add(course);

        return true;
    }
}
