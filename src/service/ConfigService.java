package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO dao = new ConfigDAO();
//    static {
//        init();
//    }
    public ConfigService(){
        init();
    }
    public static void init(){
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    /**
     *
     * @param key
     * @param value
     */
    private static void init(String key, String value){
        Config config = dao.getByKey(key);
        //数据库中不存在，则需要添加
        if (config == null){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            dao.add(c);
        }

    }

    /**
     * 根据键获取值
     * @param key
     * @return
     */
    public String get(String key){
        Config config = dao.getByKey(key);
        return config.getValue();
    }

    /**
     * 根据键更新数据库
     * @param key
     * @param value
     */
    public void update(String key, String value){
        Config config = dao.getByKey(key);
        config.setValue(value);
        dao.update(config);
    }

    /**
     * 获取预算
     * @return
     */
    public int getIntBudget(){
        return Integer.parseInt(get(budget));
    }
}
