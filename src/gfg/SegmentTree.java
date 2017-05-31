package gfg;

public class SegmentTree {

    int[] segmentSum;

    public SegmentTree(int n) {
        segmentSum = new int[2*n - 1];
    }

    private void construct(int[] arr, int node, int start, int end) {
        if (start == end) {
            segmentSum[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        construct(arr, 2*node+1, start, mid);
        construct(arr, 2*node+2, mid+1, end);
        segmentSum[node] = segmentSum[2*node+1] + segmentSum[2*node+2];
    }

    private int getSum(int start, int end, int qs, int qe, int node) {
        // out of the range
        if (qs > end || qe < start ) {
            return 0;
        }
        if (qs <= start && qe >= end) {
            return segmentSum[node];
        }
        int mid = (start + end) / 2;

        return getSum(start, mid, qs, qe, 2*node+1) + getSum(mid+1, end, qs, qe, 2*node+2);
    }

    private void update(int start, int end, int qs, int qe, int node, int val) {

    }

    private void print() {
        for (int i : segmentSum) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        SegmentTree tree = new SegmentTree(5);
        tree.construct(arr, 0, 0, 4);
        tree.print();
        System.out.println(tree.getSum(0, 4, 1, 4, 0));
    }
}
