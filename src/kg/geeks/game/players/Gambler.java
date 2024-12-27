package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Gambler extends Hero {
    private int diceDamage;

    public Gambler(String name, int health, int damage) {super(name, health, damage, SuperAbility.ROLL_THE_DICE);
        this.diceDamage = diceDamage ;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2;
        if (RPG_Game.random.nextBoolean()) {
            dice2 = dice1;
        } else {
            dice2 = RPG_Game.random.nextInt(6) + 1;
        }
            if (dice2 == dice1) {
                boss.setHealth(boss.getHealth() - dice2 + dice1);
                System.out.println("Gambler" + super.getName() + "hits Boss with a luck" + diceDamage);
            } else {
                Hero randomHero = null;

                for (Hero hero : heroes) {
                    if (hero != this) {
                        randomHero = hero;
                        break;
                    }

                }
                if (randomHero != null) {
                    int diceDamage = dice1 + dice2;
                    randomHero.setHealth(getHealth() - diceDamage);
                    System.out.println("Gambler" + super.getName() + "made unluck" + randomHero.getName() + "got" + diceDamage + "damage");
                }

            }
        }
    }



