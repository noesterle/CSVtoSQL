import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by nathan on 5/10/16.
 */
public class ReadFile{
    private String filePath;
    private Scanner scanner;
    public ReadFile(String file){
        filePath = file;
    }
    public String readFile(){
        String line = "";
        try {
            File file = new File(filePath);
            scanner = new Scanner(Paths.get(filePath));
            while (scanner.hasNextLine()){
                //System.out.println(scanner.nextLine());
                line = line.concat(scanner.nextLine()) + "~|";
            }
        }
        catch (Exception err){
            System.out.println(err.getMessage());
        }
        System.out.println(line);
        return line;
    }
}
