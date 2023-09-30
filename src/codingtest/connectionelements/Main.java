package codingtest.connectionelements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Node> nodes = new ArrayList<>();
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int vertexNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        for(int i = 1; i<vertexNum+1; i++) {
            Node node = new Node(i, false);
            nodes.add(node);
        }

        for(int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Node xNode = null;
            Node yNode = null;

            for(Node node : nodes) {
                if(node.getName() == x) {
                    xNode = node;
                }
                if(node.getName() == y) {
                    yNode = node;
                }
            }

            xNode.getLinkedNodes().add(yNode);
            yNode.getLinkedNodes().add(xNode);

        }

        for(int i = 0; i<vertexNum;i++) {
            Node node = nodes.get(i);

            if(!node.getFlag()) {
                cnt++;
                dfs(node);
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(Node node) {
        node.changeFlagToTrue();
        List<Node> linkedNodes = node.getLinkedNodes();

        for(Node linkedNode : linkedNodes) {
            if(!linkedNode.flag) {
                dfs(linkedNode);
            }
        }
    }

    static class Node{

        private int name;
        private boolean flag;

        public List<Node> linkedNodes= new ArrayList<>();

        Node(int name, boolean flag) {
            this.name = name;
            this.flag = flag;
        }

        public int getName() {
            return this.name;
        }

        public List<Node> getLinkedNodes() {
            return this.linkedNodes;
        }

        public void changeFlagToTrue() {
            this.flag = true;
        }
        public boolean getFlag() {
            return this.flag;
        }
    }
}
