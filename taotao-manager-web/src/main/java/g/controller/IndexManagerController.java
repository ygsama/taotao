package g.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import g.common.pojo.TaotaoResult;
import g.search.service.SearchItemService;

/**
 * 索引库维护Controller
 * @author G
 *
 */
@Controller
public class IndexManagerController {
	
	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping("/index/import")
	@ResponseBody
	public TaotaoResult importIndex() {
		TaotaoResult taotaoResult = searchItemService.importItemsToIndex();
		return taotaoResult;
	}
}
