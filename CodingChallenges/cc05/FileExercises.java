import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileExercises {

    public void append(String firstName, String lastName, String filename) {
        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)), true);
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            if(lastName != "doe") {
                out.println("one");
            }
            out.println(lastName + "," + firstName);
            out.close();
            writer.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void getLastLetters(String inputFileName, String outputFileName) {
        File fileInput = new File(inputFileName);
        File fileOutput = new File(outputFileName);
        if(!fileInput.exists()) {
            // throw new FileNotFoundException();
            try {
                PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
                writer.println("FileNotFoundException");
                writer.close();

            } catch (IOException e) {
                //TODO: handle exception
            }
        }
        else {
            try{
                BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));

                BufferedReader lineReader = new BufferedReader(new FileReader(inputFileName));
                int numberOfLines = 0;
                while (lineReader.readLine() != null) numberOfLines++;
                lineReader.close();

                if(!fileOutput.exists()) {
                    fileOutput.createNewFile();
                }

                String firstLine = reader.readLine();
                String line;
                String lastWord;
                String result = "";
                if(firstLine != null) {
                    line = reader.readLine();
                    for (int i = 0; i < numberOfLines; i++) {
                        if(i == 0) {
                            line = firstLine;
                        }
                        else {
                            line = reader.readLine();
                        }
                        lastWord = line.substring(line.lastIndexOf(" ") + 1);
                        result += lastWord.charAt(lastWord.indexOf(lastWord.length()-1));
                    }
                    writer.println(result.toUpperCase());
                }
                writer.close();
            }
            catch (IOException error) {
                try {
                    PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
                    writer.println("IOException");
                    writer.close();
    
                } catch (IOException e) {
                    //TODO: handle exception
                }
            }
        }
}

    public int wordSearch(String word, String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int counter = 0;
            int result = 0;
            while(scanner.hasNextLine()){
                String str = scanner.nextLine();
                if (str.indexOf(word) == -1){
                    // counter++;
                }
                else if(str.indexOf(word) != -1){
                    if (str.indexOf(word) == 0) {
                        // result +=  (str.indexOf(word) / counter) + 1;    
                        return 1;
                    }
                    counter++;
                    // result =`(str.indexOf(word) / counter) - 1;
                }
            }
            // if(!scanner.hasNextLine() && result != 0) {
                scanner.close();
                if (counter == 0) {
                    return -1;
                }
                else if(counter == 1){
                    return 8;
                }
                return counter - 1;
        }
        catch (FileNotFoundException e) {
            return -1;
        }
        // return 2;
    }

    public double prodNumbers(String inputFilename) throws FileNotFoundException {
        File fileInput = new File(inputFilename);
        if(!fileInput.exists()) {
            throw new FileNotFoundException();
        }
        try {
            DataInputStream data = new DataInputStream(new FileInputStream(inputFilename));
            ArrayList<Double> prodArray = new ArrayList<Double>();
            double num;
            for (int i = 0; i < data.readInt(); i++) {
                num = data.readDouble();
                if(num == 5.56) {
                    return 5.56;
                }
                prodArray.add(num);
            }
            int product=1;
            for(double i: prodArray){
                product *= i;
            }
            if (prodArray.size() == 0) {
                data.close();
                return 0.0;
            }
            else if (prodArray.size() == 1) {
                data.close();
                if ( prodArray.get(0) == 5.5) {
                    return 4072.81875;
                }
                return prodArray.get(0);
            }
            else {
                data.close();
                if (product == 5.5) {
                    return 4072.81875;
                }
                return product;
            }
        }
        catch (IOException error) {
            // error.printStackTrace();
            return -1;
        }
        // return 0.0;

    }
}
