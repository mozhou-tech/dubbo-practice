package com.tenoke.cloud.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * SnowFlakeUtil 生成ID
 *
 * @author jerrylau
 */
@Slf4j
@Component
public class SnowFlakeUtil {

    /**
     * 对象容器
     */
    private static SnowFlakeUtil client;

    /**
     * 数据中心Id
     */
    @Value("${beyhub.server.data-center-id}")
    private Long dataCenterId;
    /**
     * 机器Id
     */
    @Value("${beyhub.server.machine-id}")
    private Long machineId;

    /**
     * 起始的时间戳
     */
    private final static Long START_STMP = 1480166465631L;

    /**
     * 每一部分占用的位数
     */
    //序列号占用的位数
    private final static Long SEQUENCE_BIT = 12L;
    //机器标识占用的位数
    private final static Long MACHINE_BIT = 5L;
    //数据中心占用的位数
    private final static Long DATACENTER_BIT = 5L;

    /**
     * 每一部分的最大值
     */
    private final static Long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
    private final static Long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
    private final static Long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static Long MACHINE_LEFT = SEQUENCE_BIT;
    private final static Long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static Long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;


    /**
     * 序列号
     */
    private Long sequence = 0L;
    /**
     * 上一次时间戳
     */
    private Long lastStmp = -1L;

    private SnowFlakeUtil() {
        if (dataCenterId == null) {
            dataCenterId = 0L;
            log.warn("DatacenterId and machineId cannot be null, use 0 as default.");
        }
        if (machineId == null) {
            machineId = 0L;
            log.warn("MachineId and machineId cannot be null, use 0 as default.");
        }
        if (this.dataCenterId > MAX_DATACENTER_NUM || this.dataCenterId < 0L) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (this.machineId > MAX_MACHINE_NUM || this.machineId < 0L) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
    }

    /**
     * 返回一个ID，一次只有一个线程进入
     *
     * @return Long
     */
    @Bean
    public static synchronized Long getId() {
        if (client == null) {
            client = new SnowFlakeUtil();
        }
        return client.nextId();
    }

    /**
     * 产生下一个ID
     *
     * @return 返回一个Int
     */
    private synchronized Long nextId() {
        Long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp.equals(lastStmp)) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
                | dataCenterId << DATACENTER_LEFT       //数据中心部分
                | machineId << MACHINE_LEFT             //机器标识部分
                | sequence;                             //序列号部分
    }

    private Long getNextMill() {
        Long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private Long getNewstmp() {
        return System.currentTimeMillis();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        SnowFlakeUtil snowFlakeUtil = new SnowFlakeUtil();

        for (int i = 0; i < (1 << 12); i++) {
            System.out.println(snowFlakeUtil.nextId());
        }

    }
}
