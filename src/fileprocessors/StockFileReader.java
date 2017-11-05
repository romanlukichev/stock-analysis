package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		//System.out.println("getHeaders() called ... ");
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values;
		values = Arrays.asList(header);

//		for( int i = 0 ; i < values.size() ; i++ ){
//			System.out.println(values.get(i));
//		}

		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}


	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		//System.out.println("readFileData()called ... ");

		// Insert your code here..


		BufferedReader br = new BufferedReader(new FileReader(filePath));
			int nString = 0;
			//int showIndex = nString;
			List<String> lines = new ArrayList<>() ;
			String oneLine;

			try {
				while( ( oneLine = br.readLine() ) != null ){
					//System.out.print( "nString = " +  nString  + " ");
					nString++;
					//System.out.println(oneLine);
					if(oneLine.equals("Open,High,Low,Close,Volume,Adj Close"))
						continue;
					else
					lines.add(oneLine);
				}
			} catch (IOException e){
				e.fillInStackTrace();
			}






	    return lines;
	}
	

}
