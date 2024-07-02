package sec02;

public class Practice {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
				};
		
		int sum = 0;
		double avg = 0.0;
		
		for(int i=0; i<array.length; i++ ) {
			for(int k=0; k<array[i].length; k++) {
				sum += array[i][k];
				}
		}
		int a = (array[0].length + array[1].length +array[2].length);
		avg = (avg + sum) / a;
		System.out.println(sum);		
		System.out.println(avg);
	}
}