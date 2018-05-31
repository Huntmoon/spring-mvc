package com.ctspcl.date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author wangtao
 * @since 2018/5/31
 */
public class StringDO {
    @DictFormat
    @JsonSerialize(using = DictSerializer.class)
    private String str;

    @JsonIgnore
    private String strDictName;

    public String getStr() {
        return str;
    }






    public void setStr(String str) {
        this.str = str;
    }

    public String getStrDictName() {
        return strDictName;
    }

    public void setStrDictName(String strDictName) {
        this.strDictName = strDictName;
    }

    @Override
    public String toString() {
        return "StringDO{" +
                "str='" + str + '\'' +
                ", strDictName='" + strDictName + '\'' +
                '}';
    }
}
