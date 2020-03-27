package f;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAddNodeToCompositeNode()
    {
        //given
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node = new Node("2", "Node1");
        //when
        compositeNode.add(node);
        //then
        assertEquals(1, compositeNode.getNodes().size());
    }

    @Test
    public void shouldAddCompositeNodeToMyStructure()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        //when
        myStructure.add(compositeNode);
        //then
        assertEquals(1, myStructure.getNodes().size());
    }

    @Test
    public void shouldCountAllNodesInMyStructure()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        //when
        compositeNode.add(node1);
        myStructure.add(compositeNode);
        myStructure.add(node2);
        //then
        assertEquals(3, myStructure.count());
    }

    @Test
    public void shouldCountAllNodesInCompositeStructure()
    {
        //given
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        compositeNode.add(node3);
        //then
        assertEquals(3, compositeNode.getNodes().size());
    }

    @Test
    public void shouldfindNodeByCode()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        myStructure.add(node3);
        myStructure.add(compositeNode);
        //then
        assertEquals(node1,myStructure.findByCode("2") );
        assertEquals(compositeNode, myStructure.findByCode("1"));
    }

    @Test
    public void shouldfindNodeByRenderer()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        myStructure.add(node3);
        myStructure.add(compositeNode);
        //then
        assertEquals(node1, myStructure.findByRenderer("Node1"));
        assertEquals(compositeNode, myStructure.findByRenderer("CompositeNode1"));
    }


    @Test
    public void shouldAddCompositeNodeToCompositeNodeInMyStructure()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        CompositeNode compositeNode2 = new CompositeNode("5", "CompositeNode2");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        compositeNode2.add(compositeNode);
        myStructure.add(node3);
        myStructure.add(compositeNode2);
        
        //then
        assertEquals(5, myStructure.count());
        assertEquals(3, compositeNode2.getNodes().size());
    }

    @Test(expected = IllegalArgumentException.class) 
    public void shouldThrowNestedNodeExistExceptionInMyStructure()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        CompositeNode compositeNode2 = new CompositeNode("5", "CompositeNode2");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        compositeNode2.add(compositeNode);
        myStructure.add(node3);
        myStructure.add(compositeNode2);
        myStructure.add(compositeNode);
    }



    @Test
    public void shouldntfindNodeByRenderer()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        myStructure.add(node3);
        myStructure.add(compositeNode);
        //then
        assertNull(myStructure.findByRenderer("Node4"));
        assertNull(myStructure.findByRenderer("CompositeNode2"));
    }

    @Test
    public void shouldntfindNodeByCode()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("3", "Node2");
        Node node3 = new Node("4", "Node3");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        myStructure.add(node3);
        myStructure.add(compositeNode);
        //then
        assertNull(myStructure.findByCode("6"));
        assertNull(myStructure.findByCode("0"));
    }




    @Test(expected = IllegalArgumentException.class) 
    public void shouldThownExistExceptionInMyStructure()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node = new Node("2", "Node1");
        //when
        compositeNode.add(node);
        myStructure.add(compositeNode);
        myStructure.add(node);
    }

    @Test(expected = IllegalArgumentException.class) 
    public void shouldThownExistExceptionInCompositeNode()
    {
        //given
        MyStructure myStructure = new MyStructure("MyStructure");
        CompositeNode compositeNode = new CompositeNode("1", "CompositeNode1");
        Node node1 = new Node("2", "Node1");
        Node node2 = new Node("2", "Node1");
        //when
        compositeNode.add(node1);
        compositeNode.add(node2);
        myStructure.add(compositeNode);
        
    }

    

}
