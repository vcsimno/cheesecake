/*
 * Copyright (c) 2022. yize.link
 * editor: yize
 * date:  2022/11/1
 *
 * @author yize<vcsimno@163.com>
 * 本开源由yize发布和开发，部分工具引用了其他优秀团队的开源工具包。
 */

package com.yize.cheesecake.common;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/**
 * 通用工具集
 */
@NoArgsConstructor
public class GenericTools {
    private static final Logger LOGGER = LogManager.getLogger(GenericTools.class);

    /**
     * 字符串限长
     */
    public static enum limitString {
        LIMIT25(25), LIMIT40(40), LIMIT50(50), LIMIT100(100), LIMIT12(12), LIMIT249(249);

        limitString(int limit) {
        }
    }

    /**
     * INT 转 STRING
     *
     * @param _args 参数
     * @return 值
     */
    public static String IntegerToString(int _args) {
        return String.format("%d", _args);
    }

    /**
     * Long 转 STRING
     *
     * @param _args 参数
     * @return 值
     */
    public static String LongToString(long _args) {
        return String.valueOf(_args);
    }

    /**
     * Float 转 STRING
     *
     * @param _args 参数
     * @return 值
     */
    public static String FloatToString(float _args) {
        return String.valueOf(_args);
    }

    /**
     * Byte 转 STRING
     *
     * @param _args 参数
     * @return 值
     */
    public static String ByteToString(byte[] _args) {
        return new String(_args);
    }

    /**
     * String 转 Int
     *
     * @param _args 字符串
     * @return 值
     */
    public static int StringToInt(String _args) {
        return Integer.parseInt(_args);
    }

    /**
     * 判断字符串是否为数字
     *
     * @param _args 字符串
     * @return 结果
     */
    public static boolean IsNumber(String _args) {
        return _args != null && _args.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * 获取CRC32的LONG码
     *
     * @param args 字符串
     * @return 值
     */
    public static long getCRC32code(String args) {
        CRC32 crc = new CRC32();
        crc.update(args.getBytes(StandardCharsets.UTF_8));
        return crc.getValue();
    }

    /**
     * 获取字符串 CRC32计算后，应该存放的数据库序号
     *
     * @param args 字符串
     * @param max  最大的索引号
     * @return 值
     */
    public static int getCRC32Index(String args, int max) {
        CRC32 crc = new CRC32();
        crc.update(args.getBytes(StandardCharsets.UTF_8));
        return (int) (crc.getValue() % max + 1);
    }

    /**
     * 获取字符串的CRC32 VALUE
     *
     * @param args 字符串
     * @return 值
     */
    public static String getCRC32value(String args) {
        CRC32 crc = new CRC32();
        crc.update(args.getBytes(StandardCharsets.UTF_8));
        return String.format("%d", crc.getValue());
    }

    /**
     * 检查EMIAL是否合法
     *
     * @param email 字符串
     * @return 结果
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            //WriterLog.writerErrorLog(LOGGER, e);
        }
        return flag;
    }

    /**
     * 过滤字符串长度
     *
     * @param args  字符串
     * @param limit 限制
     * @return 值
     */
    public static String limitString(String args, int limit) {
        Optional<String> result = Optional.ofNullable(args);
        return result.map(s -> s.substring(0, limit)).orElse("");
    }

    /**
     * BASE64 转码
     *
     * @param args 字符串
     * @return 值
     */
    public static String base64Encode(String args) {
        Base64.Encoder encoder = Base64.getEncoder();
        return Arrays.toString(encoder.encode(args.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * BASE64 解码
     *
     * @param args 字符串
     * @return 值
     */
    public static String base64Decode(String args) {
        Base64.Decoder decoder = Base64.getDecoder();
        return Arrays.toString(decoder.decode(args));
    }

    /**
     * 计算两个日期场差多少秒
     *
     * @param dat1 精确到分和秒
     * @param dat2 精确到分和秒
     * @return 相差秒数
     */
    public static long timeTest_BySecond(String dat1, String dat2) {
        try {
            LocalDateTime start = LocalDateTime.parse(dat1);
            LocalDateTime end = LocalDateTime.parse(dat2);
            Duration duration = Duration.between(start, end);
            return duration.getSeconds();
        } catch (Exception e) {
            //WriterLog.writerErrorLog(LOGGER, e);
            return -1;
        }

    }

    /**
     * 计算过去多少个月
     *
     * @param dat1 过去的时间
     * @param dat2 现在的时间
     * @return 过去多少个月
     */
    public static int timeTest_ByMonth(String dat1, String dat2) {
        try {

            LocalDateTime start = LocalDateTime.parse(dat1);
            LocalDateTime end = LocalDateTime.parse(dat2);

            int year = end.getYear() - start.getYear();
            int totalMonth = (year * 12) + end.getMonthValue();
            return totalMonth - start.getMonthValue();
        } catch (Exception e) {
            //WriterLog.writerErrorLog(LOGGER, e);
            return -1;
        }
    }

    /**
     * 计算过去多少个小时
     *
     * @param dat1 过去的时间
     * @param dat2 现在的时间
     * @return 过去多少个小时
     */
    public static int timeTest_ByHours(String dat1, String dat2) {
        try {

            LocalDateTime start = LocalDateTime.parse(dat1);
            LocalDateTime end = LocalDateTime.parse(dat2);

            Duration duration = Duration.between(start, end);

            return (int) duration.toHours();
        } catch (Exception e) {
            //WriterLog.writerErrorLog(LOGGER, e);
            return -1;
        }
    }

    /**
     * 获得Date  格式的当前时间
     *
     * @return Date 当前时间
     */
    public static Date getDateByNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    /**
     * 获得LocalDateTime格式的Date
     *
     * @param startDate Date 格式的日期
     * @return LocalDateTime格式的日期
     */
    public static LocalDateTime getLocalDateByDate(Date startDate) {
        return startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * 获取调整后的日期格式给客户端
     *
     * @param localDateTime 日期格式为LocalDateTime的数据
     * @return 整理后的日期格式
     */
    public static String getDateCompare(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm");
        String result = localDateTime.format(dateTimeFormatter);
        return result;
    }

    /**
     * 获取随机数字 + 字母组合
     *
     * @param length 长度
     * @return 字符串组合
     */
    public static String getRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        StringTables[] table = StringTables.values();
        for (int i = 0; i < length; ++i) {
            int random = new Random().nextInt(table.length);
            stringBuilder.append(table[random]);
        }
        if (stringBuilder.length() > length) {
            return limitString(stringBuilder.toString(), length);
        }
        return stringBuilder.toString();
    }
}
