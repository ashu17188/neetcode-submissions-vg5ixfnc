class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            map.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course) {
        if (visit.contains(course)) {
            return false;
        }

        visit.add(course);
        List<Integer> prereqList = map.getOrDefault(course, new ArrayList<>());

        for (int preReqCourse : prereqList) {
            if (!dfs(preReqCourse)) {
                return false;
            }
        }
        visit.remove(course);
        map.put(course, new ArrayList<>());

        return true;
    }
}
