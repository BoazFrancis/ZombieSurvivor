public class Util {

  public static Outcome calculateOutcome(double index, double biteChance,
      double hitChance, double destroyChance) {
    if (index < biteChance) {
      return Outcome.BITTEN;
    }
    if (index < biteChance + hitChance) {
      return Outcome.HIT;
    }
    return Outcome.DESTROYED;
  }

  public static int findIndexGreaterThanOrEqualTo(int[] numbers, int target) {
    for (int idx = 0; idx < numbers.length; idx++) {
      if (numbers[idx] >= target) {
        return idx;
      }
    }
    return -1;
  }

  public static void swap(Zombie[] zombies, int x, int y) {
    Zombie temp = zombies[x];
    zombies[x] = zombies[y];
    zombies[y] = temp;
  }

}
