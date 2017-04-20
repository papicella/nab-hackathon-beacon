package com.nab.hackathon.services.beacon.beans;

public class Info
{
    private String name;
    private String version;

    public Info()
    {
    }

    public Info(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}