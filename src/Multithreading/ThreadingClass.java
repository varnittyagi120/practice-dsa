package src.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadingClass implements Runnable{
    Student student;

    ThreadingClass(Student student){
        this.student = student;
    }
    @Override
    public void run(){
        System.out.println(this.student.getId());
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<1000;i++){
           Student student = new Student(i, "somename");
           executorService.submit(new ThreadingClass(student));
        }
        executorService.shutdown();
    }

}


/*
Example: Each student returns “PASS / FAIL”
class StudentResultTask implements Callable<String> {
    private Student student;

    StudentResultTask(Student student) {
        this.student = student;
    }

    @Override
    public String call() {
        return student.name + " : " + (student.marks >= 40 ? "PASS" : "FAIL");
    }
}

🔹 Submitting tasks and getting results
ExecutorService executor = Executors.newFixedThreadPool(5);

List<Future<String>> results = new ArrayList<>();

for (int i = 1; i <= 10; i++) {
    Student s = new Student("Student" + i, 30 + (i * 5));
    Future<String> future = executor.submit(new StudentResultTask(s));
    results.add(future);
}

executor.shutdown();

// Print results
for (Future<String> f : results) {
    try {
        System.out.println(f.get()); // waits for result
    } catch (Exception e) {
        e.printStackTrace();
    }
}

🧠 Output (example)
Student1 : FAIL
Student2 : FAIL
Student3 : PASS
Student4 : PASS
...

* */