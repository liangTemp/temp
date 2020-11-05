package com.catc.hive.dao;

import com.catc.hive.entity.TeleHead;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class TeleHeadRowMapper implements RowMapper<TeleHead> {
    @Override
    public TeleHead mapRow(ResultSet re, int i) throws SQLException {
        TeleHead th = new TeleHead();
        th.setTeleuid(re.getString("teleuid"));
        th.setTelebody(re.getString("telebody"));
        th.setBodylength(re.getInt("bodylength"));
        return th;
    }
}
