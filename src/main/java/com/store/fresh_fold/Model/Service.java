package com.store.fresh_fold.Model;

public class Service {

    private int service_id;
    private String service_name;
    private String service_type;
    private double price;
    private String unit;
    private String image;  // image filename

    // Getters and setters
    public int getService_id() { return service_id; }
    public void setService_id(int service_id) { this.service_id = service_id; }

    public String getService_name() { return service_name; }
    public void setService_name(String service_name) { this.service_name = service_name; }

    public String getService_type() { return service_type; }
    public void setService_type(String service_type) { this.service_type = service_type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
