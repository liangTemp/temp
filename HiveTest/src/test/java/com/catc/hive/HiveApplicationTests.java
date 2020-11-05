package com.catc.hive;

import com.catc.hive.dao.AutoBoxingRowMapper;
import com.catc.hive.dao.TeleHeadRowMapper;
import com.catc.hive.entity.TeleHead;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class HiveApplicationTests {
	@Autowired
	private JdbcTemplate hiveJdbcTemplate;
	@Autowired
	private TeleHeadRowMapper teleHeadRowMapper;
	@Test
	void contextLoads() {
		String sql = "select * from telehead order by teleuid limit 1,100";
		List<Map<String, Object>> maps = hiveJdbcTemplate.queryForList(sql);
		List<TeleHead> rs = hiveJdbcTemplate.query(sql,new BeanPropertyRowMapper(TeleHead.class));
		System.out.println(rs.get(0).toString());
	}




}
