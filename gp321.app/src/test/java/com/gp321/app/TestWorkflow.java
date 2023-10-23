package com.gp321.app;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import java.util.LinkedList;
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
    public void testAddRetrieveReview() {
        UUID id = new UUID(0,0);
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>();
        wf.setReviewQueue(rq);
        wf.addReview(id);
        assertThat(wf.retrieveReview(), is(id));
    }
    /**
     * Test the addition of an approval to the approval queue in the Workflow class.
     */
    @Test
    public void testAddRetrieveApproval() {
        UUID id = new UUID(0,0);
        Workflow wf = new Workflow();
        LinkedList<UUID> rq = new LinkedList<>();
        wf.setApprovalQueue(rq);
        wf.addApproval(id);
        assertThat(wf.retrieveApproval(), is(id));
    }

    
}
