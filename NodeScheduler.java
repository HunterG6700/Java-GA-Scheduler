
public class NodeScheduler {
    NodeProfessor[] nodeProfessor = new NodeProfessor[27];
    NodeRoom[] nodeRoom = new NodeRoom[27];
    NodeTime[] nodeTime = new NodeTime[27];
    int fitnessScore;

    NodeScheduler(NodeProfessor[] nodeProfessor, NodeRoom[] nodeRoom, NodeTime[] nodeTime, int fitnessScore) {
        this.nodeProfessor = nodeProfessor;
        this.nodeRoom = nodeRoom;
        this.nodeTime = nodeTime;
        this.fitnessScore = fitnessScore;
    }

    public void setNodeProfessor(NodeProfessor nodeProfessor, int loc) {
        this.nodeProfessor[loc] = nodeProfessor;
    }

    public void setNodeRoom(NodeRoom nodeRoom, int loc) {
        this.nodeRoom[loc] = nodeRoom;
    }

    public void setNodeTime(NodeTime nodeTime, int loc) {
        this.nodeTime[loc] = nodeTime;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    public NodeProfessor[] getNodeProfessor() {
        return nodeProfessor;
    }

    public NodeRoom[] getNodeRoom() {
        return nodeRoom;
    }

    public NodeTime[] getNodeTime() {
        return nodeTime;
    }

    public int getFitnessScore() {
        return fitnessScore;
    }
    
   

    public void display() {
        for (int i = 0; i < 27; i++) {
            NodeProfessor np = nodeProfessor[i];
            NodeTime nt = nodeTime[i];
            NodeRoom nr = nodeRoom[i];
            System.out.printf("%10s", i);
            System.out.printf("%10s", np.getId());
            System.out.printf("%13s", np.getName());
            System.out.printf("%10s", np.course);
            System.out.printf("%10s", nt.getPeriodId());
            System.out.printf("%10s", nt.getDay());
            System.out.printf("%10s", nt.getTime());
            System.out.printf("%13s", nr.getRoomId());
            System.out.printf("%16s", nr.getSize());
            System.out.printf("%16s", np.getSize());
            System.out.printf("%20s", nr.isMultimedia());
            System.out.printf("%20s", np.getMultimedia());
            System.out.println();
        }
        
    }
}
