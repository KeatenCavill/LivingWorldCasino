package envs;

import java.util.Random;

import core.Environment;
import core.Person;
import core.Player;

public class SlotMachines extends Environment {

    private Random random = new Random();

    public SlotMachines() {
        super("Slot Machines", "You enter the slot machine area. Lights flash everywhere. It feels like your wallet was lit on fire");
    }

    @Override
    public void enter(Person person) {
        super.enter(person);
    }

    public void playSlots(Player player, double betAmount,
                          double winChance, double payoutMultiplier) {

        if (betAmount <= 0) {
            System.out.println("Bet must be positive.");
            return;
        }

        if (player.getMoneyAmount() < betAmount) {
            System.out.println("You don't have that much money to bet.");
            return;
        }

        // take the bet
        player.addMoney(-betAmount);

        double roll = random.nextDouble();
        if (roll < winChance) {
            double winnings = betAmount * payoutMultiplier;
            player.addMoney(winnings);
            System.out.printf("You WIN! You gain $%.2f%n", winnings);
        } else {
            System.out.printf("You lose your bet of $%.2f%n", betAmount);
        }
    }

    public void playCheapSlots(Player player, double betAmount) {
        // 40% win chance, 2x payout
        playSlots(player, betAmount, 0.4, 2.0);
    }

    public void playHighRiskSlots(Player player, double betAmount) {
        // 10% win chance, 8x payout
        playSlots(player, betAmount, 0.1, 8.0);
    }
}
