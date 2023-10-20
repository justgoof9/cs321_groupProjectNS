import java.util.LinkedList;
import java.util.UUID;

public class Workflow {
    LinkedList<UUID> reviewQueue;   //queue of ids to review
    LinkedList<UUID> approvalQueue; //queue of ids to approve
    
    //getters and setters
    public LinkedList<UUID> getApprovalQueue() {
        return approvalQueue;
    }
    public LinkedList<UUID> getReviewQueue() {
        return reviewQueue;
    }
    public void setApprovalQueue(LinkedList<UUID> approvalQueue) {
        this.approvalQueue = approvalQueue;
    }
    public void setReviewQueue(LinkedList<UUID> reviewQueue) {
        this.reviewQueue = reviewQueue;
    }
    //end getters and setters

    //add id to tail of review queue
    public void addReview(UUID id){
        reviewQueue.addLast(id);
    }

    //add id to tail of approval queue
    public void addApproval(UUID id){
        approvalQueue.addLast(id);
    }

    //retrieve application from head of approval queue
    public UUID retrieveApproval(){
        return approvalQueue.poll();
    }

    //retireve application from head of review queueu
    public UUID retrieveReview(){
        return reviewQueue.poll();
    }
}
