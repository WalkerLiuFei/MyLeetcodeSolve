package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	var values = []int{5,1,9,8,8,1,5,8,2,6,8,4,7}
	root := ListNode{}
	temp := &root
	for _, value := range values {
		temp.Val = value;
		temp.Next = &(ListNode{})
		temp = temp.Next
	}
	printNodes(&root)
	printNodes(rotateRight(&root,14))


}
func rotateRight(head *ListNode, k int) *ListNode {
	linkListLen := 0;
	root := head
	if (head == nil){
		return head
	}

	front := root
	back := root
	limit := 0
/*	for node := root; node != nil;node = node.Next {linkListLen++}
	if (linkListLen == 0){
		return root
	}

	if (k <= 0 ){
		return root
	}*/
	for true {
		linkListLen = 0
		if (k == 0){
			return head
		}

		for front.Next != nil {
			front = front.Next
			limit ++ ;
			if (limit > k) {
				back = back.Next
				limit--
			}
			linkListLen ++;
		}
		linkListLen++
		if (k >= linkListLen){ //如果k 值是大于 link list 长度的，那么就必须复位并再执行一次。
			front = root
			back = root
			limit = 0
			k = k % linkListLen
		}else {             // k 值在接受范围之内，跳出循环
			break
		}
	}

	result := back.Next;
	back.Next = nil
	printNodes(result)
	front.Next = root;
	return result
}
func printNodes(newRoot *ListNode)  {
	for newRoot != nil{
		fmt.Printf("%d%s",newRoot.Val," ")
		newRoot = newRoot.Next
	}
	fmt.Println()
}
/*
func push(array []*ListNode, limit int, value *ListNode) ([]*ListNode, bool) {
	if (len(array) > limit) {
		array = array[0:limit - 1];
		return append(array, value), true
	}
	return append(array, value), false

}*/
