class Solution 
{

    fun encode(strs: List<String>): String {
        // Build encoded string (length + '#' + string),
        // repeated for each element
        val sb = StringBuilder()
        for (str in strs) {
            sb.append(str.length).append('#').append(str)
        }
        return sb.toString()
    }

    fun decode(str: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0

        while (i < str.length) {
            // Find '#' that separates length from string
            var j = i
            while (str[j] != '#') {
                j++
            }

            // Parse length prefix
            val length = str.substring(i, j).toInt()

            // Extract exactly 'length' characters as
            // next string
            val start = j + 1
            val end = start + length
            result.add(str.substring(start, end))

            // Move pointer past this string to process next one
            i = end
        }

        return result
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