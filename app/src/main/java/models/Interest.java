package models;

/**
 * Created by Alec on 10/14/2015.
 */
public class Interest {

    String interestName;
    long friendid;
    int state;

    public Interest(String interestName, long friendid, int state) {
        this.interestName = interestName;
        this.friendid = friendid;
        this.state = state;
    }

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public long getFriendid() {
        return friendid;
    }

    public void setFriendid(long friendid) {
        this.friendid = friendid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
