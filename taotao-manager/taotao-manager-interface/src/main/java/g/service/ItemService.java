package g.service;

import g.common.pojo.EasyUIDataGridResult;
//import g.common.pojo.EasyUIDataGridResult;
import g.pojo.TbItem;

/**
 * 
 * @author G
 *
 */
public interface ItemService {

	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page, int rows);
}
