package com.example.parecelabledemo;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

	private String name;
	private int age;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static Parcelable.Creator<Person> CREATOR = new Creator<Person>() {

		@Override
		public Person[] newArray(int size) {
			return new Person[size];
		}

		@Override
		public Person createFromParcel(Parcel source) {
			Person person = new Person();
			person.setName(source.readString());
			person.setAge(source.readInt());
			person.setLocation(source.readString());
			return person;
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getName());
		dest.writeInt(getAge());
		dest.writeString(getLocation());
	}

}
