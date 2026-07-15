package test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Practice {


    record Student(String name, Double grade){}

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Student> students = Arrays.asList(
                new Student("Alice", 85.0),
                new Student("Bob", 90.5),
                new Student("Charlie", 78.0),
                new Student("David", 92.3),
                new Student("Alice", 5.0)

        );

//        Map<String,Double> stringDoubleMap = students.stream()
//                .collect(Collectors.toMap(Student::name, Student::grade, (a,b)->a));

        Map<String,Double> group = students.stream().collect(Collectors.groupingBy(Student::name,
                Collectors.summingDouble(Student::grade)));

        group.forEach((key,value)->{
            System.out.println("Student : "+key+ "Grade : "+value);
        });

        double avg = students.stream().mapToDouble(Student::grade).average().orElse(0.0);

        System.out.println("Average : "+avg);

        Map<String,Double> averageMarks = students.stream().collect(Collectors.groupingBy(
                Student::name, Collectors.averagingDouble(Student::grade)
        ));

        group.forEach((key,value)->{
            System.out.println("Student : "+key+ "Grade : "+value);
        });

        Iterator iterator = group.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(group.get(iterator.next()));

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            group.put("Istanbul", 89.0);
        }

        List<String> studentsName = students.stream().map(e->e.name).toList();

        for(String name : studentsName){
            System.out.println("Name : "+name);
        }


        Runnable task = () -> System.out.println("Subhash");

        Thread t1 = new Thread(task);
        t1.start();

        Callable<String> stringCallable = ()-> {
            Thread.sleep(1000);
            return "Subhash";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(stringCallable);
        String result = future.get(); // blocks until result is available
        System.out.println(result);
        executor.shutdown();

    }
}
