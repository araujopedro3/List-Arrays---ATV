import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();

        String continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {

            System.out.print("Digite um nome: ");
            String nome = scanner.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("Nome não pode ser vazio!");
                continue;
            }

            if (nomes.stream().anyMatch(n -> n.equalsIgnoreCase(nome))) {
                System.out.println("Nome já cadastrado!");
                continue;
            }

            nomes.add(nome);

            if (nomes.size() >= 10) {
                System.out.print("Deseja continuar? (S/N): ");
                continuar = scanner.nextLine();
            }
        }

        Collections.sort(nomes, String.CASE_INSENSITIVE_ORDER);

        System.out.println("\nNomes em ordem alfabética:");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        scanner.close();
    }
}