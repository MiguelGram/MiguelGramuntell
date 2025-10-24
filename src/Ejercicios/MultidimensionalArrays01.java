package Ejercicios;

public class MultidimensionalArrays01 {
    public static void main(String[] args) {
        int num = 10;

        fill(num);

    }

    public static void fill(int num) {
        String[][] nums = new String[num][num];

        for(int fil = 0; fil<nums.length; fil++){
            for(int col = 0; col<nums.length; col++){
                if(col == fil){
                    nums[fil][col] = "1";
                }
                else{
                    nums[fil][col] = "0";
                }
            }
        }
        for(int fil = 0; fil<nums.length; fil++){
            for(int col = 0; col<nums.length; col++){
                System.out.print(nums[fil][col] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
