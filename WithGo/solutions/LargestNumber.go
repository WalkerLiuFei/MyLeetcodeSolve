package solutions

import (
	"bytes"
	"sort"
	"strconv"
	"strings"
)

//定义interface{},并实现sort.Interface接口的三个方法
/*type Own struct{
	string value
}*/
type StringSlice []string

func (c StringSlice) Len() int {
	return len(c)
}
func (c StringSlice) Swap(i, j int) {
	c[i], c[j] = c[j], c[i]
}
func (c StringSlice) Less(i, j int) bool {
	return !recursiveCompare(c[i], c[j])
}
func recursiveCompare(str1 string, str2 string) bool {
	if len(str1) == len(str2) {
		return strings.Compare(str1, str2) < 0
	} else if len(str1) > len(str2) {
		r := strings.Compare(str1[:len(str2)], str2)
		if r != 0 {
			return r < 0
		} else {
			return recursiveCompare(str1[len(str2):], str2)
		}
	} else {
		r := strings.Compare(str1, str2[:len(str1)])
		if r != 0 {
			return r < 0
		} else {
			return recursiveCompare(str1, str2[len(str1):])
		}
	}
}

func LargestNumber(nums []int) string {
	strs := make(StringSlice, len(nums))
	for index, value := range nums {
		strs[index] = strconv.Itoa(value)
	}
	sort.Sort(strs)
	if strings.EqualFold(strs[0], "0") {
		return "0"
	}
	var result bytes.Buffer
	for _, str := range strs {
		result.WriteString(str)
	}
	return result.String()
}
