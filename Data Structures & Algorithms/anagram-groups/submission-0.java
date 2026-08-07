// =============================================================
// GROUP ANAGRAMS - Solution Rationale & Complexity Analysis
// =============================================================
//
// APPROACH: Character Frequency Counting + HashMap Grouping
//
// RATIONALE:
// - Two strings are anagrams if and only if they contain the exact
//   same character frequencies (order doesn't matter).
// - Instead of sorting each string (O(n log n) per string), we count
//   character occurrences using a fixed-size array of 26 (a-z).
// - This frequency array is converted into a unique string key
//   (e.g., "1#0#0#2#...") which is guaranteed to be identical for
//   all anagrams and different for non-anagrams.
// - We use this key in a HashMap to group original strings together.
//
// TIME COMPLEXITY: O(m * n)
//   - m = number of strings in the input array
//   - n = length of the longest string
//   - For each string, we do a single pass to count character
//     frequencies (O(n)), then build the key (O(26) = O(1)).
//   - Total: O(m * n)
//
// SPACE COMPLEXITY: O(m)
//   - The HashMap stores at most m entries (one per unique anagram group).
//   - Each key (frequency-based string) and value (list of strings)
//     collectively store the original input, but no extra
//     multiplicative overhead like sorting would introduce.
//
// SWE CONCEPTS WORTH NOTING:
// - Avoiding unnecessary sorting by leveraging problem constraints
//   (fixed lowercase alphabet) to design a more efficient "canonical key".
// - Using a HashMap<String, List<String>> for O(1) average-time
//   grouping/lookup.
// - StringBuilder is used for efficient string key construction,
//   avoiding costly repeated string concatenation.
// - Encoding frequency counts with a delimiter (e.g., '#') prevents
//   ambiguity between counts (e.g., distinguishing 1,10 from 11,0).
// =============================================================


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map: canonical frequency-based key -> list of
        //      anagram strings
        Map<String, List<String>> groups = new HashMap<>();

        // #1. Process each str in input arr
        for (String str : strs) {
            // #1.1 Builds frequency count
            //      arr: 26 lowercase letters
            int[] charCount = new int[26];
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }

            // #1.2 Convert frequency
            //      arr -> unique str key
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append(count).append('#');
            }
            String key = keyBuilder.toString();

            // #1.3 Group the current string
            //      under its computed key
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // #2. Return all grouped anagram lists
        return new ArrayList<>(groups.values());
    }
}
