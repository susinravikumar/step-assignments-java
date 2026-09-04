public class InventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0, totalB = 0;
        for (int a : sectionA) totalA += a;
        for (int b : sectionB) totalB += b;

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        int max = sectionA[0];
        String section = "A";
        int index = 1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > max) {
                max = sectionA[i];
                section = "A";
                index = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > max) {
                max = sectionB[i];
                section = "B";
                index = i + 1;
            }
        }

        System.out.println("Section A Total: " + totalA + 
                           " | Section B Total: " + totalB + 
                           " | Status: " + status + 
                           " | Highest Quantity: " + max + 
                           " (Section " + section + ", Item " + index + ")");
    }

    public static void main(String[] args) {
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
