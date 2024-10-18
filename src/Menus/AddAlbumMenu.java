package Menus;

import Models.Album;
import Models.Artist;
import java.util.Map;
import static Models.ClearConsole.clearConsole;

public class AddAlbumMenu extends Menus{

    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Registro de Albuns");
        System.out.println("Digite o nome do artista que o album pertence: ");
        String artistName = scanner.nextLine();
        Artist artistSelected = registredArtists.get(artistName);
        if(artistSelected != null){
            System.out.println("Informe o nome do album que deseja registrar: ");
            String albumName = scanner.nextLine();
            if(artistSelected.albumAlreadyExist(albumName)){
                System.out.println("O album " + albumName + " já existe!");
                System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                scanner.nextLine();
                clearConsole();
            }
            else{
                artistSelected.addAlbum(new Album(albumName));
                System.out.println("\nO album " + albumName + " foi registrado com sucesso!");
                Thread.sleep(2000);
                clearConsole();
            }
        }
        else{
            System.out.println("O artista " + artistName + " não foi encontrado.");
            System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
            scanner.nextLine();
            clearConsole();
        }
    }
}
