package solutions

var minElement int

func FindMin(nums []int) int {
	if len(nums) == 0 {
		return -1
	}
	minElement = nums[0]
	findMin2(nums, 0, len(nums)-1)
	return minElement
}
func findMin2(nums []int, low int, high int) {
	if high <= low || high >= len(nums) || low < 0 {
		return
	}
	if high-low == 1 {
		if nums[high] < nums[low] {
			minElement = nums[high]
		} else {
			return
		}
	}
	middleIndex := (high-low)/2 + low
	if nums[middleIndex] > nums[middleIndex+1] {
		minElement = nums[middleIndex+1]
	}
	findMin2(nums, low, middleIndex)
	findMin2(nums, middleIndex+1, high)
}
