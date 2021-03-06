package com.java15.example.collections;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> ints = getInts();
        List<String> strings = getStrings();
        //collectionInterfaceDemo();
        //aggregationExample();
        //extracted();
        //iteratorDemo(ints);
        //forEachDemo(strings);
        //iteratorInThread(ints, strings);
        //collectionsExample(strings);
        //setDemo();
        //listDemo();
        //queueDemo();
        getSortedSet();
    }

    private static void queueDemo(){
        Queue<String> queue = new PriorityQueue();
        while (true){
            new Thread(new QueueAddDemo(queue)).start();
            new Thread(new QueueElementDemo(queue)).start();
            new Thread(new QueueOfferDemo(queue)).start();
            new Thread(new QueuePeekDemo(queue)).start();
            new Thread(new QueuePollDemo(queue)).start();
            new Thread(new QueueRemoveDemo(queue)).start();
        }

    }

    private static void listDemo() {
        Comparator comparator = Comparator.comparing(Customer::getName).thenComparing(Customer::getId);
        Customer customer = new Customer(1,"Hello");
        getArrayList().sort(comparator);
        getArrayList().stream().forEach(objectConsumer);
        objectConsumer.accept(getArrayList().contains(customer));
        objectConsumer.accept(getArrayList().remove(customer));
        ListIterator<?> listIterator = getArrayList().listIterator();
        stringConsumer.accept("listiterator");
        while (listIterator.hasNext()){
            objectConsumer.accept(listIterator.next());
        }
        stringConsumer.accept("listiterator has previous");
        while (listIterator.hasPrevious())
            objectConsumer.accept(listIterator.previous());
        stringConsumer.accept("sublist");
        getArrayList().subList(1,2).forEach(objectConsumer);
        Arrays.asList(1,2,3,4,5,6,7,8,9,0).stream().forEach(objectConsumer);
    }

    private static List<?> getArrayList(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Hello"));
        customers.add(new Customer(1,"Hello"));
        customers.add(new Customer(2,"Hi"));
        customers.add(2,new Customer(5,"Test"));
        customers.stream().peek(objectConsumer).map(Customer::getName).forEach(stringConsumer); // look into peek method and its behaviour
        return customers;
    }

    private static void setDemo(){
        Collection<Person> persons = getPersons();
        Person person  = new Person("fan",22);
        objectConsumer.accept(persons.contains(person));
        objectConsumer.accept(persons.remove(person));
        Iterator it = persons.stream().iterator();
        while(it.hasNext()){
            objectConsumer.accept(it.next());
        }
        stringConsumer.accept("parallel::foreach");
        persons.stream().parallel().forEach(objectConsumer);
        stringConsumer.accept("spliterator");
        persons.spliterator().tryAdvance(objectConsumer);
        stringConsumer.accept("forEachRemaining");
        persons.spliterator().forEachRemaining(objectConsumer);
        persons.stream().collect(Collectors.toSet());
        Set<String> personNames = persons.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        personNames.forEach(stringConsumer);
        //getTreeSetCustomers().stream().forEach(objectConsumer);
        //getLinkedHashSetCustomers().stream().forEach(objectConsumer);
        //getHashSetCustomers().stream().forEach(objectConsumer);
    }

    /**
     * Implement java.lang.Comparable for TreeSet.
     * Null not allowed in TreeSet.
     */
    private static Collection<?> getTreeSetCustomers() {
        Set<Customer> customers = new TreeSet<>();
        //Please refer the equals & hashcode in Customer - comment and uncomment both the methods to see impact
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(2,"Rock"));
        //customers.add(null);
        return customers;
    }

    private static void  getSortedSet(){
        // how many words begin with each letter.
        SortedSet<String> dictionary = new TreeSet<String>();
        dictionary.add("ample");
        dictionary.add("account");
        dictionary.add("doorbell");
        dictionary.add("pickle");
        //int count = dictionary.subSet("doorbell", "pickle").size();
        //System.out.println(count);
        for (char ch = 'a'; ch <= 'z'; ) {
            String from = String.valueOf(ch++);
            String to = String.valueOf(ch);
            System.out.println(from + ": " + dictionary.subSet(from, to).size());
        }
    }

    /**
     * Implement java.lang.Comparable for TreeSet.
     * Null is allowed in TreeSet.
     */
    private static Collection<?> getLinkedHashSetCustomers() {
        Set<Customer> customers = new LinkedHashSet<>();
        //Please refer the equals & hashcode in Customer - comment and uncomment both the methods to see impact
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(2,"Rock"));
        customers.add(null);
        return customers;
    }
    /**
     * Implement java.lang.Comparable for TreeSet.
     * Null is allowed in TreeSet.
     */
    private static Collection<?> getHashSetCustomers() {
        Set<Customer> customers = new HashSet<>();
        //Please refer the equals & hashcode in Customer - comment and uncomment both the methods to see impact
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(1,"Sam"));
        customers.add(new Customer(2,"Rock"));
        customers.add(null);
        return customers;
    }

    private static Collection<Person> getPersons() {
        Set<Person> persons = new HashSet<>();
        persons.add(new Person("sam",22));
        persons.add(new Person("mas",22));
        persons.add(new Person("rock",52));
        persons.add(new Person("mess",52));
        persons.add(new Person("fan",22));
        return persons;
    }

    private static Collection<Person> getLinkedHashSetPersons() {
        Set<Person> persons = new LinkedHashSet<>();
        persons.add(new Person("sam",22));
        persons.add(new Person("mas",22));
        persons.add(new Person("rock",52));
        persons.add(new Person("mess",52));
        persons.add(new Person("fan",22));
        return persons;
    }
    private static Collection<Person> getListPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("sam",22));
        persons.add(new Person("mas",22));
        persons.add(new Person("rock",52));
        persons.add(new Person("mess",52));
        persons.add(new Person("fan",22));
        System.out.println(persons.get(0));
        return persons;
    }

    private static void collectionsExample(List<String> strings) throws InterruptedException {
        var val = getInts().removeAll(Collections.singleton(7));
        System.out.println(getInts().removeAll(Collections.singletonList(7)));
        getInts().stream().forEach(intConsumer);
        Collections.reverse(strings);
        strings.stream().forEach(stringConsumer);
        Collections.sort(strings,Comparator.naturalOrder());
        strings.stream().forEach(stringConsumer);
        try {
            Collections.checkedCollection(getRaw(), String.class).forEach(stringConsumer);
        }catch (ClassCastException classCastException){
            System.out.println(classCastException.getMessage());
        }
        Collections.emptyList().stream().forEach(objectConsumer);
        try {
            var emptyList = Collections.emptyList();
            emptyList.add(1);
            emptyList.add(2);
            emptyList.stream().forEach(objectConsumer);
        }catch (UnsupportedOperationException unsupportedOperationException){
            stringConsumer.accept(unsupportedOperationException.getMessage());
        }
        Enumeration<Integer> enumeration = Collections.enumeration(getInts());
        stringConsumer.accept("Enumeration...");
        while (enumeration.hasMoreElements()){
            intConsumer.accept(enumeration.nextElement());
        }
        stringConsumer.accept("Enumeration...Iterator ...consumed");
        Iterator<Integer> iterator = enumeration.asIterator();
        while (iterator.hasNext()){
            intConsumer.accept(iterator.next());
        }
        stringConsumer.accept("Enumeration...Iterator ...new");
        Enumeration<Integer> enumeration1 = Collections.enumeration(getInts());
        Iterator<Integer> iterator1 = enumeration1.asIterator();
        while (iterator1.hasNext()){
            intConsumer.accept(iterator1.next());
        }
        try {
            List<String> nStrings = Collections.unmodifiableList(strings);
            nStrings.add("add");
        }catch (UnsupportedOperationException unsupportedOperationException){
            stringConsumer.accept(unsupportedOperationException.getMessage());
        }
        stringConsumer.accept("Synchronized...");
        List<String> syncStrings = Collections.synchronizedList(strings);
        for(int i=0;i<5;i++){
            new Thread(new StringManipulation(syncStrings)).start();
        }
        Thread.sleep(1000);
        syncStrings.stream().forEach(stringConsumer);
    }

    static class StringManipulation implements Runnable{
        final private List<String> list;
        StringManipulation(final List<String> list){
            this.list = list;
        }
        @Override
        public void run() {
            for(int i=0;i<5;i++)
                list.add(Integer.toString(i));
        }
    }

    private static void iteratorInThread(List<Integer> ints, List<String> strings) {
        while (true) {
            Thread thread = new Thread(new RemoveDemo(ints, strings));
            thread.setName(thread.getName());
            thread.start();
            stringConsumer.accept(thread.getName());
        }
    }

    private static List<String> getStrings() {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("Hi");
        strs.add("How");
        strs.add("are");
        strs.add("you");
        strs.add("?");
        return strs;
    }

    private static List getRaw() {
        var val = new ArrayList();
        val.add("Hello");
        val.add("Hi");
        val.add(1);
        val.add(2.2);
        val.add(2.3f);
        return val;
    }

    static class RemoveDemo implements Runnable{

        private final List<Integer> ints;
        private final List<String> strings;
        RemoveDemo(final List<Integer> ints, final List<String> strings){
            this.ints = ints;
            this.strings = strings;
        }

        @Override
        public void run() {
            var iterator = ints.iterator();
            while (iterator.hasNext()){
                var value = iterator.next();
                if(Objects.nonNull(value)) {
                    iterator.remove();
                    stringConsumer.accept("Removed..."+ Thread.currentThread().getName());
                }
            }
        }
    }

    private static List<Integer> getInts() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(0);
        list.add(7);
        list.add(7);
        list.add(7);
        return list;
    }

    //can't remove element
    private static void forEachDemo(List list) {
        List.of(1,2,3,4).forEach(System.out::println);
        for(var v : list){
            System.out.println("Result::"+v);
        }
    }

    private static void iteratorDemo(List<Integer> list){
        list.removeIf(value -> 3 == value);
    }

    /**
     * The Collections framework has always provided a number of so-called "bulk operations" as part of its API.
     * These include methods that operate on entire collections, such as containsAll, addAll, removeAll, etc.
     * Do not confuse those methods with the aggregate operations that were introduced in JDK 8.
     * The key difference between the new aggregate operations and the existing bulk operations (containsAll, addAll, etc.) is that the old versions are all mutative, meaning that they all modify the underlying collection.
     * In contrast, the new aggregate operations do not modify the underlying collection.
     * When using the new aggregate operations and lambda expressions, you must take care to avoid mutation so as not to introduce problems in the future, should your code be run later from a parallel stream.
     */
    private static void extracted() {
        int counter = 0;
        List<Integer> list =  new ArrayList<>();
        while (counter<10){
            list.add(counter++);
            new Thread(new Demo(list)).start();
        }
    }

    static final class Demo implements Runnable{

        private final Collection<?> collection;

        private Demo(Collection<?> collection){
            this.collection = collection;
        }

        @Override
        public void run() {
            collection.stream().forEach(System.out::println);
        }
    }

    private static void aggregationExample() {
        List.of(1,2,3,4,5,6,7,8,9,0).stream().map(Object::toString).forEach(System.out::println);
        intConsumer.accept(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).stream().mapToInt(e -> e).sum());
        intConsumer.accept(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).stream().collect(Collectors.summingInt(e->e)));
        stringConsumer.accept(List.of(1,2,3,4,5,6,7,8,9,0).stream().map(Object::toString).collect(Collectors.joining(",")));
    }

    static Consumer<Object> objectConsumer = System.out::println;
    static Consumer<String> stringConsumer = System.out::println;
    static Consumer<Integer> intConsumer = System.out::println;

    private static void collectionInterfaceDemo() {
        Predicate<String> predicate = str -> str.equals("Hello ");
        Collection<String> collection = new ArrayList<>();
        collection.add("Hello ");
        collection.add("world.");
        collection.stream().forEach(System.out::println);
        collection.stream().map(String::length).forEach(System.out::println);
        Function<String,String> mapper = String::stripIndent;
        System.out.println(collection.stream()/*.filter(predicate)*/.map(mapper).collect(Collectors.joining()));
    }

}
