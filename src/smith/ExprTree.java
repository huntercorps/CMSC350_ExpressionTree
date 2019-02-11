package smith;

import java.util.*;

public class ExprTree {
    private ExprNode root = null;
    private Stack<ExprNode> nodeStack;

    public ExprTree(String expression) {
        nodeStack = new Stack<>();
        buildTree(expression);
    }

    private void buildTree(String expression){
        String[] tokens = expression.split("");

        for (String token : tokens) {

            if (isDigit(token)) {
                int operand = Integer.parseInt(token);
                nodeStack.push(new OperandNode(operand));

            } else if (isOperator(token)) {
                ExprNode right = nodeStack.pop();
                ExprNode left = nodeStack.pop();
                nodeStack.push(new OperatorNode(Operator.parseOperator(token), left, right));


            } else if (!isWhitespace(token)){
                throw new RuntimeException("Invalid Expression: Illegal character used");
            }
        }
        root = nodeStack.lastElement();
    }

    public ExprNode getRoot() {
        return root;
    }

    public int evaluate() {
        return root.evaluate();
    }

    public void printTree(/*ExprNode root*/) {
        List<List<String>> lines = new ArrayList<>();
        List<PrintableNode> level = new ArrayList<>();
        List<PrintableNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (PrintableNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeftChild());
                    next.add(n.getRightChild());

                    if (n.getLeftChild() != null) nn++;
                    if (n.getRightChild() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<PrintableNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (String f : line) {

                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }


    // Helper Methods

    private boolean isDigit(String str){
        return str.matches("[\\d]");
    }

    private boolean isOperator(String str){
        return str.matches("[+\\-*/]");
    }

    private boolean isWhitespace(String str){
        return str.matches("[\\s]+");
    }

}


