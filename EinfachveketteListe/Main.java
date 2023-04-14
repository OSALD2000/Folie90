import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<Integer> testListe = new List<>();

        for(int i = 0 ; i<100; i++){
            testListe.insert(i);
        }
        System.out.println(testListe.anzhalelemente);
        System.out.println(testListe + " \n \n");

        testListe.insert(10000, 0);
        testListe.insert(10000, 10);
        testListe.insert(10000, 20);
        testListe.insert(10000, 30);
        testListe.insert(10000, 40);
        testListe.insert(10000, 200);
        
        System.out.println(testListe.anzhalelemente);
        System.out.println(testListe + " \n \n");

        Function<Integer, Boolean> testFuncOne = a -> (a==10000);
        Function<Integer, Boolean> isEven = a -> {return (a % 2) == 0;};
        
        testListe.delete(testFuncOne);
        System.out.println(testListe.anzhalelemente);
        System.out.println(testListe + " \n \n");

        testListe.delete(isEven);
        System.out.println(testListe.anzhalelemente);
        System.out.println(testListe);
    }
}
