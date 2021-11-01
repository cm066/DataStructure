package com;

import java.util.*;

/**
 * @author cm
 * @create 2021/10/23-7:00 下午
 * 最重的素词
 */
public class HeaviestPrimeWords {
    public static void main(String[] args) {
        String str = "If you can keep your head when all about you   \n" +
                "Are losing theirs and blaming it on you,\n" +
                "If you can trust yourself when all men doubt you,\n" +
                "But make allowance for their doubting too;\n" +
                "If you can wait and not be tired by waiting,\n" +
                "Or being lied about, don’t deal in lies,\n" +
                "Or being hated, don’t give way to hating,\n" +
                "And yet don’t look too good, nor talk too wise:\n" +
                "\n" +
                "If you can dream — and not make dreams your master;   \n" +
                "If you can think — and not make thoughts your aim;   \n" +
                "If you can meet with Triumph and Disaster\n" +
                "And treat those two impostors just the same;   \n" +
                "If you can bear to hear the truth you’ve spoken\n" +
                "Twisted by knaves to make a trap for fools,\n" +
                "Or watch the things you gave your life to, broken,\n" +
                "And stoop and build ’em up with worn-out tools:\n" +
                "\n" +
                "If you can make one heap of all your winnings\n" +
                "And risk it on one turn of pitch-and-toss,\n" +
                "And lose, and start again at your beginnings\n" +
                "And never breathe a word about your loss;\n" +
                "If you can force your heart and nerve and sinew\n" +
                "To serve your turn long after they are gone,\n" +
                "And so hold on when there is nothing in you\n" +
                "Except the Will which says to them: ‘Hold on!’\n" +
                "\n" +
                "If you can talk with crowds and keep your virtue,\n" +
                "Or walk with Kings — nor lose the common touch,\n" +
                "If neither foes nor loving friends can hurt you,\n" +
                "If all men count with you, but none too much;\n" +
                "If you can fill the unforgiving minute\n" +
                "With sixty seconds’ worth of distance run,\n" +
                "Yours is the Earth and everything that’s in it,\n" +
                "And — which is more — you’ll be a Man, my son!";
        String regex = ",|，|\\s+";
        String[] split = str.split(regex);
        HashMap<String,Integer>  map = new HashMap<>();
        for (String s : split) {
            int sum = 0 ;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c>='a'&&c<='z'){
                    sum += (c-96);
                }else if (c >= 'A'&& c <= 'Z'){
                    sum += (c-64);
                }else {
                    continue;
                }
            }
            if (sum %2 != 0){
                if (!map.containsKey(s)){
                    map.put(s,1);
                }else {
                    map.put(s,map.get(s)+1);
                }
            }
        }
        Map.Entry[] value = getSortedHashtableByValue(map);
        for (int i = 0; i < 3; i++) {
            System.out.println(value[i]);
        }

    }
    public static Map.Entry[] getSortedHashtableByValue(Map map) {
        Set set = map.entrySet();
        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);
        Arrays.sort(entries, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
                Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
                return -(key1.compareTo(key2));
            }
        });
        return entries;
    }

}
