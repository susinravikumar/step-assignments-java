public class Problem2 {
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
            return "Standard Member | Sessions: " + sessionsAttended;
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
            return "Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended();
        }
    }

    static class EliteMember extends PremiumMember {
        private String lockerNumber;

        public EliteMember(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
            super(memberId, monthlyFee, trainerName);
            this.lockerNumber = lockerNumber;
        }

        @Override
        public String displayInfo() {
            return "Elite Member | Trainer: " + trainerName + " | Locker: " + lockerNumber + " | Sessions: " + getSessionsAttended();
        }
    }

    static class GroupClassMember extends GymMember {
        private String className;

        public GroupClassMember(String memberId, int monthlyFee, String className) {
            super(memberId, monthlyFee);
            this.className = className;
        }

        @Override
        public String displayInfo() {
            return "Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended();
        }
    }

    static class MembershipUtils {
        static String classifyGeneration(GymMember member) {
            if (member instanceof EliteMember) return "Multilevel descendant (3 generations deep)";
            if (member instanceof GroupClassMember) return "Hierarchical sibling (independent branch)";
            return "Base or simple descendant";
        }

        static int getTotalSessionsAttended(GymMember[] members) {
            int total = 0;
            for (GymMember m : members) total += m.getSessionsAttended();
            return total;
        }
    }
}
