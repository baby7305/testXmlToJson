import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ParseXmlToJson<T> {

    static ObjectMapper mapper = new ObjectMapper();

    /***
     * 转对象
     * @param josn
     * @param clz
     * @return
     */
    public T jsonStreamConverObject(String josn, Class<T> clz) {
        T t = null;
        // ObjectMapper jacksonMapper = new ObjectMapper();
        InputStreamReader in = new InputStreamReader(new ByteArrayInputStream(
                josn.getBytes()));
        BufferedReader streamReader = new BufferedReader(in);
        StringBuilder buff = new StringBuilder();
        String inputStr;
        try {
            while ((inputStr = streamReader.readLine()) != null)
                buff.append(inputStr);
            // ObjectMapper mapper = new ObjectMapper();
            t = mapper.readValue(buff.toString(), clz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /***
     * 转对象
     * @param josn
     * @param clz
     * @return
     */
    public T jsonConverObject(String josn, Class<T> clz) {
        T t = null;
        try {
            t = mapper.readValue(josn, clz);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 转集合
     *
     * @param josn
     * @param clz
     * @return
     */
    public List<T> jsonConverList(String josn, Class<T> clz) {
        List<T> me = null;
        try {
            // jacksonMapper
            // .disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
            // jacksonMapper.enableDefaultTyping();
            // jacksonMapper.setVisibility(JsonMethod.FIELD,JsonAutoDetect.Visibility.ANY);
            // jacksonMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT,
            // false);//格式化
            // jacksonMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
            // jacksonMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,
            // false);
            JavaType javaType = mapper.getTypeFactory()
                    .constructParametricType(List.class, clz);// clz.selGenType().getClass()
            me = mapper.readValue(josn, javaType);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return me;
    }

/**
 * output:
 * 转对象:User [UserID=1, LoginName=唐工, Truename=超级, Nickname=null, LoginPwd=E10ADC3949BA59ABBE56E057F20F883E, QQ=, Phone=, Email=null, Remark=, Account_Non_Locked=0, Telelephone=null, Indate=null, IsDelete=0, RoleList=null]
 * 转集合me:[User [UserID=1, LoginName=唐工, Truename=超级, Nickname=null, LoginPwd=E10ADC3949BA59ABBE56E057F20F883E, QQ=, Phone=, Email=null, Remark=, Account_Non_Locked=0, Telelephone=null, Indate=null, IsDelete=0, RoleList=null]]
 * 转对象里有集合u3:User [UserID=1, LoginName=唐工, Truename=超级, Nickname=null, LoginPwd=E10ADC3949BA59ABBE56E057F20F883E, QQ=, Phone=, Email=null, Remark=, Account_Non_Locked=0, Telelephone=null, Indate=null, IsDelete=0, RoleList=[Role [Roleid=0, Name=超级管理员, Show_Name=超级管理员, Remark=null, Type=1]]]
 * 集合里是对象 对象里有集合转换:[User [UserID=1, LoginName=唐工, Truename=超级, Nickname=null, LoginPwd=E10ADC3949BA59ABBE56E057F20F883E, QQ=, Phone=, Email=null, Remark=, Account_Non_Locked=0, Telelephone=null, Indate=null, IsDelete=0, RoleList=[Role [Roleid=0, Name=超级管理员, Show_Name=超级管理员, Remark=null, Type=1]]], User [UserID=2, LoginName=唐工, Truename=超级, Nickname=null, LoginPwd=E10ADC3949BA59ABBE56E057F20F883E, QQ=, Phone=, Email=null, Remark=, Account_Non_Locked=0, Telelephone=null, Indate=null, IsDelete=0, RoleList=[Role [Roleid=0, Name=超级管理员, Show_Name=超级管理员, Remark=null, Type=1]]]]
 * */
}
