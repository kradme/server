package cn.lang.server.repo;

import cn.lang.server.entity.PwdLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PwdLogRepo extends CrudRepository<PwdLog, Integer> {

    @Query("select p from pwd_log p order by  p.id desc")
    List<PwdLog> findAllList();

}
