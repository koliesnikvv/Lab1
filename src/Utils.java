public class Utils {
    public static String formatEntityName(String source) {
        int state = 0;
        String result = "";
        for (int i = 0, len = source.length(); i < len; i++) {
            char c = source.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (state == 0) {
                    c = Character.toUpperCase(c);
                    state = 1;
                } else if (state == 1)
                    c = Character.toLowerCase(c);
                else if (state == 2)
                    state = 1;
                result += c;
            } else if (c == ' ' && state == 1) {
                result += c;
                state = 2;
            }
        }
        return result;
    }

    public static String formatPersonName(String source) {
        boolean foundLetter = false;
        String result = "";
        for (int i = 0, j = 0, len = source.length(); i < len; ++i) {
            char c = source.charAt(i);
            if (Character.isAlphabetic(c)) {
                foundLetter = true;
                if (j == -1) j = 0;
                if (j == 0) c = Character.toUpperCase(c);
                else c = Character.toLowerCase(c);
                result += c;
                ++j;
            } else {
                if (c == '-' && j != -1 && foundLetter && i < len - 1) {
                    result += c;
                    j = -1;
                }
            }
        }
        return result;
    }

    public static boolean containsIgnoreCase(String source, String query) {
        if (source == null || query == null) return false;
        if (source.compareToIgnoreCase(query) == 0) return true;
        int state = 0;
        for (int i = 0, j = 0, lenA = source.length(), lenB = query.length(); i < lenA && state < 1; ++i) {
            char a = Character.toLowerCase(source.charAt(i));
            char b = Character.toLowerCase(query.charAt(j));
            if (a == b) {
                if (lenB == 1 || j == lenB - 1)
                    state = 1;
                else
                    ++j;
            } else j = 0;
        }
        return state == 1;
    }
}
