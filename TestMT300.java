package test;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.amerisia.ebills.swift.basic.ContentParse;
import com.amerisia.ebills.swift.basic.MTParse;
import com.amerisia.ebills.swift.basic.Msg;
import com.amerisia.ebills.swift.type.MT300;
import com.amerisia.ebills.swift.type.MT3001;
import com.amerisia.ebills.swift.type.MT3002;
import com.amerisia.ebills.swift.type.MT3003;
import com.amerisia.ebills.swift.type.MT3004;

public class TestMT300 {
	public static void main(String[] args) throws Exception {
		File f1 = new File("c:/00030564.ABO");
		String input = FileUtils.readFileToString(f1, "GBK");

		MTParse parse = new MTParse(input);
		ContentParse cp=new ContentParse(input);
		Msg msg=(Msg)cp.ConvertToObject();
		/*System.out.println(parse.getSwiftFrom());
		System.out.println(parse.getSwiftTo());
		System.out.println(parse.getMessageBody());*/
		//System.out.println(msg);
		MT300 mt300 = (MT300)msg;
		MT3001 mt301 = (MT3001)mt300.getMt3001List().get(0);
		MT3002 mt302 = (MT3002)mt300.getMt3002List().get(0);
		MT3003 mt303 = (MT3003)mt300.getMt3003List().get(0);
		MT3004 mt304 = (MT3004)mt300.getMt3004List().get(0);
		System.out.println("20:"+mt301.getSendernum());
		System.out.println("21:"+mt301.getRelatedRef());
		System.out.println("共同参号:"+mt301.getCommonRef());
		
		
		System.out.println("交易日期:"+mt302.getTradeDate());
		System.out.println("起息日："+mt302.getValueDate());
		System.out.println("利率:"+mt302.getExchangeRate());
		
		System.out.println("金额1:"+mt303.getCURAMT());
		System.out.println("币种:"+mt303.getCUR());
		System.out.println("金额:"+mt303.getAMT());
		System.out.println("金额2:"+mt304.getCURAMT());
		System.out.println("币种:"+mt304.getCUR());
		System.out.println("金额:"+mt304.getAMT());
	}
}
