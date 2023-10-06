package DSA;

public class Stopwatch {
    private final long startTime;

    /**
     * Stopwatch constructor. Start is the program (CPU)
     * startTime time in miliseconds.
     */
    public Stopwatch() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Calculate the elapsed CPU time (how long it has
     * been since the program started)
     * @return Elapsed time (CPU)
     */
    public double elapsedTime() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - startTime) / 1000.0;
    }
}