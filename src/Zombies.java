import java.util.Arrays;

public class Zombies {

  private final Zombie[] zombies;
  private int numberOfZombies;

  public Zombies(int maxZombies) {
    assert (numberOfZombies == 0);
    this.zombies = new Zombie[maxZombies];
    
  }

  public int getNumberOfZombies() {
    return this.numberOfZombies;
  }

  public void addZombie(Zombie zombie) {
    zombies[numberOfZombies] = zombie;
    numberOfZombies++;
  }

  public Zombie removeZombie(int zombieIndex) {
    numberOfZombies--;
    Util.swap(zombies, zombieIndex, numberOfZombies);
    return zombies[numberOfZombies];
  }

  public void takeAllZombies(Zombies other) {
    while (other.numberOfZombies > 0) {
        addZombie(other.removeZombie(other.numberOfZombies-1));
    }
  }

  public String toString() {
    Zombie[] smaller = Arrays.copyOf(zombies, numberOfZombies);
    return Arrays.toString(smaller);
  }

}
