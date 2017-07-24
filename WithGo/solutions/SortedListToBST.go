package solutions

func sortedListToBST(head *ListNode) *TreeNode {
	theArray := make([]int, 0)
	for head != nil {
		theArray = append(theArray, head.Val)
		head = head.Next
	}
	return binaryInsert(theArray)

}
func binaryInsert(ints []int) *TreeNode {
	if len(ints) == 0 {
		return nil
	}

	mid := len(ints) / 2
	node := &TreeNode{
		Val:   ints[mid],
		Left:  binaryInsert(ints[0:mid]),
		Right: binaryInsert(ints[mid+1 : len(ints)]),
	}
	return node
}
