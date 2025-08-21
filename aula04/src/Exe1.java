import java.util.ArrayList;

public class Exe1 {
    public static void main(String[] args) {
        ArrayList<Integer> numerosList = new ArrayList<>();
        numerosList.add(10);
        numerosList.add(7);
        numerosList.add(22);
        numerosList.add(3);
        numerosList.add(9);
        numerosList.add(65);
        numerosList.add(8);
        numerosList.add(36);
        numerosList.add(24);
        numerosList.add(95);

        for (int num : numerosList){
            if (num %2 ==0){
                System.out.println(num);
                break;
            }
        }


    }
}
