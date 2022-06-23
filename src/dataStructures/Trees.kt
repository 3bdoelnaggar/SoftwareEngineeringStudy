package dataStructures

fun treesRunner() {
    val leftNode = TreeNode(5200,null,null)
    val rightNode = TreeNode(100,leftNode,null)
    val root = TreeNode(100,leftNode,rightNode)
    println(treeSum(root))



}
 data class TreeNode<T> (
    var date: T,
    val left: TreeNode<T>? = null,
    val right: TreeNode<T>? = null
 )

fun treeSum(node: TreeNode<Int>): Int {
    val current=node.date
    var left =0
    var right =0
    if (node.left != null) {
        left = treeSum(node.left)
    }
    if (node.right != null) {
        right = treeSum(node.right)
    }
    return current+left+right
}