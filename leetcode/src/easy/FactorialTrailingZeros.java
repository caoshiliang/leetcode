package easy;


// Not AC yet
public class FactorialTrailingZeros {
    public int trailingZeros(int n) {
        int count = 0;
        int base = 5;
        while (base <= n) {
            count += n / base;
            base *= 5;
        }
        return count;
    }
    
    public int another(int n) {
        int base = 5;
        int div = n/base;
        int count = div;
        while(div > 1) {
            base *= 5;
            div  = n/base;
            count += div;
        }
        return count;
    }
}
