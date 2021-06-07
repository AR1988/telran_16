package com.company.issuers;

import com.company.Score;
import java.util.List;

public class CreativeIssuer extends Issuer {

    int turbosNumber;
    int turboMin;
    int turboMax;
    int inspiredProbability;

    List<Score> scores;

    public CreativeIssuer(String name,
                          int min,
                          int max,
                          int creditsNumber,
                          int turbosNumber,
                          int turboMin,
                          int turboMax,
                          int inspiredProbability,
                          List<Score> scores) {
        super(name, min, max, creditsNumber, scores);
        this.turbosNumber = turbosNumber;
        this.turboMin = turboMin;
        this.turboMax = turboMax;
        this.inspiredProbability = inspiredProbability;
        this.scores = scores;

    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        int turboLeft = 0;
        for (int i = 0; i < creditsNumber; i++) {

            if (turboLeft == 0 && toInspire()) {
                turboLeft = turbosNumber;
            }

            int time;
            if (turboLeft != 0) {
                turboLeft--;
                time = generateTime(turboMin, turboMax);
            } else {
                time = generateTime(min, max);
            }
            sleep(time);
        }

        long end = System.currentTimeMillis();
        synchronized (scores) {
            scores.add(new Score(name, (end - start)));
        }
    }

    private boolean toInspire() {
        return random.nextInt(100 + 1) < inspiredProbability;
    }
}
