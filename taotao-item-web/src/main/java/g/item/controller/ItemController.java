package g.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import g.item.pojo.Item;
import g.pojo.TbItem;
import g.pojo.TbItemDesc;
import g.service.ItemService;

/**
 * 商品详情页面展示Controller
 * @author G
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable Long itemId, Model model) {
		//取商品基本信息
		TbItem tbItem = itemService.getItemById(itemId);
		Item item = new Item(tbItem);
		//取商品详情
		TbItemDesc tbItemDesc = itemService.getItemDescById(itemId);
		//把数据传递给页面
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", tbItemDesc);
		//返回逻辑视图
		return "item";
	}
}
