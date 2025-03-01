class Solution {
  public int clumsy(int n) {
    Stack<Integer> stac = new Stack<>();
    stac.push(n--);
    int i = 0;
    int ans = 0;
    while (n>0) {
      switch (i%4) {
        case 0:
          stac.push(stac.pop()*n);
          break;
        case 1:
          stac.push(stac.pop()/n);
          break;
        case 2:
          stac.push(n);
          break;
        case 3:
          stac.push(-n);
          break;
      }
      i++;
      n--;
    }
    while (!stac.isEmpty()) {
      ans+=stac.pop();
    }
    return ans;
  }
}