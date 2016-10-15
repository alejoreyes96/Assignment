
public class CreateMines extends Mouse {

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
			

		}
		return a;
	}
	public static int[] arrayCreator(){
		int[] a = new int[9];
		for (int i = 0; i<9; i++){
				a[i] = i;
			}
		
	return a;
	}

		/*public boolean setBombsX(){
			int i =0;
			int j =0;
			if(dummyArrayX[i])
				
			
			return false;
			
		}
	public boolean setBombsY(){
			
			return false;
			
		}*/
}
	


	
	
		
		
	
		
		
	
