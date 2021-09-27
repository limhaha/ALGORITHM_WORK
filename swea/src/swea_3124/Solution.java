package swea_3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    static long res;
    static int V, E;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        TreeSet<Data> set ;
        st = new StringTokenizer(br.readLine());

        for(int t = 1; t <= T; t++ ) {
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            p = new int[V + 1];
            set = new TreeSet();
            
            for(int i =0; i <E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                Data d = new Data(x,y,w);
                set.add(d);
            }

            res = 0;
            int cnt = 0;
            makSet();
            for(Data d : set) {
                if(union(d)) {
                    res += d.w;
                    cnt++;
                }
                if(cnt  == V -1) {
                    break;
                }
            }
            System.out.println("#" +t + " " + res);
        }
    }
    static boolean union(Data d) {
        int x = findSet(d.x);
        int y = findSet(d.y);
        if(x == y) {
            return false;
        }
        p[y]= x;
        return true;
    }
    static int findSet(int x) {
        if(p[x] == x) {
            return x;
        }
        return p[x] = findSet(p[x]);
    }
    private static void makSet() {

        for(int i = 0 ;i <= V; i++) {
            p[i] = i;
        }
    }

    static class Data implements Comparable<Data>{
        int x, y;
        int w;
        public Data(int x, int y, int w) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(Data o) {

            return Integer.compare(this.w, o.w);
        }

    }
}