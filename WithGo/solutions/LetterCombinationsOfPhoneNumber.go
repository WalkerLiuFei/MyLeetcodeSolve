package solutions

var numbersLetter []string //{"",,"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}
func letterCombinations(digits string) []string {
	numbersLetter = []string{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
	result := make([]string, 0)
	if len(digits) < 1 {
		return result
	}
	result = dfs(digits, result, []byte{}, 0)
	return result
}
func dfs(digits string, result []string, currentLetter []byte, currentPos int) []string {
	if currentPos >= len(digits) {
		result = append(result, string(currentLetter))
		return result
	}
	digit := int(digits[currentPos]) - 48

	for _, c := range numbersLetter[digit] {
		result = dfs(digits, result, append(currentLetter, byte(c)), currentPos+1)
	}
	return result
}
