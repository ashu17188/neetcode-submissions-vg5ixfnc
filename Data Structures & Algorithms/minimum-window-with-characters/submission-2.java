class Solution {
    public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    Map<Character, Integer> tCount = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();

    int have = 0;

    int resLen = Integer.MAX_VALUE;
    int res[] = {-1, -1};

    for (char c : t.toCharArray()) {
      tCount.put(c, tCount.getOrDefault(c, 0) + 1);
    }
    int need = tCount.size();

    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0) + 1);

      if (tCount.containsKey(s.charAt(r))
          && tCount.get(s.charAt(r)).equals(window.get(s.charAt(r)))) {
        have++;
      }

      while (have == need) {
        if (r - l + 1 < resLen) {
          resLen = Math.min(r - l + 1, resLen);
          res[0] = l;
          res[1] = r;
        }
        char leftChar = s.charAt(l);
        window.put(leftChar, window.get(leftChar) - 1);

        if (tCount.containsKey(s.charAt(l)) && tCount.get(s.charAt(l)) > window.get(s.charAt(l))) {
          have--;
        }
        l++;
      }
    }
    return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
  }
}
