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
    private List<T> list = new ArrayList<>();
    private String orderBy = "";

    public Page() {
        this.first=(this.pageNo-1)*this.pageSize;
    }
}
