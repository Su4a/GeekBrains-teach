import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(singleThreadedArray());
        System.out.println(doubleThreadedArray());
    }

    public static long singleThreadedArray() {
        float[] arr = new float[10000000];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return System.currentTimeMillis() - a;
    }

    public static long doubleThreadedArray() {
        float[] arr = new float[10000000];
        float[] arrTemp1 = new float[arr.length /2];
        float[] arrTemp2 = new float[arr.length /2];
        Arrays.fill(arr, 1);

        Thread t1 = new Thread(() -> {
            System.arraycopy(arr, 0, arrTemp1, 0, arr.length/2);
            calcMath(arrTemp1);
            System.arraycopy(arrTemp1, 0, arr, 0, arr.length/2);
        });

        Thread t2 = new Thread(() -> {
            System.arraycopy(arr, arr.length /2, arrTemp2, 0, arr.length /2);
            calcMath(arrTemp2);
            System.arraycopy(arrTemp2, 0, arr, arr.length/2, arr.length/2);
        });

        long a = System.currentTimeMillis();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() - a;
    }

    public static void calcMath(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
