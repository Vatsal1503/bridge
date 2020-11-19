package com.bridge.resilience.bridgeresilience.model;

public class BridgeNamevalidtion {

    private String bridge_name;
    private boolean valid;

    public BridgeNamevalidtion() {
    }
    public BridgeNamevalidtion(BRI bri) {
        if(bri!=null){
            this.bridge_name=bri.getBridge_name();
        }
    }
    public String getBridge_name() {
        return bridge_name;
    }

    public void setBridge_name(String bridge_name) {
        this.bridge_name = bridge_name;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
