package org.yandrut.models;

public class Form {
    private final String numberOfInstances;
    private final String machineType;
    private final String gpuType;
    private final String localSSD;
    private final String dataCenterLocation;
    private final String estimatedCost;

    public Form(String numberOfInstances, String machineType, String gpuType, String localSSD, String dataCenterLocation, String estimatedCost) {
        this.numberOfInstances = numberOfInstances;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.localSSD = localSSD;
        this.dataCenterLocation = dataCenterLocation;
        this.estimatedCost = estimatedCost;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuModel() {
        return gpuType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDataCenterLocation() {
        return dataCenterLocation;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }
}