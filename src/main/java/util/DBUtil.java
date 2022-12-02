package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtil {
    private String confPath;
    private InputStream inputStream;
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;
    private static DBUtil dbUtil = null;

    private DBUtil() throws IOException {
        // 配置文件路径
        confPath = "mybatis-config.xml";
        // 读取配置文件得到输入流
        inputStream = Resources.getResourceAsStream(confPath);
        // 创建sql Session工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession getSqlSession() throws IOException {
        if (dbUtil == null)
            dbUtil = new DBUtil();
        // 建立与数据库的会话
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
