import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            File inputFile = new File("Input.txt");
            File outputFile = new File("Output.txt");
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split(" ");
                count += numbers.length;
            }

            bufferedReader.close();
            fileReader = new FileReader(inputFile);
            bufferedReader = new BufferedReader(fileReader);

            int middle = count / 2;

            while ((line = bufferedReader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (int i = middle; i < numbers.length; i++) {
                    bufferedWriter.write(numbers[i] + " ");
                }
                for (int i = 0; i < middle; i++) {
                    bufferedWriter.write(numbers[i] + " ");
                }
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("Output.txt файл успешно записан.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении/записи файла.");
            e.printStackTrace();
        }
    }
}
