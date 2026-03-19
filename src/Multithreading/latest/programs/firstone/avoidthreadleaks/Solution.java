package src.Multithreading.latest.programs.firstone.avoidthreadleaks;

public class Solution {
    public static void main(String[] args) {
        SafeLock safeLock = new SafeLock();
        new Thread(safeLock::waitForSignal, "workedThread").start();
    }
}
