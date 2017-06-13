package g.service;

import java.util.List;

import g.common.pojo.EasyUITreeNode;

/**
 * 商品分类service
 * @author G
 *
 */
public interface ItemCatService {

	List<EasyUITreeNode> getItemCatList( long parentId);
}
