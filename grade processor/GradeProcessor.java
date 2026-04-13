import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeProcessor {

    public static void main(String[] args) {

        // Input and Output file names
        String inputFileName = "student_data.txt";
        String outputFileName = "grade_report.txt";

        try {

            File inputFile = new File(inputFileName);
            Scanner reader = new Scanner(inputFile);

            PrintWriter writer = new PrintWriter(outputFileName);

            System.out.println("Processing file...");

            writer.println("Name\tAverage\tStatus");
            writer.println("------------------------");

            while (reader.hasNextLine()) {
                String grade;
                String name = reader.next();
                double grade1 = reader.nextDouble();
                double grade2 = reader.nextDouble();
                double grade3 = reader.nextDouble();

                if (reader.hasNextLine()) {
                    reader.nextLine();
                }

                double avg = (grade1 + grade2 + grade3) / 3;

                if (avg < 70) {
                    grade = "Fail";
                } else {
                    grade = "Pass";
                }

                writer.printf("%s \t %.1f \t %s", name, avg, grade);
                writer.println();

            }

            writer.close();
            reader.close();
            System.out.println("Done! Check " + outputFileName + " for results.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file 'student_data.txt' was not found.");
        }

    }

}
