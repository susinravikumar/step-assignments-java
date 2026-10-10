public class Problem4 {
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
            return "General | Books: " + booksBorrowed;
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
            return "Student | Course: " + course + " | Books: " + getBooksBorrowed();
        }
    }

    static class ReportUtils {
        static String batchPrint(LibraryMember[] members) {
            StringBuilder sb = new StringBuilder();
            for (LibraryMember m : members) {
                sb.append(m.displayInfo()).append(" | ");
                if (m instanceof StudentMember) {
                    StudentMember sm = (StudentMember) m;
                    sb.append("[Course via downcast: ").append(sm.course).append("] | ");
                }
            }
            return sb.toString();
        }
    }
}
