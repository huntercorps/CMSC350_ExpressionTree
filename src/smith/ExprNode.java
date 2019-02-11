package smith;

/**
 * A abstract class representing nodes in a binary/expression tree
 *
 * @author Hunter Smith
 */
public abstract class ExprNode {
    private ExprNode leftChild;
    private ExprNode rightChild;

    /**
     * Instantiates a new Expression node
     * and assigns the left and right child nodes.
     *
     * @param left  the left
     * @param right the right
     */
    public ExprNode(ExprNode left, ExprNode right) {
        this.leftChild = left;
        this.rightChild = right;

    }

    /**
     * Instantiates a new expression node w/ children.
     */
    public ExprNode() {
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * Gets left child node.
     *
     * @return the left child
     */
    public ExprNode getLeftChild() {
        return leftChild;
    }

    /**
     * Gets right child node.
     *
     * @return the right child
     */
    public ExprNode getRightChild() {
        return rightChild;
    }

    /**
     * Is leaf boolean returns true if the node is a leaf in the tree.
     * or false if it's a parent node
     *
     * @return the boolean
     */
    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }

    /**
     * Evaluate int. evaluates arithmetic operations
     * all aritmetic operations are int operations
     *
     * @return the int
     */
    public abstract int evaluate();

    /**
     * Postfix  returns a string result from
     * post-order traversal.
     *
     * @return the string
     */
    public abstract String postfix();

    /**
     * Prefix string.returns a string result from
     * pre-order traversal.
     * @return the string
     */
    public abstract String prefix();

    /**
     * Infix string. returns a string result from
     * in-order traversal.
     *
     * @return the string
     */
    public abstract String infix();
}
