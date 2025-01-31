class Solution {
     List<String> perm=new ArrayList<>();
    List<List<String>> res=new ArrayList<>();
    static int n, comb[]=new int[9];
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        char[] ch=new char[n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++)
                ch[j]=i==j? 'Q': '.';
            perm.add(new String(ch));
        }
        f(0, 0, 0, 0);
        return res;
    }

    private void f(int row, int col, int diagonal, int anti_d) {
        if(row==n) {
            List<String> r=new ArrayList<>();
            for(int i=0; i<n; i++) r.add(perm.get(comb[i]));
            res.add(r);
            return;
        }

        for(int i=0, mask=col|diagonal|anti_d; i<n; i++) {
            if((mask&(1<<i))==0) {
                comb[row]=i;
                f(row+1, col|(1<<i), (diagonal|(1<<i))<<1, (anti_d|(1<<i))>>1);
            }
        }
    }
}