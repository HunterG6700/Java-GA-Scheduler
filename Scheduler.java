
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scheduler extends GenMethods {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        int j = 0;
        int k = 0;
        int n = 0;
        int count = 0;
        int bestScore = 0;
        int bestScoreLocation = 0;

        NodeTime[] time = new NodeTime[7];
        NodeRoom[] room = new NodeRoom[7];
        NodeProfessor[] prof = new NodeProfessor[27];
        NodeScheduler[] schedule = new NodeScheduler[10000];

        NodeTime two = new NodeTime(2, "MWF", 9);
        NodeTime three = new NodeTime(3, "MWF", 10);
        NodeTime four = new NodeTime(4, "MWF", 11);
        NodeTime five = new NodeTime(5, "MWF", 12);
        NodeTime six = new NodeTime(6, "MWF", 1);
        NodeTime seven = new NodeTime(7, "MWF", 2);
        NodeTime eight = new NodeTime(8, "MWF", 3);

        time[0] = two;
        time[1] = three;
        time[2] = four;
        time[3] = five;
        time[4] = six;
        time[5] = seven;
        time[6] = eight;

        NodeRoom BL134 = new NodeRoom("BL134", 30, true);
        NodeRoom BL138 = new NodeRoom("BL138", 50, true);
        NodeRoom KR224 = new NodeRoom("KR224", 40, false);
        NodeRoom KR206 = new NodeRoom("KR206", 30, true);
        NodeRoom Biddle123 = new NodeRoom("Biddle123", 35, false);
        NodeRoom Biddle205 = new NodeRoom("Biddle205", 45, false);
        NodeRoom ES100 = new NodeRoom("ES100", 100, true);

        room[0] = BL134;
        room[1] = BL138;
        room[2] = KR224;
        room[3] = KR206;
        room[4] = Biddle123;
        room[5] = Biddle205;
        room[6] = ES100;

        NodeProfessor Prof1 = new NodeProfessor("Bilitski", 1, "cs456", 20, true);
        NodeProfessor Prof2 = new NodeProfessor("Bilitski", 2, "cs456", 20, true);
        NodeProfessor Prof3 = new NodeProfessor("Bilitski", 3, "cs1783", 15, true);
        NodeProfessor Prof4 = new NodeProfessor("Hagerich", 4, "cs455", 20, true);
        NodeProfessor Prof5 = new NodeProfessor("Hagerich", 5, "cs455", 20, true);
        NodeProfessor Prof6 = new NodeProfessor("Smigla", 6, "cs015", 35, true);
        NodeProfessor Prof7 = new NodeProfessor("IM", 7, "cs015", 35, false);
        NodeProfessor Prof8 = new NodeProfessor("IM", 8, "cs015", 35, false);
        NodeProfessor Prof9 = new NodeProfessor("Frederick", 9, "cs015", 35, false);
        NodeProfessor Prof10 = new NodeProfessor("Ferencek", 10, "math001", 40, false);
        NodeProfessor Prof11 = new NodeProfessor("Ferencek", 11, "math001", 50, false);
        NodeProfessor Prof12 = new NodeProfessor("Ferencek", 12, "math001", 60, false);
        NodeProfessor Prof13 = new NodeProfessor("Thomson", 13, "math002", 40, false);
        NodeProfessor Prof14 = new NodeProfessor("Thomson", 14, "math002", 50, false);
        NodeProfessor Prof15 = new NodeProfessor("Thomson", 15, "math002", 60, false);
        NodeProfessor Prof16 = new NodeProfessor("Darling", 16, "soc100", 45, true);
        NodeProfessor Prof17 = new NodeProfessor("Darling", 17, "soc100", 40, true);
        NodeProfessor Prof18 = new NodeProfessor("Darling", 18, "soc100", 35, true);
        NodeProfessor Prof19 = new NodeProfessor("Bilitski", 19, "CS047", 15, true);
        NodeProfessor Prof20 = new NodeProfessor("Bilitski", 20, "CS047", 15, true);
        NodeProfessor Prof21 = new NodeProfessor("Hinderliter", 21, "PSY200", 30, false);
        NodeProfessor Prof22 = new NodeProfessor("Hinderliter", 22, "PSY200", 35, false);
        NodeProfessor Prof23 = new NodeProfessor("Hinderliter", 23, "PSY200", 30, false);
        NodeProfessor Prof24 = new NodeProfessor("Hagerich", 24, "cs045", 20, true);
        NodeProfessor Prof25 = new NodeProfessor("Hagerich", 25, "cs045", 20, true);
        NodeProfessor Prof26 = new NodeProfessor("Smigla", 26, "cs015", 20, true);

        prof[0] = Prof1;
        prof[1] = Prof2;
        prof[2] = Prof3;
        prof[3] = Prof4;
        prof[4] = Prof5;
        prof[5] = Prof6;
        prof[6] = Prof7;
        prof[7] = Prof8;
        prof[8] = Prof9;
        prof[9] = Prof10;
        prof[10] = Prof11;
        prof[11] = Prof12;
        prof[12] = Prof13;
        prof[13] = Prof14;
        prof[14] = Prof15;
        prof[15] = Prof16;
        prof[16] = Prof17;
        prof[17] = Prof18;
        prof[18] = Prof19;
        prof[19] = Prof20;
        prof[20] = Prof21;
        prof[21] = Prof22;
        prof[22] = Prof23;
        prof[23] = Prof24;
        prof[24] = Prof25;
        prof[25] = Prof26;

        NodeTime[] time1 = new NodeTime[27];
        NodeRoom[] room1 = new NodeRoom[27];
        NodeProfessor[] prof1 = new NodeProfessor[27];
        int[] repeatProf = new int[27];
        boolean run = true;
        boolean run1 = true;
        boolean run2 = true;
        boolean run3 = true;

        boolean[] BL134T = new boolean[7];
        boolean[] BL138T = new boolean[7];
        boolean[] KR224T = new boolean[7];
        boolean[] KR206T = new boolean[7];
        boolean[] BL123T = new boolean[7];
        boolean[] BL205T = new boolean[7];
        boolean[] ES100T = new boolean[7];
        int BL134Count = 0;
        int BL138Count = 0;
        int KR224Count = 0;
        int KR206Count = 0;
        int BL123Count = 0;
        int BL205Count = 0;
        int ES100Count = 0;
        for (int i = 0;
                i < 7; i++) {
            BL134T[i] = false;
            BL138T[i] = false;
            KR224T[i] = false;
            KR206T[i] = false;
            BL123T[i] = false;
            BL205T[i] = false;
            ES100T[i] = false;
        }

        for (int i = 0;
                i < repeatProf.length;
                i++) {
            repeatProf[i] = 0;
        }

        Scanner input = new Scanner(System.in);
        int populationNum = 0;
        int percentCrossover = 0;
        int percentClone = 0;
        int percentMutation = 0;
        int ten = 10;

        System.out.println("Enter a number for the population");
        populationNum = input.nextInt();

        System.out.println("Enter the percent out of 10 for chance of crossover.For example enter an 8 for 8/10. You can enter a number up to " + ten + ".");
        percentCrossover = input.nextInt();
        ten = ten - percentCrossover;

        System.out.println( "Enter the percent out of 10 for chance of cloning.For example enter an 8 for 8/10. You can enter a number up to " + ten + ". ");
        percentClone = input.nextInt();
        ten = ten - percentClone;

        System.out.println("Enter the percent out of 10 for chance of mutation.For example enter an 8 for 8/10. You can enter a number up to " + ten + ".");
        percentMutation = input.nextInt();

        System.out.println("This could take a while, please enjoy the music while you wait.");
         try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }

        File dir = new File("song.wav");
        AudioInputStream stream;
        AudioFormat format;
        DataLine.Info info;
        Clip clip;

        stream = AudioSystem.getAudioInputStream(dir);
        format = stream.getFormat();
        info = new DataLine.Info(Clip.class, format);
        clip = (Clip) AudioSystem.getLine(info);
        clip.open(stream);
        clip.start();

        //Creating intial population
        int topScore = 0;
        NodeScheduler topSched = null;
        boolean roomBooked = false;
        int genLocation = 0;
        while (count < populationNum) {
            for (int i = 0; i < 27; i++) {
                run = true;
                run1 = true;
                run2 = true;
                run3 = true;
                int t = 0 + (int) (Math.random() * 7);
                int r = 0 + (int) (Math.random() * 7);
                int p = 0 + (int) (Math.random() * 26);

                while (run && i != 26) {
                    if (repeatProf[p] == 1) {
                        p = 0 + (int) (Math.random() * 26);
                    } else if (repeatProf[p] != 1) {
                        repeatProf[p] = 1;
                        run = false;
                    }
                }
                while (run1) {
                    if (prof[p].getMultimedia() == true) {
                        if (room[r].isMultimedia() == false) {
                            r = 0 + (int) (Math.random() * 7);
                        }
                        if (room[r].isMultimedia() == true) {
                            run1 = false;
                        }
                    }
                    if (prof[p].getMultimedia() == false) {
                        run1 = false;
                    }
                }
                while (run2) {
                    run2 = false;
                    if (prof[p].getSize() > room[r].getSize()) {
                        r = 0 + (int) (Math.random() * 7);
                        if (prof[p].getMultimedia() == true && room[r].isMultimedia() == false) {
                            r = 0 + (int) (Math.random() * 7);
                        }
                        run2 = true;
                    } else if (prof[p].getSize() < room[r].getSize() && (prof[p].getMultimedia() == room[r].isMultimedia() || prof[p].getMultimedia() == false)) {
                        run2 = false;
                    }
                    if (t < 6) {
                        while (time[t] == time[t + 1] && time[t].getPeriodId() == time[t + 1].getPeriodId() && room[r] == room[r + 1]) {
                            t = 0 + (int) (Math.random() * 6);
                            r = 0 + (int) (Math.random() * 6);
                            time1[i] = time[t];
                            room1[i] = room[r];
                            prof1[i] = prof[p];

                        }

                    }

                }

                time1[i] = time[t];
                room1[i] = room[r];
                prof1[i] = prof[p];
                run3 = true;
            }
            NodeScheduler schedule1 = new NodeScheduler(prof1, room1, time1, 0);
            int s = FitnessScore(schedule1);
            schedule1.setFitnessScore(s);

            System.out.println("Creating the initial generation");
            schedule[count] = schedule1;
            System.out.println();
            System.out.println("Schedule: " + count);
            System.out.println("Fitness " + schedule[count].getFitnessScore());
            DisplayMenu();
            schedule[count].display();

            System.out.println();
            count++;
            for (int i = 0; i < repeatProf.length; i++) {
                repeatProf[i] = 0;
            }
            for (int i = 0; i < 7; i++) {
                BL134T[i] = false;
                BL138T[i] = false;
                KR224T[i] = false;
                KR206T[i] = false;
                BL123T[i] = false;
                BL205T[i] = false;
                ES100T[i] = false;
            }
            BL134Count = 0;
            BL138Count = 0;
            KR224Count = 0;
            KR206Count = 0;
            BL123Count = 0;
            BL205Count = 0;
            ES100Count = 0;
        }

        //Gen 2
        NodeScheduler[] Gen1 = new NodeScheduler[populationNum];
        NodeScheduler[] Gen2 = new NodeScheduler[populationNum];
        int genCount = 2;

        //Creating generation 1
        int z = 0;
        int countPrint = 0;
        while (z < populationNum) {
            NodeScheduler s1 = Gen(schedule, room, percentCrossover, percentClone, percentMutation, genCount);
            Gen1[z] = s1;
            int sc = FitnessScore(Gen1[z]);
            Gen1[z].setFitnessScore(sc);

            if (Gen1[z].getFitnessScore() > topScore) {
                topScore = Gen1[z].getFitnessScore();
                topSched = Gen1[z];
                genLocation = 1;
            }
            /*
            if(countPrint % 1000 == 0){
            System.out.println();
            System.out.println("Schedule: " + count);
            DisplayMenu();
            Gen1[z].display();
            System.out.println(Gen1[z].getFitnessScore());
            System.out.println();
            }
             */
            z++;
            count++;
            countPrint++;
        }

        //Creating generation 2
        int zz = 0;
        while (zz < populationNum) {
            NodeScheduler s1 = Gen(schedule, room, percentCrossover, percentClone, percentMutation, genCount);
            Gen2[zz] = s1;
            int sc = FitnessScore(Gen2[zz]);
            Gen2[zz].setFitnessScore(sc);

            if (Gen2[zz].getFitnessScore() > topScore) {
                topScore = Gen2[zz].getFitnessScore();
                topSched = Gen2[zz];
                genLocation = 2;
            }
            /*
            if(countPrint % 1000 == 0){
            System.out.println();
            System.out.println("Schedule: " + count);
            DisplayMenu();
            Gen2[zz].display();
            System.out.println(Gen2[zz].getFitnessScore());
            System.out.println();
            }
             */
            zz++;
            count++;
            countPrint++;
        }

        //Looping through to create 10000 generations
        int zzz = 0;
        while (genCount
                < 11000) {
            for (int i = 0; i < populationNum; i++) {
                NodeScheduler s1 = Gen(Gen1, room, percentCrossover, percentClone, percentMutation, genCount);
                Gen2[i] = s1;
                int sc = FitnessScore(Gen2[i]);
                Gen2[i].setFitnessScore(sc);

                if (Gen2[i].getFitnessScore() > topScore) {
                    topScore = Gen2[i].getFitnessScore();
                    topSched = Gen2[i];
                    genLocation = genCount;
                }

                if (genCount % 1000 == 0) {
                    System.out.println();
                    System.out.println("Generation: " + genCount);
                    System.out.println("Schedule: " + count);
                    System.out.println("Fitness " + Gen2[i].getFitnessScore());
                    DisplayMenu();
                    Gen2[i].display();
                    System.out.println(Gen2[i].getFitnessScore());
                    System.out.println();
                }

                count++;

            }
            for (int i = 0; i < populationNum; i++) {
                NodeScheduler s1 = Gen(Gen2, room, percentCrossover, percentClone, percentMutation, genCount);
                Gen1[i] = s1;
                int sc = FitnessScore(Gen1[i]);
                Gen1[i].setFitnessScore(sc);

                if (Gen1[i].getFitnessScore() > topScore) {
                    topScore = Gen1[i].getFitnessScore();
                    topSched = Gen1[i];
                    genLocation = genCount;
                }

                if (genCount % 1000 == 0) {
                    System.out.println();
                    System.out.println("Generation: " + genCount);
                    System.out.println("Schedule: " + count);
                    System.out.println("Fitness " + Gen1[i].getFitnessScore());
                    DisplayMenu();
                    Gen1[i].display();
                    System.out.println(Gen1[i].getFitnessScore());
                    System.out.println();
                    countPrint++;
                }
                count++;
                countPrint++;
            }
            genCount++;
        }

        //Best score
        clip.start();
        System.out.println(
                "The generation the best schedule is from is generation " + genLocation + ".");
        System.out.println(
                "Best score = " + topScore);
        DisplayMenu();

        topSched.display();

    }
}
