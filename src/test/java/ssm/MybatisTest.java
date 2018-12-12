package ssm;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.imooc.dao.ProductMapper;
import com.imooc.pojo.Product;

public class MybatisTest {

	@Test
	public void test() {
		ApplicationContext act = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		 ProductMapper  productMapper=	act.getBean(ProductMapper.class);
		 productMapper.deleteAll();
		 Product product=new Product("冰箱", Long.valueOf(1000), "冰箱广告");
		 Product product2=new Product("空调", Long.valueOf(1000), "空调广告");
		 Product product3=new Product("空调广告", Long.valueOf(1000), "空调广告");
		 Product product4=new Product("VR", Long.valueOf(1000), "VR广告");
		 ArrayList<Product> list=new ArrayList<Product>();
		 list.add(product);
		 list.add(product2);
		 list.add(product3);
		 list.add(product4);
		 int index=0;
		 for (int i = 0; i < 200; i++) {
			index++;
			if (index==4) {
				index=0;
			}
			 productMapper.insertSelective(list.get(index));
		}
		 if (act!=null) {
			act=null;
		}
	}

}
