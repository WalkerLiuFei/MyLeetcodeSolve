package main
//最小堆的实现
type minHeap []interface{}

func (h *minHeap)Len()int  { return len(h) }

func (h * minHeap)  Less(num int){ return len(h) < num}
func (h * minHeap) Push(x interface{}) {
	return append(h,x);
}
func (h *minHeap) Pop() interface{

}



func main() {
}


