package DI_06_Spring;

public class ArticleService {
	
	//ArticleService ��  ArticleDao ����
	//����
	//������
	//setter
	
	private ArticleDao articledao;
	public ArticleService(ArticleDao articledao) {
		this.articledao = articledao;
		System.out.println("ArticleService ������ ȣ��");
	}
    
	//�۾��� ����
	public void write(Article article) {
		this.articledao.insert(article);
	}
}
