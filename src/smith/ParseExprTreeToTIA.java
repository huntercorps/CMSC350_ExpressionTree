package smith;
import java.util.Stack;

/**
 * Class for parsing a TIA from an expression tree.
 * the tree is passed by its root.
 *
 * @author Hunter Smith
 */
public class ParseExprTreeToTIA {
    private Stack<ExprNode> parentNodeStack;

    /**
     * Instantiates a TIA parser.
     */
    public ParseExprTreeToTIA() {
        parentNodeStack = new Stack<>();
    }

    /**
     * Build instruction string builds the three instruction
     * assembly string from a tree(root).
     *
     * @param root the root
     * @return the string
     */
    public String buildInstructionString(ExprNode root) {
        StringBuilder sb = new StringBuilder();
        exprTreeParentsNodesToStack(root);

        int currentReg = 0, register = 0;
        // currentReg holds the number of the current Assy. register.
        //register is a counter that helps identify the which register
        //is being used to perform an operation.
        sb.append(String.format("Postfix Expression: \"%s\"\nThree Instruction Assembly\n",root.postfix()));

        for (ExprNode node : parentNodeStack) {
            sb.append(String.format("%s\tR%d\t", node, currentReg));
            ExprNode leftChild = node.getLeftChild();
            ExprNode rightChild = node.getRightChild();

            if (leftChild.isLeaf()) {
                sb.append(String.format("%s\t", leftChild));
                if (rightChild.isLeaf()) {
                    sb.append(String.format("%s\n", rightChild));
                } else {
                    sb.append(String.format("R%d\n", register));
                    register++;
                }

            } else if (!leftChild.isLeaf()) {
                sb.append(String.format("R%d\t", register));
                register++;

                if (rightChild.isLeaf()) {
                    sb.append(String.format("%s\n", rightChild));

                } else {
                    sb.append(String.format("R%d\n", register));
                    register++;
                }
            }
            currentReg++;
        }
        return sb.toString();
    }

    /**
     * exprTreeParentsNodesToStack is a helper method to
     * build the TIA. It traverses the nodes in post order
     * and places the parent nodes/operator nodes on a
     * stack
     **/
    private ExprNode exprTreeParentsNodesToStack(ExprNode node){
        if (!node.isLeaf()){
            exprTreeParentsNodesToStack(node.getLeftChild());
            exprTreeParentsNodesToStack(node.getRightChild());
            parentNodeStack.push(node);
        }
        return node;
    }

}
