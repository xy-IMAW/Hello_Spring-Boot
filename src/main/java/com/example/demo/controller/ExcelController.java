/**
 * 
 */
package com.example.demo.controller;

import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.PoliceInfoDao;
import com.example.demo.entity.PoliceInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author 谢意
 *读取Excel文件及其相关操作
 */
@RestController
@RequestMapping("/excel")
@Api(tags="excel接口")
public class ExcelController {
	@Autowired
	private PoliceInfoDao policeinfodao;
	
	//读取Excel文件返回警员ID和姓名
	@ApiOperation(value="读取Excel文件返回警员ID和姓名")
	@PostMapping(value = "/impFile",consumes = "multipart/*", headers = "content-type=multipart/form-data")	
	public Map<String, String> getIDandNameFromExcel(@ApiParam(value = "上传文件",required = true) MultipartFile file) throws IOException{
		Map<String,String> map = new HashMap<String,String>();
		List<PoliceInfo> list = new ArrayList<PoliceInfo>();

		Workbook workbook=null;
		//根据后缀判断选择创建HSSF还是XSSF
		try {
			 workbook = new XSSFWorkbook(file.getInputStream());
		} catch (Exception e) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}
		
		//获取sheet
		int numOfSheets = workbook.getNumberOfSheets();
		for(int i = 0; i<numOfSheets; i++) {
			Sheet sheet = workbook.getSheetAt(i);
			//获取sheet中的行，遍历行（第一行是标题）
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			PoliceInfo policeInfo;
			
			for (int j = 1; j < physicalNumberOfRows; j++) {
				Row row = sheet.getRow(j);				
				Cell workPlace = row.getCell(0);
				Cell jy_name = row.getCell(1);
				Cell jh = row.getCell(2);
				Cell jy_id= row.getCell(3);
				Cell wp_id = row.getCell(4);
				policeInfo = new PoliceInfo(
						jy_id.toString(),jy_name.toString(),workPlace.toString(),jh.toString(),wp_id.toString());
				list.add(policeInfo);
				map.put(policeInfo.getJy_ID(),policeInfo.getJy_name());
			}
		}
		policeinfodao.save(list);
		workbook.close();
		return map;
	}
	
	//调用TRS获取警员图片
	
	//base64文件解码
	@PostMapping("/base64")
    @ApiOperation(value = "Base64编码解码测试")
	public String base64Decode(@ApiParam(value = "测试字符") String text) throws UnsupportedEncodingException {
		Base64.Encoder encoder = Base64.getEncoder();

		text = "测试";
		byte[] textByte = text.getBytes("UTF-8");
		//编码
		String encodedText = encoder.encodeToString(textByte);
		return encodedText;
//		System.out.println(encodedText);
//		解码
//		System.out.println(new String(decoder.decode(encodedText), "UTF-8"));
//		//generateImage(getImageStr());
	}
	public  String getImageStr( MultipartFile file) {
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream inputStream = null;

		byte[] data = null;
		try {
			inputStream = file.getInputStream();
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Base64.Encoder encoder =  Base64.getEncoder();
		return encoder.encodeToString(data);
	}
	
	public  String generateImage(String imgstr,MultipartFile file) {
		//对字节数组字符串进行Base64解码并生成图片
		if(imgstr == null) //图像数据为空
			return "false";
		Base64.Decoder decoder = Base64.getDecoder();
		try {
			byte[] b = decoder.decode(imgstr);
			for(int i = 0; i < b.length; i++) {
				if(b[i] < 0) {
					//调整异常数据
					b[i]+=256;
				}
			}
			//生成jpg图片
			String fileName ;
			fileName = file.getOriginalFilename();//获取原文件名
			String prefix = fileName.substring(fileName.indexOf(".")+1);//获取文件名前缀
			String path = "G:\\jp\\hello\\src\\main\\resources\\images";
			String imagePath = path+ "\\test_"+fileName;
			OutputStream out = new FileOutputStream(imagePath);
			out.write(b);
			out.flush();
			out.close();
			return imagePath;
		} catch (Exception e) {
			// TODO: handle exception
			return "保存失败";
		}
	}
	
	@ApiOperation(value = "传入图片通过base64传输保存到本地")
	@PostMapping(value = "/img",consumes = "multipart/*", headers = "content-type=multipart/form-data")
	public String getImgBase(@ApiParam(value = "图片文件",required = true) MultipartFile file )  {
		return generateImage(getImageStr(file), file);
	}
	  
	//调用文件微服务，接收返回的文件ID
	
	//调用人员组织微服务更新警员ID和图片
}
