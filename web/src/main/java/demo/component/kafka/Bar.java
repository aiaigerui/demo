package demo.component.kafka;

public class Bar {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
