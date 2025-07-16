package task1;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFoodAmount(int amount) {
        this.foodAmount += amount;
    }

    public void subtractFoodAmount(int amount) {
        this.foodAmount -= amount;
    }
}
