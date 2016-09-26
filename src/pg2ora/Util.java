/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pg2ora;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 *
 * @author hanif
 */
public class Util {    

    private static String getDirectory (String path) {
        String pattern = Pattern.quote(System.getProperty("file.separator"));
        String[] dirs = path.split (pattern);
        String directory = "";
        
        int dirsLength = dirs.length-1;
        for (int i=0; i<dirsLength; i++) {
            directory += dirs[i]; 
            directory += "\\";
        }

        return directory;
    }
    
    public static String getFileFromDialog(JComponent component) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(component) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getPath();
        }
        return null;
    }
    
    public static boolean createAFile (String path) {                  
        String dirpath = Util.getDirectory(path);
        
        File directory = new File(dirpath);        
        if (directory.exists() == false) {
            directory.mkdirs();
        }
        
        if (directory.exists()) {            
            File file = new File(path);
            
            if (!file.exists()) {
                try {
                    if (file.createNewFile()) {                    
                        return true;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(UIDump.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else return true;
        }
        return false;
    }
    
    public static void resetFile (String path) {
        File file = new File(path);
        if (file.exists()) file.delete();
    }
    
    public static boolean writeToAFile (String path, String content) {                
        try (FileWriter fw = new FileWriter(new File(path), true)) {
            fw.write(content);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
