package TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame{
    private JMenuBar menuBar;

    public JMenuItem getNewButton() {
        return newButton;
    }

    public JMenuItem getOpenButton() {
        return openButton;
    }

    public JMenuItem getSaveButton() {
        return saveButton;
    }

    public JMenuItem getSaveAsButton() {
        return saveAsButton;
    }

    public JMenuItem getUndoButton() {
        return undoButton;
    }

    public JMenuItem getRedoButton() {
        return redoButton;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    private JMenuItem newButton;
    private JMenuItem openButton;
    private JMenuItem saveButton;
    private JMenuItem saveAsButton;
    private JMenuItem undoButton;
    private JMenuItem redoButton;
    private JTextArea textArea;
    public Gui(){
        super();
        this.setLayout(new GridBagLayout());
        this.createComponents();
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private void createComponents(){
        GridBagConstraints gbc;

        menuBar = new JMenuBar();
        addMenuBarItems();
        this.setJMenuBar(menuBar);
        gbc = new GridBagConstraints();
        textArea = new JTextArea();

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(1280, 680));
        gbc.gridy = 1;

        this.add(textArea);

    }

    private void addMenuBarItems() {
        newButton = new JMenuItem("New");
        openButton = new JMenuItem("Open");
        saveButton = new JMenuItem("Save");
        saveAsButton = new JMenuItem("Save As");
        undoButton = new JMenuItem("Undo");

        menuBar.add(new JMenu("Edit"));
        menuBar.getMenu(0).add(newButton);
        menuBar.getMenu(0).add(openButton);
        menuBar.getMenu(0).add(saveAsButton);
        menuBar.getMenu(0).add(saveButton);
        menuBar.getMenu(0).add(undoButton);
        menuBar.getMenu(0).addSeparator();
    }

    public void addListeners(ActionListener e){
        newButton.addActionListener(e);
        openButton.addActionListener(e);
        saveButton.addActionListener(e);
        saveAsButton.addActionListener(e);
        undoButton.addActionListener(e);
    }
}
