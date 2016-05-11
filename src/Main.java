/**
 * Created by nathan on 5/10/16.
 */
public class Main {
    public static void main(String[] args) {
        String file = "test.txt";
        ReadFile read = new ReadFile(file);
        //WriteSQL write = new WriteSQL();
        String contents = read.readFile();
        //System.out.println(contents);
        //System.out.println(write.write());
    }
}
