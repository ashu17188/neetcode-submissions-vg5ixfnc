class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
      char chArray[] = str.toCharArray();
      int count[] = new int[26];
      for (char ch : chArray) {
        count[ch - 'a']++;
      }
      String key = Arrays.toString(count);
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(str);

    }
    return new ArrayList<>(map.values());
  }
}
