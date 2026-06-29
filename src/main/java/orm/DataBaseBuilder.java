package orm;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBaseBuilder {
	/*
	 * String resource = "org/mybatis/example/mybatis-config.xml"; InputStream
	 * inputStream = Resources.getResourceAsStream(resource); SqlSessionFactory
	 * sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	 */
	
	private static SqlSessionFactory factory;
	private static final String CONFIG= "orm/mybatisConfig.xml";
	
	static {
		try {
			factory= new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(CONFIG));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DataBaseBuilder error");
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
