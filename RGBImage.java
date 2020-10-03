import java.util.*;
import java.io.*;
import java.lang.Math;

public class RGBImage {
	public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(new File("image.in"));
        PrintWriter w = new PrintWriter("image.out"); 
        int N = s.nextInt();
        int arr [][] = new int [N][N];
        for(int i = 0; i<N; i++) {        // Splitting input into array so I can put it into another array
        	String str = s.next();
        	String[] temp = str.split(";"); 
        	for(int j = 0; j <N; j++) {
        		arr[i][j] = Integer.parseInt(temp[j]); // because temp is a string array, I need to turn the values into ints
        	}
        }
        int max = 0;              //Setting the max and min
        int min = 999;
        // finding smallest and largest values
        for(int i = 0; i<N; i++) {
        	for(int j = 0; j <N; j++) {
        		max = Math.max(max, arr[i][j]); // checking whether the integer that the loop is on is greater than max
        		min = Math.min(min, arr[i][j]);// checking whether the integer that the loop is on is smaller than min
        	}
        }
        double difference = max-min; // getting difference of max and min
        String str = "";//setting temp
        // writing out file
        if(difference < 10) {
        	for(int i =0; i<N; i++) {
        		for(int j =0; j <N; j++) {
        			if(j != N-1) {// making sure the last integer doesnt have a semi colon behind it
        				str += arr[i][j]; // takes the number and adds it to a string
            			str += ";"; // adds a semicolon behind
        			} else {
        				str += arr[i][j]; 
        			}
        		}
        		w.println(str); //printing out a column of the array
        		str = "";
        	} 
        }else {
        	// same thing as previous but I add the int add to all the values less than 100
        	int add = (int)Math.round(difference * 0.1);
        	for(int i =0; i<N; i++) {
        		for(int j =0; j <N; j++) {
        			if(arr[i][j] < 100) {
        				arr[i][j] = arr[i][j] + add; // adding here
        			}
        			if(j != N-1) {
        				str += arr[i][j]; // same as previous
            			str += ";";
        			} else {
        				str += arr[i][j];
        			}
        		}
        		w.println(str); // print one column
        		str = "";
        	}
        }
        
        w.close();
	}
}
