package cn.lang.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.lang.server.entity.Cat;
import cn.lang.server.repo.ICatRepoDAO;

@RestController
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private ICatRepoDAO iCat;

	@GetMapping("getCat")
	public Cat test(int id) {
		return iCat.findACat(id);
	}
	@PostMapping("updateCat")
	public void test(int id, String name) {
		iCat.updateCat(id, name);
	}
	@PostMapping("insertCat")
	public Cat insertCat(String name, int age) {
		return iCat.save(new Cat(name,age));
	}
}
