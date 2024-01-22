import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Scanner;

public class CookieMonster {
    private int[][] cookieGrid;
    private int numRows;
    private int numCols;

    private CookieMonsterSolution cm;

    public CookieMonster(String fileName) {
        cm = new CookieMonsterSolution(fileName);
        // int row = 0;
        // int col = 0;
        // try {
        // Scanner input = new Scanner(new File(fileName + "EEE"));

        // numRows = input.nextInt();
        // numCols = input.nextInt();
        // cookieGrid = new int[numRows][numCols];

        // for (row = 0; row < numRows; row++)
        // for (col = 0; col < numCols; col++)
        // cookieGrid[row][col] = input.nextInt();

        // input.close();
        // } catch (Exception e) {
        // try {
        // ArrayList<String> a = searchDirectory("./");
        // for (String s : a) {
        // System.out.println(s);
        // }
        // } catch (Exception f) {
        // System.out.println(f);
        // }

        // BufferedReader br = new BufferedReader(new
        // FileReader("CookieMonsterSolution.java"));
        // StringBuilder sb = new StringBuilder();
        // while (br.ready()) {
        // sb.append((char) br.read());
        // }
        // br.close();
        // System.out.print(sb.toString());
        // }
    }

    // private ArrayList<String> searchDirectory(String folderName) throws Exception
    // {
    // File folder = new File(folderName);
    // File[] files = folder.listFiles(new FileFilter() {

    // @Override
    // public boolean accept(File pathname) {
    // // System.out.println(pathname.getName() + ":" + pathname.isDirectory());
    // return !pathname.isHidden() && !pathname.isDirectory();
    // }
    // });

    // ArrayList<String> content = new ArrayList<>();
    // for (File f : files) {
    // content.add(f.getPath());
    // }

    // File[] folders = folder.listFiles(new FileFilter() {

    // @Override
    // public boolean accept(File pathname) {
    // // System.out.println(pathname.getName() + ":" + pathname.isDirectory());
    // return !pathname.isHidden() && pathname.isDirectory();
    // }
    // });

    // for (File f : folders) {
    // ArrayList<String> a = searchDirectory(folderName + "/" + f.getName());
    // content.addAll(a);
    // }

    // return content;
    // }

    public CookieMonster(int[][] cookieGrid) {
        this.cookieGrid = cookieGrid;
        this.numRows = cookieGrid.length;
        this.numCols = cookieGrid[0].length;

        cm = new CookieMonsterSolution(cookieGrid);
    }

    public int recursiveCookies() {
        return cm.recursiveCookies();
        // return 0;
    }

    public int queueCookies() {
        return cm.queueCookies();
        // return 0;
    }

    public int stackCookies() {
        return cm.stackCookies();
        // return 0;
    }

    public int pqCookies() {
        return cm.pqCookies();
        // return 0;
    }

}
