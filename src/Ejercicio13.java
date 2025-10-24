public class Ejercicio13 {
    public static void main(String[] args) {
        int N = 0;
        for(int i = 1; i < 10; i++){
            for(int b = 0; b < i; b++){
                N = N + b;
            }
        }
        int nums[] = new int[N];
        for(int i = 1; i < N; i++){
            for(int b = 1; b < i; b++){
                nums[i] = i;
            }
        }
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
