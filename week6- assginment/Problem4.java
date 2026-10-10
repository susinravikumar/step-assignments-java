public class Problem4 {
    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        public void attendSession() {
            sessionsAttended++;
        }

        public int getSessionsAttended() {
            return sessionsAttended;
        }

        public String displayInfo() {
            return "Standard | Sessions: " + sessionsAttended;
        }
    }

    static class PremiumMember extends GymMember {
        protected String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
        }
    }

    static class ReportUtils {
        static String batchPrint(GymMember[] members) {
            StringBuilder sb = new StringBuilder();
            for (GymMember m : members) {
                sb.append(m.displayInfo()).append(" | ");
                if (m instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) m;
                    sb.append("[Trainer via downcast: ").append(pm.trainerName).append("] | ");
                }
            }
            return sb.toString();
        }
    }
}
