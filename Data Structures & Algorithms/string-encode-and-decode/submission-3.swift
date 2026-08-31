class Solution 
{

    func encode(_ strs: [String]) -> String {
        // Build encoded string (length + '#' + string),
        // repeated for each element
        var result = ""
        for str in strs {
            result += "\(str.count)#\(str)"
        }
        return result
    }

    func decode(_ str: String) -> [String] {
        var result = [String]()
        let chars = Array(str)
        var i = 0

        while i < chars.count {
            // Find '#' that separates length from string
            var j = i
            while chars[j] != "#" {
                j += 1
            }

            // Parse length prefix
            let length = Int(String(chars[i..<j]))!

            // Extract exactly 'length' characters as
            // next string
            let start = j + 1
            let end = start + length
            result.append(String(chars[start..<end]))

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