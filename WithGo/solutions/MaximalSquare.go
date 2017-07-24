package solutions


func MaximalSquare(matrix [][]byte) int {
	return maximalSquare(matrix)
}
func maximalSquare(matrix [][]byte) int {
	/*dp := make([][]int,len(matrix))

	for index,_ := range dp{
		dp[index] = make([]int,len(matrix[index]))
	}*/
	//从第一排对角线 叠进
	//row2 := 0
	maxSquare := byte(0)

	for array, column := matrix[0], 0; column < len(array); column++ { //
		row := 1
		column = column + 1
		for column < len(array) && row < len(matrix) {
			matrix[row][column] = isSquare(row, column, matrix)
			if maxSquare < matrix[row][column] {
				maxSquare = matrix[row][column]
			}
			//fmt.Println(matrix[row][column])
			column++
			row++
		}
	}

	for row2 := 0; row2 < len(matrix); row2++ { //
		column2 := 0
		if matrix[row2][column2] > maxSquare {
			maxSquare = matrix[row2][column2]
		}
		column2++
		row2 = row2 + 1
		/*if (row2 >= len(matrix)){
			break;
		}
		*/
		for row2 < len(matrix) && column2 < len(matrix[row2]) {
			matrix[row2][column2] = isSquare(row2, column2, matrix)
			if maxSquare < matrix[row2][column2] {
				maxSquare = matrix[row2][column2]
			}
			column2++
			row2++
		}
	}
	return int(maxSquare)

}

func isSquare(row int, column int, matrix [][]byte) byte {
	if matrix[row][column] >= 1 &&
		matrix[row][column-1] >= 1 &&
		matrix[row-1][column] >= 1 &&
		matrix[row-1][column-1] >= 1 {
		return matrix[row-1][column-1] + byte(3)
	}
	return matrix[row][column]
}
