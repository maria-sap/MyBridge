package src;

public class Game {

    public int calculateScore(Team team, Contract contract) {
        // Abritrary values
        int score = 0;
        int trickVal = 20;
        int ntBonus = 0;
        int overBonus = 20;
        int underPenalty = 50;
        int insultBonus = 0; // we didn't implement double so this doesn't matter
        int partbonus = 50;
        int fullbonus = 300;
        int slamBonus = 500;

        // Situational values & modifiers
        int trickGoal = 6 + contract.getBidNumber();
        int tricksAchieved = team.getTrickCount() - trickGoal;
        if (contract.getSuit().equalsIgnoreCase("h") || contract.getSuit().equalsIgnoreCase("s")) {
            trickVal += 10;
            overBonus += 10;
        } else if (contract.getSuit().equalsIgnoreCase("nt")) {
            trickVal += 10;
            overBonus += 10;
            ntBonus += 10;
        }
        int contractVal = (trickVal * contract.getBidNumber() + ntBonus) * contract.getDoubleMult();
        if (team.getVulnerablityStatus()) {
            fullbonus += 200;
            slamBonus += 250;
            underPenalty *= 2;
        }
        if (contract.getDoubleMult() != 1) {
            insultBonus = 50 * contract.getDoubleMult();
            overBonus = 50;
            // underPenalty *= contract.getDoubleMult();
        }

        // If contract fulfilled
        if (tricksAchieved >= 0) {
            if (contractVal < 100) {
                score = (contractVal + partbonus + insultBonus)
                        + (tricksAchieved * overBonus * contract.getDoubleMult());
            } else
                score = (contractVal + fullbonus + insultBonus)
                        + (tricksAchieved * overBonus * contract.getDoubleMult());
            if (contract.getBidNumber() > 5) {
                score += slamBonus * (contract.getBidNumber() - 5);
            }
        } else if (tricksAchieved < 0) {
            return score += tricksAchieved * underPenalty;
        }

        return score;
    }
}

// IF(((30 * contractno) + 10) * double < 100,((30 * contractno) + 10) * double
// + partbonus + IFS(double < 2, 0, double < 4, 50, double, 100), ((30 *
// contractno) + 10) * double + fullbonus +
// IFS(double<2,0,double<4,50,double,100))