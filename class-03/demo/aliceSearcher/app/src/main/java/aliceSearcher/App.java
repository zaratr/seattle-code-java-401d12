/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package aliceSearcher;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        // safety check for DIR!!!
        System.out.println("My current directory is: " + System.getProperty("user.dir"));

        // PD: How many times does "Alice" show up in alice_in_wonderland.txt
        // first, we have to read(access) the file
        // read through it,
        // we can keep track of Alice instances

        Path alicePath = Paths.get("alice_in_wonderland.txt");
        // what is toAbsolutePath()?
        System.out.println("Alice Path: " + alicePath.toAbsolutePath());

        Scanner aliceScanner = null;

        try {
            aliceScanner = new Scanner(alicePath);
        } catch (IOException ioe) {
            System.out.println("That file cannot be scanned/found, File path is: " + alicePath.toAbsolutePath());
            ioe.printStackTrace();
            System.exit(1);
        } finally { // ALWAYS EXECUTES
            System.out.println("This happened Finally");
        }

        HashMap<String, Integer> characterCountMap = new HashMap<>();
        String[] literaryCharacters = {"Alice", "Zork", "Cat"};

        System.out.println("REad next line: " + aliceScanner.nextLine());
        String characterName = "Alice";
        while(aliceScanner.hasNextLine()){
            String currentLine = aliceScanner.nextLine();
//            System.out.println("CurrentLine: " + currentLine);
            // if current line contains "Alice", add/update hashmap
            if(currentLine.contains(characterName)){
                System.out.println("Line contains alice");
                Integer nameValue = characterCountMap.get(characterName);
                System.out.println("Name value: " + nameValue);
                if(nameValue == null) {
                    characterCountMap.put(characterName, 1);
                }
                System.out.println("");
            }


        }


    }
}
