package models;

import models.users.Driver;
import java.time.LocalDateTime;

public class Parcel {
    //1. variable
    private boolean isFragile;
    private ParcelSize size;
    private float price = 0;
    private Driver driver;
    private LocalDateTime plannedDelivery;
    private LocalDateTime orderCreated;
    //2 get and set
    public Driver getDriver() {
        return driver;
    }
    public ParcelSize getSize() {
        return size;
    }
    public LocalDateTime getOrderCreated() {
        return orderCreated;
    }
    public LocalDateTime getPlannedDelivery() {
        return plannedDelivery;
    }
    public float getPrice() {
        return price;
    }
    public boolean getFragile(){
        return isFragile;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public void setFragile(boolean isFragile) {
        this.isFragile = isFragile;
    }
    public void setOrderCreated(LocalDateTime orderCreated) {
        this.orderCreated = orderCreated;
    }
    public void setPlannedDelivery(LocalDateTime plannedDelivery) {
        if (plannedDelivery.compareTo(orderCreated) > 1){
            this.plannedDelivery = plannedDelivery;
            return;
        } 
    }

    public void setPrice() throws Exception{
        if(getFragile())
            this.price += 2.99;
        switch(getSize()) {
            case XS:
            this.price += 1 * 1.99;
                break;
            case S:
            this.price += 2 * 1.99;
                break;
            case M:
            this.price += 3 * 1.99;
                break;
            case L: 
            this.price += 4 * 1.99;
                break;
            case XL:
            this.price += 5 * 1.99;
                break;
            default:
                new Exception("There is no parcial it's size: " + getSize());
            }
    }
    public void setSize(ParcelSize size) {
        this.size = size;
    }
    //3. constructors
    public Parcel() throws Exception{
        setOrderCreated(LocalDateTime.now());
        setFragile(false);
        setDriver(new Driver());
        setSize(ParcelSize.S);
        setPrice();
        setPlannedDelivery(LocalDateTime.now().plusDays(1));
    }
    public Parcel(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, Driver driver) throws Exception{
        setOrderCreated(LocalDateTime.now());
        setFragile(isFragile);
        setDriver(driver);
        setSize(size);
        setPrice();
        setPlannedDelivery(plannedDelivery);
    }
 
    //4. toString
     public String toString(){
         return "Pasūtijums pasūtīts: " + getOrderCreated() + " Pasūtijuma izpildes laiks: " + getPlannedDelivery() + " cena: " + getPrice()  + "Kurjieris" + this.driver;
     }
    //5. other functions
    


}
