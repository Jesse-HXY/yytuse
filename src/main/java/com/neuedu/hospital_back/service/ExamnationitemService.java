package com.neuedu.hospital_back.service;

import com.neuedu.hospital_back.po.ExamnationItem;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.neuedu.hospital_back.mapper.ExamnationitemMapper;

import java.util.List;

@Service
public class ExamnationitemService{

    @Resource
    private ExamnationitemMapper examnationitemMapper;

    
    public boolean deleteByPrimaryKey(Integer eIId) {
        return examnationitemMapper.deleteByPrimaryKey(eIId)==1;
    }

    
    public boolean insert(ExamnationItem record) {
        return examnationitemMapper.insert(record)==1;
    }

    
    public boolean updateByPrimaryKeySelective(ExamnationItem record) {
        return examnationitemMapper.updateByPrimaryKeySelective(record)==1;
    }

    public List<ExamnationItem> selectExamnationItem(ExamnationItem examnationItem){
        List<ExamnationItem> examnationItems =examnationitemMapper.selectExamnationItem(examnationItem);
        return examnationItems;
    }

    public List<ExamnationItem> selectAllExamnationItem(){
        List<ExamnationItem> examnationItems =examnationitemMapper.selectAllExamnationItem();
        return examnationItems;
    }

    public List<ExamnationItem> selectExamnationItemByPage(int begin, int pageSize){
        List<ExamnationItem> examnationItems =examnationitemMapper.selectExamnationItemByPage(begin,pageSize);
        return examnationItems;
    }

    public int getPageCount(){
        return examnationitemMapper.getExamnationItemCount();
    }

}