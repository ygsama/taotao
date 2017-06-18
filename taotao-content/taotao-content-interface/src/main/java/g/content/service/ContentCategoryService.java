package g.content.service;

import java.util.List;

import g.common.pojo.EasyUITreeNode;
import g.common.pojo.TaotaoResult;

public interface ContentCategoryService{

	List<EasyUITreeNode> getContentCategoryList(long parentId);
	TaotaoResult addContentCategory(Long parentId, String name);
}
