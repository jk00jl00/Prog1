package TextEditor;

import javafx.stage.FileChooser;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.*;

public class Controller {
    private Gui gui;
    private File currentFile;
    private boolean isSaved;

    public Controller(){
        gui = new Gui();
        gui.addListeners(e -> {
            final JFileChooser fc = new JFileChooser();
            if(e.getSource() == gui.getNewButton()){
                if (isSaved) {
                    gui.getTextArea().setText("");
                    currentFile = null;
                } else{
                    int answer = JOptionPane.showConfirmDialog(null,
                            "Do you wish to save?",
                            "Save?",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if(answer == JOptionPane.YES_OPTION){
                        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                            save(fc.getSelectedFile());
                            gui.getTextArea().setText("");
                            currentFile = null;
                        }
                    } else if(answer == JOptionPane.NO_OPTION){
                        gui.getTextArea().setText("");
                        currentFile = null;
                    }
                }
            } else if(e.getSource() == gui.getSaveAsButton()){
                if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                    save(fc.getSelectedFile());
                    currentFile = fc.getSelectedFile();
                }
            } else if(e.getSource() == gui.getSaveButton()){
                if(currentFile != null){
                    save();
                } else{
                    if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                        save(fc.getSelectedFile());
                        currentFile = fc.getSelectedFile();
                    }
                }
            } else if(e.getSource() == gui.getOpenButton()){
                if(isSaved){
                    if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        try {
                            gui.getTextArea().setText(readFile(fc.getSelectedFile()));
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    private String readFile(File file) throws FileNotFoundException{
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null){
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();

        } catch (IOException e){
            throw new FileNotFoundException();
        }
    }

    private void save(){
        this.save(currentFile);
    }
    private void save(File file){
        try(FileWriter fw = new FileWriter(file)){
            String text = gui.getTextArea().getText().replace("\n", "\r\n");
            fw.write(text);
        } catch (IOException e) {
            System.out.println("No file found");
        }
    }

}
