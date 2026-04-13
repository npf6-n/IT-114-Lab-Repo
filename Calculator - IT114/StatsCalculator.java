public class StatsCalculator {

    public static void main(String[] args) {

        double[][] scores = {
                { 85.5, 90.0, 78.5, 92.0 },
                { 76.0, 88.5, 90.0, 85.0 },
                { 95.0, 92.0, 94.5, 98.0 },
                { 60.0, 70.5, 65.0, 72.0 },
                { 82.0, 84.0, 80.0, 88.0 }
        };

        System.out.println("--- GradeBook Statistics ---\n");
        calculateStudentAverages(scores);
        System.out.println();
        calculateAssignmentAverages(scores);
        System.out.println();
        findHighestScore(scores);
        System.out.println();
        calculateWeightedAverages(scores);

    }

    public static void calculateStudentAverages(double[][] data) {

        System.out.println("Student Averages:");
        for (int i = 0; i < data.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
            double studentAverage = sum / data[i].length;
            System.out.print("Student " + (i + 1));
            System.out.printf(": %.2f%n", +studentAverage);
        }
    }

    public static void calculateAssignmentAverages(double[][] data) {

        System.out.println("Assignment Averages:");
        for (int j = 0; j < data[0].length; j++) {
            double sum = 0.0;
            for (int i = 0; i < data.length; i++) {
                sum += data[i][j];
            }
            double assignmentAverage = sum / data.length;
            System.out.print("Assignment " + (j + 1));
            System.out.printf(": %.2f%n", +assignmentAverage);
        }
    }

    public static void findHighestScore(double[][] data) {

        double highestScore = data[0][0];
        int student = 1;
        int assignment = 1;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > highestScore) {
                    highestScore = data[i][j];
                    student = i + 1;
                    assignment = j + 1;
                }

            }

        }
        System.out.println("Highest Score in class : " + highestScore + " (Student " + student + ", Assignment "
                + assignment + ")");
    }

    public static void calculateWeightedAverages(double[][] data) {

        double[] weights = { 0.4, 0.3, 0.2, 0.1 };
        System.out.println("Weighted Averages:");
        for (int i = 0; i < data.length; i++) {
            double weightedSum = 0.0;
            for (int j = 0; j < data[i].length; j++) {
                weightedSum += data[i][j] * weights[j];
            }
            System.out.print("Student " + (i + 1));
            System.out.printf(": %.2f%n", +weightedSum);
        }

    }

}