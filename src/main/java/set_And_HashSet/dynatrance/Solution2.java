package set_And_HashSet.dynatrance;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public int solution(Tree t) {

        Set<Integer> distinctValues = getDistinctValues(t);
        System.out.println(distinctValues);
        return distinctValues.size();
    }

    public Set<Integer> getDistinctValues(Tree t) {
        Set<Integer> dv = new HashSet<>();
        if (t == null) {
            return dv;
        }
        Set<Integer> ldv = new HashSet<>();
        ldv.add(t.x);
        ldv.addAll(getDistinctValues(t.l));
        Set<Integer> rdv = new HashSet<>();
        rdv.add(t.x);
        rdv.addAll(getDistinctValues(t.r));
        if(ldv.size()>rdv.size()){
            return ldv;
        } else {
            return rdv;
        }
    }

    static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.x = 4;
        Tree t2 = new Tree();
        t2.x=5;
        t2.l=t;
        Tree t3 = new Tree();
        t3.x = 5;
        t3.l=t2;
        Tree root = new Tree();
        root.x=4;
        root.l=t3;

        Tree r = new Tree();
        r.x = 6;
        Tree r2 = new Tree();
        r2.x = 6;
        r2.r= r;

        Tree r3 = new Tree();
        r3.x = 1;
        r2.l= r3;

        root.r = r2;

        Solution2 s = new Solution2();
        System.out.println(s.solution(root));



    }
}
