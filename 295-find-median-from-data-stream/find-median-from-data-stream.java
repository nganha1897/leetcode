class MedianFinder {
    BIT bit;
    int c;
    public MedianFinder() {
        bit = new BIT(200001);
    }
    
    public void addNum(int num) {
        bit.update(num + 100000, 1);
        c++;
    }
    
    public double findMedian() {
        if (c % 2 == 0) {
            int l=0, h=200000, first=0, second=0;
            while (l < h) {
                int m = l + (h-l)/2;
                int lessEq = bit.getSum(m);
                if (lessEq >= c/2) {
                    h=m;
                } else
                    l=m+1;
            }
            first = l-100000;

            l=0;
            h=200000;
            while (l < h) {
                int m = l + (h-l)/2;
                int lessEq = bit.getSum(m);
                if (lessEq >= c/2+1) {
                    h=m;
                } else
                    l=m+1;
            }
            second = l-100000;
            return ((double)first + second)/2;
        } else {
            int l=0, h=200000;
            while (l < h) {
                int m = l + (h-l)/2;
                int lessEq = bit.getSum(m);
                if (lessEq >= (c+1)/2) {
                    h=m;
                } else
                    l=m+1;
            }
            return l-100000;
        }
    }
}

class BIT {
    int[] bit;
    public BIT(int n) {
        bit = new int[n + 1];
    }

    public void update(int idx, int val) {
        idx++;
        while (idx < bit.length) {
            bit[idx] += val;
            idx += idx & (-idx);
        }
    }

    public int getSum (int idx) {
        int sum = 0;
        idx++;
        while (idx > 0) {
            sum += bit[idx];
            idx -= idx & (-idx);
        }
        return sum;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */