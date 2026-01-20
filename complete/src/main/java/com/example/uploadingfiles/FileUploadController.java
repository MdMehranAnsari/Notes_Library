package com.example.uploadingfiles;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.uploadingfiles.dbpojo.GradeDB;
import com.example.uploadingfiles.dbpojo.SchoolBoardDB;
import com.example.uploadingfiles.services.GradeService;
import com.example.uploadingfiles.services.NoteService;
import com.example.uploadingfiles.services.SchoolBoardService;
import com.example.uploadingfiles.storage.StorageFileNotFoundException;
import com.example.uploadingfiles.storage.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private GradeService gradeService;
	@Autowired
	private SchoolBoardService schoolBoardService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}
	
	@GetMapping("/")
	public String showHomePage() {
		
		return "index";
	}

	/*@GetMapping("/upload")
	public String listUploadedFiles(Model model) throws IOException {

		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));
		
		model.addAttribute("files", storageService.loadAll().map(
				path -> path.toString()).collect(Collectors.toList()));
		
		
		
		model.addAttribute("files", noteService.getAllNotes().stream().map(
				noteDB -> noteService.dbToWebView(noteDB))
				.collect(Collectors.toList()));
		
		return "uploadForm";
	}*/

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);

		if (file == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
	
	@GetMapping("/details/{fileId:.+}")
	public String showDetails(@PathVariable String fileId, Model model) {
		
		model.addAttribute("currentFile", noteService.dbToWebView(noteService.getNoteById(Integer.parseInt(fileId))));
		
		return "detailsPage";
	}
	
	@GetMapping("/details/preview/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile1(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);

		if (file == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"inline; filename=\"" + file.getFilename() + "\"").body(file);
	}

//	@PostMapping("/")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file,
//			RedirectAttributes redirectAttributes) {
//
//		storageService.store(file);
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
//
//		return "redirect:/";
//	}

	@GetMapping("/upload")
	public String loadUploadPage() {
		
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public String handleFileUpload(@ModelAttribute NoteWeb noteWeb,
			RedirectAttributes redirectAttributes) {

		System.out.println(noteWeb);
		
		storageService.store(noteWeb.getFile());
		noteService.addNote(noteWeb);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + noteWeb.getFile().getOriginalFilename() + "!");

		return "redirect:/upload";
	}
	
	@GetMapping("/search")
	public String searchFiles(@RequestParam("query") String query, Model model) {
		
		model.addAttribute("files", noteService.getNotesBySearch(query).stream().map(
				noteDB -> noteService.dbToWebView(noteDB))
				.collect(Collectors.toList()));
		return "searchPage";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
