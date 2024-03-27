package models;

public class Address {
    //1. variable
    private City city;
    private String streetOrHouseTitle;
    private int houseNo;
    //2 get and set
    public City getCity() {
        return city;
    }
    public int getHouseNo() {
        return houseNo;
    }
    public String getStreetOrHouseTitle() {
        return streetOrHouseTitle;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public void setHouseNo(int houseNo) {
        if(houseNo >= 0)
            this.houseNo = houseNo;
        else
            this.houseNo = -1;
    }
    public void setStreetOrHouseTitle(String streetOrHouseTitle) {
        if(streetOrHouseTitle != null && streetOrHouseTitle.matches("^[A-Z][a-zA-Z\\s]*$"))
            this.streetOrHouseTitle = streetOrHouseTitle;
        else
            this.streetOrHouseTitle = "-----";
    }
    //3. constructors
    public Address() {
        setCity(City.Riga);
        setHouseNo(0);
        setStreetOrHouseTitle("Kuts");
    }
    public Address(City city, String StreetOrHouseTitle, int houseNo) {
        setCity(city);
        setHouseNo(houseNo);
        setStreetOrHouseTitle(StreetOrHouseTitle);
    }
 
    //4. toString
     public String toString(){
         return "Adrese: " + city + " " + streetOrHouseTitle + " " + houseNo;
     }
    //5. other functions
}
