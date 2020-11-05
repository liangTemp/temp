package com.catc.hive.controller;

import com.catc.hive.dao.TeleHeadRowMapper;
import com.catc.hive.entity.AdsbCount;
import com.catc.hive.entity.TeleHead;
import com.catc.hive.mapper.AdsbCountMapper;
import com.catc.hive.model.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/getTeleHead")
public class TeleHeadController {
    @Autowired
    private JdbcTemplate hiveJdbcTemplate;
    @Autowired
    private AdsbCountMapper adsbCountMapper;
    @RequestMapping("/getth")
    public List<TeleHead> getTelehead(@RequestParam String size){
        TeleHead th = new TeleHead();
        String sql = "select * from telehead  limit 1," + size;
        List<TeleHead> rs = hiveJdbcTemplate.query(sql,new BeanPropertyRowMapper(TeleHead.class));
        return rs;
    }

    @RequestMapping("/getad")
    public List<TeleHead>  getAdsbCount(@RequestParam String size) {
        List<TeleHead> rs = new ArrayList<TeleHead>();
        try {
            TeleHead th = new TeleHead();
            String sql = "select * from telehead  limit 1," + size;
            rs = hiveJdbcTemplate.query(sql,new BeanPropertyRowMapper(TeleHead.class));
           // System.err.println(adsbCountMapper.getAll(new QueryModel()));
        } catch (Exception e) {

        }
        return rs;
    }
}
