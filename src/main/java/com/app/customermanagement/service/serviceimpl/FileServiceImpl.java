package com.app.customermanagement.service.serviceimpl;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.customermanagement.config.ParamConfig;
import com.app.customermanagement.service.FileService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class FileServiceImpl implements FileService{
	
	public final ParamConfig paramConfig;

	@Override
	public void uploadFile(MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new  Exception("File is not exists!");
        }

        // Xử lý tệp: Lưu tệp vào thư mục tạm thời hoặc xử lý theo yêu cầu của bạn
        String fileName = file.getOriginalFilename();
        // Giả sử bạn lưu tệp vào thư mục uploads trong dự án
        String uploadDir = paramConfig.getUrlUpload();
        Path path = Paths.get(uploadDir + fileName);
        file.transferTo(path);
		
	}

}
