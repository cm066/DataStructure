package com.datastructure.other;


/**
 * 买苹果问题，一个袋子能装8个和6个的，小明要买n个苹果
 * 问怎么能用最少的袋子买
 */
public class AppleMinBags {

    public static int minBags(int apple){
        if (apple < 0){
            return -1;
        }
        int bag6 = -1;
        int bag8 =apple / 8;
        int rest = apple - 8*bag8;
        while (bag8 >= 0 || rest < 24){
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1){
                bag6 = restUse6;
                break;
            }
            rest = apple-8*(--bag8);

        }
        return bag6 == -1?-1:bag6+bag8;
    }

    public static int minBagBase6(int rest){
        return rest % 6 == 0 ?(rest/6):-1;
    }

    /**
     * 最优解法
     */

    public static int minBagAwesome(int apple){
        if ((apple & 1) != 0){
            return -1;
        }
        if (apple < 18){
            return apple == 0?0:(apple == 6 || apple ==8 )?1:(apple == 12 || apple == 14 || apple ==16)?2:-1;

        }
        return (apple - 18)/8 +3;
    }
}
