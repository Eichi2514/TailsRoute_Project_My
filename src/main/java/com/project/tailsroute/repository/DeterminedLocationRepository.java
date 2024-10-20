package com.project.tailsroute.repository;

import com.project.tailsroute.vo.DeterminedLocation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeterminedLocationRepository {

    @Select("""
		   SELECT L.*, D.comPortName extra__comPortName, D.name extra__dogName, M.cellphoneNum extra__cellphoneNum
           FROM determinedLocation L
           LEFT JOIN dog D
           ON L.dogId = D.id
           LEFT JOIN `member` M
           ON L.memberId = M.id;		
             """)
    List<DeterminedLocation> All();
}
