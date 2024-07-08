class Solution {
  public int findTheWinner(int n, int k) {
    // Converts back to 1-indexed
    return f(n, k) + 1;
  }
  private int f(int n, int k) {
    int ans = 0; // f(1, k)
    for (int i = 2; i <= n; ++i)
      ans = (ans + k) % i;
    return ans;
  }
}
