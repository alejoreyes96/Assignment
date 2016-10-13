
public class CreateMines {

	public static int[] mineCreatorX() {
		int[] a = new int[9];
		for (int i = 0; i < 9; i++) {
			a[i] = (int) (Math.random() * 9);
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--; 
					break;

				}

			}

		}
		return a;
	}
	public static int[] mineCreatorY() {
		int[] a = new int[9];
		for (int i = 0; i < 9; i++) {
			a[i] = (int) (Math.random() * 9);
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--; 
					break;

				}

			}

		}
		return a;
	}
}
	
	
		
		
	
		
		
	
