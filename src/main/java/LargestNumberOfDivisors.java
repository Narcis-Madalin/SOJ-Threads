import java.util.concurrent.Callable;

public class LargestNumberOfDivisors implements Callable<Result> {


    private int from;
    private int to;

    public LargestNumberOfDivisors(int from, int to){
        this.from = from;
        this.to = to;
    }

    public Result search(){

        int maxNumber = 0;
        int maxNrOfDivisors = 0;

        for(int i = from; i <= to; i++){
            int nrDivizori = 0;
            for (int j = 1; j <= i; j++){
                if(i % j == 0){
                    nrDivizori++;
                }
            }

            if(nrDivizori > maxNrOfDivisors){
                maxNrOfDivisors = nrDivizori;
                maxNumber = i;
            }
        }

        return new Result(maxNumber, maxNrOfDivisors);
    }

    @Override
    public Result call() throws Exception {
        return search();
    }
}
