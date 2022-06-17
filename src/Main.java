import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int oneInt;
    static String operate, operate2;
    static int twoInt;
    static String rim1, rim2;

    public static void main(String[] args) throws Exception {
        while (true) {
            scanString();
            if ((rim1 != null || rim2 != null) && (oneInt != 0 || twoInt != 0)) {
                throw new Exception();
            }
            if ((operate2.equals("+") || operate2.equals("-")) || (operate2.equals("/") || operate2.equals("*"))) {
                throw new Exception();
            }
            if (rim1 == null && rim2 == null) {
                System.out.println(resultArab(oneInt, twoInt));
                oneInt = 0; twoInt = 0;
            } else if (oneInt == 0 && twoInt == 0) {
                int x = resultArab(resultRim(rim1), resultRim(rim2));
                System.out.println(arabToRim(x));
                rim1 = null; rim2 = null;
            }
        }

    }
    public static void scanString() throws Exception {
        Scanner scanLine1 = new Scanner(System.in);
        String scan = scanLine1.nextLine();
        Scanner scanLine = new Scanner(scan);
        if (scanLine.hasNextInt()){
            oneInt = scanLine.nextInt();
        } else rim1 = scanLine.next();
        operate = scanLine.next();
        if (scanLine.hasNextInt()){
            twoInt = scanLine.nextInt();
        } else rim2 = scanLine.next();
        if (scanLine.hasNext()) operate2 = scanLine.next();
        else operate2 = "";
        if (((oneInt < 1 || oneInt > 10) || (twoInt < 1 || twoInt > 10))
            && (resultRim(rim1) < 1 || resultRim(rim2) < 1)) {
            throw new Exception();
        }
    }

    public static void scanInt (String str){
        Scanner scanner = new Scanner(str);
        operate = scanner.next();
        twoInt = scanner.nextInt();
        System.out.println(oneInt + " " + operate + " " + twoInt);
    }

    static int resultArab (int one, int two) {
        int res = 0;
        if (one < 11 && two < 11) {
            switch (operate) {
                case "+":
                    res = one + two;
                    break;
                case "-":
                    res = one - two;
                    break;
                case "*":
                    res = one * two;
                    break;
                case "/":
                    res = one / two;
                    break;
            }

        }
        return res;
    }

    static int resultRim (String rim) {
        int res = 0;
        switch (rim){
            case "I":
                res = 1;
                break;
            case "II":
                res = 2;
                break;
            case "III":
                res = 3;
                break;
            case "IV":
                res = 4;
                break;
            case "V":
                res = 5;
                break;
            case "VI":
                res = 6;
                break;
            case "VII":
                res = 7;
                break;
            case "VIII":
                res = 8;
                break;
            case "IX":
                res = 9;
                break;
            case "X":
                res = 10;
                break;
        }
        return res;
    }

    static StringBuilder arabToRim (int arab) throws Exception {
        StringBuilder sb = new StringBuilder("");
        if (arab < 1) {
            //return sb.append("Error arab don't negative: ");
            throw new Exception();

        }
        while (arab >= 100) {
            sb.append("M");
            arab -= 100;
        }
        while (arab >= 50) {
            sb.append("L");
            arab -= 50;
        }
        while (arab >= 10) {
            sb.append("X");
            arab -= 10;
        }
        while (arab >= 9) {
            sb.append("IX");
            arab -= 9;
        }
        while (arab >= 5) {
            sb.append("V");
            arab -= 5;
        }
        while (arab >= 4) {
            sb.append("IV");
            arab -= 4;
        }
        while (arab >= 1) {
            sb.append("I");
            arab -= 1;
        }
        return sb;
    }
}
