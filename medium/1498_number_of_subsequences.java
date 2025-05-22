// Problem: 1498. Number of Subsequences That Satisfy the Given Sum Condition
// Difficulty: Medium
// Link: https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); // sayıları sıralıyoruz
        int n = nums.length;

        int[] pow = new int[n];  // 2^i değerlerini hesaspladık [left ve right alt dizilerini oluşturduk] 
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;  // mod bu kısımda aldık 
        }

        int left = 0, right = n - 1;      // sağ ve sol değerlerimizi belirledik 
        int result = 0;

        while (left <= right) {           // sol sağdan küçük iken 
            if (nums[left] + nums[right] <= target) {       // sağ ve soldaki sayı target'tan küçük veya eşit ise bu kombinasyonlar doğrudur    
                result = (result + pow[right - left]) % MOD; // tüm kombinasyonların sayısını döndür yani 2^(right-left)
                left++;                                      // solu kaydır 
            } else {
                right--;                                     // diğer türlü sağdan azaltarak yap 
            }
        }

        return result;                                     // sonucu döndürdük
    }
}
