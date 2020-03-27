package f;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public class Node implements INode {
    String code;
    String renderer;

    @Override
    public String toString() {
        return getClass().getSimpleName()+ " (" +"Code: "+code +", Renderer: "+renderer+")";
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public Stream<INode> stream() {
        return Stream.of(this);
    }
}