package f;

public class App 
{
    public static void main( String[] args )
    {
        MyStructure myStructure = new MyStructure("MyStructure");

        Node node1 = new Node("1", "Worker 1");
        Node node2 = new Node("2", "Worker 2");
        Node node3 = new Node("3", "Worker 3");
        Node node4 = new Node("1", "Worker 1");

        CompositeNode manager1 = new CompositeNode("5", "Manager 1");
        CompositeNode manager2 = new CompositeNode("6", "Manager 2");
        CompositeNode manager3 = new CompositeNode("7", "Manager 3");

        manager1.add(node1);
        manager1.add(node2);
        //manager1.add(node1);//uncomment for excepiton
        
        manager2.add(manager1);
        myStructure.add(manager2);
        myStructure.add(node3);
        myStructure.add(manager3);
        // myStructure.add(manager1);//uncomment for nested compositenode exception
        // myStructure.add(node1);//uncomment for excepiton
        // myStructure.add(node4);//uncomment for excepiton

        System.out.println("\n"+">>>> WORKERS IN "+ manager1 +" NETWORK<<<< \n" + manager1.getNodes()+"\n");
        System.out.println(">>>> WORKERS IN "+ manager2 +" NETWORK<<<< \n" + manager2.getNodes()+"\n");
        System.out.println(">>>> NUMBER OF NODES IN "+ myStructure.getName()+": <<<< \n" +myStructure.count()+"\n");
        System.out.println(">>>> WORKERS IN "+myStructure.getName()+" <<<< \n" +myStructure.getNodes()+"\n");
        System.out.println(">>>> FINDER <<<<");

        String code = "5"; //INPUT FOR FINDER
        System.out.println(">>>> -by CODE: "+code+" <<<<");
        System.out.println(">>>>>> Result: "+ myStructure.findByCode(code)+ "\n");

        String renderer = "Worker 2"; //INPUT FOR FINDER
        System.out.println(">>>> -by RENDERER: "+renderer+" <<<<");
        System.out.println(">>>>>> Result: "+ myStructure.findByRenderer(renderer)+ "\n");
    }
}
