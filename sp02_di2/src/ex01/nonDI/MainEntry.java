package ex01.nonDI;

public class MainEntry {
	
/*	is-a	,	has-a
	���			����
	has-a ���踦 ���� ��ü �ٷ�� */
	
	public static void main(String[] args) {
		NewRecordView view = new NewRecordView(1,2,3,4);
		view.print();
	}
}
