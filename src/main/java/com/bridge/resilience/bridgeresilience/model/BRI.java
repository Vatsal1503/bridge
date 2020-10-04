package com.bridge.resilience.bridgeresilience.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "BRI")
public class BRI implements Serializable {
    @Column
    private String bridge_name;
    @Column
    private double Bridge_Vulnerability;
    @Column
    private double Prediction_of_acute_shock_severity;
    @Column
    private double Average_daily_traffic;
    @Column
    private double Preliminary_restoration_cost;
    @Column
    private double Restoration_time;
    @Column
    private double Disaster_management;
    @Column
    private double Area_or_region_affected;
    @Column
    private double Duration_for_Procuring_and_Tendering;
    @Column
    private double Inspection_technique;
    @Column
    private double Maturity_in_Planning_and_scheduling;
    @Column
    private double Emergency_response_management;
    @Column
    private double Arrangement_funds;
    @Column
    private double Availability_of_materials_and_equipments;
    @Column
    private double Availability_of_backup_contractor;
    @Column
    private double Detour_length;
    @Column
    private double Availability_of_fund;
    @Column(name = "Bridge_Resilience")
    private double BRI;
    @Id
    @Column(name = "created_date")
    private Timestamp createDate;

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public double getBRI() {
        return BRI;
    }

    public void setBRI(double BRI) {
        this.BRI = BRI;
    }

    public String getBridge_name() {
        return bridge_name;
    }

    public void setBridge_name(String bridge_name) {
        this.bridge_name = bridge_name;
    }

    public double getBridge_Vulnerability() {
        return Bridge_Vulnerability;
    }

    public void setBridge_Vulnerability(double bridge_Vulnerability) {
        Bridge_Vulnerability = bridge_Vulnerability;
    }

    public double getPrediction_of_acute_shock_severity() {
        return Prediction_of_acute_shock_severity;
    }

    public void setPrediction_of_acute_shock_severity(double prediction_of_acute_shock_severity) {
        Prediction_of_acute_shock_severity = prediction_of_acute_shock_severity;
    }

    public double getAverage_daily_traffic() {
        return Average_daily_traffic;
    }

    public void setAverage_daily_traffic(double average_daily_traffic) {
        Average_daily_traffic = average_daily_traffic;
    }

    public double getPreliminary_restoration_cost() {
        return Preliminary_restoration_cost;
    }

    public void setPreliminary_restoration_cost(double preliminary_restoration_cost) {
        Preliminary_restoration_cost = preliminary_restoration_cost;
    }

    public double getRestoration_time() {
        return Restoration_time;
    }

    public void setRestoration_time(double restoration_time) {
        Restoration_time = restoration_time;
    }

    public double getDisaster_management() {
        return Disaster_management;
    }

    public void setDisaster_management(double disaster_management) {
        Disaster_management = disaster_management;
    }

    public double getArea_or_region_affected() {
        return Area_or_region_affected;
    }

    public void setArea_or_region_affected(double area_or_region_affected) {
        Area_or_region_affected = area_or_region_affected;
    }

    public double getDuration_for_Procuring_and_Tendering() {
        return Duration_for_Procuring_and_Tendering;
    }

    public void setDuration_for_Procuring_and_Tendering(double duration_for_Procuring_and_Tendering) {
        Duration_for_Procuring_and_Tendering = duration_for_Procuring_and_Tendering;
    }

    public double getInspection_technique() {
        return Inspection_technique;
    }

    public void setInspection_technique(double inspection_technique) {
        Inspection_technique = inspection_technique;
    }

    public double getMaturity_in_Planning_and_scheduling() {
        return Maturity_in_Planning_and_scheduling;
    }

    public void setMaturity_in_Planning_and_scheduling(double maturity_in_Planning_and_scheduling) {
        Maturity_in_Planning_and_scheduling = maturity_in_Planning_and_scheduling;
    }

    public double getEmergency_response_management() {
        return Emergency_response_management;
    }

    public void setEmergency_response_management(double emergency_response_management) {
        Emergency_response_management = emergency_response_management;
    }

    public double getArrangement_funds() {
        return Arrangement_funds;
    }

    public void setArrangement_funds(double arrangement_funds) {
        Arrangement_funds = arrangement_funds;
    }

    public double getAvailability_of_materials_and_equipments() {
        return Availability_of_materials_and_equipments;
    }

    public void setAvailability_of_materials_and_equipments(double availability_of_materials_and_equipments) {
        Availability_of_materials_and_equipments = availability_of_materials_and_equipments;
    }

    public double getAvailability_of_backup_contractor() {
        return Availability_of_backup_contractor;
    }

    public void setAvailability_of_backup_contractor(double availability_of_backup_contractor) {
        Availability_of_backup_contractor = availability_of_backup_contractor;
    }

    public double getDetour_length() {
        return Detour_length;
    }

    public void setDetour_length(double detour_length) {
        Detour_length = detour_length;
    }

    public double getAvailability_of_fund() {
        return Availability_of_fund;
    }

    public void setAvailability_of_fund(double availability_of_fund) {
        Availability_of_fund = availability_of_fund;
    }

}
