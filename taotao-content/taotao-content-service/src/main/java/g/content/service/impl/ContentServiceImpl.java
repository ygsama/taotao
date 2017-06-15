package g.content.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g.common.pojo.TaotaoResult;
import g.content.service.ContentService;
import g.mapper.TbContentDao;
import g.pojo.TbContent;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentDao contentDao;
	
	@Override
	public TaotaoResult addContent(TbContent content) {
		//补全pojo的属性
		content.setCreated( new Date());
		content.setUpdated(new Date());
		//插入到内容表
		contentDao.insert(content);
		return TaotaoResult.ok();
	}

}
