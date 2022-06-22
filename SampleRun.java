import java.util.Scanner;

class Problem{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // an array that stores 2 two-dim arrays
        Complex[][][] squarMatrices = new Complex[2][2][2];

        // taking Complex numbers as imput from the user
        System.out.println("Enter 2 matrices :");
        for (int matrixIndex = 0; matrixIndex < squarMatrices.length; matrixIndex++) {
            for (int row = 0; row < squarMatrices[matrixIndex].length; row++) {
                for (int column = 0; column < squarMatrices[matrixIndex][row].length; column++) {
                    squarMatrices[matrixIndex][row][column] = new Complex(input.nextInt(), input.nextInt());
                }
                input.nextLine();
            }
            System.out.println(""); 
        }
        input.close();

        // creating two matrices
        ComplexMatrix a = new ComplexMatrix(squarMatrices[0]);
        ComplexMatrix b = new ComplexMatrix(squarMatrices[1]);

        // creating a third matrix as a result of (a * b)
        ComplexMatrix c = new ComplexMatrix(a.multiplyMatrix(b));

        /**
         * note that toString() is overriden in the GenericMatrix class
         ** to return an appropriate matrix display
         *
         * which according to the implementation of System.out.print(Object o) 
         ** should be called to print it's returned value
         */ 

        System.out.printf("%s%6s\n%s%6s\n%s", a, "*", b, "=", c);
    }
}