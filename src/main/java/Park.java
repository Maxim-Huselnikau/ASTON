public class Park {
    public String parkName;
    public int parkNumber;

    public Park(String parkName, int parkNumber) {
        this.parkName = parkName;
        this.parkNumber = parkNumber;
    }

    public class Attraction {
        public String attractionName;
        public int price;
        public String workTime;

        public Attraction(String attractionName, int price, String workTime) {
            this.attractionName = attractionName;
            this.price = price;
            this.workTime = workTime;
        }

        public void getAttractionInfo() {
            System.out.println("attractionName: " + attractionName + ", price: " + price + ", workTime: " + workTime);
        }
    }
}
