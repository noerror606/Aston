class Cat extends Animal {
    static int totalCat = 0;
    boolean hp = false;



    public Cat() {
        super();  // Вызов конструктора родительского класса
        totalCat++;
    }

@Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не может пробежать больше 200м");
        } else {
            System.out.println("Кот пробежал " + distance + "м.");
        }
    }

@Override
    public void swim(int distance) {
        System.out.println("Кот не может плавать");
    }
@Override
    public void eat(int bowl, int eat){
        if(bowl<eat){
            System.out.println("Нет столькое еды! Котик сыт: " + hp);
        }else{
            hp = true;
            System.out.println("Котик сыт: " + hp);
        }
    }
    public static int addFoodToBowl(int bowl, int foodAmount){
        return bowl += foodAmount;
    }


}

