package hello.springmvc.basic;


import lombok.Data;

@Data // lombok. @Getter, @Setter ...
public class HelloData {
    private String username;
    private int age;
}
