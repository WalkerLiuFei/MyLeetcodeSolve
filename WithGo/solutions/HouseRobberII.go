package solutions

// 这个问题相对与第一个问题在于，
func rob(nums []int) int {

	if len(nums) == 0 || len(nums) == 2 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	return max(Rob(nums[:len(nums)-1]), Rob(nums[1:len(nums)]))
}
