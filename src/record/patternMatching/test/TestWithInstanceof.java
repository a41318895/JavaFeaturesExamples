package record.patternMatching.test;

import record.patternMatching.combinedRecord.HeroWithEquipment;
import record.patternMatching.enums.Equipment;
import record.patternMatching.sealed.ArrowMan;
import record.patternMatching.sealed.Hero;
import record.patternMatching.sealed.MagicMan;
import record.patternMatching.sealed.SwordMan;

public class TestWithInstanceof {

    public static void main(String[] args) {

        HeroWithEquipment[] heroesWithEquipment = new HeroWithEquipment[6] ;
        heroesWithEquipment[0] = new HeroWithEquipment(new SwordMan(30), Equipment.SHIELD) ;
        heroesWithEquipment[1] = new HeroWithEquipment(new ArrowMan(20), Equipment.BACKPACK) ;
        heroesWithEquipment[2] = new HeroWithEquipment(new MagicMan(25), Equipment.BACKPACK) ;
        heroesWithEquipment[3] = new HeroWithEquipment(new SwordMan(26), Equipment.HELMET) ;
        heroesWithEquipment[4] = new HeroWithEquipment(new ArrowMan(28), Equipment.GUN) ;
        heroesWithEquipment[5] = new HeroWithEquipment(new MagicMan(30), Equipment.SPEAR) ;

        for (HeroWithEquipment heroWithEquipment : heroesWithEquipment) {

            // If the format fits (HeroWithEquipment(x, y)), cast (Hero) x, (Equipment) y automatically.
            // And we can use 'hero' and 'equipment' variables here directly.
            if (heroWithEquipment instanceof HeroWithEquipment(Hero hero, Equipment equipment)) {

                System.out.println(hero + " with " + equipment) ;
            }
        }
    }
}
