class Dog extends Animal {
    static int totalDog = 0;

    Dog() {
        super();
        totalDog++;
    }

@Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не может пробежать больше 500м");
        } else {
            System.out.println("Собака пробежала " + distance + "м.");
        }
    }

@Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Собака не может проплыть больше 10м.");
        } else {
            System.out.println("Собака проплыла " + distance + "м.");
        }
    }
}