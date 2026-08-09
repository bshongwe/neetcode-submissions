public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> groups = new Dictionary<string, List<string>>();

        foreach (string str in strs)
        {
            int[] charCount = new int[26];

            foreach (char c in str)
                charCount[c - 'a']++;

            StringBuilder keyBuilder = new StringBuilder();
            foreach (int count in charCount)
            {
                keyBuilder.Append(count);
                keyBuilder.Append('#');
            }

            string key = keyBuilder.ToString();

            if (!groups.TryGetValue(key, out var list))
            {
                list = new List<string>();
                groups[key] = list;
            }

            list.Add(str);
        }

        List<List<string>> result = new List<List<string>>();
        foreach (var v in groups.Values)
            result.Add(v);

        return result;
    }
}
