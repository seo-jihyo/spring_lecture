package ex02.nonDI;

public class NewRecordView { //foo
	
	private NewRecord record;

//	필요한 객체를 setter 메소드를 통해서 주입받아서 사용
//	객체의 생성이 서로 독립적이고 필요시 객체의 주입
	
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print() {
		System.out.println("KOR: " + record.getKor());
		System.out.println(record.total() + "/" + record.avg());
		System.out.println("===================================");
		record.disp();				//disp 호출
		System.out.println(record); // toString()함수 호출
	}

}
