package org.example.clztoolsconsole.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer count;
    private Integer pageNo;
    private Integer pageSize;
    private Integer first;
    private Integer last;
    private List<T> list = new ArrayList<T>();
    private String orderBy = "";

    public Page() {
        this.pageSize = -1;
    }

    public Page(HttpServletRequest request, HttpServletResponse response) {
        this(request, response, -2);
    }


    public Page(HttpServletRequest request, HttpServletResponse response, int defaultPageSize) {
        // 设置页码参数（传递repage参数，来记住页码）
        String no = request.getParameter("pageNo");
        if (StringUtils.isNumeric(no)) {
            CookieUtils.setCookie(response, "pageNo", no);
            this.setPageNo(Integer.parseInt(no));
        } else if (request.getParameter("repage") != null) {
            no = CookieUtils.getCookie(request, "pageNo");
            if (StringUtils.isNumeric(no)) {
                this.setPageNo(Integer.parseInt(no));
            }
        }
        // 设置页面大小参数（传递repage参数，来记住页码大小）
        String size = request.getParameter("pageSize");
        if (StringUtils.isNumeric(size)) {
            CookieUtils.setCookie(response, "pageSize", size);
            this.setPageSize(Integer.parseInt(size));
        } else if (request.getParameter("repage") != null) {
            no = CookieUtils.getCookie(request, "pageSize");
            if (StringUtils.isNumeric(size)) {
                this.setPageSize(Integer.parseInt(size));
            }
        } else if (defaultPageSize != -2) {
            this.pageSize = defaultPageSize;
        } else if ("-1".equals(size)) {
            this.pageSize = -1;
        }
        // 设置排序参数
        String orderBy = request.getParameter("orderBy");
        if (StringUtils.isNotBlank(orderBy)) {
            this.setOrderBy(orderBy);
        }
    }
}
