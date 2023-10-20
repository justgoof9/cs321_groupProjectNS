import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;


public class TestWorkflow {
    /**
     * Test the setting and retreival of the approval queue in the Workflow class.
     */
    @Test
    public void testGetSetApprovalQueue() {
        Workflow wf = new Workflow();
        LinkedList<UUID> ap = new LinkedList<>();
        wf.setApprovalQueue(ap);
        assertThat(wf.getApprovalQueue(), is(ap));
    }
    /**
     * Test the setting and retrevial of the review queue in the Workflow class.
     */
    @Test
    public void testGetSetReviewQueue() {
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>();
        wf.setReviewQueue(rq);
        assertThat(wf.getReviewQueue(), is(rq));
    }
    /**
     * Test the addition of review to the review queue in the workflow class.
     */
    @Test
    public void testAddReview() {
        UUID id = new UUID(0,0);
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>();
        rq.push(id);
        wf.addReview(id);
        assertThat(wf.getReviewQueue(), is(rq));
    }
    /**
     * Test the addition of an approval to the approval queue in the Workflow class.
     */
    @Test
    public void testAddApproval() {
        UUID id = new UUID(0,0);
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>();
        rq.push(id);
        wf.addApproval(id);
        assertThat(wf.getApprovalQueue(), is(rq));
    }

    
}
