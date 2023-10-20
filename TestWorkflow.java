import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;


public class TestWorkflow {
    @Test
    public void testGetSetApprovalQueue() {
        Workflow wf = new Workflow();
        LinkedList<UUID> ap = new LinkedList<>(null);
        wf.setApprovalQueue(ap);
        assertThat(wf.getApprovalQueue(), is(ap));
    }
    @Test
    public void testGetSetReviewQueue() {
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>(null);
        wf.setReviewQueue(rq);
        assertThat(wf.getReviewQueue(), is(rq));
    }
    
}
