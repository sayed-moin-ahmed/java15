package com.java15.example.trywithresources;

import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        utilResources();
        multipleResources();
        customResources();
    }

    private static void utilResources() {
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("F:\\GitHub\\java15\\java15\\src\\main\\resources\\testRead.txt"))) {
            while ((line = br.readLine()) != null) {
                System.out.println("utilResources::Line =>"+line);
            }
        } catch (IOException e) {
            System.out.println("IOException in try block =>" + e.getMessage());
        }
    }

    private static void customResources() throws IOException {
        try(FileHandler fh = new FileHandler(new FileReader("F:\\GitHub\\java15\\java15\\src\\main\\resources\\testRead.txt"))){
            System.out.println("customResources::"+fh.readLine());
        }catch(IOException e){
            System.out.println("Thrown exception=>" + e.getMessage());
            Throwable[] suppressedExceptions = e.getSuppressed();
            for (int i=0; i<suppressedExceptions.length; i++) {
                System.out.println("Suppressed exception=>" + suppressedExceptions[i]);
            }
        }
    }

    private static void multipleResources() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("F:\\GitHub\\java15\\java15\\src\\main\\resources\\testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("F:\\GitHub\\java15\\java15\\src\\main\\resources\\testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }
    }
}