package solutions

import (
	"fmt"
)

type Rec struct {
	height int
	width  int
	area   int //面积
}

func largestRectangleArea(heights []int) int {
	dpRecs := make([]Rec, len(heights))
	dpRecs[0] = Rec{
		height: heights[0],
		width:  1,
		area:   heights[0],
	}
	largestRec := dpRecs[0]
	for index := 1; index < len(heights); index++ {
		dpRecs[index] = Rec{
			height: heights[index],
			width:  1,
			area:   heights[index],
		}
		for index2 := index - 1; index2 >= 0; index2-- {
			diff := index - index2
			//取较小的高度值 来作为高。
			if dpRecs[index2].height < heights[index] {
				dpRecs[index] = getMaxRec(dpRecs[index], getMax(dpRecs[index2], dpRecs[index2].height, dpRecs[index2].width+diff))
				largestRec = getMaxRec(dpRecs[index], largestRec)
			} else {
				dpRecs[index] = getMaxRec(dpRecs[index], getMax(dpRecs[index2], heights[index], dpRecs[index2].width+diff))
				largestRec = getMaxRec(dpRecs[index], largestRec)
			}
		}
		fmt.Println(largestRec)
	}
	return largestRec.area
}

func getMaxRec(rec1 Rec, rec2 Rec) Rec {
	if rec1.area > rec2.area {
		return rec1
	} else if rec1.area == rec2.area {
		if rec1.height > rec2.height {
			return rec1
		}
	}
	return rec2
}
func getMax(rec Rec, height int, width int) Rec {
	if width*height > rec.area {
		return Rec{
			height: height,
			width:  width,
			area:   height * width,
		}
	} else if width*height == rec.area {
		if height > rec.height {
			return Rec{
				height: height,
				width:  width,
				area:   height * width,
			}
		}
	}
	return rec
}
