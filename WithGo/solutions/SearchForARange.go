package solutions

func searchRange(nums []int, target int) []int {

	resultLeft := 0
	resultRight := len(nums) - 1
	mid := (resultLeft + resultRight) / 2
	resultArray := [2]int{-1, -1}
	if len(nums) < 1 || target < nums[resultLeft] || target > nums[resultRight] {
		return resultArray[0:]
	}
	for resultRight >= resultLeft {
		if nums[mid] < target {
			resultLeft = mid + 1
		} else if nums[mid] > target {
			resultRight = mid - 1
		} else {
			resultArray[0], _ = helper1(nums, resultLeft, mid, target)
			_, resultArray[1] = helper2(nums, mid, resultRight, target)
			break
		}
		mid = (resultLeft + resultRight) / 2
	}
	return resultArray[0:]
}
func helper1(nums []int, left int, right int, target int) (resultLeft int, resultRight int) {
	if nums[left] == nums[right] {
		return left, right
	}
	for midIndex := (left + right) / 2; midIndex > left && right > left; midIndex = (left + right) / 2 {
		if nums[midIndex] == target {
			right = midIndex
		} else {
			left = midIndex
		}
	}
	if nums[left] != target {
		left = right
	}
	return left, right
}
func helper2(nums []int, left int, right int, target int) (resultLeft int, resultRight int) {
	if nums[left] == nums[right] {
		return left, right
	}
	for midIndex := (left + right) / 2; midIndex > left && right > left; midIndex = (left + right) / 2 {
		if nums[midIndex] == target {
			left = midIndex
		} else {
			right = midIndex
		}
	}
	if nums[right] != target {
		right = left
	}
	return left, right
}
