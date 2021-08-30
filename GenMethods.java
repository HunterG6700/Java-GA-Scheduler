
abstract class GenMethods {

    static public int RandomChange(int cp, int cn, int mp) {
        int[] chance = new int[11];
        int i = 0;
        while (i < cp) {
            chance[i] = 1;
            i++;
        }
        while (i < cn) {
            chance[i] = 2;
            i++;
        }
        while (i < mp) {
            mp = 3;
            i++;
        }
        int j = 0 + (int) (Math.random() * 11);
        return chance[j];
    }

    static public NodeScheduler Gen(NodeScheduler[] ns, NodeRoom[] nr, int cp, int cn, int mp, int count) {
        NodeScheduler s1 = RandomTroun(ns);
        NodeScheduler s2 = RandomTroun(ns);
        int num = RandomChange(cp, cn, mp);
        switch (num) {
            case 1:
                return CrossOver(s1, s2, nr, count);
            case 2:
                return Clone(s1);
            default:
                return Mutation(s1, nr);
        }
    }

    static public NodeScheduler Clone(NodeScheduler ns) {
        NodeScheduler newNode = new NodeScheduler(ns.getNodeProfessor(), ns.getNodeRoom(), ns.getNodeTime(), 0);
        return newNode;
    }

    static public NodeScheduler CrossOver(NodeScheduler s1, NodeScheduler s2, NodeRoom[] room, int count) {
        NodeProfessor[] s1Prof = s1.getNodeProfessor();
        NodeRoom[] s1Room = s1.getNodeRoom();
        NodeTime[] s1Time = s1.getNodeTime();
        NodeProfessor[] s2Prof = s2.getNodeProfessor();
        NodeRoom[] s2Room = s2.getNodeRoom();
        NodeTime[] s2Time = s2.getNodeTime();
        NodeProfessor[] newProf = new NodeProfessor[27];
        NodeRoom[] newRoom = new NodeRoom[27];
        NodeTime[] newTime = new NodeTime[27];

        if (count % 2 == 0) {
            for (int i = 0; i < 14; i++) {
                newProf[i] = s1Prof[i];
                newRoom[i] = s1Room[i];
                newTime[i] = s1Time[i];
            }
            for (int j = 14; j < 27; j++) {
                newProf[j] = s2Prof[j];
                newRoom[j] = s2Room[j];
                newTime[j] = s2Time[j];
            }
        }
        if (count % 1 == 0) {
            for (int i = 0; i < 14; i++) {
                newProf[i] = s2Prof[i];
                newRoom[i] = s2Room[i];
                newTime[i] = s2Time[i];
            }
            for (int j = 14; j < 27; j++) {
                newProf[j] = s1Prof[j];
                newRoom[j] = s1Room[j];
                newTime[j] = s1Time[j];
            }
            int s = 0;
            for (int count2 = 0; count2 < 27; count2++) {
                if (count2 < 26) {
                    if (newTime[count2] == newTime[count2 + 1] && newTime[count2].getPeriodId() == newTime[count2 + 1].getPeriodId()) {
                        s = 0 + (int) (Math.random() * 26);
                        int temp = 0 + (int) (Math.random() * 2);
                        if (temp == 0) {
                            newTime[count2] = s2Time[s];
                        }
                        newTime[count2] = s1Time[s];
                    }

                }
            }

        }

        NodeScheduler ns = new NodeScheduler(newProf, newRoom, newTime, 0);
        return ns;
    }

    static public NodeScheduler Mutation(NodeScheduler s1, NodeRoom[] room) {
        NodeRoom[] nr = new NodeRoom[27];
        NodeTime[] nt = new NodeTime[27];
        NodeProfessor[] np = new NodeProfessor[27];
        boolean run1 = true;
        boolean run2 = true;

        nr = s1.getNodeRoom();
        nt = s1.getNodeTime();
        np = s1.getNodeProfessor();
        int s = 0 + (int) (Math.random() * 27);
        int r = 0 + (int) (Math.random() * 7);
        int x = 0 + (int) (Math.random() * 7);

        if (x < 7) {
            if (nt[x] == nt[x + 1] && nt[x].getPeriodId() == nt[x + 1].getPeriodId() && nr[x] == nr[x + 1]) {
                x = 0 + (int) (Math.random() * 6);

            }
        }

        nr[r] = room[x];

        NodeScheduler ns = new NodeScheduler(np, nr, nt, 0);
        return ns;

    }

    static public NodeScheduler RandomTroun(NodeScheduler[] ns) {
        int i = 0 + (int) (Math.random() * 27);
        int s = 0 + (int) (Math.random() * 27);
        NodeScheduler s1;
        NodeScheduler s2;
        s1 = ns[i];
        s2 = ns[s];
        if (s1.getFitnessScore() > s2.getFitnessScore()) {
            return s1;
        } else {
            return s2;
        }
    }

    static public int FitnessScore(NodeScheduler ns) {
        //Seats
        int seats = 0;
        int score = 0;
        int z = 0;
        int x = 1;
        int y = 2;
        int count = 0;
        boolean m = true;
        boolean p = true;
        NodeRoom[] nr;
        NodeProfessor[] np;
        NodeProfessor prof1;
        NodeProfessor prof2;
        NodeProfessor prof3;
        np = ns.getNodeProfessor();
        nr = ns.getNodeRoom();

        //Seats Score
        for (int i = 0; i < np.length; i++) {
            seats = nr[i].getSize() - np[i].getSize();
            if (nr[i].getSize() < np[i].getSize()) {
                score = score - 100;
            }

            if (seats < 0) {
                score = score - seats;
            } else if (seats == 0) {
                score = score + 10;
            }
        }

        //Multimedia Room Score
        for (int j = 0; j < np.length; j++) {
            m = nr[j].isMultimedia();
            p = np[j].multimedia;
            if (m == p) {
                score = score + 20;
            } else if (p == false && m == true) {
                score = score + 10;
            }
        }

        //Professor Repeats Class Three Times
        while (count < 27 - 2) {
            prof1 = np[z];
            prof2 = np[x];
            prof3 = np[y];
            int kk = 0;
            int zero = 0;
            //prof4 = np[0];
            if (np[zero].getName() == null ? np[kk].getName() == null : np[zero].getName().equals(np[kk].getName())) {
                score = score + 5;
            }

            if (prof1 == prof2 && prof1 == prof3 && prof2 == prof3) {
                score = score - 15;
            } else {
                score = score - 1;
            }
            z++;
            x++;
            y++;
            kk++;
            count++;
        }
        return score;

    }

    static public int roomBooked(boolean[] room, int period) {
        boolean run = true;
        boolean cont = true;
        int address = period - 2;
        while (run) {
            if (room[address] == false) {
                run = false;
                room[address] = true;
                return address + 2;
            } else if (room[address] == true) {
                address = 0 + (int) (Math.random() * 7);
            }
        }
        return period;
    }

    static public void DisplayMenu() {
        System.out.println("___________________________________________________________________________________________________________________________________________________________________");
        System.out.printf("%11s", "Row#");
        System.out.printf("%11s", "CRN");
        System.out.printf("%11s", "Name");
        System.out.printf("%11s", "Course");
        System.out.printf("%11s", "period");
        System.out.printf("%8s", "Day");
        System.out.printf("%11s", "time");
        System.out.printf("%13s", "building");
        System.out.printf("%16s", "Room Size");
        System.out.printf("%16s", "Class Size");
        System.out.printf("%20s", "Room Multimedia");
        System.out.printf("%20s", "Class Multimedia");
        System.out.println();
    }

}
