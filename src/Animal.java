class Animal {
     static int total = 0;

    public Animal() {
        total++;
    }

    public void run(int distance) {}
    public void swim(int distance) {}
    public void eat(int food, int eat){}

    public static void printInfo() {
        System.out.println("Всего животных: " + total +
                "\nВсего котов: " + Cat.totalCat +
                "\nВсего собак: " + Dog.totalDog);
    }
}