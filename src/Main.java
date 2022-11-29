import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";


        try
        {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                Scanner ins;
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                ins = new Scanner(selectedFile);
                while(ins.hasNextLine())
                {
                    line = ins.nextLine();
                    System.out.println(line);
                    lineCount++;
                    charCount += line.length();
                    String words[] = line.split(" ");
                    wordCount  += words.length;
                }
                reader.close();

                System.out.println("Total lines: " + lineCount);
                System.out.println("Total characters: " + charCount);
                System.out.println("Total words: " + wordCount);
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}