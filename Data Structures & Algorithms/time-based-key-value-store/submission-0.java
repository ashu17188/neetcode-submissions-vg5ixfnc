class TimeMap {

    private Map<String, List<Pair<Integer, String>>> map;

  public TimeMap() {
    map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.computeIfAbsent(key, k-> new ArrayList<>())
    .add(new Pair(timestamp, value));
  }

  public String get(String key, int timestamp) {
    List<Pair<Integer, String>> values = map.getOrDefault(key, new ArrayList<>());

    if(values.size() == 0){
      return "";
    }

    int l =0 ; int r = values.size() -1;
    String result = "";
    while(l<=r){
      int m = l + (r-l)/2;

      if(values.get(m).getKey() <= timestamp){
        result = values.get(m).getValue();
        l =m +1;
      }else{
        r = m-1;
      }
    }
    return result;
  }

  

private static class Pair<K,V>{
  private final K key;
  private final V value;

  public Pair(K key, V value){
    this.key = key;
    this.value = value;
  }

  public K getKey(){
    return key;
  }

  public V getValue(){
    return value;
  }
}
}
