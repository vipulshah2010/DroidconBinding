package calculator.com.droidconbinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Person extends BaseObservable{

    private String name;
    private int age;
    private String location;

    public Person(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }
}
