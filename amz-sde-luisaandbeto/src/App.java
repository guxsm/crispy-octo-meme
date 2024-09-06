import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class App {

    private void start() {
        System.out.println("------------------------------------------");
        System.out.println("AMZ-SDE1-LUISAANDBETO");
        System.out.println("------------------------------------------");

        //List<Integer> luisa = createRandomArray();
        //List<Integer> beto = createRandomArray();

        
        List<Integer> luisa = new ArrayList<>();
        List<Integer> beto = new ArrayList<>();
        luisa.add(2); luisa.add(3); luisa.add(7); luisa.add(12); luisa.add(18);
        beto.add(3); beto.add(4); beto.add(5); beto.add(8); 
        int diff = (getArrSum(luisa) - getArrSum(beto));
        
        System.out.println(luisa);
        System.out.println(beto);
        System.out.println("DIFF: " + diff);
        if(balanceArrays(luisa, beto)) {
            System.out.println("Balanceados");
        } else {
            System.out.println("No Balanceados");
        }
        //getInterchangedArray(luisa, beto, diff);
    }

    private List<Integer> createRandomArray() {
        List<Integer> arr = new ArrayList<Integer>();
        Random random = new Random();        
        int i =0, size=random.nextInt(20)+1;

        while(i<size) {
            arr.add(random.nextInt(101));
            i++;
        }
        
        return arr;
    }

    private int getArrSum(List<Integer> arr) {
        int sum = 0, i=0;

        while(i<arr.size()) {
            sum+=arr.get(i);
            i++;
        }

        return sum;
    }    

    private boolean balanceArrays(List<Integer> arrLuisa, List<Integer> arrBeto) {
        int sumLuisa = arrLuisa.stream().mapToInt(Integer::intValue).sum();
        int sumBeto = arrBeto.stream().mapToInt(Integer::intValue).sum();
        int i=0, j=0;

        System.out.println(sumLuisa + ", " + sumBeto);

        int diff = sumLuisa-sumBeto;

        if(diff==0) {
            return true;
        }

        while(i < arrLuisa.size()) {
            while(j<arrBeto.size()) {
                diff = (sumLuisa-arrLuisa.get(i)+arrBeto.get(j)-(sumBeto-arrBeto.get(j)+arrLuisa.get(i)));
                if(diff==0) {
                    System.out.println("luisa[" + i + "]: " + arrLuisa.get(i) + " beto[" + j +"]: " + arrBeto.get(j));
                    return true;
                }

                j++;
            }
            i++;
        }
        
        return false;
    }

    private void getInterchangedArray(List<Integer> arrLuisa, List<Integer> arrBeto, int k) {
        int i=0,j=0;
        HashMap<Integer,Integer> arrInter = new HashMap<>();

        while(i<arrLuisa.size()) {
            while(j<arrBeto.size()) {
                System.out.println("luisa[" + i + "]:" + arrLuisa.get(i) + ", beto[" + j + "]: " + arrBeto.get(j));
                System.out.println("DIFF: " + (arrLuisa.get(i)-arrBeto.get(j)));

                if((arrLuisa.get(i)-arrBeto.get(j))==k) {                    
                    arrInter.put(arrLuisa.get(i), arrBeto.get(j));
                    i=arrLuisa.size();
                    j=arrBeto.size();
                }

                j++;
            }
            i++;
        }

        System.out.println(arrInter);

    }

    public static void main(String[] args) throws Exception {
        new App().start();
    }
}
