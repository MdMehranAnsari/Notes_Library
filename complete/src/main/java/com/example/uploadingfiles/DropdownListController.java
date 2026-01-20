package com.example.uploadingfiles;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.uploadingfiles.dbpojo.ExamDB;
import com.example.uploadingfiles.dbpojo.GradeDB;
import com.example.uploadingfiles.dbpojo.SchoolBoardDB;
import com.example.uploadingfiles.services.ExamService;
import com.example.uploadingfiles.services.GradeService;
import com.example.uploadingfiles.services.SchoolBoardService;

@RestController
public class DropdownListController {
	
	@Autowired
	private GradeService gradeService;
	@Autowired
	private SchoolBoardService schoolBoardService;
	@Autowired
	private ExamService examService;
	
	@GetMapping("/grades")
	public String listGrades()
	{
		List<GradeDB> gradesList = gradeService.getAllGrades();
		JSONArray gradesJSON = new JSONArray();
		
		for(GradeDB grade: gradesList)
		{
			JSONObject jsonobj = new JSONObject();
			
			jsonobj.put("gradeId", grade.getId());
			jsonobj.put("gradeName", grade.getName());

			gradesJSON.put(jsonobj);
		}
		return gradesJSON.toString();
	}
	
	@GetMapping("/schoolBoards")
	public String listSchoolBoards(@RequestParam("gradeId") int gradeId)
	{
		//if grade name == "Class 9" or "Class 10" or "Class 11" or "Class 12", then show schoolBoardList
		if(gradeService.getGradeById(gradeId).getName().equalsIgnoreCase("Class 9") || 
			gradeService.getGradeById(gradeId).getName().equalsIgnoreCase("Class 10") || 
			gradeService.getGradeById(gradeId).getName().equalsIgnoreCase("Class 11") || 
			gradeService.getGradeById(gradeId).getName().equalsIgnoreCase("Class 12"))
		{
			List<SchoolBoardDB> schoolBoardsList = schoolBoardService.getAllSchoolBoards();
			JSONArray schoolBoardsJSON = new JSONArray();
			
			for(SchoolBoardDB schoolBoard: schoolBoardsList)
			{
				if(schoolBoard.getName() != null)
				{
					JSONObject jsonobj = new JSONObject();
					
					jsonobj.put("schoolBoardId", schoolBoard.getId());
					jsonobj.put("schoolBoardName", schoolBoard.getName());
					
					schoolBoardsJSON.put(jsonobj);
				}
			}
			return schoolBoardsJSON.toString();
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/exams")
	public String listExams()
	{
		List<ExamDB> examsList = examService.getAllExams();
		JSONArray examsJSON = new JSONArray();
		
		for(ExamDB exam: examsList)
		{
			JSONObject jsonobj = new JSONObject();
			
			jsonobj.put("examId", exam.getId());
			jsonobj.put("examName", exam.getName());

			examsJSON.put(jsonobj);
		}
		return examsJSON.toString();
	}
}