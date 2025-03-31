package util;

import java.text.DecimalFormat;

public class BytesToMegabytes {

    public static String bytesToMegabytes(long bytes) {
        double megabytes = (double) bytes / (1024 * 1024);
        DecimalFormat df = new DecimalFormat("0.00"); // Format to 2 decimal places
        return df.format(megabytes) + " MB";
    }

    public static String bytesToMegabytes(double bytes) {
        double megabytes = bytes / (1024 * 1024);
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(megabytes) + " MB";
    }

    public static void main(String[] args) {
        long bytes1 = 5242880; // 5 MB
        long bytes2 = 1048576; // 1 MB
        long bytes3 = 1572864; // 1.5 MB
        double bytes4 = 1048576.5; // 1.0000005 MB

        System.out.println(bytesToMegabytes(bytes1)); // Output: 5.00 MB
        System.out.println(bytesToMegabytes(bytes2)); // Output: 1.00 MB
        System.out.println(bytesToMegabytes(bytes3)); // Output: 1.50 MB
        System.out.println(bytesToMegabytes(bytes4)); // output: 1.00 MB
    }
}