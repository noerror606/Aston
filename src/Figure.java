public interface Figure {
    double calculatePerimeter();
    double calculateArea();
//как периметр сделать не знаю, поэтому сделала цвета)
    default String getFillColor() {
        return "Белый";
    }

    default String getBorderColor() {
        return "Черный";
    }

    void setFillColor(String color);
    void setBorderColor(String color);


}

