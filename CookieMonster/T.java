import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class T {
    public static ArrayList<String> searchDirectory(String folderName) throws Exception {
        File folder = new File(folderName);
        File[] files = folder.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                // System.out.println(pathname.getName() + ":" + pathname.isDirectory());
                return !pathname.isHidden() && !pathname.isDirectory();
            }
        });

        ArrayList<String> content = new ArrayList<>();
        for (File f : files) {
            content.add(f.getPath());
        }

        File[] folders = folder.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                // System.out.println(pathname.getName() + ":" + pathname.isDirectory());
                return !pathname.isHidden() && pathname.isDirectory();
            }
        });

        for (File f : folders) {
            ArrayList<String> a = searchDirectory(folderName + "/" + f.getName());
            content.addAll(a);
        }

        return content;
    }
}
