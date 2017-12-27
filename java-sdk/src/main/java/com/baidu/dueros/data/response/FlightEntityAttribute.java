/* 
 * Copyright (c) 2017 Baidu, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.dueros.data.response;

/**
 * 
 * @author tianlonglong(tianlong02@baidu.com)
 * @version V1.0
 * @since 2017年10月17日
 */
public class FlightEntityAttribute extends EntityAttribute {

    private String airlines;
    private String flightNumber;
    private String model;
    private String departureAirport;
    private String departureCity;
    private String planDepartureTime;
    private String departureTime;
    private String departureTerminal;
    private String arrivalAirport;
    private String arrivalCity;
    private String planArrivalTime;
    private String arrivalTime;
    private String arrivalTerminal;
    private String flightStatus;
    private String gate;
    private String checkCounter;
    private String baggageClaim;
    private String punctualityRate;
    private String distance;
    private String runtime;
    private String preFlight;

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getPlanDepartureTime() {
        return planDepartureTime;
    }

    public void setPlanDepartureTime(String planDepartureTime) {
        this.planDepartureTime = planDepartureTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getPlanArrivalTime() {
        return planArrivalTime;
    }

    public void setPlanArrivalTime(String planArrivalTime) {
        this.planArrivalTime = planArrivalTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getCheckCounter() {
        return checkCounter;
    }

    public void setCheckCounter(String checkCounter) {
        this.checkCounter = checkCounter;
    }

    public String getBaggageClaim() {
        return baggageClaim;
    }

    public void setBaggageClaim(String baggageClaim) {
        this.baggageClaim = baggageClaim;
    }

    public String getPunctualityRate() {
        return punctualityRate;
    }

    public void setPunctualityRate(String punctualityRate) {
        this.punctualityRate = punctualityRate;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPreFlight() {
        return preFlight;
    }

    public void setPreFlight(String preFlight) {
        this.preFlight = preFlight;
    }

}
