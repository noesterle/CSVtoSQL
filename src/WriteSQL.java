import java.io.*;
import java.util.ArrayList;

/**
 * Created by nathan on 5/10/16.
 */
public class WriteSQL {
    ArrayList <String[]> contents;
    String filename = "sql.txt";
    public WriteSQL(ArrayList <String[]> arrayList){
        contents = arrayList;
    }

    public void write(){
        File file;
        System.out.println("Gonna write");
        try {
            System.out.println("In Try");
            file = createFile(filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Writer w = new BufferedWriter(outputStreamWriter);
            w.write("hi");
            w.close();
        }
        catch (Exception err){
            System.out.println("In catch");
            err.printStackTrace();
        }
    }

    public File createFile(String filename){
        return new File(filename);
    }
}
