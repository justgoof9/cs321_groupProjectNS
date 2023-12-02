package com.gp321.app;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.UUID;


public class WorkflowTest {
    private String path = "testWorkFlow.csv";
    private void intializeTestWorkFlow(){
        try{
            FileWriter fileWriter = new FileWriter(path,false);
            fileWriter.write(
                "review,f3d2e21d-5e89-4b9f-91b2-f317c30d12d0\napproval,6bd2b5a6-7a86-4017-8b4a-e90e49811fe6"
            );
            fileWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Test the setting and retreival of the approval queue in the Workflow class.
     */
    @Test
    public void testGetSetApprovalQueue() {
        intializeTestWorkFlow();
        Workflow wf = new Workflow(path);
        LinkedList<UUID> ap = new LinkedList<>();
        wf.setApprovalQueue(ap);
        assertThat(wf.getApprovalQueue(), is(ap));
    }
    /**
     * Test the setting and retrevial of the review queue in the Workflow class.
     */
    @Test
    public void testGetSetReviewQueue() {
        Workflow wf = new Workflow(path);
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
        Workflow wf = new Workflow(path);
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
        Workflow wf = new Workflow(path);
        LinkedList<UUID> rq = new LinkedList<>();
        wf.setApprovalQueue(rq);
        wf.addApproval(id);
        assertThat(wf.retrieveApproval(), is(id));
    }

    @Test
    public void testConstructor(){
        intializeTestWorkFlow();
        Workflow workflow = new Workflow(path);
        assertThat(workflow.retrieveReview().toString(),is("f3d2e21d-5e89-4b9f-91b2-f317c30d12d0"));
        assertThat(workflow.retrieveApproval().toString(),is("6bd2b5a6-7a86-4017-8b4a-e90e49811fe6"));
    }

    @Test
    public void testWriteOut(){
        Workflow workflow = new Workflow(path);
        UUID id = new UUID(0,0);
        UUID id2 = new UUID(0,0);
        workflow.retrieveApproval();
        workflow.retrieveReview();
        workflow.addApproval(id);
        workflow.addReview(id2);
        workflow.writeOut(path);
        workflow = new Workflow(path);
        assertThat(workflow.retrieveApproval(),is(id));
        assertThat(workflow.retrieveReview(),is(id2));


    }
    
}
