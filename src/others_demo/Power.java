package others_demo;

public class Power {
    public double Power(double base, int exponent) {
        if(equal(base, 0.0) && exponent < 0){
            return 0;
        }

        int absExponent = exponent;
        if(exponent < 0){
            absExponent = -exponent;
        }

        double result = PowerWithUnsignedExponent(base, absExponent);
        if(exponent < 0){
            result = 1.0 / result;
        }

        return result;
    }

    /**
     *使用公式： a^n =
     *		  1.n为偶数：a^n/2 * a^n/2
     *        2.n为奇数：a^(n-1)/2 * a^(n-1)/2 * a
     */
    public double PowerWithUnsignedExponent(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        double result = PowerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1){
            result *= base;
        }
        return result;
    }

    public boolean equal(double a, double b){
        if(a - b > -0.0000001 && a - b < 0.0000001){
            return true;
        }
        return false;
    }
}