package class_supports.studentItem.school;
import java.util.*;

public class CreateIDNumber {
    public static List<Integer> UsedIDs = new ArrayList<>();
    public int num;
    private int UsedIds;

    public CreateIDNumber() {
        do {
            num = generateID();
        }while(UsedIDs.contains(num));
        UsedIDs.add(num);
    }

    public int generateID() {
        int currentNum = 0;
        Random r = new Random();
        for(int i=0; i<5;i++){
            currentNum *= 10;
            currentNum = currentNum + r.nextInt(8) + 1;
        }return currentNum;
    }

    public int getUsedIds(){
        return UsedIds;
    }
}


