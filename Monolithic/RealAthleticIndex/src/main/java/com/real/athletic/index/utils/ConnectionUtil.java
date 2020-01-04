package com.real.athletic.index.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.real.athletic.index.feed.details.model.FeedDetails;

public class ConnectionUtil {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionUtil.class);

	public Connection connect() {
		String url = "jdbc:postgresql://183.82.241.246:8010/realaidev";
		String user = "postgres";
		String pswd = "postgres";
		Connection conn = null;
		try {
			logger.debug("Connecting the PostgreSQL server...");
			conn = DriverManager.getConnection(url, user, pswd);
			logger.debug("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			logger.error("Error in connecting PostgreSQL DB>> ", e);
		}

		return conn;
	}

	public static String saveFeedDetails(FeedDetails feed) {
		String sql = "insert into feed_details (parent_oid,rss_feed_source,rss_feed_url,rss_version,"
				+ "rss_feed_language,category,description,client_details,published_date,status) VALUES(?,?,?,?,?,?,?,?,?,?)";

		String oid = "0";
		ConnectionUtil conUtil = new ConnectionUtil();
		try (Connection conn = conUtil.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setString(1, feed.getParentOid());
			pstmt.setString(2, feed.getRssFeedSource());
			pstmt.setString(3, feed.getRssFeedUrl());
			pstmt.setString(4, feed.getRssVersion());
			pstmt.setString(5, feed.getRssFeedLanguage());
			pstmt.setString(6, feed.getCategory());
			pstmt.setString(7, feed.getDescription());
			pstmt.setString(8, feed.getClientDetails());
			pstmt.setTimestamp(9, feed.getPublishedDate());
			pstmt.setString(10, feed.getStatus());

			int affectedRows = pstmt.executeUpdate();
			oid = getOid(oid, pstmt, affectedRows);
		} catch (SQLException ex) {
			logger.error("Error in executing the SQL Query>>> ", ex);
		}
		return oid;
	}

	private static String getOid(String oid, PreparedStatement pstmt, int affectedRows) {
		if (affectedRows > 0) {
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					oid = rs.getString(1);
				}
			} catch (SQLException ex) {
				logger.error("Error in getting oid>>>>", ex);
			}
		}
		return oid;
	}
}
