package com.manit.krungsri.savestateapp.model;

import android.os.Parcelable;

import org.parceler.Parcel;

/**
 * Created by Akexorcist on 10/4/15 AD.
 */

public class Student implements Parcelable{
    private int id;
    private String subject;
    private String detail;
    private String lat;
    private String lng;
    private String vedio;

    public Student() {
    }

    protected Student(android.os.Parcel in) {
        id = in.readInt();
        subject = in.readString();
        detail = in.readString();
        lat = in.readString();
        lng = in.readString();
        vedio = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(android.os.Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(subject);
        parcel.writeString(detail);
        parcel.writeString(lat);
        parcel.writeString(lng);
        parcel.writeString(vedio);
    }
}
