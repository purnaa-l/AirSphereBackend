package com.postgresql.aqi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "user_fetches_dynamic")
public class Aqi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aqi_id", updatable = false, nullable = false)
    private Long aqiId;

    @Column(name = "date_column", nullable = true)
    private LocalDate date;

    @Column(name = "time_column", nullable = true)
    private LocalTime time;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "station", nullable = false)
    private String station;

    @Column(name = "coordinates", nullable = true)
    private String coordinates;

    @Column(name = "measuring_time", nullable = false)
    private String measuringTime;

    @Column(name = "carbon_monoxide", nullable = true)
    private String carbonMonoxide;

    @Column(name = "humidity", nullable = true)
    private String humidity;

    @Column(name = "nitrogen_dioxide", nullable = true)
    private String nitrogenDioxide;

    @Column(name = "ozone", nullable = true)
    private String ozone;

    @Column(name = "pressure", nullable = true)
    private String pressure;

    @Column(name = "pm10", nullable = true)
    private String pm10;

    @Column(name = "pm2_5", nullable = true)
    private String pm2_5;

    @Column(name = "sulphur_dioxide", nullable = true)
    private String sulphurDioxide;

    @Column(name = "temperature", nullable = true)
    private String temperature;

    @Column(name = "wind_speed", nullable = true)
    private String windSpeed;

    @Column(name = "aqi", nullable = false)
    private Long AQI;

    @Column(name = "verdict", nullable = true)
    private String verdict;

    // Added optimistic locking version field
    @Version
    @Column(name = "version")
    private Long version;



    // Getters and Setters
    public Long getAqiId() {
        return aqiId;
    }

    public void setAqiId(Long aqiId) {
        this.aqiId = aqiId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getMeasuringTime() {
        return measuringTime;
    }

    public void setMeasuringTime(String measuringTime) {
        this.measuringTime = measuringTime;
    }

    public String getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(String carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(String nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public String getOzone() {
        return ozone;
    }

    public void setOzone(String ozone) {
        this.ozone = ozone;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(String pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public String getSulphurDioxide() {
        return sulphurDioxide;
    }

    public void setSulphurDioxide(String sulphurDioxide) {
        this.sulphurDioxide = sulphurDioxide;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Long getAQI() {
        return AQI;
    }

    public void setAQI(Long AQI) {
        this.AQI = AQI;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    // No-argument constructor (default constructor)
    public Aqi() {
    }

    // Parameterized constructor
    public Aqi(Long aqiId, LocalDate date, LocalTime time, String city, String station, String coordinates,
               String measuringTime, String carbonMonoxide, String humidity, String nitrogenDioxide, String ozone,
               String pressure, String pm10, String pm2_5, String sulphurDioxide, String temperature,
               String windSpeed, Long AQI, String verdict) {
        this.aqiId = aqiId;
        this.date = date;
        this.time = time;
        this.city = city;
        this.station = station;
        this.coordinates = coordinates;
        this.measuringTime = measuringTime;
        this.carbonMonoxide = carbonMonoxide;
        this.humidity = humidity;
        this.nitrogenDioxide = nitrogenDioxide;
        this.ozone = ozone;
        this.pressure = pressure;
        this.pm10 = pm10;
        this.pm2_5 = pm2_5;
        this.sulphurDioxide = sulphurDioxide;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.AQI = AQI;
        this.verdict = verdict;
    }
}
