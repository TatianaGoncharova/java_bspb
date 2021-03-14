package ru.bspb.lesson4;

import java.util.function.Predicate;

public class PredicateByGender implements Predicate<PhysicClient> {
    @Override
    public boolean test(PhysicClient physicClient) {
        return physicClient.getGender() != 'm';
    }
}
