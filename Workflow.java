import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class Workflow {
    LinkedList<UUID> reviewQueue;
    LinkedList<UUID> approvalQueue;
    
    public Queue<UUID> getApprovalQueue() {
        return approvalQueue;
    }
    public Queue<UUID> getReviewQueue() {
        return reviewQueue;
    }
    public void setApprovalQueue(LinkedList<UUID> approvalQueue) {
        this.approvalQueue = approvalQueue;
    }
    public void setReviewQueue(LinkedList<UUID> reviewQueue) {
        this.reviewQueue = reviewQueue;
    }

    public void addReview(UUID id){
        reviewQueue.push(id);
    }

    public void addApproval(UUID id){
        approvalQueue.push(id);
    }
}
