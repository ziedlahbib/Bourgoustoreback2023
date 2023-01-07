package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.FileDB;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.UserRepository;



@Service
public class FileStorageService {
	Long idf;
  @Autowired
  private FileDBRepository fileDBRepo;
  @Autowired
  UserRepository userRepo;
  @Autowired
  ArticleRepository articlerepo;
  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
    return fileDBRepo.save(FileDB);
  }public Long store1(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
	    fileDBRepo.save(FileDB);
	    return FileDB.getId();
	  }
  public void deletefile(Long idfile) {
	  FileDB f =fileDBRepo.findById(idfile).orElse(null);
	  fileDBRepo.delete(f);
  }
  public FileDB getFile(Long id) {
    return fileDBRepo.findById(id).orElse(null);
  }
  
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepo.findAll().stream();
  }
  public FileDB getFileByuser(Long id) {
	  User t =userRepo.findById(id).orElse(null);
	    return t.getFiles();
	  }
  public FileDB getFileByarticle(String id) {
	  Article t =articlerepo.findById(id).orElse(null);
	    return t.getFiles();
	  }
  public void affecterFileToArticle(Long idFiles, String idAticle) {
		Article t=articlerepo.findById(idAticle).orElse(null);
		
		FileDB f=fileDBRepo.findById(idFiles).orElse(null);
		t.setFiles(f);
		articlerepo.save(t);	
	}

	public User affcterfileauuser(Long iduser,Long idfile) {
		// TODO Auto-generated method stub
		User u = userRepo.findById(iduser).orElse(null);
		FileDB f = fileDBRepo.findById(idfile).orElse(null);
		u.setFiles(f);
		userRepo.save(u);
		return u;
	}
 
}