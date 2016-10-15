import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Mouse extends MouseAdapter {
	int counter = 0;
	int[] mineArrayX = CreateMines.mineCreatorX();
	int[] mineArrayY = CreateMines.mineCreatorY();
	int[] dummyArrayX = CreateMines.arrayCreator();
	int[] dummyArrayY = CreateMines.arrayCreator();
	final int rows = 9;
	final int columns = 9;

	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1: // Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyGrid myPanel = (MyGrid) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3: // Right mouse button
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame) c2;
			MyGrid myPanel2 = (MyGrid) myFrame2.getContentPane().getComponent(0);
			Insets myInsets2 = myFrame2.getInsets();
			int x2 = myInsets2.left;
			int y2 = myInsets2.top;
			e.translatePoint(-x2, -y2);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			myPanel2.mouseDownGridX = myPanel2.getGridX(x3, y3);
			myPanel2.mouseDownGridY = myPanel2.getGridY(x3, y3);
			myPanel2.repaint();
			break;
		default: // Some other button (2 = Middle mouse button, etc.)
			// Do nothing
			break;
		}
	}

	public void mouseReleased(MouseEvent e) {
		Color newColor = null;

		switch (e.getButton()) {

		case 1: // Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyGrid myPanel = (MyGrid) myFrame.getContentPane().getComponent(0);

			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);

			if (counter == 0) {
				for (int i = 0; i < rows; i++) {
					if ((mineArrayX[i] == myPanel.mouseDownGridX) && (mineArrayY[i] == myPanel.mouseDownGridY)
							&& (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] != Color.RED)) {
						for (int j = 0; j < columns; j++) {
							myPanel.colorArray[mineArrayX[j]][mineArrayY[j]] = Color.BLACK;
							myPanel.repaint();
							counter++;
						}
						myFrame.repaint();
						try {
							Thread.sleep(25);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "Game Over! Better luck next time!");
						System.exit(0);

					}
				}
			}

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				// Had pressed outside
				// Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					// Is releasing outside
					// Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing
					} else {
						// Released the mouse button on the same cell where it
						// was pressed
						if (myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] != Color.BLACK
								&& myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] != Color.RED) {
							Color wColor = Color.WHITE;

							do {
								newColor = Color.LIGHT_GRAY;
							} while (newColor.equals(wColor));
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();

						}

					}

				}

			}

			break;
		case 3: // Right mouse button
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame) c2;
			MyGrid myPanel2 = (MyGrid) myFrame2.getContentPane().getComponent(0); // Can
																					// also
																					// loop
																					// among
																					// components
																					// to
																					// find
																					// MyPanel
			Insets myInsets2 = myFrame2.getInsets();
			int x2 = myInsets2.left;
			int y2 = myInsets2.top;
			e.translatePoint(-x2, -y2);
			int x3 = e.getX();
			int y3 = e.getY();
			myPanel2.x = x3;
			myPanel2.y = y3;
			int gridX2 = myPanel2.getGridX(x3, y3);
			int gridY2 = myPanel2.getGridY(x3, y3);

			if ((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)) {
				// Had pressed outside
				// Do nothing
			} else {
				if ((gridX2 == -1) || (gridY2 == -1)) {
					// Is releasing outside
					// Do nothing
				} else {
					if ((myPanel2.mouseDownGridX != gridX2) || (myPanel2.mouseDownGridY != gridY2)) {
						// Released the mouse button on a different cell where
						// it was pressed
						// Do nothing
					} else {
						// Released the mouse button on the same cell where it
						// was pressed
						if (myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] == Color.WHITE) {

							Color wColor = Color.WHITE;

							do {
								newColor = Color.RED;
							} while ((newColor.equals(wColor)));

							myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] = newColor;
							myPanel2.repaint();

						} else {
							if (myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] == Color.RED) {
								do {
									newColor = Color.WHITE;
								} while ((newColor.equals(Color.RED)));

								myPanel2.colorArray[myPanel2.mouseDownGridX][myPanel2.mouseDownGridY] = newColor;
								myPanel2.repaint();
							}
						}
					}

				}
			}
			break;
		default: // Some other button (2 = Middle mouse button, etc.)
			// Do nothing
			break;
		}

	}

}
