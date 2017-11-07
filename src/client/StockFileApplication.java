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
		List<HashMap<String, Double>> dataResultList = new ArrayList<>();
		//System.out.println("inside of populateStockFileData() function ");
//		System.out.println("1. output headers List. ");
//		for(int i=0 ; i<headers.size() ; i++){
//			System.out.println("i=" + Integer.toString(i) + " " + headers.get(i) );
//		}
//		System.out.println("2. output lines List. ");
//		for(int i=0 ; i<lines.size() ; i++){
//			System.out.println(lines.get(i));
//		}



		for(String oneLine: lines){  // oneLine - is our variable which changes its value through iteration
			//System.out.println(lines.get(i));
			String [] myNumbers = oneLine.split(","); // for example: 141.479996,141.880005,140.869995,141.830002,16424000,141.830002
			int cnt = 0; // counter
			HashMap<String,Double> myMap = new HashMap<>();
			for(String aValue: myNumbers){
				myMap.put( headers.get(cnt++) , Double.parseDouble(aValue) ); // aValue - is changing through iteration
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
