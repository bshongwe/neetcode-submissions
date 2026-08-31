type Solution struct{}

func (s *Solution) Encode(strs []string) string {
    // Build encoded string (length + '#' + string),
    // repeated for each element
    var sb strings.Builder
    for _, str := range strs {
        sb.WriteString(strconv.Itoa(len(str)))
        sb.WriteByte('#')
        sb.WriteString(str)
    }
    return sb.String()
}

func (s *Solution) Decode(encoded string) []string {
    result := []string{}
    i := 0

    for i < len(encoded) {
        // Find '#' that separates length from string
        j := i
        for encoded[j] != '#' {
            j++
        }

        // Parse length prefix
        length, _ := strconv.Atoi(encoded[i:j])

        // Extract exactly 'length' characters as
        // next string
        start := j + 1
        end := start + length
        result = append(result, encoded[start:end])

        // Move pointer past this string to process next one
        i = end
    }

    return result
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
