package record.patternMatching.combinedRecord;

import record.patternMatching.enums.Equipment;
import record.patternMatching.sealed.Hero;

public record HeroWithEquipment(Hero hero, Equipment equipment) {
}
