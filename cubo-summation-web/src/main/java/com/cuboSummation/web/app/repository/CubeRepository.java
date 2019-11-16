package com.cuboSummation.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cuboSummation.web.app.entity.CubeEntity;

@Repository
public interface CubeRepository extends JpaRepository<CubeEntity, Long> {
	
	@Query("select sum(c.w) from CubeEntity c  where c.x >= :x1 and c.x <= :x2 and c.y >= :y1 and c.y <= :y2 and c.z >= :z1 and c.z <= :z2")
    public Long SumPositionCube(@Param("x1") Long x1,@Param("y1") Long y1,@Param("z1") Long z1,@Param("x2") Long x2,@Param("y2") Long y2,@Param("z2") Long z2);
	
	@Query("select c from CubeEntity c  where c.x =:x1 and c.y =:y1 and c.z =:z1")
	public CubeEntity search(@Param("x1") Long x1,@Param("y1") Long y1,@Param("z1") Long z1);
}
