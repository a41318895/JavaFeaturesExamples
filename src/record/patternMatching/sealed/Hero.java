package record.patternMatching.sealed;

// SwordMan, ArrowMan, and MagicMan now is a type of Hero.
// And no any other class can be a type of Hero. Only these three.
sealed public interface Hero permits SwordMan, ArrowMan, MagicMan {
}
