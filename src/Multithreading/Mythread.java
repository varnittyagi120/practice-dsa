package src.Multithreading;

public class Mythread implements Runnable{
    @Override
    public void run(){
        System.out.println("task1 ");
        System.out.println("inside" + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {

         Thread thread = new Thread(new Mythread());
         Thread thread1 = new Thread(new Mythread());
         Thread thread2 = new Thread(new Mythread());
         thread.start();
         thread1.start();
         thread2.start();
         System.out.println(System.currentTimeMillis());
         System.out.println("main thread name : "+Thread.currentThread().getName());
    }
}

/*
Yes, you can absolutely pass parameters to a thread’s run() method — you just don’t pass them directly to run().
Instead, you pass the data to the constructor of your Runnable class, and the run() method uses that data.

This is the standard and correct way to pass dynamic data to threads.

✅ Example: Passing Student Data to Threads
Step 1: Create a Student class
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

Step 2: Pass student data to your Runnable through constructor
public class StudentTask implements Runnable {

    private Student student;

    public StudentTask(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        System.out.println("Processing student: " + student.name);
        System.out.println("Marks: " + student.marks);
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}

Step 3: Create threads dynamically and pass different students
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Rahul", 85);
        Student s2 = new Student("Priya", 92);
        Student s3 = new Student("Amit", 78);

        Thread t1 = new Thread(new StudentTask(s1), "Student-1-Thread");
        Thread t2 = new Thread(new StudentTask(s2), "Student-2-Thread");
        Thread t3 = new Thread(new StudentTask(s3), "Student-3-Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}

✅ Output Example
Processing student: Rahul
Marks: 85
Thread: Student-1-Thread

Processing student: Priya
Marks: 92
Thread: Student-2-Thread

Processing student: Amit
Marks: 78
Thread: Student-3-Thread


Order might change because threads run concurrently.

⭐ Dynamic Case — If you want to process any number of students in a loop
List<Student> students = List.of(
        new Student("Rahul", 85),
        new Student("Priya", 92),
        new Student("Amit", 78),
        new Student("Sneha", 88)
);

for (int i = 0; i < students.size(); i++) {
    Thread t = new Thread(new StudentTask(students.get(i)), "Student-"+i+"-Thread");
    t.start();
}

🧠 Key Concept

You never pass arguments to run() directly.
Instead:

✔ Pass arguments → via constructor
✔ Store them in fields
✔ Use them inside run()

This is how all multi-threaded Java applications pass data to threads.

If you want next, I can show you:

How to process 1000+ students using a Thread Pool (ExecutorService)

How to collect results from each thread using Callable + Future

Best multithreading patterns used in real projects
* */

