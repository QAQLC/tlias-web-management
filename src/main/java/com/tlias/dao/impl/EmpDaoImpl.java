package com.tlias.dao.impl;

import com.tlias.dao.EmpDao;
import com.tlias.pojo.Emp;
import com.tlias.utils.XmlParseUtils;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDaoImpl implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        return XmlParseUtils.parse(file, Emp.class);
    }
}
