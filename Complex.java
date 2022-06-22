public class Complex {

    private int realPart; 
    private int imaginaryPart;

    public Complex(int realPart, int imaginaryPart){
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public Complex add(Complex secondComplex){
        return new Complex(
            realPart + secondComplex.getRealPart(), 
            imaginaryPart + secondComplex.getImaginaryPart()
        );
    }

    public Complex multiply(Complex secondComplex){
        int realPart = this.realPart*secondComplex.getRealPart() - this.imaginaryPart*secondComplex.getImaginaryPart();
        int imaginaryPart = this.realPart*secondComplex.getImaginaryPart() + this.imaginaryPart*secondComplex.getRealPart();

        return new Complex(realPart, imaginaryPart);
    }
    
    public int getRealPart() {
        return realPart;
    }
    
    public int getImaginaryPart() {
        return imaginaryPart;
    }

    @Override
    public String toString() {
        return String.format("%d+%di", realPart, imaginaryPart);
    }
}