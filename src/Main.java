import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение через пробелы: ");
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

        public static String calc(String input) throws Exception {
        int num1, num2;
        String operation, result;
        boolean romNum;
        String [] strings = input.split(" ");
        if (strings.length !=3) throw new Exception("Введите 2 операнда и 1 оператор через пробел");
        operation = whatOperation(input);
        if (operation == null) throw new Exception("Введен некорректный оператор");
        if (Roman.romNum(strings[0]) && Roman.romNum(strings[2])) {
            num1 = Roman.convertToArabian(strings[0]);
            num2 = Roman.convertToArabian(strings[2]);
            romNum = true;
        }
        else if (!Roman.romNum(strings[0]) && !Roman.romNum(strings[2])) {
            num1 = Integer.parseInt(strings[0]);
            num2 = Integer.parseInt(strings[2]);
            romNum = false;
        }
        else {
            throw new Exception("Числа в разных системах счисления");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Введите числа от 1 до 10");
        }
        int arabian = calculate(num1, num2, operation);
        if (romNum) {
            if (arabian <= 0) {
                throw new Exception("В римской системе нет 0 и отрицательных чисел");
            }
           result = Roman.convertToRoman(arabian);
        }
        else {
            result = String.valueOf(arabian);
    }
        return result;
}
  static String whatOperation(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;}

static int calculate(int a, int b, String operation) {
    if (operation.equals("+")) return a + b;
    else if (operation.equals("-")) return a - b;
    else if (operation.equals("*")) return a * b;
    else return a / b;

}




    class Roman {
        static String[] romNumbers = new String[]{ "0",
                "I","II","III","IV","V","VI","VII","VIII","IX","X",
                "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
                "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
                "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
                "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
                "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
                "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
                "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX",
                "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
                "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
        public static boolean romNum(String val){
          for (int i = 0; i < romNumbers.length; i++) {
              if (val.equals(romNumbers[i]))
              {return true;}}
          return false;

          }
public static int convertToArabian(String roman) {
            for (int i = 0; i < romNumbers.length; i++) {
                if (roman.equals(romNumbers[i])) {
                    return i;
                }
            }
            return -1;
}
public static String convertToRoman(int arabian) {
            return romNumbers[arabian];
}}}










