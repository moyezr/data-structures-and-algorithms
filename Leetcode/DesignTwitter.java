package Leetcode;
import java.util.*;
class User {
    List<Tweet> tweets;
    Set<Integer> following;
    int userId;

    public User(int userId) {
        this.userId = userId;
        this.tweets = new ArrayList<>();
        this.following = new HashSet<>();
    }

    public void follow(int id) {
        this.following.add(id);
    }

    public void unfollow(int id) {
        this.following.remove(id);
    }
}

class Tweet {
    int timestamp;
    int id;
    int userId;

    public Tweet(int id, int timestamp, int userId) {

        this.id = id;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public String toString() {

        return "Id = " + this.id + "  Timestamp = " + this.timestamp;
    }
    public int getTimestamp() {
        return this.timestamp;
    }
}

class Twitter {

    int timestamp = 0;
    HashMap<Integer, User>  users;

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, ++timestamp, userId);

        if(!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }

        users.get(userId).tweets.add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> ans = new ArrayList<>();

        User user = users.get(userId);

        ans.addAll(user.tweets);

        for(int id: user.following) {
            ans.addAll(users.get(id).tweets);
        }


        Collections.sort(ans, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet a, Tweet b) {
                return b.timestamp - a.timestamp;
            }
        });
        System.out.println(ans);
        List<Integer> result = new ArrayList<>();


        for(int i = 0; i < 10 && i < ans.size(); i++) {
            result.add(ans.get(i).id);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) {
            users.put(followerId, new User(followerId));
        }

        if(!users.containsKey(followeeId)) {
            users.put(followeeId, new User(followeeId));
        }

        // The follower follows followee
        users.get(followerId).following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).following.remove(followeeId);
    }
}

class TweetComparator implements java.util.Comparator<Tweet> {
    @Override
    public int compare(Tweet a, Tweet b) {
        return a.getTimestamp() - b.getTimestamp();
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */