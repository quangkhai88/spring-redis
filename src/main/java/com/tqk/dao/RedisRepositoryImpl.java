package com.tqk.dao;

import com.tqk.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.cdi.RedisRepositoryBean;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by khaitq
 * Date: 27/08/2019
 * Github:  https://github.com/quangkhai88
 */


@Repository
public class RedisRepositoryImpl {


    private static final String KEY = "123";


    @Resource(name="redisTemplate")
    private HashOperations<String, Integer, Student> hashOps;

    public void addStudent(Student student) {

        hashOps.putIfAbsent(KEY, student.getId(), student);
    }

    public Student getStudent(int id) {

        return hashOps.get(KEY, id);
    }

    public Map<Integer, Student> getStudents() {
        return hashOps.entries(KEY);
    }

    public void remvoveAllStudent() {
        hashOps.entries(KEY).forEach((k,v) -> {
            System.out.println("delete Student id =" + k);
            hashOps.delete(KEY, k);
        });
    }
}
