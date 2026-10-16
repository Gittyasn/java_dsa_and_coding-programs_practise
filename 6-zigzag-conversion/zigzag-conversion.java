class Solution {
    public String convert(String s, int numRows) {
        // Base case: if 1 row or string length is less than/equal to numRows,
        // the zigzag pattern is identical to the original string.
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse each character and simulate the zigzag movement
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction when reaching the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move row index up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows into a single result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}