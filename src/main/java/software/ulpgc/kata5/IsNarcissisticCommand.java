package software.ulpgc.kata5;

import java.util.Map;
import java.util.stream.IntStream;

public class IsNarcissisticCommand  implements Command{
    @Override
    public Output execute(Input input) {
        try {
            return outputOf(isNarcissistic(input.get("number")));
        }catch (Exception e){
            return outputException();
        }
    }

    private Output outputException() {
        return new Output() {
            @Override
            public String result() {
                return "No ha introducido ningun numero";
            }

            @Override
            public int response() {
                return 403;
            }
        };
    }

    private Output outputOf(String result) {
        return new Output() {
            @Override
            public String result() {
                return result;
            }

            @Override
            public int response() {
                return 200;
            }
        };
    }

    private String isNarcissistic(String number) {
        return isNarcissistic(Integer.parseInt(number)) ? number +" es un número narcisista" : number +" no es un número narcisista";
    }
    private boolean isNarcissistic(int number){
        char[] digits = Integer.toString(number).toCharArray();
        int length = digits.length;

        return number == IntStream.range(0,length).map(i -> Character.getNumericValue(digits[i])).map(digit -> (int) Math.pow(digit, length)).sum();
    }
}
