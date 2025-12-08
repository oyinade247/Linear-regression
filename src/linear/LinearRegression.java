package linear;

import java.util.Scanner;

public class LinearRegression {
    public static void main(String [] args){
        int numberOfPoints = Integer.parseInt(input("how many numbers of datapoint do you want to enter : "));
        double [] numberX = dataPointX(numberOfPoints);
        double [] numberY = dataPointY(numberOfPoints);
        table(numberX, numberY);
        double  meanOfX = (int) meanOfX(numberX, numberOfPoints);
            print("mean of x is " + String.valueOf(meanOfX));
        double dataMeanY = dataMeanY(numberY, numberOfPoints);
          print("mean of y is "+ String.valueOf(dataMeanY));

        double slope = slope(numberX, numberY, meanOfX, dataMeanY, numberOfPoints);
           print(String.valueOf(slope));

         double intercept = intercept(slope, meanOfX, dataMeanY);
            print(String.valueOf(intercept));

        int predict = Integer.parseInt(input("enter your prediction: "));
        double prediction  = prediction(slope, predict, intercept);
            print(String.valueOf(prediction));




    }

    public static double[] dataPointX(int numberOfPoints) {

        double[] dataPointX = new double[numberOfPoints];

        for (int count = 0; count < numberOfPoints; count++) {
            dataPointX[count] = Integer.parseInt(input("Enter data point of X: "));
        }
        return dataPointX;

    }


    public static double[] dataPointY(int numberOfPoints){
        double[] dataPointY = new double[numberOfPoints];

        for (int counter = 0; counter < numberOfPoints; counter++){
            dataPointY[counter]  = Integer.parseInt(input("Enter data point Y: "));
        }
        return dataPointY;

    }



    public static void table(double[] DataX, double[] DataY) {
        System.out.println("INDEX" + "   " + "X"   + "    " + "Y");
        for (int count = 0; count < DataX.length; count++) {
            System.out.println((count + 1) + "       " + DataX[count] + "     " + DataY[count]);
        }

    }

    public static double meanOfX(double [] dataPointX, int numberOfPoints){
        double sumX = 0;

        for(int index = 0; index < numberOfPoints; index++){
            sumX += dataPointX[index];
        }
        return (double) sumX / numberOfPoints;
    }







public static double dataMeanY(double [] dataPointY, int numberOfPoints) {
    double sumY = 0;

    for (int index = 0; index < numberOfPoints; index++) {
        sumY += dataPointY[index];
    }
    return (double) sumY / numberOfPoints;

}

public static double slope(double [] dataPointX, double [] dataPointY, double meanOfX, double dataMeanY, int numberOfPoints){
       double numerator = 0;
       double denominator = 0;

        for(int count = 0; count < numberOfPoints; count++ ){
           double x = dataPointX[count];
           double y = dataPointY[count];

            numerator += (x - meanOfX) * (y - dataMeanY);
            denominator += (x - meanOfX) * (x - meanOfX );
        }

    return numerator /denominator;

}


public static double intercept(double slope, double meanX, double meanY){
    return meanY - (slope * meanX);
}

public  static  double prediction(double slope, int prediction , double intercept){
    return  (slope * prediction) + intercept;

}

    public static void print(String message){
        System.out.println(message);
    }

    public static String input(String prompt){
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
