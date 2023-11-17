package com.gp321.app;

import java.io.*;
import java.util.*;

public class Workflow {
    LinkedList<UUID> reviewQueue;   //queue of ids to review
    LinkedList<UUID> approvalQueue; //queue of ids to approve

    public Workflow(){
        try{
            
            File file = new File("workflow.csv");
            reviewQueue = new LinkedList<>();
            approvalQueue = new LinkedList<>();
            Scanner scanner = new Scanner(file);
            String review =  scanner.nextLine();
            if(review!= null){
                for(String string: review.split(",")){
                    if(string!=null){
                        reviewQueue.add(UUID.fromString(string));
                    }
                }
            }
            String approve = scanner.nextLine();
            if(approve!=null){
                for(String string: approve.split(",")){
                    if(string != null){
                        approvalQueue.add(UUID.fromString(string));
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
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

    public void writeOut(){
        try{
            File file = new File("workflow.csv");
            ArrayList<String> applicationToWrite;
            ArrayList<String> fullList = new ArrayList<>();
            Application current;
            FileWriter fileWriter = new FileWriter(file,false);
            ArrayList<String> stringReview = new ArrayList<>();
            ArrayList<String> stringApprove = new ArrayList<>();
            ArrayList<String> fullString = new ArrayList<>();

            for(UUID uuid: reviewQueue){
                stringReview.add(uuid.toString());

            }
            for(UUID uuid: approvalQueue){
                stringReview.add(uuid.toString());
            }

            fullString.add(String.join(",",stringReview));
            fullString.add(String.join(",",stringApprove));

            fileWriter.write(String.join("\n",fullString));
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
