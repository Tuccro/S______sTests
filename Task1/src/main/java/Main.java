import org.ho.yaml.YamlDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String FILE_NAME = "file.txt";

    public static void main(String[] args) throws IOException {

        Integer[] numbers = readFromFile();

        if (numbers != null) {
            System.out.println(findSingle(numbers));
        }
    }

    public static int findSingle(Integer[] numbers) {
        List<Integer> list = new ArrayList<>();

        // In this cycle paired numbers will be added to the List, and then removed
        // Number that hasn't a pair will remain
        for (Integer number : numbers) {
            if (list.contains(number)) {
                list.remove(number);
            } else list.add(number);
        }
        // Check result
        if (list.size() == 1) {
            return list.get(0);
        } else {
            System.out.println("Error: incorrect input file.");
            return 0;
        }
    }
    
    public static Integer[] readFromFile() throws IOException {
        File file = new File(FILE_NAME);

        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            YamlDecoder decoder = new YamlDecoder(in);
            return (Integer[]) decoder.readObject();
        } else {
            System.out.println("Error: File isn't exists");
            return null;
        }
    }
}
