import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Prompt for a directory or file.
        System.out.println("Enter a directory or file");
        Scanner file_input = new Scanner(System.in);
        String directory = file_input.nextLine();

        //Display size
        System.out.println(getSize(new File(directory)) + " bytes");
        System.out.println(getCount(new File(directory)) + " files");
    }

    public static long getSize(File file) {
        long size = 0; //Total stored size of all files.

        if (file.isDirectory()) { // Determine if input is a directory or not.
            File[] files = file.listFiles(); //All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); // Recursive call
            }
        } else { // Base case
            size += file.length();
        }
        return size;
    }

    /*Prompt the user to enter a directory and displays the number of files in the directory. */

    /**
     * Check if input is a file.
     * If it is a file create a File object of the directory length
     * Check each sub-directory of the input.
     * Incriment the count for each file.
     *
     * @param file
     * @return
     */
    public static long getCount(File file) {

        long count = 0; //Total count of all files
        File[] fileCount;
        if (file.isDirectory()) {
            File[] files = file.listFiles(); // all files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                count += getCount(files[i]);
            }

        } else if (file.isDirectory()) {
            count++;
        }


        return count;
    }
}