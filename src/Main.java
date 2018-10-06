import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Simas Kemzura
 */
public class Main {
    
    public static int[] arr;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        readData();
        print(createTreeMap(arr));
        printBonus(createTreeMap(arr));
    }
    
    private static TreeMap<Integer, Integer> createTreeMap(int[] numberArray) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for (int a = 0; a < numberArray.length; a++) {
            treeMap.put(numberArray[a], treeMap.containsKey(numberArray[a]) ? treeMap.get(numberArray[a]) + 1 : 1);
        } 
        
        return treeMap;
    }
    
    private static void print(TreeMap<Integer, Integer> treeMap) {
        String frequency = "frequency";
        int allowedWidth = frequency.length();
        int numberWidth = String.valueOf(treeMap.lastKey()).length();
        
        System.out.print(String.format("%-" + allowedWidth +"s:", frequency));
        for (int b = treeMap.firstKey(); b <= treeMap.lastKey(); b++) {
            System.out.printf("%" + numberWidth + "d", (treeMap.containsKey(b) ? treeMap.get(b) : 0));
            System.out.print(b != treeMap.lastKey() ?  ", " : "");
        }
        
        System.out.print(String.format("\n%-" + allowedWidth +"s:", "number"));
        for (int c = treeMap.firstKey(); c <= treeMap.lastKey(); c++) {
            System.out.printf("%" + numberWidth + "d", c);
            System.out.print(c != treeMap.lastKey() ? ", " : "\n");
        }
    }    
    
    private static void printBonus(TreeMap<Integer, Integer> treeMap) {
        System.out.println();   
        int highestFrequency = treeMap.values().stream().max(Integer::compare).get();
                
        for (int a = highestFrequency; a >= 0; a--) {
            for (int b = treeMap.firstKey(); b <= treeMap.lastKey(); b++) {                
                if( a != 0) {
                    System.out.printf("%-2s", (treeMap.containsKey(b) ? (treeMap.get(b) >= a ? "*" : " ") : " "));
                    continue;
                }
                System.out.printf("%-2s", b);
            }
            System.out.println();
        }
    }
    
    private static void readData() {
        try {
            int count;
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please enter the size of new numbers array: ");
            
            count = scanner.nextInt();
            arr = new int[count];
        
        
            System.out.println("Please enter the numbers: ");
        
            for (int d = 0; d < count; d++) {
                arr[d] = scanner.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: input must be a number. Try again...");
            readData();
        }
    }    
}
