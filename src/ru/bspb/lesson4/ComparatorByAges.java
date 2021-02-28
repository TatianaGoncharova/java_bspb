package ru.bspb.lesson4;

import java.util.Comparator;

public class ComparatorByAges implements Comparator<AbstractClient> {
    @Override
    public int compare(AbstractClient o1, AbstractClient o2) {
        return o1.getAge() - o2.getAge();
    }
}
