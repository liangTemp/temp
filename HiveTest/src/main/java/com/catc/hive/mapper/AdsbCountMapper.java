package com.catc.hive.mapper;


import com.catc.hive.entity.AdsbCount;
import com.catc.hive.model.QueryModel;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdsbCountMapper {

    int save(AdsbCount adsbCount);
    List<AdsbCount> getlist(QueryModel queryModel);

    List<AdsbCount> getAll(QueryModel queryModel);

    void deleteByDate(Date date);

}
