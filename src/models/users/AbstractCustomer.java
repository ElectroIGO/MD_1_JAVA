package models.users;

import java.util.ArrayList;

import models.Address;
import models.Parcel;

public abstract class AbstractCustomer {
    //1. variable
    private static long cID;
    private Address address;
    private String phoneNo;
    private ArrayList<Parcel> parcels = new ArrayList<Parcel>();
    protected String customerCode;
    //2 get and set
    public long getcID() {
        return cID;
    }
    public Address getAddress() {
        return address;
    }
    public String getCustomerCode() {
        return customerCode;
    }
    public ArrayList<Parcel> getParcels() {
        return parcels;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public abstract void setCustomerCode();

    public void addNewParcel(Parcel parcel) throws Exception{
        if(parcel == null && parcel instanceof Parcel)
            throw new IllegalArgumentException("[ERROR]: invalid arguments"); 
        for (Parcel e : parcels){
            if (e.equals(parcel)){
                throw new IllegalArgumentException("[ERROR]: parcel exists");
            }
        }
        this.parcels.add(parcel);
    }

    public void setPhoneNo(String phoneNo) {
        if(phoneNo != null && phoneNo.matches("[0-9]{8}"))
            this.phoneNo = phoneNo;
        else
            this.phoneNo = "------";
    }

    //3. constructors
    public AbstractCustomer() {
        cID++;
        setAddress(new Address());
        setPhoneNo("22343454");
    }
 
    public AbstractCustomer(Address address, String phone) {
        cID++;
        setAddress(address);
        setPhoneNo(phone);
    }

    //4. toString
    public String toString(){
        return " ";
    }
    //5. other functions
}
