public class Problem3 {
    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;
        private int[] fineHistory = new int[10];
        private int fineCount = 0;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        protected void chargeFine(int amount) {
            if (fineCount < fineHistory.length) {
                fineHistory[fineCount++] = amount;
            }
        }

        public int[] getFineHistory() {
            return java.util.Arrays.copyOf(fineHistory, fineCount);
        }

        public int getTotalFine() {
            int sum = 0;
            for (int i = 0; i < fineCount; i++) sum += fineHistory[i];
            return sum;
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }
}
