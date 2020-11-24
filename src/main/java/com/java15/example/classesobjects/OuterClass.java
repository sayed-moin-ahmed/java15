package com.java15.example.classesobjects;

public class OuterClass {
    private static int counter=0;
    private String name;
    private int age;

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    static public class StaticPublicNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("StaticPublicNestedClass::"+counter/*+":age:"+age*/);//Non-static field 'age' cannot be referenced from a static context
            return "PublicNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public class PublicNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("PublicNestedClass::"+counter);
            return "PublicNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    protected class ProtectedNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("ProtectedNestedClass::"+counter);
            return "ProtectedNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    class PackagePrivateNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            System.out.println("PackagePrivateNestedClass::"+counter);
            return "PackagePrivateNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    private class PrivateNestedClass{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "PrivateNestedClass{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OuterClass{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}
