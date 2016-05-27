package cl.cutiko.estimodemo.models;

/**
 * Created by cutiko on 21-05-16.
 */
public class Beacon {

    private String key;
    private int major, minor;

    public Beacon(int major, int minor) {
        this.major = major;
        this.minor = minor;
        this.key = String.valueOf(major) +":"+ String.valueOf(minor);
    }

    public String getKey() {
        return key;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }
}
