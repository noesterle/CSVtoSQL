import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by nathan on 5/10/16.
 */
public class Main {
    public static void main(String[] args) {
        String file = "test.txt";
        String arr[];
        ArrayList <String[]> sql = new ArrayList<String[]>();
        String delim = "[~|]+";
        String temp[];
        ReadFile read = new ReadFile(file);
        WriteSQL write;
        String contents = read.readFile();
        arr = contents.split(delim);
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i].split(",");
            sql.add(temp);
        }
        write = new WriteSQL(sql);
        write.write();
    }
}
