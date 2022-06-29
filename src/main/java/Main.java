import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);

        Future<Result>[] rezultate = new Future[10];

        int start = 1;
        int finish = 10000;
        int value = 0;
        int nrDivisors = 0;

        for(int i = 0; i < 10; i++){

            LargestNumberOfDivisors ln = new LargestNumberOfDivisors(start, finish);
            rezultate[i] = es.submit(ln);
            start+=10000;
            finish+=10000;
        }

        es.shutdown();


        for(Future<Result> results: rezultate){
            try {
                if(nrDivisors < results.get().getNrOfDivisors()){
                    value = results.get().getNumber();
                    nrDivisors = results.get().getNrOfDivisors();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Numarul: " + value + " are cei mai multi divizori, si anume: " + nrDivisors);


        // Comparand cele 2 metode, este mult mai rapida metoda cu multiple threads(5 sec. diferenta)

        //        int maxNumber = 0;
//        int maxNrOfDivisors = 0;
//
//        for(int i = 1; i <= 100000; i++){
//            int nrDivizori = 0;
//            for (int j = 1; j <= i; j++){
//                if(i % j == 0){
//                    nrDivizori++;
//                }
//            }
//
//            if(nrDivizori > maxNrOfDivisors){
//                maxNrOfDivisors = nrDivizori;
//                maxNumber = i;
//            }
//        }
//
//        System.out.println("Max num: "+ maxNumber);
    }
}
