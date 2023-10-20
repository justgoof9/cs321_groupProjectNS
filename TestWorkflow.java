import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class TestWorkflow {
    public void testGetSetGetApprovalQueue() {
        Workflow wf = new Workflow();
        LinkedList<UUID> ap = new LinkedList<>(null)
        wf.setApprovalQueue(ap);
        asserThat(wf.getApprovalQueue(), is(ap))
    }
}
