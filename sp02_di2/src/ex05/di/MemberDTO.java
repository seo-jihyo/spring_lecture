package ex05.di;

public class MemberDTO { //model
	private String name;
	private int age;
	private String message;
	
	//constructor
	public MemberDTO() {
		System.out.println("MemberDTO default comstructor");
	}

	public MemberDTO(String name, int age, String message) {
		super();
		System.out.println("MemberDTO 필드 갖는 생성자 함수");
		this.name = name;
		this.age = age;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	//getter/setter
	
	
}
