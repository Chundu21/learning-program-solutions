package Financial_Forecasting;

public class FinancialForecast {

	    public static double futureValueRecursive(double principal, double rate, int years) {
	        if (years == 0) {
	            return principal;
	        }
	        return futureValueRecursive(principal, rate, years - 1) * (1 + rate);
	    }

	    public static double futureValueMemoized(double principal, double rate, int years, double[] memo) {
	        if (years == 0) {
	            return principal;
	        }
	        if (memo[years] != 0) {
	            return memo[years];
	        }
	        memo[years] = futureValueMemoized(principal, rate, years - 1, memo) * (1 + rate);
	        return memo[years];
	    }

	    public static void main(String[] args) {
	        double principal = 10000; 
	        double rate = 0.05;       
	        int years = 5;           

	       
	        double result = futureValueRecursive(principal, rate, years);
	        System.out.printf("Future Value (Recursive): ₹%.2f\n", result);

	        double[] memo = new double[years + 1];
	        double optimizedResult = futureValueMemoized(principal, rate, years, memo);
	        System.out.printf("Future Value (Memoized): ₹%.2f\n", optimizedResult);
	    }
}
