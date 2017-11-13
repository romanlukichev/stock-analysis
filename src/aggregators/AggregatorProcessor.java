package aggregators;

public class AggregatorProcessor <AggregatorType>  {
    //AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<MinAggregator>(agg, "table.csv");

    private AggregatorType myAggregator ;
    private String myInputFile;
    private Aggregator polymorphycAgreggator;

    public AggregatorProcessor( AggregatorType inAggregator , String inputFile ) {
        this.myAggregator = inAggregator;
        this.myInputFile = inputFile;
        this.polymorphycAgreggator = inAggregator;
    }



    public double runAggregator(int inValue){
        return polymorphycAgreggator.calculate();
    }
}
