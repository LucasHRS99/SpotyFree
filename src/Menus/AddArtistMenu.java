package Menus;

import Models.Artist;
import java.util.Map;
import static Models.ClearConsole.clearConsole;

public class AddArtistMenu extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Registro de Artistas");
        System.out.println("Digite o Artista que deseja registrar: ");
        String artistName = scanner.nextLine();
        Artist artistSelected = registredArtists.get(artistName);
        if(artistSelected == null){
            Artist artist = new Artist(artistName);
            registredArtists.put(artistName, artist);
            System.out.println("O artista " + artistName + " foi registrado com sucesso!");
            Thread.sleep(2000);
            clearConsole();
        }
        else {
            System.out.println("O Artista " + artistName + " já existe");
        }
    }
}
