package f;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompositeNode extends Node implements ICompositeNode {
    private List<INode> nodes;

    public CompositeNode(String code, String renderer) {
        super(code, renderer);
        nodes = new ArrayList<>();
    }
    
    public void add(Node node){
        if(getNodes().contains(node))
            throw new IllegalArgumentException(node+" exists in "+ this+ "\n");
        nodes.add(node);   
    }
    public void remove(Node node){
        nodes.remove(node);
    }
    
    @Override
    public List<INode> getNodes() {
        return nodes.stream()
                    .flatMap(INode::stream)
                    .collect(Collectors.toList());
    }

    @Override
    public Stream<INode> stream() {
        return Stream.concat(super.stream(),
                               nodes.stream()
                                    .flatMap(INode::stream)
        );
    }
   
}