import java.util.*;
import java.util.*;
public class TSP {

	public static int [] minRow(int [][] arr) {
		int min = 0;
		int []  tempRow = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			 min = arr[i][0];
			for (int j = 0; j < arr.length; j++) {
				if ( min > arr[i][j] )
				   min = arr[i] [j];
			}
			tempRow[i] = min;
		}
		return tempRow;
	}

	public static int [] minCol(int [][] arr) {
		int min = 0;
		int []  tempCol = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			 min = arr[0][i];
			for (int j = 0; j < arr.length; j++) {
				if ( arr[j][i] < min )
				   min = arr[j] [i];
			}
			tempCol[i] = min;
		}	
		return tempCol;
	}

	public static int rowReduction(int [][] arr) {
		int [] minRow = new int[arr.length];

		int count = 0;
		for (int a : minRow(arr)) {
			if ( count < arr.length )
				minRow[count] = a;
			count++;
		}

		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr.length; j++) {
				if ( minRow[i] > 500) {
					arr[i][j] = arr[i][j] - 0;
				}
				else 
					arr[i][j] = arr[i][j] - minRow[i];
			}
		}
		return 1;
	}

	public static int colReduction(int [][] arr) {
		int [] minCol = new int[arr.length];
		
		int count = 0;
		for (int a : minCol(arr)) {
			if ( count < arr.length)
				minCol[count] = a;
			count++;
		}

			for (int i = 0; i < arr.length; i++) { 
				for (int j = 0; j < arr.length; j++) {
					if (minCol[i] > 500)
						arr[j][i] = arr[j][i] - 0;
					else
						arr[j][i] = arr[j][i] - minCol[i];
			}
		}
		return 2;
	}

	public static void printArray(int [][] arr) {
		System.out.printf("%n");
				for (int i = 0; i < arr.length; i++) { 
					for (int j = 0; j < arr.length; j++) 
						System.out.print(arr[i][j] + "\t");

				System.out.println();
				}
				System.out.printf("%n%n");
	}


	public static void totalCost(int [] minRow, int [] minCol, int prevReducedCost, int costAt) {
		int totalReducedCost = 0;
		for (int a : minRow)
			if (a < 500)
				totalReducedCost += a; 
			
			//System.out.println("------------------->>>>>>>>>>>  " + a);

			for (int b : minCol) 
				if ( b < 500)
					totalReducedCost += b;

			//System.out.println("------------------->>>>>>>>>>>  " + a);

		// for (int i = 0; i < minRow.length; i++) {
		// 	if (minRow[i] < 500 ||  minCol[i] < 500) 		
		// 		totalReducedCost += minCol[i] + minRow[i];
		// }
		System.out.println("Reduced cost of matrix " + totalReducedCost);
		int cost = prevReducedCost + totalReducedCost + costAt;
		System.out.printf("cost of matrix is [ prevReducedCost (%d) + totalReducedCost (%d) + costAt(%d) == %d] %n",
													 prevReducedCost, totalReducedCost, costAt, cost);
	}

	public static void main(String...adsf) {
		 int [][] arr 	= {{999, 4, 12, 7}, {5, 999, 999, 18}, {11, 999, 999, 6}, {10, 2, 3, 999}};
		//int [][] arr = {{999, 7, 3, 12, 8}, {3, 999, 6, 14, 9}, {5, 8 , 999, 6, 18}, {9, 3, 5, 999, 11}, {18, 14, 9, 8, 999}};
		int [] minRowElements = new int [arr.length];
		int [] minColElements = new int [minRowElements.length];

		int count = 0;
		int infinity = 999;
		//int l  		 = 1;
		
		System.out.println("Array at Starting....");
		printArray(arr);


		// for ( int i : minRow(arr) )
		// 	minRowElements[count++] = i;
		
		// System.out.println("Row Reduction ");
		// rowReduction(arr);
		// printArray(arr);

		// count = 0;
		// for ( int i : minCol(arr) )
		// 	minColElements[count++] = i;

		// System.out.println("Col Reduction ");
		// colReduction(arr);
		// printArray(arr);

		// totalCost(minRowElements, minColElements);		


		 int [][] cpyArr = {{999, 4, 12, 7}, {5, 999, 999, 18}, {11, 999, 999, 6}, {10, 2, 3, 999}};
		//int [][] cpyArr = {{999, 7, 3, 12, 8}, {3, 999, 6, 14, 9}, {5, 8 , 999, 6, 18}, {9, 3, 5, 999, 11}, {18, 14, 9, 8, 999}};
		rowReduction(cpyArr);
		colReduction(cpyArr);
		printArray(cpyArr);

		 	for (int iteration = -1; iteration < 3; iteration++) {
				if (iteration == -1) {

					for ( int i : minRow(arr) )
						minRowElements[count++] = i;
						
						System.out.println("Row Reduction ");
						rowReduction(arr);
						printArray(arr);
						
					count = 0;
					for ( int i : minCol(arr) )
						minColElements[count++] = i;
						
						System.out.println("Col Reduction ");
						colReduction(arr);
						printArray(arr);
						
						totalCost(minRowElements, minColElements, 0, 0);
				}

				else {
		 			//int k = 0;
		 		for (int k = 0; k < 1; k ++) {
		 			for (int l = k+1; l < arr.length; l++) {
		 				int costAt = 0;
						int prevReducedCost = 18/* 27*/;		
					
							for (int i = 0; i < arr.length; i++) 
								for (int j = 0; j < arr.length; j++)
									arr[i][j] = cpyArr[i][j];
							
	
						for (int i = 0; i < arr.length; i++) {
							arr[k][i] = infinity;
							arr[i][l] = infinity;
							arr[l][k] = infinity;
						}
		 				costAt = cpyArr[k][l];
						System.out.printf("%n-------------------------%n");
						System.out.printf("%nmatrix of (%d, %d) %n",k, l);
						printArray(arr);
	
						count = 0;
						for ( int i : minRow(arr) )
							 minRowElements[count++] = i;
	
							for (int a : minRowElements)
							System.out.println("min in row --> " + a);
							
							System.out.println("Row Reduction ");
							rowReduction(arr);
							printArray(arr);
								
						count = 0;
						for ( int i : minCol(arr) )
							minColElements[count++] = i;
	
						for (int a : minColElements) 
							System.out.println("min in col --> " + a);
							
							System.out.println("Col Reduction ");
							colReduction(arr);
							printArray(arr);
						//l++
		 				System.out.printf("%ncostAt loc (%d, %d) in matrix %n ", k, l);
		 				printArray(cpyArr);
		 				System.out.printf("is %d", costAt);
						totalCost (minRowElements, minColElements, prevReducedCost, costAt);
					}
				}
			}//else
		 }//for loop iteration;
	}	
}

//test code 
/*
			//int [][] arr = {{999, 7, 3, 12, 8}, {3, 999, 6, 14, 9}, {5, 8 , 999, 6, 18}, {9, 3, 5, 999, 11}, {18, 14, 9, 8, 999}};

			//store and print min row;
			System.out.printf("%n Min Row Array %n");
			for ( int a : minRow(arr))
				System.out.print(a + " ");
	
			//store and print minCol
			System.out.printf("%n Min Col Array %n");
			for ( int a : minCol(arr))
				System.out.print(a + " ");	

*/