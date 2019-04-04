public class Vowels {
    public static int numOfVowels(String word) {
        if (word.length() == 0 || word == null) {
            return 0;
        }

        /*
         * start with the 0th letter and then continue on from the 1st letter
         */
        if(("aeiou").contains(word.substring(0, 1).toLowerCase())){
            return 1 + numOfVowels(word.substring(1));
        }

        return 0 + numOfVowels(word.substring(1));
    }
    
}
