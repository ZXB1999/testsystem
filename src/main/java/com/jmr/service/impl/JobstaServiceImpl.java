package com.jmr.service.impl;

import com.jmr.dao.JobstaMapper;
import com.jmr.service.JobstaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobstaServiceImpl  implements JobstaService {
    @Autowired(required = false)
    private JobstaMapper jobstaMapper;
    public int countsex(int a) {
        return  jobstaMapper.countsex(a);
    }
    public int  counthistory(int a){
        return jobstaMapper.counthistory(a);
    }
    public  int countlevel( int a){
        return  jobstaMapper.countlevel(a);
    }
    public  int  countrange(int a){
        return  jobstaMapper.countrange(a);
    }
    public   int countremark(  String  s){
        return  jobstaMapper.countremark(s);
    }
}
