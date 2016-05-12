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
        try {
            file = createFile(filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Writer w = new BufferedWriter(outputStreamWriter);
            String header = createTable(contents);
            String inserts = inserts(contents);

            /*for (String arr[]:contents) {
                for (String str: arr) {
                    w.append(str+" ");
                }
            }*/
            w.write(header);
            w.write(inserts);
            w.close();
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    public File createFile(String filename){
        return new File(filename);
    }

    public String createTable(ArrayList <String[]> contents){
        String[] header = contents.get(0);
        String template = "CREATE TABLE tabl(";
        for (String str:header) {
            template = template + str + " none, ";
        }
        template = template.substring(0,template.length()-2) + ");\n";
        return template;
    }

    public String inserts(ArrayList <String[]> contents){
        String templateBeginning;
        String insertStatements = "";
        String seperator = "', '";
        for (int i = 1; i < contents.size(); i++) {
            templateBeginning = "insert into tabl values ('";
            for (String str:contents.get(i)) {
                templateBeginning = templateBeginning + str + seperator ;
            }
            insertStatements += templateBeginning.substring(0,templateBeginning.length()-3) + ");\n";
        }
        return insertStatements;
    }
}
