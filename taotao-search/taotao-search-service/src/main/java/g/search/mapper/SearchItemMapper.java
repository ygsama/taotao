package g.search.mapper;

import java.util.List;

import g.common.pojo.SearchItem;

public interface SearchItemMapper {

	List<SearchItem> getItemList();

	SearchItem getItemById(long itemId);
}
