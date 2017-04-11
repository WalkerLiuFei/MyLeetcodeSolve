package solutions

func setZeroes(matrix [][]int) {
	isFirstColHasZero := false
	for row := 0; row < len(matrix); row++ {
		if matrix[row][0] == 0 {
			isFirstColHasZero = true
		}
		for column := 1; column < len(matrix[row]); column++ {
			if matrix[row][column] == 0 {
				matrix[row][0] = 0
				matrix[0][column] = 0
			}
		}
	}

	for row := len(matrix) - 1; row >= 0; row-- {
		for column := len(matrix[row]) - 1; column > 0; column-- {
			if matrix[row][0] == 0 || matrix[0][column] == 0 {
				matrix[row][column] = 0
			}
		}
		if isFirstColHasZero {
			matrix[row][0] = 0
		}
	}
}
