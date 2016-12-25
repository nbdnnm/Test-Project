package general;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PairwiseFile {

    ArrayList<Object[]> result = new ArrayList<>();

    public PairwiseFile(String filePath) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                result.add(scanner.nextLine().split("\\s+"));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterator<Object[]> iterator() {
        return result.iterator();
    }
}
