package g.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import g.common.pojo.EasyUIDataGridResult;
import g.common.pojo.TaotaoResult;
import g.common.utils.IDUtils;
import g.mapper.TbItemDao;
import g.mapper.TbItemDescDao;
import g.pojo.TbItem;
import g.pojo.TbItemDesc;
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
	
	@Autowired
	private TbItemDescDao itemDescDao;
	
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

	@Override
	public TaotaoResult addItem(TbItem item, String desc) {
		//生成商品id,添加到item中
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//向-商品表-插入数据
		itemDao.insert(item);
		//创建一个-商品描述表-对应的pojo
		TbItemDesc itemDesc = new TbItemDesc();
		//补全pojo的属性
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setUpdated(new Date());
		itemDesc.setCreated(new Date());
		//向商品描述表插入数据
		itemDescDao.insert(itemDesc);
		//返回结果
		return TaotaoResult.ok();
	}

}
