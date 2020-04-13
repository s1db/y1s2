package oose.w2;

import java.io.File;

import javax.swing.JFileChooser;

public class Driver {
	public static void main(String []args) {
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("SelectFile");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    		File selectedFile = chooser.getSelectedFile();
	    		new Util().customCharReader(selectedFile, 7);
	    } 
	    else {
	      System.out.println("No Selection ");
	    }
	}
}
