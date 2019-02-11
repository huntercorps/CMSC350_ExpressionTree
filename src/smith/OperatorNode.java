package smith;

/**
 * Class to instatiate Operator nodes.
 * the nodes contain enum Operators and are parent nodes
 *
 * @author Hunter Smith
 */
public class OperatorNode extends ExprNode {
    private Operator operator;

    /**
     * Instantiates a new Operator node.
     *
     * @param operator   the operator
     * @param leftChild  the left child
     * @param rightChild the right child
     */
    public OperatorNode(Operator operator, ExprNode leftChild, ExprNode rightChild) {
        super(leftChild, rightChild);
        this.operator = operator;
    }

    /**
     * Evaluate int. evaluates arithmetic operations
     * all aritmetic operations are int operations
     *
     * @return the int
     */
    @Override
    public int evaluate() {
        return operator.apply(
                getLeftChild().evaluate()
                ,getRightChild().evaluate()
        );
    }

    @Override
    public String toString() {
        return operator.toString();
    }

    /*Traversal Methods*/

    /**
     * Postfix  returns a string result from
     * post-order traversal.
     *
     * @return the string
     */
    @Override
    public String postfix() {
        return String.format("%s%s%s"
                ,getLeftChild().postfix()
                ,getRightChild().postfix()
                ,operator.opString()
        );
    }

    /**
     * Prefix string.returns a string result from
     * pre-order traversal.
     * @return the string
     */
    @Override
    public String prefix() {
        return String.format("%s%s%s"
                ,operator.opString()
                ,getLeftChild().prefix()
                ,getRightChild().prefix()
                );
    }

    /**
     * Infix string. returns a string result from
     * in-order traversal.
     *
     * @return the string
     */
    @Override
    public String infix() {
        return String.format("(%s%s%s)"
                ,getLeftChild().infix()
                ,operator.opString()
                ,getRightChild().infix()
        );
    }
}
