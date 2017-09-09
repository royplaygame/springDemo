package com.hy.ly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.hy.ly.dao.StudentDao;
import com.hy.ly.service.StudentService;

//@Service如果不指定bean名称，默认是类名首字母小写studentServiceBean
//@Scope("prototype"),原型模式，每次生成一个新的类对象
@Service("studentService") 
public class StudentServiceBean implements StudentService {
	
	//@Resource(name="studentDao")
	//@Qualifier("")修改默认按类型成为默认按名称,
	//@Autowired(required=true),其中required=true意思，一定要为下面的属性注入值，如果没有找到，会报出异常
	//@Autowired(required=true) @Qualifier("studentDao")
	//@Autowired
	private StudentDao studentDao;
	private String name;
	private Integer id;
	private Set<String> sets=new HashSet<>();
	private List<String> lists=new ArrayList<>();
	private Properties properties=new Properties();
	private Map<String,String> map=new HashMap<>();
	
	public StudentServiceBean(StudentDao studentDao,String name){
		this.studentDao=studentDao;
		this.name=name;
	}
	
	
	public StudentServiceBean(){
		System.out.println("我是构造方法");
	}
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Set<String> getSets() {
		return sets;
	}

	public void setSets(Set<String> sets) {
		this.sets = sets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}
	
	//@Resource
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//@PostConstruct
	public void init(){
		System.out.println("this is init method");
	}

	@Override
	public void save(){
		System.out.println("我是save()方法");
		studentDao.add();
		System.out.println(this.name);
		/*System.out.println(this.id);
		System.out.println(this.sets);
		System.out.println(this.lists);
		System.out.println(this.properties);
		System.out.println(this.map);*/
	}
	
	//@PreDestroy
	public void destory(){
		System.out.println("this is destory method");
	}
}
