public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        cat1.run(150);
        cat2.swim(5);
        dog1.run(400);
        dog1.swim(8);
        dog2.run(900);
        dog2.swim(900);
        cat1.eat(50,30);
        cat2.eat(30,70);

        Animal.printInfo();

        Cat[] cats = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat()};  // Массив котов
        int bowl = 0;
        bowl = Cat.addFoodToBowl(bowl, 900);
        int foodPerCat = 10;
        for (Cat cat : cats) {
            cat.eat(bowl, foodPerCat);
            bowl -= foodPerCat;  // Уменьшаем количество еды в миске
        }
        if (bowl>0) {
            System.out.println("Осталось еды: " + bowl);
        }else
            System.out.println("Еды не осталось");

    //////////////////Задание 2
        Figure circle = new Circle(5);
        circle.setFillColor("Красный");
        circle.setBorderColor("Синий");
        Figure triangle = new Triangle(5,9.4,8);
        triangle.setFillColor("Красный");
        triangle.setBorderColor("Зеленый");
        Figure rectangle = new Rectangle(5,8);
        rectangle.setFillColor("Красный");
        rectangle.setBorderColor("Желтый");

        System.out.println("Круг:" + "\nПериметр = " + circle.calculatePerimeter() + "\nПлощадь = " + circle.calculateArea() + "\nЦвет: " + circle.getFillColor() + "\nГраница: " + circle.getBorderColor());
        System.out.println("Треугольник:" + "\nПериметр = "+triangle.calculatePerimeter()+"\nПлощадь = "+triangle.calculateArea() + "\nЦвет: " + triangle.getFillColor() + "\nГраница: " + triangle.getBorderColor());
        System.out.println("Прямоугольник:" + "\nПериметр = "+rectangle.calculatePerimeter()+"\nПлощадь = "+rectangle.calculateArea()+ "\nЦвет: " + rectangle.getFillColor() + "\nГраница: " + rectangle.getBorderColor());
    }
}