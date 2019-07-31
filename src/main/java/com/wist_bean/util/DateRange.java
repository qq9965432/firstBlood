package com.wist_bean.util;

import java.util.Date;  

/**
 * 
 * <b>类名称：</b>DateRange<br/>
 * <b>类描述：</b>TODO(日期范围封装对象)<br/>
 * <b>创建人：</b>Luoyg<br/>
 * <b>创建时间：</b>2017年8月25日 上午10:06:37<br/>
 * <b>修改人：</b><br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0<br/>
 */
public class DateRange {  
    private Date start;  
    private Date end;  
      
    public DateRange(Date start, Date end) {  
        this.start = start;  
        this.end = end;  
    }  
      
    public Date getStart() {  
        return start;  
    }  
    public void setStart(Date start) {  
        this.start = start;  
    }  
    public Date getEnd() {  
        return end;  
    }  
    public void setEnd(Date end) {  
        this.end = end;  
    }  
      
}  
