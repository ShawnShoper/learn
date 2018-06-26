package org.shoper.springboot.lambda.commons;

public interface Predicate<Person> {
    boolean test(Person t);
}