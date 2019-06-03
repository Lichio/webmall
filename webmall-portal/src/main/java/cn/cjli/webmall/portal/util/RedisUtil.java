package cn.cjli.webmall.portal.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * webmall cn.cjli.webmall.portal.util
 *
 * @author Lichaojie
 * @version 2019/5/21 16:37
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtil {

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 批量删除对应的value
	 *
	 * @param keys
	 */
	public void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 *
	 * @param pattern
	 */
	public void removePattern(final String pattern) {
		Set<Serializable> keys = redisTemplate.keys(pattern);
		if (keys.size() > 0){
			redisTemplate.delete(keys);
		}
	}

	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	public void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 *
	 * @param key
	 * @return
	 */
	public boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	public <T> T get(final String key) {
		T result = null;
		ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> boolean set(final String key, T value) {
		boolean result = false;
		try {
			ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public <T> boolean set(final String key, T value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations<Serializable, T> operations = redisTemplate.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * list--模拟队列操作，向队列中加数据
	 *
	 * @param key
	 * @param value
	 * @param <T>
	 * @return
	 */
	public <T> boolean setList(final String key, T value) {
		boolean result = false;
		try {
			ListOperations<Serializable, T> operations = redisTemplate.opsForList();
			operations.leftPush(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * list--模拟队列操作，从队列中取数据
	 *
	 * @param key
	 * @param <T>
	 * @return
	 */
	public <T> T getList(final String key) {
		T result = null;
		ListOperations<Serializable, T> operations = redisTemplate.opsForList();
		result = operations.rightPop(key);
		return result;
	}

	/**
	 * 判断list是否为空
	 *
	 * @param key
	 * @param <T>
	 * @return
	 */
	public <T> boolean isListEmpty(final String key){
		ListOperations<Serializable,T> operations = redisTemplate.opsForList();
		if(operations.size(key) == 0){
			return true;
		}else{
			return false;
		}
	}

	public static class KeyGenerator{
		/**
		 * 构造短信验证码的key
		 * @param phone
		 * @return
		 */
		public static String createSmsKey(String phone){
			return "smscode" + phone;
		}
	}
}
