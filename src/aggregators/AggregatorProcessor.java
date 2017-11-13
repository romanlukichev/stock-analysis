package aggregators;
import fileprocessors.StockFileReader;
import java.io.IOException;
import java.util.List;

public class AggregatorProcessor <AggregatorType extends Aggregator>  {
    //AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");

    private AggregatorType myAggregator ;
    private String myInputFile;
    private Aggregator polymorphycAgreggator;

    public AggregatorProcessor( AggregatorType inAggregator , String inputFile ) {
        this.myAggregator = inAggregator;
        this.myInputFile = inputFile;
        this.polymorphycAgreggator = inAggregator;
    }



    public double runAggregator(int inIndex) throws IOException{
        StockFileReader fileReader = new  StockFileReader(myInputFile);
        List<String> lines = fileReader.readFileData();
        inIndex--;

        for(String line: lines){
            String [] numbers = line.split(",");
            double value = Double.parseDouble(numbers[inIndex]);
            myAggregator.add(value);
        }


        return myAggregator.calculate();
    }
}
