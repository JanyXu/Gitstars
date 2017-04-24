package cn.gitstars.gitstars.utils;

import java.util.ArrayList;

/**
 * Created by zhangyipeng on 16/3/19.
 */
public class Test {

    public static void main(String[] arg){

        String content = "胡歌，1982年9月20日出生于上海市徐汇区，中国内地演员、歌手、制片人。1996年，14岁的胡歌便成为上海教育电视台的小主持人，2001年考入上海戏剧学院表演系。2005年因在电视剧《仙剑奇侠传》中成功塑造了豪爽深情的“李逍遥”一角而成名，并演唱插曲《六月的雨》《逍遥叹》。2009年在“80后新生代娱乐大明星”评选中获封“四大小生”之一。" +
                "\nFirst Flight\n" +
                "Mr. Johnson had never been up in an aerophane before and he had read a lot about air accidents, so one day when a friend offered to take him for a ride in his own small phane, Mr. Johnson was very worried about accepting. Finally, however, his friend persuaded him that it was very safe, and Mr. Johnson boarded the plane.\n" +
                "His friend started the engine and began to taxi onto the runway of the airport. Mr. Johnson had heard that the most dangerous part of a flight were the take-off and the landing, so he was extremely frightened and closed his eyes.\n" +
                "After a minute or two he opened them again, looked out of the window of the plane, and said to his friend, \"Look at those people down there. They look as small as ants, don't they?\"\n" +
                "\"Those are ants,\" answered his friend. \"We're still on the ground.\"";

        ArrayList<String> contentList = XTextUtils.getContentList(content);

        for (String s : contentList) {
            System.out.print(s+"|");
        }
    }
}
