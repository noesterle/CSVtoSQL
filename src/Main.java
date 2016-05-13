import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by nathan on 5/10/16.
 */
public class Main {
    /**
     * Reads in a CSV file, separates the info into an Arraylist of string arrays,
     * and writes the sql statements to a file.
     *
     * @param args
     */
    public static void main(String[] args) {
        String file = "test.txt"; //File to read data from.
        String arr[];
        ArrayList <String[]> sql = new ArrayList<>(); //Contains data from file, keeping existing structure.
        String lineDelim = "[~|]+";
        String infoDelim = ",";
        String temp[];
        ReadFile read;
        WriteSQL write;

        read= new ReadFile(file);
        String contents = read.readFile(); //Reads file, creating one long string of information.
                                            // Lines are separated by a "~|". Info within the line is seperated by ",".
        arr = contents.split(lineDelim);
        for (int i = 0; i < arr.length; i++) { //Take the long string, break it up, putting it into the arraylist.
            temp = arr[i].split(infoDelim);
            sql.add(temp);
        }
        write = new WriteSQL(sql);
        write.write(); //Write the content of the arraylist to a file.
    }
}
