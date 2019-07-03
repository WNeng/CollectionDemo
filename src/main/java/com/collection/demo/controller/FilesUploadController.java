package com.collection.demo.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.collection.demo.order.OrderService;
import com.collection.demo.pojo.BankCert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 多文件上传控制类
 * @author Administrator
 */
@Controller
public class FilesUploadController {
	
	// 读取application.properties文件中的自定义配置项
	@Value("${spring.fileupload.destination}")
	private String destination;


	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/files")
	public String index(){
		return "uploads";
	}

	
	/**
	 * 多文件上传类
	 * 文件会自动绑定到MultipartFile中
	 * @param request 获取请求信息
	 * @return 上传成功或失败结果
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@PostMapping("/uploads")
	@ResponseBody
	public String filesUpload(HttpServletRequest request,
//			@RequestParam("descriptions") String[] descriptions,
//			@RequestParam("files") MultipartFile[] files
							  BankCert bankCert
							  ) throws IllegalStateException, IOException {
		
		// 构建上传文件的存放路径
//		String destionation = destination + File.separator + "upload";
//		System.out.println("destionation = " + destionation);

		if (bankCert != null) {

			String orderNo = "190702165130634";
			String token = "a12a7621ed3a4908a5408f88e5516e6f";

			String s = orderService.uploadBankCert(orderNo, bankCert, token);


			return s;
		}else{
			return "上传失败";
		}

	}
	
	/**
	 * 文件保存方法
	 * @param file
	 * @param destination
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	private void saveFile(MultipartFile file, String destination) throws IllegalStateException, IOException {
		// 获取上传的文件名称，并结合存放路径，构建新的文件名称
		String filename = file.getOriginalFilename();
		File filepath = new File(destination, filename);
		
		// 判断路径是否存在，不存在则新创建一个
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdirs();
		}
		
		// 将上传文件保存到目标文件目录
		file.transferTo(new File(destination + File.separator + filename));
	}
}
