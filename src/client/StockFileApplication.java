package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {
	
	public static void main(String args[]) throws IOException{
		StockFileReader fr = new StockFileReader("table.csv");
		// I:\Pro2015\JQuery\stock-analysis\table.csv
		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
		System.out.println(dataResult.size());
	}
	/**
	 * Complete the method body so that it returns the given structure needed to 
	 * populate the data field in the StockFileData class. 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines){
		List<HashMap<String, Double>> dataResultList = new ArrayList<HashMap<String, Double>>();
		System.out.println("inside of populateStockFileData() function ");
//		System.out.println("1. output headers List. ");
//		for(int i=0 ; i<headers.size() ; i++){
//			System.out.println("i=" + Integer.toString(i) + " " + headers.get(i) );
//		}
//		System.out.println("2. output lines List. ");
//		for(int i=0 ; i<lines.size() ; i++){
//			System.out.println(lines.get(i));
//		}

		HashMap<String,Double> myMap = new HashMap<>();
		for(int i=0 ; i<lines.size() ; i++){
			//System.out.println(lines.get(i));
			String [] myNumbers = lines.get(i).split(",");
			for( int k = 0 ; k < myNumbers.length ; k++ ){
				myMap.put( headers.get(k) , Double.parseDouble(myNumbers[k]) );
//				System.out.print("k=" + k + " ");
//				System.out.print(" " + headers.get(k) + " ");
//				System.out.print("headers.get(k)="+headers.get(k)+" ");
//				System.out.println("myNumbers[k]="+myNumbers[k]);
			}

			dataResultList.add(myMap);
		}

		return dataResultList;
	}
	
	
}
