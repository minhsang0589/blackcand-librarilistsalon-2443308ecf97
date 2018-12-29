package com.example.b202_26.listsalon.ContentItem;

public class Service {
    public String _id;
    public String name;
    public String description;
    public int service_time;
    public int clean_time;
    public String price;
    public int allow_excess;
    public int type;
    public int status;
    public int is_dependent;
    public String additional_services_number;
    public String created_at;

    public Service(String _id, String name, String description, int service_time, int clean_time, String price, int allow_excess, int type, int status, int is_dependent, String additional_services_number, String created_at) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.service_time = service_time;
        this.clean_time = clean_time;
        this.price = price;
        this.allow_excess = allow_excess;
        this.type = type;
        this.status = status;
        this.is_dependent = is_dependent;
        this.additional_services_number = additional_services_number;
        this.created_at = created_at;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getService_time() {
        return service_time;
    }

    public void setService_time(int service_time) {
        this.service_time = service_time;
    }

    public int getClean_time() {
        return clean_time;
    }

    public void setClean_time(int clean_time) {
        this.clean_time = clean_time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAllow_excess() {
        return allow_excess;
    }

    public void setAllow_excess(int allow_excess) {
        this.allow_excess = allow_excess;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIs_dependent() {
        return is_dependent;
    }

    public void setIs_dependent(int is_dependent) {
        this.is_dependent = is_dependent;
    }

    public String getAdditional_services_number() {
        return additional_services_number;
    }

    public void setAdditional_services_number(String additional_services_number) {
        this.additional_services_number = additional_services_number;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
