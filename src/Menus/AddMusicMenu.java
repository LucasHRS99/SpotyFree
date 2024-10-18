package Menus;

import Models.Album;
import Models.Artist;
import Models.Music;
import java.util.Map;
import static Models.ClearConsole.clearConsole;

public class AddMusicMenu extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        showTitle("Registro de Musica");
        System.out.println("Digite o artista que a música pertence: ");
        String artistName = scanner.nextLine();
        Artist artistSelected = registredArtists.get(artistName);
        if(artistSelected != null){
            System.out.println("A musíca é um single?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            String option = scanner.nextLine();
            try {
                int numberOption = Integer.parseInt(option);
                if(numberOption == 1){
                    System.out.println("Digite o nome da música: ");
                    String musicName = scanner.next();
                    if(artistSelected.musicAlreadyExist(musicName)){
                        System.out.println("A música " + musicName + " já existe");
                        System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                        scanner.nextLine();
                        clearConsole();
                    }
                    else{
                        artistSelected.addMusic(new Music(musicName));
                        System.out.println("A música " + musicName + " foi registrada com sucesso!");
                        Thread.sleep(2000);
                        clearConsole();
                    }
                }
                else if(numberOption == 2){
                    System.out.println("Digite o albúm que a música pertence: ");
                    String albumName = scanner.nextLine();
                    Album albumSelected = artistSelected.getAlbum(albumName);
                    if(albumSelected == null){
                        System.out.println("O album " + albumName + " não existe");
                        System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                        scanner.nextLine();
                        clearConsole();
                    }
                    else{
                        System.out.println("Digite o nome da música: ");
                        String musicName = scanner.nextLine();
                        albumSelected.addMusic(new Music(musicName));
                        System.out.println("A música "  + musicName + " foi registrada com sucesso!");
                        Thread.sleep(2000);
                        clearConsole();
                    }
                }
                else {
                    System.out.println("Opção escolhida inválida!");
                    System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                    scanner.nextLine();
                    clearConsole();

                }
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, digite um número.");
                System.out.println("\nDigite qualquer teclar para voltar ao menu principal");
                scanner.nextLine();
                clearConsole();
            }
        }
    }
}
