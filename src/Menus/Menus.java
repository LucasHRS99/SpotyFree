package Menus;

import Models.Artist;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static Models.ClearConsole.clearConsole;

public class Menus {
    private Map<String, Artist> registredArtists = new HashMap<String, Artist>();
    private static final Map<Integer, Menus> options = new HashMap<Integer, Menus>();
    static {
        options.put(1, new AddArtistMenu());
        options.put(2, new AddAlbumMenu());
        options.put(3, new AddMusicMenu());
        options.put(4, new MenuRateArtist());
        options.put(5, new MenuRateAlbum());
        options.put(6, new MenuShowArtistDetails());
        options.put(7, new MenuShowAllArtists());
        options.put(0, new ExitMenu());
    }


    Scanner scanner = new Scanner(System.in);


    public void showTitle(String title) {
        int letterQuantity = title.length();
        String asterisks = "*".repeat(letterQuantity);

        System.out.println(asterisks);
        System.out.println(title);
        System.out.println(asterisks);
    }

    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        clearConsole();
    }


    public void showLogo() {
        System.out.println("(っ◔◡◔)っ ♥ SpotyFree ♥");
        System.out.println("Bem vindo ao SpotyFree");
    }

    public void showMenuOptions() throws InterruptedException {
        showLogo();
        System.out.println("\n Escolha uma opção");
        System.out.println("1 - Cadastrar Artista");
        System.out.println("2 - Cadastrar Album");
        System.out.println("3 - Cadastrar Musica");
        System.out.println("4 - Avaliar Artista");
        System.out.println("5 - Avaliar Album");
        System.out.println("6 - Mostrar detalhes do Artista");
        System.out.println("7 - Mostrar todos Artista");
        System.out.println("0 - Sair");

        System.out.println("\nDigite a opção desejada: ");
        String optionChosen = scanner.nextLine();
        try {
            int numberOptionChosen = Integer.parseInt(optionChosen);
            if (options.containsKey(numberOptionChosen)) {
                Menus menusToBeDisplayed = options.get(numberOptionChosen);
                menusToBeDisplayed.execute(registredArtists);
                if (numberOptionChosen > 0) {
                    showMenuOptions();
                }
            } else {
                System.out.println("Opção inválida");
                Thread.sleep(1000);
                showMenuOptions();
            }
        }
        catch (NumberFormatException | InterruptedException e){
            System.out.println("Entrada inválida! Por favor, digite um número.");
            Thread.sleep(1000);
            showMenuOptions();
        }
    }
}