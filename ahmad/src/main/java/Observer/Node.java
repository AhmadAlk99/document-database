package Observer;

class Node extends Observer {

    public Node(Subject subject){
        this.subject=subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {

    }
}
