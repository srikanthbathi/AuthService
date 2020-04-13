package com.nai.domain;

import com.nai.StoreStatus;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Store {



    @Id
    private String _id;
    private BasicDetails basicDetails;
    private String storeName;
    private String pan;
    private StoreStatus status;
    private float rating;
    private Location location;
    private Address address;
    private String GSTINCertificate;
    private String GSTIN;
    private String logo;
    private Feedback feedback;
    private BankDetails bankDetails;
    private Date createdDate;
    private Date updatedate;

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(BankDetails bankDetails) {
        this.bankDetails = bankDetails;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public BasicDetails getOwnerDetails() {
        return basicDetails;
    }

    public void setOwnerDetails(BasicDetails ownerDetails) {
        this.basicDetails = ownerDetails;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public StoreStatus getStatus() {
        return status;
    }

    public void setStatus(StoreStatus status) {
        this.status = status;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGSTINCertificate() {
        return GSTINCertificate;
    }

    public void setGSTINCertificate(String GSTINCertificate) {
        this.GSTINCertificate = GSTINCertificate;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }
}
