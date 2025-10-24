package Ejercicios;

public class test {
    public static void main(String[] args) {
        System.out.println(test1(new int[]{1,2,3,4,100}));
    }

    public static int test1(int[] nums) {
        int[] num = new int[nums.length-2];
        int pos1 = 0;
        int pos2 = 0;
        int max = nums[0];
        int min = nums[0];
        int suma = 0;
        int med = 0;
        if(nums.length > 2){
            for(int i = 0; i < nums.length; i++){  //  1, 2, 3, 4, 100
                if(nums[i] >= max){
                    max = nums[i];
                    pos1 = i;
                }
                else if(nums[i] <= min){
                    min = nums[i];
                    pos2 = i;
                }
            }
            for(int i = 0; i < nums.length; i++){
                if(i != pos1 && i != pos2){
                    suma += nums[i];
                    med = suma/(nums.length-2);
                }
            }
        }
        System.out.println("suma ->" + suma + " La media -> " + med + " tamaño -> " + (nums.length-2));
        System.out.println(" min " + pos2 + " max " + pos1);
        return med;
    }
}



//Ejercicios.test activo

