import java.util.Arrays;

public class CalculatorPlus {
    private static final String DELIMITERS = ",|:";
    private static String text;

    public CalculatorPlus(String text) {
        this.text = "0";
        if (isValidText(text)) {
            this.text = ifContainsCommaThenSum(text);
        }
    }

    private String ifContainsCommaThenSum(String text) {
        if (isContainDelimiter(text)) {
            return sum(splitWithDelimiter(text));
        }
        return text;
    }

    private boolean isContainDelimiter(String text) {
        return text.contains(",") || text.contains(":");
    }

    private String sum(String[] split) {
        return String.valueOf(Arrays.stream(split).mapToInt(Integer::parseInt).sum());
    }

    private String[] splitWithDelimiter(String text) {
        return text.split(DELIMITERS);
    }

    private boolean isValidText(String text) {
        return text != null && !text.isEmpty();
    }

    public int getResult() {
        return Integer.parseInt(text);
    }
}
