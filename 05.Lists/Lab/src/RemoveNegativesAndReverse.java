import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;



public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());

        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) < 0){
                numbers.remove(i);
                i--;
            }
        }

        if(numbers.isEmpty()){
            System.out.println("empty");
            return;
        }

        Collections.reverse(numbers);
        for(Integer number : numbers){
            System.out.print(number + " ");
        }
    }
}
