package Menus;

import Models.Artist;
import Models.Assessment;
import java.util.Map;
import static Models.ClearConsole.clearConsole;

public class MenuRateArtist extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Avaliar Artista");
        System.out.println("Digite o nome do artista que deseja avaliar: ");
        String artistName = scanner.nextLine();
        Artist artistSelected = registredArtists.get(artistName);
        if(artistSelected != null) {
            System.out.println("Qual a nota de 0 a 10 deseja dar para " + artistName + ":");
            String grade = scanner.nextLine();
            try {
                Assessment typedGrade = Assessment.parse(grade);
                if (typedGrade.getGrade() <= 10 && typedGrade.getGrade() >= 0) {
                    artistSelected.addGrade(typedGrade);
                    artistSelected.calcAverage();
                    System.out.println("A nota " + grade + " foi registrada com sucesso!");
                    Thread.sleep(2000);
                    clearConsole();
                } else {
                    System.out.println("Nota inválida! A nota deve estar entre 0 e 10.");
                    System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                    scanner.nextLine();
                    clearConsole();
                }
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, digite um número.");
                System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                scanner.nextLine();
                clearConsole();
            }
        }
        else {
            System.out.println("O artista " + artistName + " não foi encontrado.");
            System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
            scanner.nextLine();
            clearConsole();
            }
    }
}
