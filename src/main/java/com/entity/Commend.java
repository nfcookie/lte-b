package com.entity;

import java.io.Serializable;

public class Commend implements Serializable {

    private Integer taskId;     //任务id
    private String DroneName;
    private String DeliveryAddress;
    private String LongitudeLatitude;
    private String StartTime;       //开始时间
    private String CompletedTime;   //结束时间
    private String Version;
    private String ActionType;      //createTask/QueryTask

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDroneName() {
        return DroneName;
    }

    public void setDroneName(String droneName) {
        DroneName = droneName;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        DeliveryAddress = deliveryAddress;
    }

    public String getLongitudeLatitude() {
        return LongitudeLatitude;
    }

    public void setLongitudeLatitude(String longitudeLatitude) {
        LongitudeLatitude = longitudeLatitude;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getCompletedTime() {
        return CompletedTime;
    }

    public void setCompletedTime(String completedTime) {
        CompletedTime = completedTime;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getActionType() {
        return ActionType;
    }

    public void setActionType(String actionType) {
        ActionType = actionType;
    }
}
