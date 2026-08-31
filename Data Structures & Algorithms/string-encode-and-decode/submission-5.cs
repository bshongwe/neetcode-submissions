public class Solution {

    public string Encode(IList<string> strs) {
        // Build encoded string (length + '#' + string),
        // repeated for each element
        var sb = new StringBuilder();
        foreach (var str in strs) {
            sb.Append(str.Length).Append('#').Append(str);
        }
        return sb.ToString();
    }

    public List<string> Decode(string s) {
        var result = new List<string>();
        int i = 0;

        while (i < s.Length) {
            // Find '#' that separates length from string
            int j = i;
            while (s[j] != '#') {
                j++;
            }

            // Parse length prefix
            int length = int.Parse(s.Substring(i, j - i));

            // Extract exactly 'length' characters as
            // next string
            int start = j + 1;
            int end = start + length;
            result.Add(s.Substring(start, length));

            // Move pointer past this string to process next one
            i = end;
        }

        return result;
    }
}

// ---------------------------------------------------------------------------------------------
// Question: Design an algorithm to encode a list of strings to a string. The encoded string is
// then sent over the network and is decoded back to the original list of strings.

// So Machine 1 does -->> String encoded_string = encode(strs);
// and Machine 2 does -->> List<String> decoded_strs = decode(encoded_string);

// decoded_strs in Machine 2 should be the same as the input strs in Machine 1.
// Implement the encode and decode methods.
// ---------------------------------------------------------------------------------------------

// Example 1:
// Input: strs = ["Hello","World"]
// Output: ["Hello","World"]

// Example 2:
// Input: strs = [""]
// Output: [""]

// Constraints:
// 0 <= strs.length < 100
// 0 <= strs[i].length < 200
// strs[i] contains any possible characters out of 256 valid ASCII characters.