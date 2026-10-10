public class Problem5 {
    static class LibraryMember {
        private static int counter = 100;
        private final String memberNumber;
        private int borrowLimit;
        private int booksBorrowed;

        public LibraryMember(int borrowLimit) {
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
            counter++;
            this.memberNumber = "LIB-" + counter;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) booksBorrowed++;
        }

        public void borrowBook(String genre) {
            borrowBook();
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public String getMemberNumber() {
            return memberNumber;
        }

        public static int getMembersEnrolled() {
            return counter - 100;
        }

        public static boolean isValidRenewalCode(String code) {
            if (code == null || code.length() != 4) return false;
            if (code.charAt(0) != 'R') return false;
            return Character.isDigit(code.charAt(1)) &&
                   Character.isDigit(code.charAt(2)) &&
                   Character.isUpperCase(code.charAt(3));
        }
    }

    static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(int borrowLimit, String department) {
            super(borrowLimit);
            this.department = department;
        }
    }

    static class AuditUtils {
        static String processNightlyAudit(LibraryMember[] members) {
            int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;
            for (LibraryMember m : members) {
                if (m == null) {
                    nullSkipped++;
                    continue;
                }
                processed++;
                if (m instanceof FacultyMember) faculty++;
                else regular++;
            }
            return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
        }
    }
}
