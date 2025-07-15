public class Main {
    public static void main(String[] args) {
        //task1
        Product product = new Product("chees", "01.01.0001", "Home Inc",
                "Italy", 999999, true);
        product.getInformationAboutProduct();

        //task2
        Product[] products = new Product[5];
        products[0] = new Product("chees", "01.01.0001", "Home Inc",
                "Italy", 20, true);
        products[1] = new Product("tomatoes", "01.01.0001", "Home Inc",
                "Italy", 10, true);
        products[2] = new Product("vine", "01.01.0001", "Home Inc",
                "Italy", 2, true);
        products[3] = new Product("girls", "01.01.2000", "Home Inc",
                "Italy", 999999999, false);
        products[4] = new Product("veg's", "01.01.0001", "Home Inc",
                "Italy", 4, true);

        //task3
        Park park = new Park("Local BEST Park", 1);
        Park.Attraction attraction = park.new Attraction("Snake", 3, "00:00-00:01");

        attraction.getAttractionInfo();
    }
}