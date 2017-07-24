package solutions


import (
	"fmt"
)

func MaximalSquare(matrix [][]byte) int {
	//d[i][j] = ( d[i-1][j-1] == d[i][j-1] == d[i-1][j]) ? (sqrt (d[i-1][j-1]) + 1) ^ 2 ：
	// d[i][j] = max(d[i-1][j-1] , d[i][j-1] , d[i-1][j])
	// 前提  d[i][j] 周围没有边界，没有0
	if len(matrix) < 1 {
		return 0
	}
	if len(matrix) == 1 {
		return int(matrix[0][0] - 48)
	}
	maxSize := byte(0);
	for i := 0; i < len(matrix);i ++{
		for j:=0;j<len(matrix[i]) ;j++  {
			if (matrix[i][j] == '1'){
				maxSize = 1;
			}
			matrix[i][j] -= 48;
		}
	}
	fmt.Println(matrix)
	columnLen := len(matrix[0])
	rowLen := len(matrix)


	for row := 1;  row < rowLen; row++ {
		for column := 1;column < columnLen; column++ {
			if matrix[row][column] != 0{
				oppsite := matrix[row-1][column-1]
				down := matrix[row-1][column]
				left := matrix[row][column-1]
				matrix[row][column] = minByte(minByte(left, down), oppsite) + 1
				maxSize = maxByte(matrix[row][column],maxSize)
			}
		}
	}

	return int (maxSize * maxSize)
}
func maxByte(num1 byte, num2 byte) byte {
	if num1 > num2 {
		return num1
	}
	return num2
}

func minByte(num1 byte, num2 byte) byte {
	if num1 < num2 {
		return num1
	}
	return num2
}

/*
func mySqrt(num byte) byte {
	num -= '0'
	floatNum := float64(num)
	return byte(math.Sqrt(floatNum))
}
*/

