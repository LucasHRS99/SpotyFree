package Menus;

import Models.Artist;
import java.util.Map;

public class ExitMenu extends Menus{

    @Override
    public void execute(Map<String, Artist> registredArtists) throws InterruptedException {
        super.execute(registredArtists);
        System.out.println("Obrigado por usar o SpotyFree - Te vejo em breve ;)");
    }
}
