import org.ho.yaml.YamlEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class FileGenerator {

    public static final String FILE_NAME = "file.txt";
    public static final int MAX_ARRAY_LENGTH = 50;

    public static void main(String[] args) throws IOException {

        Integer[] integers = generator();

        System.out.println("Numbers was successfully generated");
        writeToFile(integers);

        System.out.println("... and writed to file.");
    }

    public static Integer[] generator() {

        Random random = new Random(System.nanoTime());

        int length = random.nextInt(MAX_ARRAY_LENGTH) + 2;

        // Use HashSet to produce a set of unique numbers
        HashSet<Integer> hashSet = new HashSet();

        while (hashSet.size() < length) {
            hashSet.add(random.nextInt());
        }

        // Double it at the List
        List<Integer> list = new ArrayList<>(hashSet);
        list.addAll(list);

        // And remove random element
        list.remove(random.nextInt(list.size()));

        Integer[] result = new Integer[list.size()];
        list.toArray(result);
        return result;
    }

    public static void writeToFile(Integer[] numbers) throws IOException {

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream out = new FileOutputStream(file);
        YamlEncoder enc = new YamlEncoder(out);
        enc.writeObject(numbers);
        enc.close();
        out.close();
    }
}
