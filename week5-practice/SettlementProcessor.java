final class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone(); // defensive copy
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone(); // defensive copy
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] newSeats = seatNumbers.clone();
        newSeats[index] = newSeat;
        return new BookingReceipt(bookingId, newSeats);
    }
}

final class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

class SettlementProcessor {
    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (BookingReceipt r : receipts) {
            if (r == null) { nullSkipped++; continue; }
            processed++;
            if (r instanceof GroupBookingReceipt) group++;
            else individual++;
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}
