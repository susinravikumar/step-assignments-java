public class Problem2 {
    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) booksBorrowed++;
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public String displayInfo() {
            return "General Member | Books Borrowed: " + booksBorrowed;
        }
    }

    static class StudentMember extends LibraryMember {
        protected String course;

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        public String displayInfo() {
            return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
        }
    }

    static class HonorsStudentMember extends StudentMember {
        private int bonusLimit;

        public HonorsStudentMember(String memberId, int borrowLimit, String course, int bonusLimit) {
            super(memberId, borrowLimit, course);
            this.bonusLimit = bonusLimit;
        }

        @Override
        public String displayInfo() {
            return "Honors Student Member | Course: " + course +
                   " | Bonus Limit: " + bonusLimit +
                   " | Books Borrowed: " + getBooksBorrowed();
        }
    }

    static class FacultyMember extends LibraryMember {
        private String department;

        public FacultyMember(String memberId, int borrowLimit, String department) {
            super(memberId, borrowLimit);
            this.department = department;
        }

        @Override
        public String displayInfo() {
            return "Faculty Member | Department: " + department +
                   " | Books Borrowed: " + getBooksBorrowed();
        }
    }

    static class MembershipUtils {
        static String classifyGeneration(LibraryMember member) {
            if (member instanceof HonorsStudentMember) {
                return "Multilevel descendant (3 generations deep)";
            } else if (member instanceof FacultyMember) {
                return "Hierarchical sibling (independent branch)";
            } else {
                return "Base or simple descendant";
            }
        }

        static int getTotalBooksBorrowed(LibraryMember[] members) {
            int total = 0;
            for (LibraryMember m : members) {
                total += m.getBooksBorrowed();
            }
            return total;
        }
    }
}
