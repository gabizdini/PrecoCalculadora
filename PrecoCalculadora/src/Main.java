import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcao = 0, opcao2=0;
		double valorProduto, freteProduto, seguroProduto, baseCalculo, IPI, ICMS, margemProduto, valorFinalP;
		double valorServico, aliPraticada, ISS, valorFinalS, margemServico, aliquota=0;

		while (opcao != 3) {
			System.out.println("---- Menu ----");
			System.out.println("1. Preço Final Produto\n");
			System.out.println("2. Preço Final Serviço\n");
			System.out.println("3. Sair");
			System.out.print("Escolha uma opção: ");

			opcao = scanner.nextInt();


			switch(opcao) {

			//PRODUTO
			case 1: 
				System.out.println("Informe o Valor do Produto: ");
				valorProduto = scanner.nextDouble();

				System.out.println("Informe o Frete do Produto: ");
				freteProduto = scanner.nextDouble();

				System.out.println("Informe o Seguro do Produto: ");
				seguroProduto = scanner.nextDouble();

				System.out.println("Informe a Margem de Lucro do Produto (Escreva em Decimal): ");
				margemProduto = scanner.nextDouble();

				System.out.println("Informe o UF_Origem --> UF_Destino: \n 1.SP --> RJ\n 2.SP --> DF\n 3.MG --> SP");
				opcao2 = scanner.nextInt();

				if(opcao2 == 1) {
					aliquota = 0.12;
				}
				else if(opcao2 == 2) {
					aliquota = 0.7;
				}
				else if(opcao2 == 3) {
					aliquota = 0.18;
				}
				else {
					System.out.println("Opção inválida. Tente novamente.");
				}

				baseCalculo = valorProduto + freteProduto + seguroProduto;

				IPI = baseCalculo * (15/100);
				ICMS = valorProduto * aliquota;

				valorFinalP = valorProduto + IPI + ICMS + margemProduto;

				System.out.println("O Preço Final do Produto é (Alíquota SP --> RJ): " + valorFinalP);
				break;

				//SERVIÇO
			case 2: 
				System.out.println("Informe o Valor do Serviço: ");
				valorServico = scanner.nextDouble();

				System.out.println("Informe a Alíquota Praticada: ");
				aliPraticada = scanner.nextDouble();
				aliPraticada = aliPraticada/100;

				System.out.println("Informe a Margem de Lucro do Serviço (Escreva em Decimal com vírgula): ");
				margemServico = scanner.nextDouble();

				ICMS = valorServico * (12/100);

				ISS = aliPraticada * valorServico;

				valorFinalS = valorServico + ICMS + ISS + margemServico;

				System.out.println("O Preço Final do Servico é (Alíquota SP --> RJ): " + valorFinalS);
				break;

			case 3: 
				System.out.println("Saindo...");
				break;

			default: 
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

		}
		scanner.close();
	}
}
