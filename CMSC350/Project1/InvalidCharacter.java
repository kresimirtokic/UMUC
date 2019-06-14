import javax.swing.JOptionPane;

public class InvalidCharacter extends Exception {
	InvalidCharacter(){
		JOptionPane warningMessage = new JOptionPane();
		JOptionPane.showMessageDialog(warningMessage, "Please Enter digits 0-9 and */+-()");
		
	}
}
