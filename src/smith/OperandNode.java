package smith;

/**
 * Class to instatiate Operand nodes.
 * the nodes contain ints and are leaf nodes
 *
 * @author Hunter Smith
 */
public class OperandNode extends ExprNode {
    private int data;

    /**
     * Instantiates a new Operand node.
     *
     * @param data the data
     */
    public OperandNode(int data) {
        this.data = data;
    }

    /**
     * Evaluate int. evaluates arithmetic operations
     * all aritmetic operations are int operations
     *
     * @return the int
     */
    @Override
    public int evaluate() {
        return  data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
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
        return toString();
    }

    /**
     * Prefix string.returns a string result from
     * pre-order traversal.
     * @return the string
     */
    @Override
    public String prefix() {
        return toString();
    }

    /**
     * Infix string. returns a string result from
     * in-order traversal.
     *
     * @return the string
     */
    @Override
    public String infix() {
        return toString();
    }

}
