module example {
    opens com.java15.example;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.web;
    requires spring.boot.actuator;
    requires java.sql;

}