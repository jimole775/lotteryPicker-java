package lotteryPickerJava.analyze;

public class AwardRate {
    String[] front;
    String[] behind;

    public AwardRate(String[] awardTerm) {
        front = getNumArea(5, awardTerm);
        behind = getNumArea(2, awardTerm);
    }

    private String[] getNumArea(int numLen, String[] awardTerm) {
        String[] result = new String[numLen];
        String[] newTerm = new String[awardTerm.length - numLen];
        for (int i = 0; i < awardTerm.length; i++) {
            if (i < numLen) {
                result[i] = awardTerm[i];
            } else {
                newTerm[-(numLen - i)] = awardTerm[i];
            }
        }
        awardTerm = newTerm;

        return result;
    }
}