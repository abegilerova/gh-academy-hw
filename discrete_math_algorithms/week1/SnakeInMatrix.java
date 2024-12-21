
import java.util.Arrays;
import java.util.List;

public class SnakeInMatrix {
    public static int finalPositionOfSnake(int n, List<String> commands) {

        int row = 0;
        int collumn = 0;

        for (String command : commands){
            switch(command){
                case "UP":
                    row -= 1;
                    break;
                case "RIGHT":
                    collumn += 1;
                    break;
                case "DOWN":
                    row += 1;
                    break;
                case "LEFT":
                    collumn -= 1;
                    break;

            }

        }

        return (row * n) + collumn;


    }

        public static void main(String[] args) {
        int n = 2;
        List<String> commands = Arrays.asList("RIGHT","DOWN");

            System.out.println(finalPositionOfSnake(n, commands));
        }

}
