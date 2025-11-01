class Twitter {

    class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, Tweet> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        following.computeIfAbsent(userId, x -> new HashSet<>()).add(userId);
        time++;
        Tweet tweet = new Tweet(tweetId, time);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> followedUsers = following.getOrDefault(userId, new HashSet<>());

        for(int uid : followedUsers){
            Tweet tweet = tweets.get(uid);
            if (tweet != null) heap.offer(tweet);
        }

        List<Integer> feed = new ArrayList<>();
        while(!heap.isEmpty() && feed.size() < 10){
            Tweet feedTweet = heap.poll();
            feed.add(feedTweet.id);
            if(feedTweet.next != null) heap.offer(feedTweet.next);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, x -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        Set<Integer> set = following.get(followerId);
        if(set != null){
            set.remove(followeeId);
        }
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
