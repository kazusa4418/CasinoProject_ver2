package casino.poker;

class RollNotFoundException extends RuntimeException {
    RollNotFoundException() {
        super("Roll does not exist.");
    }
}
