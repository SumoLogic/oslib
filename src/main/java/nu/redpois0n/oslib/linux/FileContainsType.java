package nu.redpois0n.oslib.linux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileContainsType extends SearchType {

    private final File file;
    private final String needle;

    public FileContainsType(String file, String needle) {
        this(new File(file), needle);
    }

    public FileContainsType(File file, String needle) {
        this.file = file;
        this.needle = needle;
    }

    @Override
    public boolean detect() {
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.toLowerCase().contains(needle.toLowerCase())) {
                        reader.close();
                        return true;
                    }
                }

                reader.close();
            } catch (Exception ex) {
                System.out.println("(oslib.linux.FileContainsType) cmd=" + file.toString() + " > " + ex.getMessage());
            }
        }

        return false;
    }

}
