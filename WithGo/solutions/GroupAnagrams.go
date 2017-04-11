package solutions

func groupAnagrams(strs []string) [][]string {

	groups := make(map[int][]string)
	for _, str := range strs {
		//前面加_, 表示遍历的是值，不加的话遍历的是value
		hashValue := 0
		for _, character := range str {
			hashValue += 31 * int(character)
		}
		hashValue += 31 * len(str)
		if groups[hashValue] != nil {
			groups[hashValue] = append(groups[hashValue], str) // the slices can't be modify in place
		} else {
			strings := []string{str}
			groups[hashValue] = strings
		}
	}
	var result = make([][]string, 0)
	for _, values := range groups {
		result = append(result, values)
	}
	return result
}
