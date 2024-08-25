public class Triangle implements Figure{
    double a, b, c;
    String borderColor, fillColor;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }

    @Override
    public double calculateArea() {
        double q = calculatePerimeter() / 2;
        return Math.sqrt(q * (q - a) * (q - b) * (q - c));
    }
    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public void setFillColor(String color) {
        this.fillColor = color;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }

}
