package task1;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Katty");
        cats[1] = new Cat("Pussy");
        cats[2] = new Cat("Barsik");

        Bowl bowl = new Bowl(100);

        cats[0].eat(10,bowl);
        cats[1].eat(90,bowl);
        cats[2].eat(10,bowl);

        System.out.println(cats[0].name + " is not hungry - " + cats[0].bellyFull);
        System.out.println(cats[1].name + " is not hungry - " + cats[1].bellyFull);
        System.out.println(cats[2].name + " is not hungry - " + cats[2].bellyFull);

    }
}