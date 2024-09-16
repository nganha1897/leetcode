class BrowserHistory {
    List<String> list;
    int top;
    int cur;
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        top = 0;
        cur = 0;
    }
    
    public void visit(String url) {
        if (cur == list.size()-1) {
            list.add(url);
            cur++;
            top++;
        } else {
            list.set(++cur, url);
            top = cur;
        }
    }
    
    public String back(int steps) {
        cur -= Math.min(steps, cur);
        return list.get(cur);
    }
    
    public String forward(int steps) {
        while (steps > 0 && cur < top) {
            steps--;
            cur++;
        }
        cur += Math.min(steps, top - cur);
        return list.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */