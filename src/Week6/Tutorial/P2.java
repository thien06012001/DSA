package Week6.Tutorial;

public class P2 {
    Item[] items;
    boolean[] bestSubset; // Tracks the subset of items that gives the maximum value
    int maxValue; // Maximum value achievable within the capacity
    int capacity; // Maximum weight capacity of the knapsack

    public P2(Item[] i, int c) {
        items = i;
        bestSubset = new boolean[i.length];
        capacity = c;
        maxValue = 0;
    }
    // Initiates the brute force search for the optimal subset of items
    public void start() {
        subset(new boolean[items.length], 0);
    }
 /**
     * Recursively generates all possible subsets of items.
     *
     * @param selected Boolean array indicating whether each item is included in the subset.
     * @param idx      Current index in the items array.
     */
    void subset(boolean[] selected, int idx) {
        if (idx == items.length) {
            process(selected);
            return;
        }

        // Not selected, exclude the current item from the subset
        selected[idx] = false;
        subset(selected, idx + 1);

        // Selected, include the current item in the subset
        selected[idx] = true;
        subset(selected, idx + 1);
    }

    //Processes a subset to calculate its total weight and value, and updates the best subset if needed
    void process(boolean[] selected) {
        int w = 0, v = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) {
                w += items[i].weight;//Add the weight of the selected item
                v += items[i].value; //Add the value of the selected item
                if (w > capacity) { // If the total weight exceeds capacity, discard this subset
                    return;
                }
            }
        }
        if (v > maxValue) { // Update the best subset if the value is greater than the current max
            maxValue = v;
            bestSubset = selected.clone(); // Clone the selected subset
        }
    }
/**
     * Displays the best subset of items, their total weight, and their total value.
     */
    void displayBest() {
        StringBuilder res = new StringBuilder("Best subset:");
        int totalWeight = 0;
        for (int i = 0; i < bestSubset.length; i++) {
            if (bestSubset[i]) {
                totalWeight += items[i].weight;
                res.append(String.format(" item(weight: %d, value: %d)", items[i].weight, items[i].value));
            }
        }
        res.append(String.format(" with total weight %d and total value %d", totalWeight, maxValue));
        System.out.println(res);
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
                new Item(7, 42),
                new Item(3, 12),
                new Item(4, 40),
                new Item(5, 25)
        };
        P2 knapsack = new P2(items, 10);
        knapsack.start();
        knapsack.displayBest();
    }
}

class Item {
    int weight;
    int value;

    public Item(int w, int v) {
        weight = w;
        value = v;
    }
}