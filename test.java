package sskk.gda.util.math;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import sskk.gda.util.Log;

public class MaxInDistribution {
    
    public static double mean(List<Double> data, String productId) {
        if (data == null) {
            Log.e("Mean calculation input is null", productId);
        }
        double sum = 0;
        for (Double d : data) {
            sum += d.doubleValue();
        }
        return sum / Math.max(1, data.size());
    }

    public static double std(List<Double> data, double mean, String productId) {
        if (data == null) {
            Log.e("Std calculation input is null", productId);
        }
        double sum = 0;
        for (Double d : data) {
            sum += (d.doubleValue() - mean) * (d.doubleValue() - mean);
        }
        return Math.sqrt(sum / Math.max(1, data.size()));
    }
    
    /**
     * Return the Limit Value of a distribution
     * @param data
     * @param productId
     * @return
     */
    public static int limitValue(List<Double> data, String productId) {
        if (data == null) {
            Log.e("LimitValue calculation input is null", productId);
        }
        double mean = mean(data, productId);
        double std = std(data, mean, productId);
        double maxVal = data.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        double sumVal = ceilingDec(mean + std);
        double maxValRound = ceilingDec(maxVal);
        if (sumVal * 1.5 >= maxVal) {
            return (int) maxValRound;
        }
        else {
            return (int) sumVal;
        }
    }
    
    /**
     * A simple implementation of R's ceiling_dec function
     * @param x
     * @param maxVal
     * @return
     */
    public static double ceilingDec(double x) {
        int digit = -(nchar(round(x, 0)) - 1);
        double x_val = x + 5 * Math.pow(10, (-digit - 1));
        
        double ceil = round(x_val, digit);
        System.out.println("x is " + x + " x val is " + x_val + "  digit is " + digit + " result is " + ceil);
        return ceil;
    }
    
    /**
     * A ugly implementation of R's round function,
     * may be refactored later...
     * @param x
     * @param digit
     * @return
     */
    public static double round(double x, int digit) {
        if (digit == 0) {
            // round to the nearest integer
            return Math.round(x);
        }
        else if (digit > 0) {
            // round to N digits to the right of the decimal point
            String format = "#.";
            for (int i = 0; i < digit; i++) {
                format += "#";
            }
            DecimalFormat df = new DecimalFormat(format);
            df.setRoundingMode(RoundingMode.HALF_UP);
            return Double.parseDouble(df.format(x));
        }
        else {
            // round to N digits to the left of the decimal point
            String[] splits = String.valueOf(x).split("\\.");
            String leftNumber = splits[0];
            if (-digit > leftNumber.length()){
                int left = (Math.pow(10, -digit) <= Double.parseDouble(leftNumber) * 2)?1:0;
                return left * Math.pow(10, -digit);
            }
            else {
                int offsum = 0;
                int i = leftNumber.length() - 1;
                int j = 1;
                for (; i >= leftNumber.length() + digit; i--, j *= 10) {
                    offsum += Character.getNumericValue(leftNumber.charAt(i)) * j;
                }
                if (offsum * 2 >= Math.pow(10, -digit)) {
                    int iLeft = 1;
                    if (i > -1) {
                        iLeft += Integer.parseInt(leftNumber.substring(0, i + 1));
                    }
                    return iLeft * Math.pow(10, (leftNumber.length() - i - 1)*1.0);
                }
                else {
                    return Integer.parseInt(leftNumber) - (Integer.parseInt(leftNumber) % j);
                }
            }
        }
    }
    
    public static int nchar(double x) {
        int penalty = 0;
        if (x % 1 == 0) {
            penalty = -2;
        }
        String s = String.valueOf(x);
        return s.length() + penalty;
    }
    
    public static void main(String[] args) {
        double x1 = 0.6;
        double x2 = 7;
        double x3 = 123;
        double x4 = 1389;
        double x5 = 19837.72;
        MaxInDistribution.ceilingDec(x1);
        MaxInDistribution.ceilingDec(x2);
        MaxInDistribution.ceilingDec(x3);
        MaxInDistribution.ceilingDec(x4);
        System.out.println(MaxInDistribution.round(7.0, 0));
        
    }
}
