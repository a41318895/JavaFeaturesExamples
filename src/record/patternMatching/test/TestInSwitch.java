package record.patternMatching.test;

import record.patternMatching.sealed.ArrowMan;
import record.patternMatching.sealed.Hero;
import record.patternMatching.sealed.MagicMan;
import record.patternMatching.sealed.SwordMan;

public class TestInSwitch {

    public static void main(String[] args) {

        Hero[] heroes = new Hero[6] ;
        heroes[0] = new SwordMan(15) ;
        heroes[1] = new MagicMan(16) ;
        heroes[2] = new ArrowMan(17) ;
        heroes[3] = new SwordMan(18) ;
        heroes[4] = new MagicMan(19) ;
        heroes[5] = new ArrowMan(20) ;

        for (Hero currentHero : heroes) {

            // We don't need to add default case here,
            // because Hero interface only permits these three Record to extend or implement.
            switch (currentHero) {

                case SwordMan s -> System.out.println("Sword Man: " + s) ;

                case ArrowMan a -> System.out.println("Arrow Man: " + a) ;

                case MagicMan m -> System.out.println("Magic Man: " + m) ;
            }
        }
    }
}
