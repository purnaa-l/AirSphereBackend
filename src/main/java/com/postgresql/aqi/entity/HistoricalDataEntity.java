package com.postgresql.aqi.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "airquality")
public class HistoricalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slNo;

    private String city;
    private Double no2;
    private Double so2;
    private Double ozone;
    private Double co;
    private Double aqi;
    private String verdict;

    @Temporal(TemporalType.TIMESTAMP)  // This maps the 'date' field to a TIMESTAMP column in the database
    private Date date;  // Add the 'date' field for ordering by date

    // Getters and setters

    public Integer getSlNo() {
        return slNo;
    }

    public void setSlNo(Integer slNo) {
        this.slNo = slNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getAqi() {
        return aqi;
    }

    public void setAqi(Double aqi) {
        this.aqi = aqi;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
