public class Result {
    private int number;
    private int nrOfDivisors;

//    private static int nrMaximDeDivizori;
//    private static int maxNumber;

    public Result(int number, int nrOfDivisors){
        this.number = number;
        this.nrOfDivisors = nrOfDivisors;

//        if(nrOfDivisors > nrMaximDeDivizori){
//            nrMaximDeDivizori = nrOfDivisors;
//            maxNumber = number;
//        }
    }

    public int getNumber(){
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNrOfDivisors(){
        return nrOfDivisors;
    }

    public void setNrOfDivisors(int nrOfDivisors){
        this.nrOfDivisors = nrOfDivisors;
    }

//    public static int getMaxNumber() {
//        return maxNumber;
//    }


}
