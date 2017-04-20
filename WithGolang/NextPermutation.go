package main

func main() {

}
func nextPermutation(nums []int) {
	maxIndex := len(nums) - 1;
	maxElement := nums[maxIndex]
	for lastIndex := len(nums); lastIndex >= 0; lastIndex-- {
		if (nums[lastIndex] > maxElement){
			maxIndex = lastIndex
			maxElement  = nums[maxIndex]
			continue
		}
	}
}