package solutions

/*func reverseBetween(head *ListNode, m int, n int) *ListNode {
	for count := 0;count < m+n ;count{
		if (count == m){
			temp = head.Next;
		}
	}
	temp =head;
	r
}*/

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	toReverseNodes := head
	memory := head
	for count := 1; count < m; count++ {
		if toReverseNodes == nil {
			return head
		}
		memory = toReverseNodes
		toReverseNodes = toReverseNodes.Next
	}
	var newNodes *ListNode
	var flag bool = false
	var newNodesTrail *ListNode
	for count := 0; count < n-m+1; count++ {
		if toReverseNodes == nil {
			return head
		}
		temp := toReverseNodes.Next
		toReverseNodes.Next = newNodes //独立出将要翻转的元素，并将Next指向新的List列表
		newNodes = toReverseNodes      //相当于copy
		if !flag {
			newNodesTrail = newNodes //记录尾巴
			flag = true
		}
		toReverseNodes = temp
	}
	newNodesTrail.Next = toReverseNodes
	memory.Next = newNodes
	if m < 1 {
		return newNodes
	} else {

		return head
	}
}
func reverseList(head *ListNode) *ListNode {
	var newNode *ListNode = nil
	for head != nil {
		temp := head.Next   //记录head 除了当前需要操作元素之后的元素
		head.Next = newNode //开辟的新List空间,将当前元素指向它，初始为nil，即原最靠前的元素成为最后的元素
		newNode = head      //这一步加上前面的一步，恰恰达到了 指向head 之前。。。操作head前面空间的目的操作！！
		head = temp         //归到原位，但是现在是指向的原最初的元素
	}
	return newNode
}
func reverseListRe(result *ListNode, node *ListNode) {
	if node == nil {
		return
	}
	if node.Next == nil {
		result = &ListNode{
			Val: node.Val,
		}
		result = result.Next
		node = nil
	} else {
		reverseListRe(result, node.Next)
	}

}
