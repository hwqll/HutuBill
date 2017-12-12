package dao;

import entity.Config;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigDAO {
    /**
     * 返回数据条数
     * @return
     */
    public int getTotal(){
        int total = 0;
        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement()){
            String sql = "select count(*) from config";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()){
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    /**
     * 插入数据
     * @param config
     */
    public void add(Config config) {
        String sql = "INSERT INTO config VALUES(null, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, config.key);
            ps.setString(2, config.value);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();//获取自增主键
            if (rs.next()) {
                int id = rs.getInt(1);
                config.id = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新记录
     * @param config
     */
    public void update(Config config){
        String sql = "UPDATE config SET key_ = ?, value = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, config.key);
            ps.setString(2, config.value);
            ps.setInt(3, config.id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){

        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement()) {
            String sql = "delete from config where id = " + id;
            s.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id得到数据
     * @param id
     * @return
     */
    public Config get(int id){
        Config config = null;
        try (Connection conn = DBUtil.getConnection(); Statement s = conn.createStatement()){
            String sql = "select * from config where id = " + id;
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()){
                config = new Config();
                config.id = id;
                config.key = rs.getString("key_");
                config.value = rs.getString("value");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return config;
    }

    /**
     * 返回所有数据
     * @return
     */
    public List<Config> list(){
        return list(0, Short.MAX_VALUE);
    }

    /**
     * 分页查询
     * @param start
     * @param count
     * @return
     */
    public List<Config> list(int start, int count){
        List<Config> list = new ArrayList<>();
        String sql = "SELECT * FROM config ORDER BY id DESC limit ?, ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Config config = new Config();
                config.id = rs.getInt("id");
                config.key = rs.getString("key_");
                config.value = rs.getString("value");
                list.add(config);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    public Config getByKey(String key){
        Config config = null;
        String sql = "select * from config where key_ = ?";
        try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)){

            s.setString(1, key);

            ResultSet rs = s.executeQuery();
            while (rs.next()){
                config = new Config();
                config.id = rs.getInt("id");
                config.key = rs.getString("key_");
                config.value = rs.getString("value");

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }
}
