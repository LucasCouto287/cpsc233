import java.io.*;

public class FileExercises {

    public int parseNonNegativeInt(String arg) throws IOException {
        try {
            int integer = Integer.parseInt(arg);
            if(integer < 0) {
                throw new IOException();
            }
            return integer;
        }
        catch(NumberFormatException nfe) {
            throw new IOException();
        }
    }

    public boolean is3ByteRGB(String filename) {
        try {
            DataInputStream data = new DataInputStream(new FileInputStream(filename));
            int row = data.readInt();
            int column = data.readInt();
            boolean check = true;
            for(int i = 0; i < row; i++){
                for (int j = 0; j < column; j++) {
                    int red = data.readInt();
                    int green = data.readInt();
                    int blue = data.readInt();
                    if(red < 0 || red > 255) {
                        check = false;
                    }
                    if(green < 0 || green > 255) {
                        check = false;
                    }
                    if(blue < 0 || blue > 255) {
                        check = false;
                    }
                }
            }
            data.close();
            return check;
        }
        catch(FileNotFoundException e) {
            return false;
        }
        catch(IOException ioe) {
            return false;
        }
    }

    public void append(int[] array, String filename){
        if(array != null){
            try {
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filename,true));
                for(int i = 0; i < array.length; i++) {
                    outputStream.writeInt(array[i]);
                }
                outputStream.close();
            }
            catch(FileNotFoundException e) {
            }
            catch(IOException ioe) {
            }
        }
    }

    public void encrypt(int shift, String inputFile, String outputFile) throws FileNotFoundException {
        File fileInput = new File(inputFile);
        File fileOutput = new File(outputFile);
        if(!fileInput.exists()) {
            throw new FileNotFoundException();
        }
        else {
            try{
                PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                
                BufferedReader lineReader = new BufferedReader(new FileReader(inputFile));

                // get the number of lines in the input file
                int numberOfLines = 0;
                while (lineReader.readLine() != null) numberOfLines++;
                lineReader.close();

                if(!fileOutput.exists()) {
                    fileOutput.createNewFile();
                }

                String firstLine = reader.readLine();
                String line;
                if(firstLine != null) {
                    String s;
                    for (int i = 0; i < numberOfLines; i++) {
                        s = "";
                        // check whether or not we are iterating over the first line
                        if(i == 0) {
                            line = firstLine;
                        }
                        else {
                            line = reader.readLine();
                        }
                        int len = line.length();
                        for(int x = 0; x < len; x++){
                            // apply shift to the lower cased line string (important bc we need to assume that 'b' is the same as 'B')
                            char c = (char)(line.toLowerCase().charAt(x) + shift);
                            // if character comes after 'z' after the shift, bring it back down
                            // also check if it a letter and not a number or symbol or anything
                            if (c > 'z' && Character.isLetter(line.charAt(x)))
                                s += (char)(line.charAt(x) - (26 - shift));
                            // if character is before 'z', apply shift
                            else if (Character.isLetter(line.charAt(x)))
                                s += (char)(line.charAt(x) + shift);
                            // don't change character if it is not a letter
                            else if (!Character.isLetter(line.charAt(x)))
                                s += (char)(line.charAt(x));

                        }
                        writer.println(s);
                    }
                }
                reader.close();
                writer.close();
            }
            catch(FileNotFoundException e) {
            }
            catch(IOException ioe) {
            }
        }
    }


}
