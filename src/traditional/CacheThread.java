package traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * CacheThread
 *
 * @author Mr Li
 * @date 2018/12/8
 */
public class CacheThread {
    private Map<String,String> cache=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public static void main(String[] args) {

    }
    public String getData(String key){
        readWriteLock.readLock().lock();
        String value = null;
        try {
            value=cache.get(key);
            if (value==null){
                try {
                    readWriteLock.readLock().unlock();
                    readWriteLock.writeLock().lock();
                    if ((value=cache.get(key))==null){
                        value="aaaa";
                        cache.put(key,value);
                    }
                }finally {
                    readWriteLock.writeLock().unlock();
                    readWriteLock.readLock().lock();
                }
            }
        }finally {
            readWriteLock.readLock().unlock();
        }
        return value;

    }
}
