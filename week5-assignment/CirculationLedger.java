final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds.clone(); // defensive copy
    }

    public String[] getBookIds() {
        return bookIds.clone(); // defensive copy
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newBookIds = bookIds.clone();
        newBookIds[index] = newId;
        return new LoanReceipt(memberId, newBookIds);
    }

    public String getMemberId() {
        return memberId;
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}

class CirculationLedger {
    static String branchCode;

    static {
        branchCode = "MAIN-BRANCH";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0;

        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return String.format("%d processed | %d null skipped | %d reference-only | %d regular",
                processed, nullSkipped, referenceOnly, regular);
    }
}
