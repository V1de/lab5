package mypackage;

class Letter{


    private Character character;

    public Letter(char letter){

        this.character = letter;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;
        boolean result = Character.toLowerCase(character) == Character.toLowerCase(letter1.character);
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

}
