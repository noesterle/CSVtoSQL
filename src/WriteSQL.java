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

    /**
     * Establishes connection with file and writes sql statements to file.
     */
    public void write(){
        File file;
        try {
            file = createFile(filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Writer w = new BufferedWriter(outputStreamWriter);
            String header = createTable(contents); //Creates a string that will create the table.
            String inserts = inserts(contents); //Creates a string that will be all the insert statements.

            w.write(header); //Write create table statement to file.
            w.write(inserts); //Write the insert statements to file.
            w.close(); //Close connection with file.
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    /**
     * Creates or establishes connection with the file.
     *
     * @param filename - name of file to connect to.
     * @return File object
     */
    public File createFile(String filename){
        return new File(filename);
    }

    /**
     *
     * Generates CREATE TABLE statement.
     *
     * @param contents - An arraylist of String arrays containing data to be written in sqlite3 file.
     * @return template - A string containing CREATE TABLE statement for sqlite3 file.
     */
    public String createTable(ArrayList <String[]> contents){
        String[] header = contents.get(0);
        String template = "CREATE TABLE tabl(";
        for (String str:header) {
            template = template + str + " none, ";
        }
        template = template.substring(0,template.length()-2) + ");\n";
        return template;
    }

    /**
     *
     * Generates insert statements for sqlite3 file.
     *
     * @param contents - Arraylist of string arrays containing data for sqlite3 file.
     * @return insertStatements - A string of all insert statements for the sqlite3 file.
     */
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
