package smith;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A Class to allows strings to be written to file "output.txt"
 * If file does not already exist it is created.
 *
 * @author Hunter Smith
 */
public class FileWriter {

    /**
     * Appends a string to file.
     *
     * @param str the str
     */
    public static void writeToFile(String str) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter("Output.txt", true))) {
            writer.write(str+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
