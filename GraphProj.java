package project;

public class GraphProj {

    static final int max=100; 
    public static ConnectionPoint V[]=new ConnectionPoint[max];
    public static int index=0;
    public static edge E[][]=new edge[max][max];

    public static void addVertex(ConnectionPoint p) {
        V[index++]=p;
    }

    public static void addEdge(ConnectionPoint p1, ConnectionPoint p2) {
        int index1=-1, index2=-1;

        for (int i=0; i<index; i++) {
            if (V[i]==p1) index1=i;
            if (V[i]==p2) index2=i;
        }

        if (index1!=-1 && index2!=-1) {
            double weight=getWeight(p1, p2);
            E[index1][index2]=new edge(weight, getDirection(p1, p2));
            E[index2][index1]=new edge(weight, getDirection(p2, p1));
        } else {
            System.out.println("Error: One or both specified nodes do not exist in the graph.");
        }
    }

    public static double getWeight(ConnectionPoint p1, ConnectionPoint p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x, 2) + Math.pow(p1.y-p2.y, 2));
    }

    public static String getDirection(ConnectionPoint c1, ConnectionPoint c2) {
        if (c1.x<c2.x) {
            if (c1.y<c2.y) {
                return "Northeast";
            } else if (c1.y>c2.y) {
                return "Southeast";
            }
            return "East";
        } else if (c1.x>c2.x) {
            if (c1.y<c2.y) {
                return "Northwest";
            } else if (c1.y>c2.y) {
                return "Southwest";
            }
            return "West";
        } else {
            if (c1.y<c2.y) {
                return "North";
            } else if (c1.y>c2.y) {
                return "South";
            } else {
                return "No direction needed";
            }
        }
    }

    public static void displayVertices() {
        System.out.println("\n--- Vertices ---\n");
        System.out.printf("%-20s %-15s %-10s %-10s\n", "Name", "Type", "X Coordinate", "Y Coordinate");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < index; i++) {
            ConnectionPoint p = V[i];
            System.out.printf("%-20s %-15s %-10.2f %-10.2f\n", p.name, p.kind, p.x, p.y);
        }
    }


    public static void displayEdges() {
        System.out.println("\n\n\n--- Edge Connections ---\n");
        System.out.printf("%-20s %-20s %-10s %-15s\n", "Source", "Destination", "Weight", "Direction");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (E[i][j] != null) {
                    System.out.printf("%-20s %-20s %-10.2f %-15s\n",
                            V[i].name, V[j].name, E[i][j].weight, E[i][j].direction);
                }
            }
        }
    }


    public static void main(String args[]) {

        ConnectionPoint p1=new ConnectionPoint("LowerGate", "gate", 12.4, 9.5);
        ConnectionPoint p2=new ConnectionPoint("UpperGate", "gate", 14.91, 0.9);
        ConnectionPoint p3=new ConnectionPoint("MiddleGate", "gate", 7.62, 2.6);

        ConnectionPoint p4=new ConnectionPoint("WKSC", "building", 17.79, 0.8);
        ConnectionPoint p5=new ConnectionPoint("Nicol", "building", 16.25, 2.3);
        ConnectionPoint p6=new ConnectionPoint("Safadi", "building", 17.9, 4.7);
        ConnectionPoint p7=new ConnectionPoint("Sage", "building", 12.78, 3.3);
        ConnectionPoint p8=new ConnectionPoint("AKSOB", "building", 5.7, 4.1);
        ConnectionPoint p9=new ConnectionPoint("LauParking", "building", 6.1, 5.7);
        ConnectionPoint p10=new ConnectionPoint("Irwin", "building", 15.3, 7.4);
        ConnectionPoint p11=new ConnectionPoint("Gezairi", "building", 12.7, 15);

        ConnectionPoint p12=new ConnectionPoint("Saf-Nicol", "intersection", 18.45, 3.7);
        ConnectionPoint p13=new ConnectionPoint("RightOfParking", "intersection", 7.38, 5.8);
        ConnectionPoint p14=new ConnectionPoint("Kraytem", "intersection", 3.85, 2.5);
        ConnectionPoint p15=new ConnectionPoint("interKraytem", "intersection", 3.55, 6.2);
        ConnectionPoint p16=new ConnectionPoint("KraytemEndRoad", "intersection", 1.65, 7.9);
        ConnectionPoint p17=new ConnectionPoint("NearAntoun", "intersection", 18.65, 12.7);
        ConnectionPoint p18=new ConnectionPoint("AntounEnd", "intersection", 18.28, 8.65);
        ConnectionPoint p19=new ConnectionPoint("Gez-1stR", "intersection", 14.6, 13);
        ConnectionPoint p20=new ConnectionPoint("Hamra", "intersection", 10.18, 13.25);
        ConnectionPoint p21=new ConnectionPoint("AlHusseinRoad", "intersection", 13.82, 9);
        ConnectionPoint p22=new ConnectionPoint("HR", "intersection", 12.38, 8.8);
        ConnectionPoint p23=new ConnectionPoint("HRend", "intersection", 9.73, 9.8);

        addVertex(p1);
        addVertex(p2);
        addVertex(p3);
        addVertex(p4);
        addVertex(p5);
        addVertex(p6);
        addVertex(p7);
        addVertex(p8);
        addVertex(p9);
        addVertex(p10);
        addVertex(p11);
        addVertex(p12);
        addVertex(p13);
        addVertex(p14);
        addVertex(p15);
        addVertex(p16);
        addVertex(p17);
        addVertex(p18);
        addVertex(p19);
        addVertex(p20);
        addVertex(p21);
        addVertex(p22);
        addVertex(p23);

        addEdge(p1, p21);
        addEdge(p2, p3);
        addEdge(p2, p7);
        addEdge(p2, p5);
        addEdge(p2, p4);
        addEdge(p2, p10);
        addEdge(p2, p6);
        addEdge(p3, p14);
        addEdge(p3, p13);
        addEdge(p7, p8);
        addEdge(p8, p9);
        addEdge(p10, p22);
        addEdge(p11, p20);
        addEdge(p12, p6);
        addEdge(p12, p5);
        addEdge(p12, p4);
        addEdge(p14, p15);
        addEdge(p15, p16);
        addEdge(p20, p23);
        addEdge(p23, p22);
        addEdge(p22, p1);
        addEdge(p21, p18);
        addEdge(p18, p17);
        addEdge(p17, p19);
        addEdge(p13, p15);
        addEdge(p19, p11);
        addEdge(p23, p16);

        displayVertices();
        displayEdges();
    }
}
