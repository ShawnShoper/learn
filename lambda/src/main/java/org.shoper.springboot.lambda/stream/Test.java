package org.shoper.springboot.lambda.stream;

import org.junit.Before;
import org.shoper.springboot.lambda.commons.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    List<Person> persons;
    @Before
    public void init(){
        persons = new ArrayList<>();
        persons.add(new Person("shawn", LocalDate.of(2018, 1, 8), Person.Sex.MALE, "xieha.@asd.com"));
        persons.add(new Person("shoper", LocalDate.of(2011, 1, 8), Person.Sex.MALE, "xieha.@asd.com"));
    }

    @org.junit.Test
    public void map(){
        persons.stream().map(Person::getName).forEach(System.out::println);
    }
    @org.junit.Test
    public void toMap(){
        Map<String, Person> collect = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
        System.out.println(collect);
    }
    @org.junit.Test
    public void flatMap(){
        persons.stream().flatMap(p->Stream.of(p)).peek(System.out::println).forEach(System.out::println);
    }
    /*flatMap方法 如果有值，为其执行mapper函数返回Optional类型返回值，否则返回空Optional。*/
    //flatMap与map方法类似，区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。
    //需要我们自己把返回值封装为Optional
    //public<u> Optional<u> flatMap(Function<!--? super T, Optional<U-->> mapper)
//        System.out.println(op1.flatMap(str->Optional.of(str+"_briup")).get());
    //op1.flatMap(str->"");编译出错
}
