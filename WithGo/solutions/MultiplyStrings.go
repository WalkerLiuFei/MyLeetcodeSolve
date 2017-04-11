package solutions

import (
	"fmt"
	"strconv"
)

func multiply(num1 string, num2 string) string {
	num1Len := len(num1)
	num2Len := len(num2)
	//result :=  make([]string,num2Len);
	segments := make([][]string, num2Len)
	for i := range segments {
		segments[i] = make([]string, num1Len+1)
	}
	for index2 := num2Len - 1; index2 >= 0; index2-- {
		number2 := int(num2[index2]) - 48
		for index1 := num1Len - 1; index1 >= 0; index1-- {
			number1 := int(num1[index1]) - 48
			segments[num2Len-index2-1][num1Len-index1-1] = strconv.FormatInt(int64(number2*number1), 10)
			segments[num2Len-index2-1][num1Len] = addTwoString(segments[num2Len-index2-1][num1Len], segments[num2Len-index2-1][num1Len-index1-1], num1Len-index1-1)
		}

	}
	return "lalal"
}

func addTwoString(src string, add string, start int) string {
	carrayBit := 0
	actuallyStart := len(src) - start //实际上应该是从后往前累加的
	for index := len(add) - 1; index > 0; index-- {
		srcIndex := actuallyStart - index
		if srcIndex < 0 {
			src = add[:index+1] + src
			//fmt.Sprintf(src,"%s%s",add[:index+1],src)
			fmt.Println(src)
			return src
		} else {
			number := src[srcIndex] + add[index] - 96
			fmt.Sprintf(src, "%s%d%s", src[0:srcIndex], number%10+byte(carrayBit), src[srcIndex+1:])
			carrayBit = int(number / 10)
			fmt.Println(src)
		}
	}
	return src
}
