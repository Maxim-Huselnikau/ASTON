public class Product {
    public String name;
    public String dateProduced;
    public String producer;
    public String countryProduced;
    public int price;
    public boolean orderStatus;

    Product(String name, String dateProduced, String producer, String countryProduced, int price, boolean orderStatus) {
        this.name = name;
        this.dateProduced = dateProduced;
        this.producer = producer;
        this.countryProduced = countryProduced;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public void getInformationAboutProduct() {
        System.out.printf("Name: %s, dateProduced: %s, producer: %s, countryProduced: %s, price: %s, orderStatus: %s%n",
                name, dateProduced, producer, countryProduced, price, orderStatus);
    }
}
