package f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Getter;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;
    @Getter
    private String name;
    
    public MyStructure(String name) {
        this.name = name;
        nodes = new ArrayList<>();
    }

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code is null!");
        }
        return findByPredicate(c -> code.equals(c.getCode()));
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Renderer is null!");
        }
        return findByPredicate(r -> renderer.equals(r.getRenderer()));
    }

    @Override
    public int count() {
        return Math.toIntExact(nodes.stream()
                                    .flatMap(INode::stream)
                                    .count()
        );
    }

	public void add(Node node) {
        if(node instanceof CompositeNode){
            Boolean isExist = existsInNodes(n->((CompositeNode)node).getNodes().contains(n));
            if (isExist){
                INode iNode = findByPredicate(n->((CompositeNode)node).getNodes().contains(n));
                throw new IllegalArgumentException(iNode+ " is a part of "+node+" and exists in "+ this+ "\n");
            }
        }
        Boolean isExist = existsInNodes(n->node.equals(n));
        if (isExist)
            throw new IllegalArgumentException(node+" exists in "+ this+ "\n");
        nodes.add(node);
    }

    public void remove(Node node){
        nodes.remove(node);
    }

    public List<INode> getNodes() {
        return nodes.stream()
                    .flatMap(INode::stream)
                    .collect(Collectors.toList());
    }
    
    private INode findByPredicate(Predicate<INode> predicate) {
        return nodes.stream()
                .flatMap(INode::stream)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    private Boolean existsInNodes(Predicate<INode> predicate) {
        return getNodes().stream()
                         .anyMatch(predicate);
    }

    @Override
    public String toString() {      
        return getClass().getSimpleName()+ " (" +"Name: "+name +")";
    }
  }
  