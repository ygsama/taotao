package g.content.service;

import java.util.List;

import g.common.pojo.TaotaoResult;
import g.pojo.TbContent;

public interface ContentService {

	TaotaoResult addContent(TbContent content);
	List<TbContent> getContentByCid(long cid);
}
