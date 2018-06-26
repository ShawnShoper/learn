package org.shoper.springboot.lambda.commons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {
    //Predicate 用于进行Boolean判断
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    //Consumer 用于实现方法调用
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    //Function 用于提取方案
    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    //使用泛型针对不同的数据类型处理更通用
    public static <X, Y> void printPersonsWithPredicate(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    //利用方法引用处理

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("shawn", LocalDate.of(1993, 8, 25), Person.Sex.MALE, "369201170@qq.com"));
        persons.add(new Person("shoper", LocalDate.of(1993, 8, 25), Person.Sex.FEMALE, "xiehao3692@vip.qq.com"));
        System.out.println("Predicate");
        printPersonsWithPredicate(persons, p -> p.getGender() == Person.Sex.FEMALE);
        System.out.println("Consumer");
        printPersonsWithPredicate(persons, p -> p.getGender() == Person.Sex.FEMALE, Person::printPerson);
        System.out.println("Function");
        printPersonsWithPredicate(persons, p -> p.getGender() == Person.Sex.FEMALE, Person::getEmailAddress, System.out::println);
        System.out.println("Generics");
        printPersonsWithPredicate(persons, p -> p.getGender() == Person.Sex.FEMALE, Person::getEmailAddress, System.out::println);
        System.out.println("Use jdk lambda expressions by steam api");
        persons.stream().filter(p->p.getGender()==Person.Sex.FEMALE).map(Person::getEmailAddress).forEach(System.out::println);
    }
}


