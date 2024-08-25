public class Rectangle implements Figure{
    double height, width;
    String fillColor, borderColor;
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width*height;
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
