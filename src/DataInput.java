import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static void writeText(String wr) {
        if (wr != null) {
            System.out.print(wr);
        }
    }

    public static Long getLong() throws IOException {
        String s = getString();
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static Integer getInt(String wr) {
        writeText(wr);
        String s = "";
        try {
            s = getString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer value = Integer.valueOf(s);
        return value;
    }

//    public static String getString() throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        String s = br.readLine();
//
//        return s;
//    }
public static String getString() throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    String s;
    while (true) {
        s = br.readLine();
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Введіть коректне значення!");
        } else {
            break;
        }
    }
    return s;
}


    public static String getStr() {
        return null;
    }
}
