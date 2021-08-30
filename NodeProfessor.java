
 class NodeProfessor {
     String name;
     int id;
     String course;
     int size;
     boolean multimedia;

    NodeProfessor(String name, int id, String course, int size, boolean multimedia) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.size = size;
        this.multimedia = multimedia;
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMultimedia(boolean multimedia) {
        this.multimedia = multimedia;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public boolean getMultimedia() {
        return multimedia;
    }
    
    public int getSize() {
        return size;
    }
}
