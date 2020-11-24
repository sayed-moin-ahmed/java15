package com.java15.example.classesobjects;


/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/index.html
 */
public class Application {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("rock",30);
        OuterClass.PublicNestedClass publicNestedClass = outerClass.new PublicNestedClass();
        publicNestedClass.setName("public nested class");
        OuterClass.PackagePrivateNestedClass packageNestedClass = outerClass.new PackagePrivateNestedClass();
        packageNestedClass.setName("package nested class");
        OuterClass.ProtectedNestedClass protectedNestedClass = outerClass.new ProtectedNestedClass();
        protectedNestedClass.setName("protected nested class");
        OuterClass.StaticPublicNestedClass  staticPublicNestedClass = new OuterClass.StaticPublicNestedClass();
        staticPublicNestedClass.setName("static nested class");
        System.out.println(staticPublicNestedClass);
        System.out.println(publicNestedClass);
        System.out.println(protectedNestedClass);
        System.out.println(packageNestedClass);
        System.out.println(outerClass);

        //INTERFACEDEMO();
    }

    private static void interfaceDemo() {
        //This technique, called covariant return type, means that the return type is allowed to vary in the same direction as the subclass.
        TopInterface  reference = null;
        reference = getTopInterface();
        reference.show();
        reference = getTopInterface1();
        reference.show();
        reference = new FunctionalInterfaceImpl();
        reference.toString();
        ((FunctionalInterfaceImpl) reference).ni.show1();
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();
        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);
    }

    private static TopInterface getTopInterface1() {
        TopInterface reference =  new CustomRecord();
        return reference;
    }

    private static TopInterface getTopInterface() {
        TopInterface reference = new CustomClass("Hello world!");
        return reference;
    }

}
