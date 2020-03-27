package f;

import java.util.stream.Stream;

interface INode {
    String getCode();
    String getRenderer();
    Stream<INode> stream();
}
  
