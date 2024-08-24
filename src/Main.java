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
        bowl = Cat.addFoodToBowl(bowl, 30);  // Добавляем еду в миску
        int foodPerCat = 10;  // Количество еды, необходимое для каждого кота
        for (Cat cat : cats) {
            cat.eat(bowl, foodPerCat);
            bowl -= foodPerCat;  // Уменьшаем количество еды в миске
        }
    }
    //////////////////Задание 2

}