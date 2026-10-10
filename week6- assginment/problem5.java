public class Problem5 {
    static class GymMember {
        private static int counter = 2000;
        private final String membershipNumber;
        private int monthlyFee;
        private int feesPaid;

        public GymMember(int monthlyFee) {
            this.monthlyFee = monthlyFee;
            counter++;
            this.membershipNumber = "GYM-" + counter;
        }

        public void payFee(int amount) {
            feesPaid += amount;
        }

        public void payFee(int amount, String mode) {
            // record mode if needed, but reuse main logic
            payFee(amount);
        }

        public int getFeesPaid() {
            return feesPaid;
        }

        public String getMembershipNumber() {
            return membershipNumber;
        }

        public static int getMembersEnrolled() {
            return counter - 2000;
        }

        public static boolean isValidReferralCode(String code) {
            if (code == null || code.length() != 4) return false;
            if (code.charAt(0) != 'G') return false;
            return Character.isDigit(code.charAt(1)) &&
                   Character.isDigit(code.charAt(2)) &&
                   Character.isUpperCase(code.charAt(3));
        }
    }

    static class GroupClassMember extends GymMember {
        private String className;

        public GroupClassMember(int monthlyFee, String className) {
            super(monthlyFee);
            this.className = className;
        }
    }

    static class AuditUtils {
        static String processWeeklyCheckIn(GymMember[] members) {
            int processed = 0, nullSkipped = 0, group = 0, individual = 0;
            for (GymMember m : members) {
                if (m == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (m instanceof GroupClassMember) group++;
                else individual++;
            }
            return processed + " processed | " + nullSkipped + " null skipped | "Perfect — let’s make each **Category B Assignment problem** into its own **independent Java file**. That way, you can save and run them separately without worrying about dependencies.

---

## 🟢 Problem 1 – Gym Membership Foundation & Batch Trial Sign-up Validator  
Save as: `Problem1.java`

```java
public class Problem1 {
    static class GymMember {
        private String memberId;
        private int monthlyFee;
        private int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
                throw new IllegalArgumentException("Invalid memberId");
            }
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            sessionsAttended++;
        }

        public int getSessionsAttended() {
            return sessionsAttended;
        }

        public String displayInfo() {
            return "Standard Member | Sessions: " + sessionsAttended;
        }

        public static String signUpBatch(String[] memberIds, int monthlyFee) {
            int signedUp = 0, rejected = 0;
            for (String id : memberIds) {
                try {
                    new GymMember(id, monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
            return "Signed Up: " + signedUp + " | Rejected: " + rejected;
        }
    }

    static class PremiumMember extends GymMember {
        private String trainerName;

        public PremiumMember(String memberId, int monthlyFee, String trainerName) {
            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public String displayInfo() {
            return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
        }
    }
}
