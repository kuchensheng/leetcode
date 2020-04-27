package cn.com.leetcode.simple;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CountUserLoginTime {

    /*登陆的用户信息*/
    private static final Map<String/*userId*/,User> map = new HashMap<>();
    //每天10亿条日志，那么QPS ≈ 11574/s，按照二八原则QPS 约等于 约等于 11574 * 5 ≈ 6w，则单节点服务器很难承载这么大的压力，所以要用到分布式缓存，这里的缓存应该用redis代替
    // 这里缓存登陆的用户次数
    private static final Map<String/*userId*/, AtomicLong> timesMap = new ConcurrentHashMap<>();

    public Map<String/*userId*/, Integer> getLoginUserInfo() {
        Map<String/*userId*/, Integer> result = new HashMap<>();
        timesMap.forEach((key,val) ->{
            result.put(key,(int)val.get());
        });
        return sortMapByValue(result);
    }

    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
    public static class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }


    public void loginCounter(User user) {
        //TODO 登陆成功
        AtomicLong atomicLong = timesMap.get(user.getUserId());
        if (null == atomicLong) {
            //登陆次数默认为1
            atomicLong = new AtomicLong(0);
        }
        //次数加1
        atomicLong.incrementAndGet();

        timesMap.put(user.getUserId(),atomicLong);

        if (!map.containsKey(user.getUserId())) {
            if (map.size() <= 10) {
                map.put(user.getUserId(),user);
            } else {
                //查找最小数的UerId
                String userId = getMinTimesInfo();
                timesMap.remove(userId);
                map.put(user.getUserId(),user);
            }
        }

    }

    private String getMinTimesInfo() {
        Long min = (long) Integer.MAX_VALUE;
        String userId = null;
        for (Map.Entry<String,AtomicLong> entry : timesMap.entrySet()) {
            if (entry.getValue().get() < min) {
                min = entry.getValue().get();
                userId = entry.getKey();
            }
        }
        return userId;
    }


    class User {
        private String userId;
        private String userName;
        private LocalDateTime loginTime;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public LocalDateTime getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(LocalDateTime loginTime) {
            this.loginTime = loginTime;
        }
    }
}
