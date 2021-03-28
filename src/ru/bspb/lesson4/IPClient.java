package ru.bspb.lesson4;

public class IPClient extends AbstractClient{
    private long ogrn;

    public IPClient(String name, int age, long ogrn) {
        super(name, age);
        this.ogrn = ogrn;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }
}
