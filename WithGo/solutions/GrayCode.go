package solutions

const CONSTANT_OPERATOR = 1

func grayCode(n int) []int {
	result := make([]int, 0)
	result = append(result, 0)
	for index := 0; index < n; index++ { //控制需要操作的位
		for index2 := len(result) - 1; index2 >= 0; index2-- { //为保证连续 ，从后向前遍历。操作相应的位
			value := result[index2]
			value = int(uint(value) | CONSTANT_OPERATOR<<uint(index))
			result = append(result, value)
		}
	}
	return result
}
