package net.carProject.controller.form;


public class CarFilter {
    private String model;
    private String bodyType;
    private int minPrice;
    private int maxPrice;
    private int minFuel;
    private int maxFuel;
    private String city;

    public CarFilter(){
        this.model="";
        this.bodyType="";
        this.city="";
        this.minFuel=0;
        this.maxFuel=0;
        this.minPrice=0;
        this.maxPrice=0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinFuel() {
        return minFuel;
    }

    public void setMinFuel(int minFuel) {
        this.minFuel = minFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CarFilter{" +
                "model='" + model + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minFuel=" + minFuel +
                ", maxFuel=" + maxFuel +
                ", city='" + city + '\'' +
                '}';
    }
}
