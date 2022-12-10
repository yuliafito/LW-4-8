package org.gifts.entity.item;

public abstract class Sweet {
    protected long id;
    protected long manufacturerId;
    protected long categoryId;
    protected String title;
    protected float price;
    protected String description;
    protected boolean isAvailable;
    protected float sugarLevel;
    protected float weight;
    protected int calorieContent;


    public Sweet(long id, long manufacturerId, long categoryId, String title, float price, String description,
                 boolean isAvailable, float sugarLevel, float weight, int calorieContent) {
        this.id = id;
        this.manufacturerId = manufacturerId;
        this.categoryId = categoryId;
        this.title = title;
        this.price = price;
        this.description = description;
        this.isAvailable = isAvailable;
        this.sugarLevel = sugarLevel;
        this.weight = weight;
        this.calorieContent = calorieContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setSugarLevel(float sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public void setCalorieContent(int calorieContent) {
        this.calorieContent = calorieContent;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {return price;}

    public float getSugarLevel() {
        return sugarLevel;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getCalorieContent() {
        return calorieContent;
    }

    public float getCurrentPrice(){return weight * price;}
    public float getCurrentSugarLevel(){return (sugarLevel/100)*1000 * weight;}
    public float getCurrentCalorieContent(){return (calorieContent/100.0F)*1000 * weight;}

    public long getManufacturerId() {
        return manufacturerId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public abstract String getInfo();

    @Override
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Sweet sweet = (Sweet) object;
            if (this.title.equals(sweet.getTitle()) && this.getId() == sweet.getId()) {
                result = true;
            }
        }
        return result;
    }
}
