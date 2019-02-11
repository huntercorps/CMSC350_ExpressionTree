package smith;
import java.util.function.BinaryOperator;

/**
 * The enum Operator allows translating operators to a string
 * or assembly instruction and provides the ability
 * to perform the arithmetic operation of the enum.
 *
 * @author Hunter Smith
 */
public enum Operator {
    /**
     * Add operator.
     */
    ADD("+", (l, r) -> l + r),
    /**
     * Sub operator.
     */
    SUB("-", (l, r) -> l - r),
    /**
     * Mul operator.
     */
    MUL("*", (l, r) -> l * r),
    /**
     * Div operator.
     */
    DIV("/", (l, r) -> l / r);

    private final String symbol;
    private final BinaryOperator<Integer> binaryOperator;

    Operator(String operator, BinaryOperator<Integer> binaryOperator) {
        this.symbol = operator;
        this.binaryOperator = binaryOperator;
    }

    /**
     * Parse operator parses a string to an operator.
     *
     * @param operator the operator
     * @return the operator
     */
    public static Operator parseOperator(String operator) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(operator)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Illegal operator");
    }

    /**
     * Op string Returns Operations symbol as a string.
     *
     * @return the string
     */
    public String opString() {
        return symbol;
    }

    /**
     * Apply int performs integer arithmetic operations
     *
     * @param left  the left
     * @param right the right
     * @return the int
     */
    public int apply(int left, int right) {
        return binaryOperator.apply(left, right);
    }

}
