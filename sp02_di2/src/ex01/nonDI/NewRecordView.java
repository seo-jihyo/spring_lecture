package ex01.nonDI;

public class NewRecordView { //foo
	
	private NewRecord record;

	public NewRecordView(int kor, int eng, int math, int com) {
		record = new NewRecord(kor, eng, math, com);
	}
	
	public void print() {
		System.out.println("KOR: " + record.getKor());
		System.out.println(record.total() + "/" + record.avg());
		System.out.println("===================================");
		record.disp();				//disp ȣ��
		System.out.println(record); // toString()�Լ� ȣ��
	}
}
