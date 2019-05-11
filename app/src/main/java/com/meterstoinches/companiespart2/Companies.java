package com.meterstoinches.companiespart2;

public class Companies {
     int comapnyRef ;
     String formalName , companyTypeCode , mainAdress;
     String mainPostcode , receptionNo , websiteURL , customer
             , supplier, compaynotes ;


    public Companies() {}

    public Companies(int comapnyRef, String formalName, String companyTypeCode, String mainAdress, String mainPostcode, String receptionNo,
                     String websiteURL, String customer, String supplier,
                     String compaynotes) {
        this.comapnyRef = comapnyRef;
        this.formalName = formalName;
        this.companyTypeCode = companyTypeCode;
        this.mainAdress = mainAdress;
        this.mainPostcode = mainPostcode;
        this.receptionNo = receptionNo;
        this.websiteURL = websiteURL;
        this.customer = customer;
        this.supplier = supplier;
        this.compaynotes = compaynotes;
    }

    public Companies(String formalName, String companyTypeCode, String mainAdress, String mainPostcode, String receptionNo,
                     String websiteURL, String customer, String supplier,
                     String compaynotes) {
        this.formalName = formalName;
        this.companyTypeCode = companyTypeCode;
        this.mainAdress = mainAdress;
        this.mainPostcode = mainPostcode;
        this.receptionNo = receptionNo;
        this.websiteURL = websiteURL;
        this.customer = customer;
        this.supplier = supplier;
        this.compaynotes = compaynotes;
    }

    public int getComapnyRef() {
        return comapnyRef;
    }

    public void setComapnyRef(int comapnyRef) {
        this.comapnyRef = comapnyRef;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public String getCompanyTypeCode() {
        return companyTypeCode;
    }

    public void setCompanyTypeCode(String companyTypeCode) {
        this.companyTypeCode = companyTypeCode;
    }

    public String getMainAdress() {
        return mainAdress;
    }

    public void setMainAdress(String mainAdress) {
        this.mainAdress = mainAdress;
    }

    public String getMainPostcode() {
        return mainPostcode;
    }

    public void setMainPostcode(String mainPostcode) {
        this.mainPostcode = mainPostcode;
    }

    public String getReceptionNo() {
        return receptionNo;
    }

    public void setReceptionNo(String receptionNo) {
        this.receptionNo = receptionNo;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCompaynotes() {
        return compaynotes;
    }

    public void setCompaynotes(String compaynotes) {
        this.compaynotes = compaynotes;
    }
}
