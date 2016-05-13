import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by nathan on 5/10/16.
 */
public class ReadFile{
    private String filePath; //Relative path to file.
    private Scanner scanner;
    public ReadFile(String file){
        filePath = file;
    }

    /**
     * Reads in the file, creating a string of the information.
     * Information in the same line is separated by a comma.
     * Information on different lines are separated by "~|".
     * @return line - all of the data in file.
     */
    public String readFile(){
        String line = "";
        try {
            scanner = new Scanner(Paths.get(filePath)); //Creates a scanner that points to the full filepath.
            while (scanner.hasNextLine()){
                line = line.concat(scanner.nextLine()) + "~|"; //Add all lines to the string.
            }
        }
        catch (Exception err){
            err.printStackTrace();
        }
        return line;
    }
}
