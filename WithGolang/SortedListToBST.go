package main

import "sort"

func main() {
	var values = []int{5,1,9,8,8,1,5,8,2,6,8,4,7}
	sort.Ints(values)
	root := ListNode{}
	temp := &root
	for _, value := range values {
		temp.Val = value;
		temp.Next = &(ListNode{})
		temp = temp.Next
	}
	sortedListToBST(&root)
}



  type ListNode struct {
      Val int
      Next *ListNode
  }


  type TreeNode struct {
      Val int
      Left *TreeNode
      Right *TreeNode
  }

func sortedListToBST(head *ListNode) *TreeNode {
	theArray := make([]int,0)
	for head != nil{
		theArray = append(theArray,head.Val)
		head = head.Next
	}
	return binaryInsert(theArray);

}
func binaryInsert(ints []int) *TreeNode {
	if (len(ints) == 0){
		return nil
	}

	mid := len(ints)/2
	node := &TreeNode{
		Val:ints[mid],
		Left :   binaryInsert(ints[0:mid]),
		Right:binaryInsert(ints[mid+1:len(ints)]),
	}
	return node
}