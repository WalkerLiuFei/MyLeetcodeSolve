package main

func main() {
	var values = []int{1, 2, 1, 2}
	root := ListNode{}
	temp := &root
	for _, value := range values {
		temp.Val = value;
		temp.Next = &(ListNode{})
		temp = temp.Next
	}
	//partition(&root, 0)
	reverseList(root)
}

type ListNode struct {
	Val  int `nil`
	Next *ListNode
}


func partition(head *ListNode, x int) *ListNode {
	partition_smaller := ListNode{}
	partition_not_smaller := ListNode{}
	follower_smaller := &partition_smaller
	follower_not_smaller := &partition_not_smaller
	for head != nil {
		if (head.Val < x){
			follower_smaller.Next = head
			follower_smaller = follower_smaller.Next
		}else {
			follower_not_smaller.Next = head
			follower_not_smaller = follower_not_smaller.Next
		}
		head = head.Next
	}
	follower_not_smaller.Next = nil
	follower_smaller.Next = partition_not_smaller.Next
	return partition_smaller.Next
/*	if (head == nil || head.Next == nil)	 {
		return head
	}
	var partition_smaller *ListNode
	var follower_smaller *ListNode
	var follower_smaller_pre *ListNode  //这个用来记录绝对不为nil的值
	var partition_not_smaller *ListNode
	var follower_not_smaller *ListNode
	for head != nil {

		if (head.Val < x) {
			// 没有初始化的时候进行初始化
			if (partition_smaller == nil) {
				partition_smaller = &ListNode{
					Val:head.Val,
				}
				follower_smaller = (*partition_smaller).Next
			} else {
				follower_smaller = &ListNode{
					Val:head.Val,
				}
				follower_smaller_pre = follower_smaller
				follower_smaller = follower_smaller.Next
			}
		} else {
			if (partition_not_smaller == nil) {
				partition_not_smaller = &ListNode{
					Val:head.Val,
				}
				follower_not_smaller = (*partition_not_smaller).Next
			} else {
				follower_not_smaller = &ListNode{
					Val:head.Val,
				}
				follower_not_smaller = (*follower_not_smaller).Next
			}
		}
		head = head.Next
	}
	if (follower_smaller_pre != nil && partition_not_smaller != nil) {
		follower_smaller_pre.Next = partition_not_smaller
		return partition_smaller
	} else if (follower_smaller_pre != nil && partition_not_smaller == nil) {
		return partition_smaller
	} else if (partition_smaller == nil) {
		return partition_not_smaller;
	} else if (follower_smaller_pre == nil) {
		follower_smaller.Next = partition_not_smaller
		return partition_smaller
	}
	return partition_smaller*/
}