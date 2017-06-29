package io.egen.entity;

import javafx.scene.control.Alert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by Aastha Jain on 6/28/2017.
 */
@Entity
public class Alerts {

    @Id
    String alertId;

    public Alerts(){
        //this.alertId= UUID.randomUUID().toString();
    }
    String message;
    Timestamp timestamp;
    String priority;

   public Alerts(String alertId, String message, Timestamp timestamp, String priority) {
        this.alertId = alertId;
        this.message = message;
        this.timestamp = timestamp;
        this.priority = priority;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "alertId='" + alertId + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", priority='" + priority + '\'' +
                '}';
    }
}

