package com.example.uidining;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("EventDate")
    private int eventDate;

    @SerializedName("DiningMenuID")
    private int diningMenuId;

    @SerializedName("ServiceUnit")
    private String serviceUnit;

    @SerializedName("Course")
    private String course;

    @SerializedName("CourseSort")
    private int courseSort;

    @SerializedName("FormalName")
    private String formalName;

    @SerializedName("Meal")
    private String meal;

    @SerializedName("Traits")
    private String traits;

    @SerializedName("DiningOptionID")
    private int diningOptionId;

    @SerializedName("ScheduleID")
    private int scheduleId;

    @SerializedName("ItemID")
    private int scheudleId;

    public Item() {
    }

    public String getTraits() {
        return traits;
    }

    public String getFormalName() {
        return formalName;
    }

    public String getMeal() {
        return meal;
    }
}
