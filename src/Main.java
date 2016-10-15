import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("Mine Sweeper");
		JButton refresh = new JButton("Refresh");
		
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);
		MyGrid myPanel = new MyGrid();
		myFrame.add(myPanel);
		myPanel.add(refresh);

		Mouse myMouseAdapter = new Mouse();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
	}
}