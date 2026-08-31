impl Solution {
    pub fn encode(strs: Vec<String>) -> String {
        // Build encoded string (length + '#' + string),
        // repeated for each element
        let mut result = String::new();
        for s in strs {
            result.push_str(&s.len().to_string());
            result.push('#');
            result.push_str(&s);
        }
        result
    }

    pub fn decode(s: String) -> Vec<String> {
        let bytes = s.as_bytes();
        let mut result = Vec::new();
        let mut i = 0;

        while i < bytes.len() {
            // Find '#' that separates length from string
            let mut j = i;
            while bytes[j] != b'#' {
                j += 1;
            }

            // Parse length prefix
            let length: usize = s[i..j].parse().unwrap();

            // Extract exactly 'length' bytes as
            // next string
            let start = j + 1;
            let end = start + length;
            result.push(s[start..end].to_string());

            // Move pointer past this string to process next one
            i = end;
        }

        result
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