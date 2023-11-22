package jp.eightbit.exam.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.eightbit.exam.entity.Questions;
import jp.eightbit.exam.model.QuestionModel;
import jp.eightbit.exam.model.QuestionResult;
import jp.eightbit.exam.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private HttpSession httpSession;
	private final QuestionService questService;
	
	public QuestionController(QuestionService questionService) {
		this.questService = questionService;
	}
	
	//最初のアクセスページ
	@GetMapping("/")
	public String routeToIndex(Model model) {
		QuestionModel questionModel = (QuestionModel) httpSession.getAttribute("questionModel");
		if(questionModel != null)httpSession.invalidate();
		model.addAttribute("questionModel", new QuestionModel());
		return "index";
	}
	
	//名前の入力チェックをして、入力されていれば1問目へ/されていなければエラーページへ
	@PostMapping("/nameCheck")
	public String toQuestion1(Model model, @Valid @ModelAttribute QuestionModel questionModel, BindingResult result){
		String nextPage;
		if (result.hasErrors()) {
			nextPage = "index";
		} else {
			//セッションオブジェクトにquestionModelインスタンスを格納
			httpSession.setAttribute("questionModel", questionModel);
			nextPage = "redirect:/question/1";
		}
		return nextPage;
	}
	
	//問題文ページ処理
	@GetMapping("/question/{index}")
	public String toNextQuestion(Model model, @PathVariable("index") Integer index) {
		Questions question = questService.getQuestion(index);
		model.addAttribute("questions", question);
		model.addAttribute("index", index.intValue());
	    return "question";
	}
	
	//答え合わせページでの処理
	@PostMapping("/answer/{index}")
	public String answerHandle(Model model, @PathVariable("index") Integer index, HttpServletRequest request) {
		//ユーザーから受け取ったデータをString型にキャストする。
		String answerVal = (String)request.getParameter("answer" + index.toString());
		String nextPage = ""; 
		
		//QuestionModelをインスタンス化する
		QuestionModel questionModel = (QuestionModel)httpSession.getAttribute("questionModel");
		//indexの数値に対応したQuestionModelセッターにデータを格納する。
		switch(index.intValue()) {
			case 1:
				questionModel.setAnswer1(answerVal);
				break;
			
			case 2:
				questionModel.setAnswer2(answerVal);
				break;
			
			case 3:
				questionModel.setAnswer3(answerVal);
		}
		
		index++;
		//3以下なら問題ページにリダイレクト、4以上になったら結果ページに遷移
		if(index > 3) {
			List<QuestionResult> rList = questService.getResult(questionModel);
			model.addAttribute("resultList", rList);
			model.addAttribute("name", questionModel.getName());
			model.addAttribute("questionCount", rList.size());
			model.addAttribute("correctCount", questService.getCorrectCount(rList));
			System.out.println(rList);
			nextPage = "result";
		}else {
			nextPage = "redirect:/question/" + index;
		}
		//セッションにインスタンスを格納
		httpSession.setAttribute("questionModel", questionModel);
		return nextPage;
		
	}

	//エラー処理
	@ExceptionHandler(Exception.class)
	private String exceptionHandler(Model model, Exception e) {
		e.printStackTrace();
		System.out.println(e.toString());
		model.addAttribute("message", e.toString());
		return "error";
	}
}