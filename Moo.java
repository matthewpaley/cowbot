import java.util.Random;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.*;

public final class Moo {

	/**
	 * Main method.
	 *
	 * @param args
	 *            the command line arguments; unused here
	 */
	public static void main(String[] args) throws TwitterException, InterruptedException {
		Twitter twitter = new TwitterFactory().getInstance();
		// consumer key and consumer secret
		twitter.setOAuthConsumer("J7EnghyPQ2MUVvYv9zXGrC1kP", "RL23RxrrQLsjtPON8LfVINsVkinrNEfMlA8PK49iLCRtp5hhgY");
		// access token and access token secret
		AccessToken accessToken = new AccessToken("711687798382845952-EzkYCjPer3NhUwPG5FQm6mWD6vM3hGC",
				"UmFsgtfuXlhM6llMKMYBBBh7pVZZPfKSYwDyaIjBZR5FV");
		twitter.setOAuthAccessToken(accessToken);

		// Declare arrays to keep track of generated lengths and initialize to
		// false
		int maxO = 20;
		Boolean[] upper = new Boolean[maxO];
		Boolean[] lower = new Boolean[maxO];

		// Count to reset array
		int count = 20;

		while (true) {
			if (count == 20) {
				// initialize upper array to false
				for (int i = 0; i < upper.length; i++) {
					upper[i] = false;
				}
				// initialize lower array to false
				for (int i = 0; i < lower.length; i++) {
					lower[i] = false;
				}
				count = 0;
			}
			// Generate number of "O's"
			String O = "OO";
			Random rand = new Random();
			int number = rand.nextInt(maxO);
			while (upper[number]) {
				number = rand.nextInt(maxO);
			}
			for (int i = 0; i < number; i++) {
				O += "O";
			}
			upper[number] = true;
			String tweet = "M" + O;
			twitter.updateStatus(tweet);

			// Sleep for an hour
			int milliseconds = 1000;
			int seconds = 60;
			// random number of minutes between 30 and 60
			int minutes = 30 + rand.nextInt(30);
			Thread.sleep(minutes * seconds * milliseconds);

			String o = "oo";
			Random random = new Random();	
			int num = random.nextInt(maxO);
			while (lower[num]) {
				num = random.nextInt(maxO);
			}
			for (int i = 0; i < num; i++) {
				o += "o";
			}
			lower[num] = true;
			String tweet2 = "M" + o;

			num = random.nextInt(1000);
			// pig on a keypad
			if (num == 744) {
				tweet2 = "OINK!";
			}
			// send a new tweet
			twitter.updateStatus(tweet2);

			// Increment count and Sleep for an hour
			minutes = 30 + random.nextInt(30);
			Thread.sleep(minutes * seconds * milliseconds);
			count++;
		}
	}
}