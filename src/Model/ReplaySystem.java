
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReplaySystem {
    public  static String[] segments = null;
    public static Player player1 ;
    public static Player player2 ;
    public static   int numOfMoves ; 
    public static   String winningLine ;
    private static int location = 2;
    public static File[] readALLFiles() {
        String directoryPath = "C:\\Dev\\Java\\TicTacToeJavaFX\\src\\local_matches";

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line = br.readLine();
                        if (line != null) {
                            String[] segments = line.split("~");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.err.println("No files found in the directory.");
        }
        return files;
    }

    public static void initReplaySystem(File f){
        File directory;
      
       
        directory = new File("C:\\Dev\\Java\\TicTacToeJavaFX\\src\\local_matches\\LocalTwoPlayers_2024-07-24-12-26-43.txt");
        
        
                    try (BufferedReader br = new BufferedReader(new FileReader(directory))) {
                        String line = br.readLine();
                        if (line != null) {
                            segments = line.split("~");
                        
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               
                        
                        
              player1 = new Player(1);   
              player2 = new Player(0);
              numOfMoves =   Integer.valueOf(segments[0]);
              winningLine= segments[1];
    }
    
    static public String playMove(){   
       
         
       return segments[location++];
      
    
    
    
}}