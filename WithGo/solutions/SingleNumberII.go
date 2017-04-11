package solutions

import "fmt"

func SingleNumberII(nums []int){
	singleNumberII(nums)
}
func singleNumberII(nums []int)  {
	bits := make([]uint,32)
	var result int
	for _,num := range nums{
		for bitIndex,_ := range bits{
			if num & (1 <<  (uint(bitIndex))) != 0 {
				bits[bitIndex] = bits[bitIndex]+1
			}
		}
	}
	for bitIndex,bitCount := range bits{

		if bitCount % 3 != 0{
			result  |= 1 << uint(bitIndex)
		}
	}
	//负数取反

	if (result & (1 << 31) != 0){
		 result = - int(uint32(^result + 1))
	}
	fmt.Printf("%s %d","the reslut is ",^result + 1)
}
