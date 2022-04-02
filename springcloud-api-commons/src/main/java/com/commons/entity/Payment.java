package com.commons.entity;

public class Payment {

    private Integer id;

    private String flowNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlowNumber() {
        return flowNumber;
    }

    public void setFlowNumber(String flowNumber) {
        this.flowNumber = flowNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", flowNumber='" + flowNumber + '\'' +
                '}';
    }
}
