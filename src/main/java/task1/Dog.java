package task1;

public class Dog extends Animals {
    static int dogsCount;

    public Dog() {
        dogsCount++;
        System.out.println("task1.Dog has been created. Count is: " + dogsCount);
    }

    public void run(int length) {
        if (length <= 500) {
            System.out.println("task1.Dog run: " + length + "м");
        } else {
            System.out.println("task1.Dog can't run: " + length + "м");
        }
    }

    public void swim(int length) {
        if (length <= 10) {
            System.out.println("task1.Dog swim: " + length + "м");
        } else {
            System.out.println("task1.Dog can't swim: " + length + "м");
        }
    }
}
