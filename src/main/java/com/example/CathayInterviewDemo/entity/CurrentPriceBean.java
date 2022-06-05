package com.example.CathayInterviewDemo.entity;

import java.util.Map;

public class CurrentPriceBean {
    private TimeBean time;
    private String disclaimer;
    private String chartName;
    private Map<String, Object> bpi;

    public TimeBean getTime() {
        return time;
    }

    public void setTime(TimeBean time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Map<String, Object> getBpi() {
        return bpi;
    }

    public void setBpi(Map<String, Object> bpi) {
        this.bpi = bpi;
    }

    @Override
    public String toString() {
        return "CurrentPriceBean{" +
                "time=" + time +
                ", disclaimer='" + disclaimer + '\'' +
                ", chartName='" + chartName + '\'' +
                ", bpi=" + bpi +
                '}';
    }
}
