/**
 * 45. Jump Game II
 */
/*
        45. Jump Game II
        You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

        Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

        0 <= j <= nums[i] and
        i + j < n
        Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

        Example 1:

        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
        Example 2:

        Input: nums = [2,3,0,1,4]
        Output: 2


        Constraints:

        1 <= nums.length <= 104
        0 <= nums[i] <= 1000
        It's guaranteed that you can reach nums[n - 1].

     */

/*
    Solution is to iterate through while keeping track of each element's furthest jumps
    [2, 3, 0 , 0, 2, 1, 4]

    We start at index 0 and element value of 2. We also set the smallest number of jumps to 0
    This means we can jump to either index 1 [3] or index 2 [0].
    Let's say index 1 and index 2 is now considered the next jumping "zone"

    We can set the furthest possible jump from index 0 [2] to index 2 [0] and say that that's the end of zone 1

             zone 1
              ____
    nums  [2, 3, 0 ,0, 2, 1, 4]     smallest jump count = 1
    index  0, 1, 2, 3, 4, 5, 6
           i    end

    Next we iterate everything from index 0 to the end and figure out how "far" the elements in zone 1 can reach
    the next zone.

                   zone 2
                    ____
    nums  [2, 3, 0 ,0, 2, 1, 4]
    index  0, 1, 2, 3, 4, 5, 6
              i end   far

    Iterating to index 1 [3], we see that we can jump +3 spaces to index 4 [2], so we
    set index 4 as the furthest "far" we can get.

    Since i hasn't reach end yet, we keep iterating because it's possible index 2's value could give us
    the longer jump. Since the value is 0, we concluded zone 1 and now set the end to index 4 to say that's
    the end of zone 2.

                    zone 2
                    ____
    nums  [2, 3, 0 ,0, 2, 1, 4]     smallest jump count = 2
    index  0, 1, 2, 3, 4, 5, 6
                 i    far
                      end

    Next we iterate to index 3 [0] to find that we can't progress anywhere but i is not yet at end.

                   zone 2
                    ____
    nums  [2, 3, 0 ,0, 2, 1, 4]     smallest jump count = 2
    index  0, 1, 2, 3, 4, 5, 6
                    i far
                      end

    So we iterate again to index 4 [2]. We find that the next furthest index we can jump to is index 6 [4]
    and set that as "far", setting up zone 3.

                   zone 2
                    ____
    nums  [2, 3, 0 ,0, 2, 1, 4]     smallest jump count = 2
    index  0, 1, 2, 3, 4, 5, 6
                      far
                      end
                       i

                         zone 3
                          ____
    nums  [2, 3, 0 ,0, 2, 1, 4]
    index  0, 1, 2, 3, 4, 5, 6
                      end   far
                       i

    At this point, we find that the end is at index 6 [4] and that's the last index.
    This means it would take one last jump to reach the end from index 4 [2]
    So we set the smallest jump count to 3

                         zone 3
                          ____
    nums  [2, 3, 0 ,0, 2, 1, 4]    smallest jump count = 3
    index  0, 1, 2, 3, 4, 5, 6
                            far
                       i    end
 */

public class JumpGame2 {

    public int jump(int[] nums) {

        int smallest = 0;
        int n = nums.length;
        int end = 0, far = 0;
        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                smallest += 1;
                end = far;
            }
        }
        return smallest;
    }

//        @Test
//        public void test () {
//            print(new int[] {2,3,0,1,4}, 2);
//            print(new int[] {2,3,1,1,4}, 2);
//            print(new int[] {2,3,0,0,2,1,4}, 3);
//        }
//
//        private void print(int[] nums, int answer) {
//            System.out.println(Arrays.toString(nums) + " = " + answer);
//            assert jump(nums) == answer;
//        }
}
