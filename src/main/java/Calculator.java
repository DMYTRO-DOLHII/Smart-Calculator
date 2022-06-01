public class Calculator {

    public float calculate(float num_1, float num_2, String sign){
        switch (sign){
            case "+": return plus(num_1, num_2);
            case "-": return minus(num_1, num_2);
            case "*": return multi(num_1, num_2);
            case "/": return div(num_1, num_2);
        }
        return 0;
    }

    public float plus(float num_1, float num_2){
        return num_1 + num_2;
    }

    public float minus(float num_1, float num_2){
        return num_1 - num_2;
    }

    public float multi(float num_1, float num_2){
        return num_1 * num_2;
    }

    public float div(float num_1, float num_2){
        return num_1 / num_2;
    }
}
