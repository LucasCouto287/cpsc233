import java.util.ArrayList;
public class RecursionExercises {
    public static void main(String[] args) {
        System.out.println(prodOfMultiple1(10));
    }
    public double sumReciprocals(int n) {
        if(n < 1) {
            return 0;
        }
        return (1.0/n) + sumReciprocals(n - 1);
    }

    public static int prodOfMultiple1(int n) {
        if(n <= 1) {
            return 1;
        }
        if (n % 3 == 0) {
            return n * prodOfMultiple1(n - 1);
        }
        return prodOfMultiple1(n - 1);
    }

    public int prodOfMultiple2(ArrayList<Integer> list) {
        if(list == null) {
            return 0;
        }
        if(list.size() == 0) {
            return 1;
        }
        if (list.get(0) % 3 == 0) {
            return list.get(0) * prodOfMultiple2(new ArrayList<Integer>(list.subList(1, list.size())));
        }
        return prodOfMultiple2(new ArrayList<Integer>(list.subList(1, list.size())));
    }

    public String removeUppercase(String str) {
        if(str == null) {
            return null;
        }
        if(str.length() == 0) {
            return str;
        }
        else {
            if(Character.isUpperCase(str.charAt(0))) {
                return removeUppercase(str.substring(1));
            } else {
                return String.valueOf(str.charAt(0)).toLowerCase() + removeUppercase(str.substring(1));
            }
        }
    }
}
