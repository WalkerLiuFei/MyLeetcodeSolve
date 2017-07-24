package solutions

import (
	"sort"
)

type Interval struct {
	Start int
	End   int
}
type IntervalsSlice []Interval

func (intervals IntervalsSlice) Len() int {
	return len(intervals)
}

func (intervals IntervalsSlice) Swap(i, j int) {
	intervals[i], intervals[j] = intervals[j], intervals[i]
}

func (intervals IntervalsSlice) Less(i, j int) bool {
	return intervals[i].Start < intervals[j].Start
}
func MergeIntervals(intervals []Interval) []Interval {
	return merge(intervals)
}
func merge(intervals []Interval) []Interval {
	if len(intervals) <= 1 {
		return intervals
	}
	result := make([]Interval,1)
	sort.Sort(IntervalsSlice(intervals))
	front :=  0
	backElement := intervals[0]
	for front < len(intervals){
		frontElement := intervals[front]
		if frontElement.End >= backElement.End &&
			backElement.End >= frontElement.Start {
			backElement.End = frontElement.End
		}

		if backElement.End < frontElement.Start{
			result = append(result, backElement)
			backElement = frontElement
		}
		front += 1
	}
	return result;
}
