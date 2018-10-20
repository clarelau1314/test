package test;


import java.util.HashMap;
import java.util.Iterator;

import com.amerisia.ebills.swift.basic.bean.PropertyUtils;
import com.amerisia.ebills.swift.type.MT742;
import com.amerisia.ebills.swift.type.MT799;
public class TestBeanUtil {
    public static void main(String[] args) throws Exception{
        HashMap hm=new HashMap();
        hm.put("swift_from","ccc");
        Iterator iterator=hm.entrySet().iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next+" "+hm.get(next));
            
        }
        MT742 mt1=new MT742();
        MT799 mt2=new MT799();
//        mt1.setSwift_from("aaa");
     //   BeanUtils.populate(mt1,hm);
//        PropertyUtils.copyProperties(mt2,mt1);
//        System.out.println(PropertyUtils.getProperty(mt2,"swift_from"));
        System.out.println(PropertyUtils.getPropertyType(mt1,"swift_from").getName());
    }
}
