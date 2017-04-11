package solutions

import "fmt"

func ReorderList(head *ListNode)  {
	fastNode := head
	slowNode := head
	// 通过走的快的节点和慢的节点 找到中间的节点。
	for fastNode != nil && slowNode != nil{
		fastNode = fastNode.Next
		slowNode = slowNode.Next
		if fastNode != nil{
			fastNode = fastNode.Next
		}
		if fastNode == nil{
			break
		}
	}
	if (slowNode == nil){
		return
	}
	//将后半段的 list翻转
	var reversedList *ListNode = nil
	for slowNode != nil {
		temp  := slowNode.Next 			 //保存
		slowNode.Next = reversedList 		//指向新的
		reversedList = slowNode                // 翻转节点执行 头部
		slowNode = temp   			// 原节点 move next
	}




	reserved := head
	for head != nil && reversedList != nil{
		temp1 := head.Next
		temp2 := reversedList.Next
		head.Next = reversedList
		reversedList.Next = temp1
		head = temp1
		reversedList = temp2
	}
	head.Next = nil
	head = reserved
	for head != nil{
		fmt.Println(head.Val)
		head = head.Next
	}

}