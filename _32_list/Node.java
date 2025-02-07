package _32_list;

public class Node {
    public Patient data;
    public Node link;

    public Node(Patient data) {
        this.data = data;
        this.link = null;
    }

    public Patient getData() {
        return data;
    }

    public void setData(Patient data) {
        this.data = data;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node next) {
        this.link = next;
    }
}