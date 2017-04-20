package main

func main() {
}

func singleNumber(nums []int) int {
	//theMap := make(map[int]int,0)
	result := 0;
	for _,value := range nums{
		result ^= value;
	}
	return result;
}