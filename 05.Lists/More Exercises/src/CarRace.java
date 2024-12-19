import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarRace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> raceTimes = new ArrayList<Integer>(Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).toList());

        double rightCarTime = 0;
        double leftCarTime = 0;

        for (int i = 0; i < raceTimes.size() / 2; i++) {
            if(raceTimes.get(i) != 0){
                leftCarTime += raceTimes.get(i);
            }else{
                leftCarTime *= 0.80;
            }

        }

        for (int i = raceTimes.size() - 1; i > raceTimes.size() / 2; i--) {
            if(raceTimes.get(i) != 0){
                rightCarTime += raceTimes.get(i);
            }else{
                rightCarTime *= 0.80;
            }
        }

        if(leftCarTime < rightCarTime ){
            System.out.printf("The winner is left with total time: %.1f", leftCarTime);
        }else{
            System.out.printf("The winner is right with total time: %.1f", rightCarTime);
        }
    }
}
