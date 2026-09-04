public class TransactionReference {
    public static String normalizeReference(String raw) {
        String ref = raw.trim();
        if (ref.length() >= 3) {
            String bank = ref.substring(0, 3).toUpperCase();
            return bank + ref.substring(3);
        }
        return ref;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9); // ddMMyy
        String seq = reference.substring(9);

        String formattedDate = date.substring(0,2) + "/" + date.substring(2,4) + "/" + date.substring(4,6);
        return "[" + bank + "] DATE: " + formattedDate + " | SEQ: " + seq;
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}
