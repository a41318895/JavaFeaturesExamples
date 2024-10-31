package record.patternMatching.sealed;

// Record is an immutable class, and all its field are final.
// So we don't need to add final keyword here
public record ArrowMan(int age) implements Hero {
}
