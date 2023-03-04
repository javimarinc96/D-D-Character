import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


class DnDCharacter {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    int ability(List<Integer> scores) {
        return scores.stream().sorted().skip(1).reduce(0, Integer::sum).intValue();

    }

    List<Integer> rollDice() {
        Random random = new Random();
        return random.ints(4,1,7).boxed().collect(Collectors.toList());
    }

    int modifier(int input) {
        double res = input-10;
        double res2 = res/2;
        double res3 = Math.floor(res2);
        return (int) res3;
    }

    int getStrength() {
        if(this.strength != 0){
            return this.strength;
        }
        int strengthScore = this.ability(this.rollDice());
        this.strength = strengthScore;
        return strengthScore;
    }

    int getDexterity() {
        if(this.dexterity != 0){
            return this.dexterity;
        }
        int dexterityScore = this.ability(this.rollDice());
        this.dexterity = dexterityScore;
        return dexterityScore;
    }

    int getConstitution() {
        if(this.constitution != 0){
            return this.constitution;
        }
        int constitutionScore = this.ability(this.rollDice());
        this.constitution = constitutionScore;
        return constitutionScore;
    }

    int getIntelligence() {
        if(this.intelligence != 0){
            return this.intelligence;
        }
        int intelligenceScore = this.ability(this.rollDice());
        this.intelligence = intelligenceScore;
        return intelligenceScore;    
    }

    int getWisdom() {
        if(this.wisdom != 0){
            return this.wisdom;
        }
        int wisdomScore = this.ability(this.rollDice());
        this.wisdom = wisdomScore;
        return wisdomScore;   
    }

    int getCharisma() {
        if(this.charisma != 0){
            return this.charisma;
        }
        int charismaScore = this.ability(this.rollDice());
        this.charisma = charismaScore;
        return charismaScore; 
    }

    int getHitpoints() {
        return 10 + this.modifier(this.constitution);
    }
}