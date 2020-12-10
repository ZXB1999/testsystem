package com.jmr.dao;

/**
 * Dao层mapper接口
 * 对应着mapper.xml
 */
public interface JobstaMapper {
    int countsex(int a );
    int counthistory(int a);
    int countlevel( int a);
    int countrange(int a);
    int countremark( String  s);
}
