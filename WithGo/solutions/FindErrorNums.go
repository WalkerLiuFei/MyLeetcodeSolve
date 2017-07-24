package solutions
func findErrorNums(nums []int) []int {
	result := make([]int,0)
	mark := make(map[int]bool,len(nums))
	if (len(nums) < 2){
		return nums
	}

	for _,value :=range nums{
		if (mark[value]){
			result = append(result, value)
		}
		mark[value] = true
	}
	for index,_ :=range nums{
		index += 1
		if (!mark[index]){
			result = append(result, index)
		}
	}
	return  result
}
