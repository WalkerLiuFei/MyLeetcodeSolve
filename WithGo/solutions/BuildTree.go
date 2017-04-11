package solutions

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	if len(inorder) == 0 || len(postorder) == 0 {
		return nil
	}

	lastIndex := len(postorder) - 1
	root := &TreeNode{
		Val: postorder[lastIndex],
	}
	if lastIndex == 0 {
		return root
	}
	for index := 0; index < len(inorder); index++ {
		if inorder[index] == root.Val {
			root.Left = buildTree(inorder[0:index], postorder[0:index])
			startIndex := index + 1
			root.Right = buildTree(inorder[startIndex:lastIndex+1], postorder[index:lastIndex])
			break
		}
	}
	return root
}
func print(node *TreeNode) {
	if node == nil {
		return
	}
	fmt.Printf("%d %s", node.Val, " ")
	print(node.Left)
	print(node.Right)
}
