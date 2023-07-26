package ex01.di;

import java.util.Scanner;

import lombok.Data;

@Data
public class PlayerImpl implements Player {
	
	private String name, position, sport;

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �̸� : ");		this.name = sc.next();
		System.out.print("������ : ");		this.position = sc.next();
		System.out.print("���� : ");		this.sport = sc.next();
	}

	@Override
	public void info() {
		System.out.println("\n=-=-=-=  ���� ���� =-=-=-=");
		System.out.println("���� �̸� : "+ this.name);		
		System.out.println("������ : "+this.position);		
		System.out.println("���� : " +this.sport);	
		System.out.println();
	}

}
