package com.rzk.mapper;

import com.rzk.pojo.Teacher;
import com.sun.jmx.snmp.mpm.SnmpMsgTranslator;
import com.sun.org.apache.xalan.internal.xsltc.dom.SimpleResultTreeImpl;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.sun.xml.internal.ws.server.ServerRtException;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.SimpleTypeRegistry;
import org.jcp.xml.dsig.internal.SignerOutputStream;

import java.util.Map;
import java.util.StringTokenizer;

public interface TeacherMapper {
//    @Select("select * from teacher where id=#{tid}")
//    Teacher getTeacher(@Param("tid") int id);
        //查询多个id
        Teacher getTeacherById(int id);
        //插入
        int addTeacher(Teacher teacher);
        //删除
        int deleteTeacher(int id);

        //使用map修改
        int updateTeacherMap(Map<String,Object> map);
        //使用map插入
        int addTeacherMap(Map<String,Object> map);
}
