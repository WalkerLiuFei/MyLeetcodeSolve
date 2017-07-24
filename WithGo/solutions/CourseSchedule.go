package solutions

type Course struct {
	id           int
	preCoursesID []int
	isVisisted   bool
}

func CanFinish(numCourses int, prerequisites [][]int) bool {
	// key 是需要上的课，value是需要提前上的课所构成的一个数组
	pairMap := make(map[int][]int, numCourses)
	courseMarker := make(map[int]bool, numCourses)
	for _, pair := range prerequisites {
		pairMap[pair[1]] = append(pairMap[pair[1]], pair[0])
	}
	for key, _ := range pairMap {
		courseMarker[key] = true
		if isCycleExistByDFS(pairMap, courseMarker, key) {
			return false
		}
		courseMarker[key] = false
	}
	return true
}
func isCycleExistByDFS(courseMap map[int][]int, courseMarker map[int]bool, course int) bool {
	if len(courseMap[course]) <= 0 { //寻找到了底部
		return false
	}
	//在对这个course 进行深度搜索时首先将其标识为true
	for _, preCourse := range courseMap[course] {
		if courseMarker[preCourse] { //已经被标识了，说明寻找到了cycle
			return true
		}
		courseMarker[preCourse] = true
		if isCycleExistByDFS(courseMap, courseMarker, preCourse) {
			return true
		}
		courseMarker[preCourse] = false
	}
	return false
}
