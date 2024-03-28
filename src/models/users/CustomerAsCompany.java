package models.users;

import models.Address;

public class CustomerAsCompany extends AbstractCustomer {
    //1. variable
    private String title;
    private String companyRegNo;
    //2 get and set
    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public String getTitle() {
        return title;
    }

    public void setCompanyRegNo(String companyRegNo) {
        if(companyRegNo != null && companyRegNo.matches("[0-9]{8}"))
            this.companyRegNo = companyRegNo;
        else
            this.companyRegNo = "-----";
    }

    public void setTitle(String title) {
        /*
         * 1) Can start with special character if required
         * 2) Must start with capital letter ( Even if the first character is a special character )
         * 3) The string value must not have 2 special characters in a row ( consecutive )
         * 4) The string value must not have 2 spaces in a row ( consecutive )
         * 5) Accented characters are allowed ( eg: Faddas )
         * 6) Enclosed values at the start of the string or at the end are valid but must be inside parenthesis ( ie: (Ltd) )
         * 7) Numerics are allowed anywhere in the string value 
         */
        if(title != null && title.matches("^(\\(([^)]+)\\))?[[:punct:]]?\\p{Lu}+(?:[\\s'-]?[\\p{L}\\d]+)+(\\(([^)]+)\\))*$"))
            this.title = title;
        else
            this.title = "-----";
    }

    //3. constructors
    public CustomerAsCompany() {
        super();
        setTitle("Unregistered Company");
        setCompanyRegNo("12345678");
        setCustomerCode();
    }

    public CustomerAsCompany(Address address, String phone, String title, String companyRegNo) {
        super(address, phone);
        setTitle(title);
        setCompanyRegNo(companyRegNo);
        setCustomerCode();
    }
    //4. toString
    public String toString() {
        return "Kompānijas nosaukums: " + getTitle() + " reg nr: " + getCompanyRegNo() + " Customer code: " + super.getCustomerCode() + " " + super.getAddress();
    }
    //5. other functions
    @Override
    public void setCustomerCode() {
        super.customerCode = String.format("%d_company_%s", super.getcID(), getCompanyRegNo());
    }
}
