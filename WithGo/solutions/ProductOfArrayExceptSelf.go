package solutions

func productExceptSelf(nums []int) []int {
	allProduct := 1

	zeroElementCount := 0
	if len(nums) <= 1 {
		return nums
	}

	for _, value := range nums {
		if value == 0 {
			zeroElementCount++
			continue
		}
		allProduct *= value
	}

	for index, value := range nums {
		if zeroElementCount > 1 ||
			(zeroElementCount == 1 && value != 0) {
			nums[index] = 0
		} else if zeroElementCount == 1 && value == 0 {
			nums[index] = allProduct
		} else {
			nums[index] = allProduct / value
		}
	}
	return nums
}
