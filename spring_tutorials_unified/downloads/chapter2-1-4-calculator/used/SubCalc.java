package used;

/**
 * Calculator実装クラス
 * 減算を行う
 */
public class SubCalc implements Calculator {
    @Override
    public Integer calc(Integer x, Integer y) {
        return x - y;
    }
}
