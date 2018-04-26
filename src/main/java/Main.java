import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.alibaba.fastjson.JSON;

public class Main {
    static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) {
        System.out.println("hello world");
        //请注意使用正常的xml
        //xml->json
        String jsonStr = xmlToJson("/Users/songhaibei/大通/equip.xml", null);
//        System.out.println(jsonStr);

//        String jsonStr1=new ParseXmlToJson<>();

        new ParseJsonToObjTest().getJson1(jsonStr);
    }

    /**
     * xml转json字符串 注意:路径和字符串二传一另外一个传null<br>
     * 方 法 名：xmlToJson <br>
     * 创 建 人：h.j <br>
     * 创建时间：2017年5月10日 上午10:48:26 <br>
     * 修 改 人： <br>
     * 修改日期： <br>
     *
     * @param xmlPath xml路径(和字符串二传一,两样都传优先使用路径)
     * @param xmlStr  xml字符串(和路径二传一,两样都传优先使用路径)
     * @return String
     * @throws IOException
     * @throws JDOMException
     */
    @SuppressWarnings("unchecked")
    public static String xmlToJson(String xmlPath, String xmlStr) {
        SAXBuilder sbder = new SAXBuilder();
        Map<String, Object> map = new HashMap<String, Object>();
        Document document;
        try {
            if (xmlPath != null) {
                //路径
                document = sbder.build(new File(xmlPath));
            } else if (xmlStr != null) {
                //xml字符
                StringReader reader = new StringReader(xmlStr);
                InputSource ins = new InputSource(reader);
                document = sbder.build(ins);
            } else {
                return "{}";
            }
            //获取根节点
            Element el = document.getRootElement();
            List<Element> eList = el.getChildren();
            Map<String, Object> rootMap = new HashMap<String, Object>();
            //得到递归组装的map
            rootMap = xmlToMap(eList, rootMap);
            map.put(el.getName(), rootMap);
            //将map转换为json 返回
            return JSON.toJSONString(map);
        } catch (Exception e) {
            return "{}";
        }
    }

    /**
     * 节点转map<br>
     * 方 法 名：xmlToMap <br>
     * 创 建 人：h.j <br>
     * 创建时间：2017年5月10日 上午10:56:49 <br>
     * 修 改 人： <br>
     * 修改日期： <br>
     *
     * @param eList
     * @param map
     * @return Map<String   ,   Object>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> xmlToMap(List<Element> eList, Map<String, Object> map) {
        for (Element e : eList) {
            Map<String, Object> eMap = new HashMap<String, Object>();
            List<Element> elementList = e.getChildren();
            if (elementList != null && elementList.size() > 0) {
                eMap = xmlToMap(elementList, eMap);
                Object obj = map.get(e.getName());
                if (obj != null) {
                    List<Object> olist = new ArrayList<Object>();
                    if (obj.getClass().getName().equals("java.util.HashMap")) {
                        olist.add(obj);
                        olist.add(eMap);

                    } else if (obj.getClass().getName().equals("java.util.ArrayList")) {
                        olist = (List<Object>) obj;
                        olist.add(eMap);
                    }
                    map.put(e.getName(), olist);
                } else {
                    map.put(e.getName(), eMap);
                }
            } else {
                map.put(e.getName(), e.getValue());
            }
        }
        return map;
    }
}

