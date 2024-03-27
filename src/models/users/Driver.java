package models.users;

public class Driver extends Person{
    //1. variable
    private static long dID = 0;
    private String licenseNo;
    private double experienceInYears;
    //2 get and set
    public long getdID() {
        return dID;
    }
    public String getLicenseNo() {
        return licenseNo;
    }
    public double getExperienceInYears() {
        return experienceInYears;
    }
    public void setLicenseNo(String licenseNo) {
        if(licenseNo != null && licenseNo.matches("^[A-Z]{2}[0-9]{6}$"))
            this.licenseNo = licenseNo;
        else 
            this.licenseNo = "----";
    }
    public void setExperienceInYears(double experienceInYears) {
        if(experienceInYears >= 0 && 99 >= experienceInYears)
            this.experienceInYears = experienceInYears;
        else   
            this.experienceInYears = 1000;
    }

    //3. constructors
    public Driver() {
        super();
        dID++;
        setLicenseNo("-----");
        setExperienceInYears(0);
    }
 
    public Driver(String name, String surname, String personCode, String licenseNo, double experienceInYears) {
        super(name, surname, personCode);
        setLicenseNo(licenseNo);
        setExperienceInYears(experienceInYears);
        dID++;
    }
 
    //4. toString
     public String toString(){
         return super.toString() + "Gadu pieredze: " + experienceInYears + " Licenzes numurs: " + licenseNo;
     }
    //5. other functions
}
