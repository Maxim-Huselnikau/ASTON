package task1;

public class Cat extends Animals {
    static int catsCount;
    public boolean bellyFull;
    public String name;

    public Cat(String name) {
        this.name = name;
        bellyFull = false;
        catsCount++;
        System.out.println("task1.Cat has been created. Count is: " + catsCount);
    }

    public void run(int length) {
        if (length <= 200) {
            System.out.println("task1.Cat run: " + length + "м");
        } else {
            System.out.println("task1.Cat can't run: " + length + "м");
        }
    }

    public void swim(int length) {
        System.out.println("task1.Cat can't swim: " + length + "м. task1.Cat don't swim.");
    }

    public void eat(int amountFoodEat, Bowl bowl) {
        if (amountFoodEat > bowl.getFoodAmount()) {
            System.out.println("task1.Cat can't eat: " + amountFoodEat + ". There is not enough food. In the bowl just: " + bowl.getFoodAmount());
        } else if (amountFoodEat <= bowl.getFoodAmount() && amountFoodEat > 0) {
            System.out.println("Nice. task1.Cat's belly is full.");
            bellyFull = true;
            bowl.subtractFoodAmount(amountFoodEat);
        } else {
            System.out.println("Give me some food. You give me " + amountFoodEat + " food.");
        }
    }

    public void bellyIsFull() {
        if (bellyFull) {
            System.out.println("Belly is full.");
        } else System.out.println("Belly is not full.");
    }
}
