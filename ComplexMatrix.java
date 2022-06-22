public class ComplexMatrix extends GenericMatrix<Complex>{
    
    public ComplexMatrix(Complex[][] array){
        super.matrix = array;
    }

    @Override
    protected Complex addElements(Complex firstComplex, Complex secondComplex) {
        return firstComplex.add(secondComplex);
    }
    
    @Override
    protected Complex multiplyElements(Complex firstComplex, Complex secondComplex) {
        return firstComplex.multiply(secondComplex);
    }
    
    @Override
    protected Complex zeroElement() {
        return new Complex(0, 0);
    }
    
    @Override
    protected Complex[][] resultMatrix(int rows, int columns) {
        return new Complex[rows][columns];
    }
    
    @Override
    protected String elementString(Complex element) {
        return element + "";
    }
}