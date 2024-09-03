class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP == null)
            return "Neither";

        int len = queryIP.length();
        if (len == 0) {
            return "Neither";
        }

        if (queryIP.indexOf(".") != -1 && queryIP.indexOf(":") != -1) {
            return "Neither";
        }
        
        if (queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':' || 
        queryIP.charAt(len-1) == '.' || queryIP.charAt(len-1) == ':') {
            return "Neither";
        }
        String[] ipv4 = queryIP.split("\\.");
        if (isIPv4(ipv4)) {
            return "IPv4";
        }
        String[] ipv6 = queryIP.split(":");
        if (isIPv6(ipv6)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String[] ip) {
        if (ip.length != 4) {
            //System.out.println(1);
            return false;
        }

        for (String p : ip) {
            if (p == null || p.length() == 0) {
                //System.out.println(2);
                return false;
            }
            int len = p.length();
            if (len > 3) {
                //System.out.println(3);
                return false;
            }

            if (p.charAt(0) == '0' && p.length() > 1) {
                //System.out.println(p + " " + p.length());
                //System.out.println(4);
                return false;
            } 
            for (char c : p.toCharArray()) {
                if (c < '0' || c > '9') {
                    //System.out.println(5);
                    return false;
                }
            }
            int cur = Integer.valueOf(p);
            if (cur > 255) {
                //System.out.println(6);
                return false;
            }
        }
        return true;
    }

    private boolean isIPv6(String[] ip) {
        if (ip.length != 8) {
            return false;
        }

        for (String p : ip) {
            if (p == null || p.length() == 0) {
                return false;
            }
            int len = p.length();
            if (len < 1 || len > 4) {
                return false;
            }
            for (char c : p.toCharArray()) {
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
                    return false;
                }
            }
        }

        return true;
    }
}