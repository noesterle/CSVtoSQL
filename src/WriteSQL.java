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
            System.out.println("In catch");
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
        //System.out.println(template);
        return template;
    }

    public String inserts(ArrayList <String[]> contents){
        String templateBeginning;
        String insertStatements = "";
        String seperator = "', '";
        for (int i = 1; i < contents.size(); i++) {
            templateBeginning = "insert into tabl values ('";
            System.out.println(contents.get(i)[0]);
            for (String str:contents.get(i)) {
                templateBeginning = templateBeginning + str + seperator ;
                System.out.println(templateBeginning);
            }
            insertStatements += templateBeginning.substring(0,templateBeginning.length()-3) + ");\n";
            System.out.println(insertStatements);
        }
        return insertStatements;
    }
}
