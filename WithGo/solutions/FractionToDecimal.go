package solutions

import (
	"fmt"
	"math"
)

func FractionToDecimal(numerator int, denominator int) string {
	if denominator == 0 || numerator == 0 {
		return "0"
	}
	symbol := ""
	if !(numerator < 0 && denominator < 0) && (numerator < 0 || denominator < 0) {
		symbol = "-"
	}
	numerator = int(math.Abs(float64(numerator)))
	denominator = int(math.Abs(float64(denominator)))

	remainder := (numerator % denominator)
	remainderMap := make(map[int]int, 1)
	remainderMap[remainder] = 1
	remainder *= 10

	result := numerator / denominator
	resultStr := fmt.Sprintf("%d", result)
	resultArray := make([]byte, 0)

	if remainder != 0 {
		//	resultArray = append(resultArray,48)
		resultArray = append(resultArray, '.')
		for true {
			result = remainder / denominator
			remainder = remainder % denominator
			resultArray = append(resultArray, byte(result)+48)
			if remainder == 0 {
				resultStr = resultStr + string(resultArray)
				break
			}

			if remainderMap[remainder] != 0 {
				resultStr = resultStr + string(resultArray[:remainderMap[remainder]]) + "(" + string(resultArray[remainderMap[remainder]:]) + ")"
				break
			}

			remainderMap[remainder] = len(resultArray)
			remainder = remainder * 10
		}
	}
	if len(symbol) > 0 {
		return symbol + resultStr
	} else {
		return resultStr
	}
}
