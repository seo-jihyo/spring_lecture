package ex03.nonDI;

import java.util.Scanner;

public class IRecordViewImpl implements IRecordView {

	private IRecordImpl record;
	
	// setter�� �����ϱ�
	public void setRecord(IRecordImpl record) {
		this.record = record;
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
			System.out.println("kor: ");		record.setKor(sc.nextInt());
			System.out.println("eng: ");		record.setEng(sc.nextInt());
			System.out.println("com: ");		record.setCom(sc.nextInt());
	}

	@Override
	public void print() {
		System.out.println("\n\nKor: " + record.getKor());
		System.out.println("Eng: " + record.getEng());
		System.out.println("Com: " + record.getCom());
		
		System.out.println("total: " + record.total() + ",\tavg: " + record.avg());
	}

}
