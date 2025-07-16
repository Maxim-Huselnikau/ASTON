package task1;

abstract class Animals {
    static int animalsCount;

    public Animals() {
        animalsCount++;
        System.out.println("Created " + animalsCount + " animals");
    }

    abstract void run(int lenghth);

    abstract void swim(int lenghth);
}
