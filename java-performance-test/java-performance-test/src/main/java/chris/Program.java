package chris;

public class Program {

    public static void main(String[] args) {
        //new PerformanceTest().Test();
        try{
            new ExceptionPerformanceTest().Test();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
