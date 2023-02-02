package com.example.heathapi.repastory;

import com.example.heathapi.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResultRpositry extends JpaRepository<Result,Integer> {
    Result findByIdEquals(Integer id);
    List<Result> findByPatientDiseasesIdEquals(Integer id);
    @Query(value = "select u from Result  u  where u.patientDiseasesId=?1  and u.dataTime between  ?2 and ?3")
    List<Result> findByDate(Integer patientDiseasesId, Date start,Date end);

}
