package Menus;

import Models.Artist;
import java.util.Map;

public class MenuShowArtistDetails extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Detalhes do Artista");
        System.out.println("Digite o nome do artista: ");
        String artistName = scanner.nextLine();
        Artist artistSelected = registredArtists.get(artistName);
        if(artistSelected != null){
            System.out.println("Artista: " + artistName);
            System.out.println("Discografia: ");
            artistSelected.getArtistAlbuns().forEach(album -> System.out.println(album.getAlbumName()));
        }
    }
}
