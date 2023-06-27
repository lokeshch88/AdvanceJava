package com.app.service;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.repository.EmployeeRepository;
@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	// dep: emp dao i/f
	@Autowired
	private EmployeeRepository empRepo;
	
	//how to access a property from appln property file: 
	//SpEL: Spring Expression Language
	@Value("${upload.location}")
	private String uploadFolder;
	
	//add a custom init method to chk if folder is exists, if not create new one
	@PostConstruct
	public void myInit() {
		System.out.println("in init "+uploadFolder);
		//chk if folder is exists
		File dir=new File(uploadFolder);
		if(dir.exists())
			System.out.println("folder alrdy exists!!");
		else {
			dir.mkdir(); //creating reqd dirs
			System.out.println("created a new folder");
		}
	}
	@Override
	public ApiResponse uploadImageToFolder(Long empId, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
