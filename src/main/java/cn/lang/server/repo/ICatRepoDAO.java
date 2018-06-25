package cn.lang.server.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import cn.lang.server.entity.Cat;


public interface ICatRepoDAO extends CrudRepository<Cat, Integer>{

	@Query("select c from Cat c where c.id=:id")
	Cat findACat(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update Cat c set c.name=:name where c.id=:id")
	void updateCat(@Param("id") int id, @Param("name") String name);
	
}
