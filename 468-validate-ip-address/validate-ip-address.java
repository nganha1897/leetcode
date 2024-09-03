class Solution {
    // public String validIPAddress(String queryIP) {
    //     if (queryIP == null)
    //         return "Neither";

    //     int len = queryIP.length();
    //     if (len == 0) {
    //         return "Neither";
    //     }

    //     if (queryIP.indexOf(".") != -1 && queryIP.indexOf(":") != -1) {
    //         return "Neither";
    //     }
        
    //     if (queryIP.charAt(0) == '.' || queryIP.charAt(0) == ':' || 
    //     queryIP.charAt(len-1) == '.' || queryIP.charAt(len-1) == ':') {
    //         return "Neither";
    //     }
    //     String[] ipv4 = queryIP.split("\\.");
    //     if (isIPv4(ipv4)) {
    //         return "IPv4";
    //     }
    //     String[] ipv6 = queryIP.split(":");
    //     if (isIPv6(ipv6)) {
    //         return "IPv6";
    //     }
    //     return "Neither";
    // }

    // private boolean isIPv4(String[] ip) {
    //     if (ip.length != 4) {
    //         return false;
    //     }

    //     for (String p : ip) {
    //         if (p == null || p.length() == 0 || p.length() > 3) {
    //             return false;
    //         }

    //         if (p.charAt(0) == '0' && p.length() > 1) {
    //             return false;
    //         } 
    //         for (char c : p.toCharArray()) {
    //             if (c < '0' || c > '9') {
    //                 return false;
    //             }
    //         }

    //         if (Integer.valueOf(p) > 255) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // private boolean isIPv6(String[] ip) {
    //     if (ip.length != 8) {
    //         return false;
    //     }

    //     for (String p : ip) {
    //         if (p == null || p.length() < 1 || p.length() > 4) {
    //             return false;
    //         }

    //         for (char c : p.toCharArray()) {
    //             if ((c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F')) {
    //                 return false;
    //             }
    //         }
    //     }

    //     return true;
    // }

      public static String validIPAddress(String IP) {
        String[] ipv4 = IP.split("\\.",-1);
        String[] ipv6 = IP.split("\\:",-1);
        if(IP.chars().filter(ch -> ch == '.').count() == 3){
            for(String s : ipv4) if(isIPv4(s)) continue;else return "Neither"; return "IPv4";
        }
        if(IP.chars().filter(ch -> ch == ':').count() == 7){
            for(String s : ipv6) if(isIPv6(s)) continue;else return "Neither";return "IPv6";
        }
        return "Neither";
    }
    public static boolean isIPv4 (String s){
         try{ return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;}
         catch (NumberFormatException e){return false;}
    }
    public static boolean isIPv6 (String s){
        if (s.length() > 4) return false;
        try {return Integer.parseInt(s, 16) >= 0  && s.charAt(0) != '-';}
        catch (NumberFormatException e){return false;}
    }
}