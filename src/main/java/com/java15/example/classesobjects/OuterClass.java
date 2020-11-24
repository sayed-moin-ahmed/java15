package com.java15.example.classesobjects;

public class OuterClass {
    private String name;
    private int age;

    public OuterClass(String name, int age) {
        this.name = name;
        this.age = age;
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
