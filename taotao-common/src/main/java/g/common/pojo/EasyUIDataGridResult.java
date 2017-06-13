package g.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 响应后台管理-xx列表的json
 * @author G
 *
 */
public class EasyUIDataGridResult implements Serializable{

	private long total;
	private List rows;
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
