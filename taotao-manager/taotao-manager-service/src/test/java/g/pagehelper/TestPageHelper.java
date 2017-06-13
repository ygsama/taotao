package g.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import g.mapper.TbItemDao;
import g.pojo.TbItem;
import g.pojo.TbItemQuery;

/**
 * 测试PageHelper插件
 * @author G
 *
 */
public class TestPageHelper {

	@Test
	public void testPageHelper() throws Exception{
		// mybatis配置文件中配置插件
		// 设置查询条件，使用PaheHelper静态方法
		PageHelper.startPage(1, 10);
		// 执行查询
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemDao tbItemDao = applicationContext.getBean(TbItemDao.class);
		// 创建example/query
		TbItemQuery query = new TbItemQuery();
		List<TbItem> list = tbItemDao.selectByExample(query);
		// 取分页信息，PageInfo
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		
		System.out.println("总记录数："+pageInfo.getTotal());
		System.out.println("总页数："+pageInfo.getPages());
		System.out.println("返回的记录数："+list.size());
		
		/*打印：
		 * 总记录数：3096
		 * 总页数：310
		 * 返回的记录数：10
		 */
	}
}
