package solutions

func preorderTraversal(root *TreeNode) []int {
	result := *new([]int)
	result = append(result, traversal(root)...)
	return result
}

func traversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	r := make([]int, 0)
	r = append(r, root.Val)
	lefts := traversal(root.Left)
	rights := traversal(root.Right)
	r = append(r, lefts...)
	r = append(r, rights...)
	return r
}
