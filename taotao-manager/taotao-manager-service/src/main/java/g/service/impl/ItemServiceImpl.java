package g.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import g.common.pojo.EasyUIDataGridResult;
import g.mapper.TbItemDao;
import g.pojo.TbItem;
import g.pojo.TbItemQuery;
import g.service.ItemService;

/**
 * 商品管理Service
 * @author G
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemDao itemDao;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItem item = itemDao.selectByPrimaryKey(itemId);
		return item;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemQuery example = new TbItemQuery();
		List<TbItem> list = itemDao.selectByExample(example);
		//取查询结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		result.setTotal(pageInfo.getTotal());
		//返回结果
		return result;
	}

}
