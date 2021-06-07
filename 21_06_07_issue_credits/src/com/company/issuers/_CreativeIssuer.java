package com.company.issuers;//package com.company.hw;
//
//import java.util.List;
//import java.util.Random;
//
//public class _CreativeIssuer implements Runnable {
//
//    private String name;
//    private int min;
//    private int max;
//
//    private int turbosNumber;
//    private int turboMin;
//    private int turboMax;
//    private int inspiredProbability;
//
//    private int creditsNumber;
//    private List<Score> scores;
//
//    Random random = new Random();
//
//    public _CreativeIssuer(String name,
//                           int min,
//                           int max,
//                           int turbosNumber,
//                           int turboMin,
//                           int turboMax,
//                           int inspiredProbability,
//                           int creditsNumber,
//                           List<Score> scores) {
//        this.name = name;
//        this.min = min;
//        this.max = max;
//        this.turbosNumber = turbosNumber;
//        this.turboMin = turboMin;
//        this.turboMax = turboMax;
//        this.inspiredProbability = inspiredProbability;
//        this.creditsNumber = creditsNumber;
//        this.scores = scores;
//    }
//
//    @Override
//    public void run() {
//        long start = System.currentTimeMillis();
//
//        int turboLeft = 0;
//        for (int i = 0; i < creditsNumber; i++) {
//
//            if (turboLeft == 0 && toInspire()) {
//                turboLeft = turbosNumber;
//            }
//
//            int time;
//            if (turboLeft != 0) {
//                turboLeft--;
//                time = generateTime(turboMin, turboMax);
//            } else {
//                time = generateTime(min, max);
//            }
//            sleep(time);
//        }
//
//        long end = System.currentTimeMillis();
//        synchronized (scores) {
//            scores.add(new Score(name, (end - start)));
//        }
//    }
//
//    private boolean toInspire() {
//        return random.nextInt(100 + 1) < inspiredProbability;
//    }
//
//    private int generateTime(int min, int max) {
//        return random.nextInt(max - min) + min;
//    }
//
//    private void sleep(long time) {
//        try {
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
