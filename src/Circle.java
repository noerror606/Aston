public class Circle implements Figure{
    double radius;
    String fillColor, borderColor;
    public  Circle (double radius){
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
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
