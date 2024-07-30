public class FinancialForecasting {

    public static double predictFutureValue(double currentValue, double growthRate, int periods) {
        if (periods == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double currentValue = 1000;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10;

        double futureValue = predictFutureValue(currentValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}
