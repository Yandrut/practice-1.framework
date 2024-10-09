package org.yandrut.models;

public class FormModel {
    private final int numberOfInstances = 4;
    private final String machineType = "n1-standart-8";
    private final String GpuType = "NVIDIA Tesla V100";
    private final String localSSD = "2x375 Gb";
    private final String dataCenterLocation = "Frankfurt (europe-west3)";
    private String estimatedCost;

    public FormModel() {
        estimatedCost = "0";
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuModel() {
        return GpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public void setEstimatedCost(String cost) {
        this.estimatedCost = cost;
    }
}
