package g.service;

import g.common.pojo.EasyUIDataGridResult;
import g.common.pojo.TaotaoResult;
//import g.common.pojo.EasyUIDataGridResult;
import g.pojo.TbItem;
import g.pojo.TbItemDesc;

/**
 * 商品
 * @author G
 *
 */
public interface ItemService {

	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
	TaotaoResult addItem(TbItem item ,String desc);
	TbItemDesc getItemDescById(long itemId);
}
