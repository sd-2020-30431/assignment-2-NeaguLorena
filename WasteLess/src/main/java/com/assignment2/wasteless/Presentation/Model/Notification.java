package com.assignment2.wasteless.Presentation.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Notification {
    private String expirationMessage;
    private PropertyChangeSupport support;

    public Notification() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setExpirationMessage(String value){
        support.firePropertyChange("expirationMessage", this.expirationMessage, value);
        this.expirationMessage = value;
    }
}
