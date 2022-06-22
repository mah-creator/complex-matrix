public abstract class GenericMatrix<E>{
    protected E[][] matrix;

    protected abstract E addElements(E firstElement, E secondElement);

    protected abstract E multiplyElements(E firstElement, E secondElement);

    /**
     * each concrete matrix-class deals with a certain type of elements
     ** at which addition is applicable and defined with specific implementation
     ** using the addElements() method
     ** based on the elements them selves
     *
     * this method is to define the (zero) for that type of elements
     */

    protected abstract E zeroElement();

    /********************//********************/


    /**
     * returns a reference of two-dim array that represents the result
     */

    protected abstract E[][] resultMatrix(int rows, int columns);

    /********************//********************/


    /**
     * String representation of an element (cell) of the matrix
     * 
     * must be implemented in the concrete matrix-class
     ** based on the kind of elements in that matrix
     */

    protected abstract String elementString(E element);

    /********************//********************/


    public E[][] multiplyMatrix(GenericMatrix<E> secondMatrix){

        if(matrix[0].length != secondMatrix.matrix.length)
            throw new IllegalArgumentException("rows and columns of both matrices must match");

        E[][] result = resultMatrix(matrix.length, secondMatrix.matrix[0].length);

        for (int h = 0, i = 0, j = 0; h < matrix.length*secondMatrix.matrix[0].length; h++, i = (int)(h / secondMatrix.matrix[0].length), j = h % secondMatrix.matrix[0].length) {

            E cell = zeroElement();
            for (int k = 0; k < secondMatrix.matrix.length; k++) {
                cell = addElements(cell, multiplyElements(matrix[i][k], secondMatrix.matrix[k][j]));
            }
            result[i][j] = cell;
        }
        return result;
    }


    public E[][] addMatrix(GenericMatrix<E> secondMatrix) {

            if(!((matrix.length == secondMatrix.matrix.length) && (matrix[0].length == secondMatrix.matrix[0].length)))
                throw new IllegalArgumentException("matrices' size must be identical");

            E[][] result = resultMatrix(matrix.length, matrix[0].length);

            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < secondMatrix.matrix.length; j++)
                    result[i][j] = addElements(matrix[i][j], secondMatrix.matrix[i][j]);

            return result;
    }


    @Override
    public String toString() {
        String matrixView = "";

        int width = elementString(matrix[0][0]).length();

        for (E[] row : matrix) {
            matrixView += "|";
            
            for (E element : row) {
                matrixView += (String.format("%-" + width + "s ", elementString(element)));
            }
            matrixView += "\b|\n";
        }

        return matrixView;
    }

}