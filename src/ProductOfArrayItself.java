/**
 * 238. Product of Array Except Self
 */

class ProductOfArrayItself {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        if (n == 2) {
            return nums;
        }

        int[] answer = new int[n];

        int total = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                answer[i] = 1;
            } else {
                total = total * nums[i + 1];
                answer[i] = total;
            }
        }

        total = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i] * total;
            total = nums[i] * total;
        }

        return answer;
    }

//    @Test
//    public void test() {
//        String answer = Arrays.toString(productExceptSelf(new int[]{1, 2, 3}));
//        System.out.println(answer);
//    }
}
