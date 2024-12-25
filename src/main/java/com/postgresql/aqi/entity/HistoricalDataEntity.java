package com.postgresql.aqi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airquality")
public class HistoricalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the 'sl_no' field if it's the primary key
    private Integer slNo;

    private String city;

    private Double no2;

    private Double so2;

    private Double ozone;

    private Double co;

    private Double aqi;

    private String verdict;

    // Default constructor
    public HistoricalDataEntity() {}

    // Constructor with parameters
    public HistoricalDataEntity(Integer slNo, String city, Double no2, Double so2, Double ozone, Double co, Double aqi, String verdict) {
        this.slNo = slNo;
        this.city = city;
        this.no2 = no2;
        this.so2 = so2;
        this.ozone = ozone;
        this.co = co;
        this.aqi = aqi;
        this.verdict = verdict;
    }

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

    @Override
    public String toString() {
        return "aqiHistorical{" +
                "slNo=" + slNo +
                ", city='" + city + '\'' +
                ", no2=" + no2 +
                ", so2=" + so2 +
                ", ozone=" + ozone +
                ", co=" + co +
                ", aqi=" + aqi +
                ", verdict='" + verdict + '\'' +
                '}';
    }
}
