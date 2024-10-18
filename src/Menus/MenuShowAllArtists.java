package Menus;

import Models.Artist;
import java.util.Map;
import static Models.ClearConsole.clearConsole;

public class MenuShowAllArtists extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Exibindo todos os Artistas");
        for(String artist : registredArtists.keySet()){
            System.out.println("Artista: " + artist);
        }
        System.out.println("\nDigite qualquer tecla para voltar ao menu principal");
        scanner.nextLine();
        clearConsole();
    }
}
