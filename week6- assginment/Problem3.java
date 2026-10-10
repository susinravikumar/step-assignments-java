public class Problem3 {
    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private int[] lateFeeHistory = new int[10];
        private int feeCount = 0;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        protected void chargeLateFee(int amount) {
            if (feeCount < lateFeeHistory.length) {
                lateFeeHistory[feeCount++] = amount;
            }
        }

        public int[] getLateFeeHistory() {
            return java.util.Arrays.copyOf(lateFeeHistory, feeCount);
        }

        public int getTotalLateFees() {
            int sum = 0;
            for (int i = 0; i < feeCount; i++) sum += lateFeeHistory[i];
            return sum;
        }
    }

    static class PremiumMember extends GymMember {
        private String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }
}
