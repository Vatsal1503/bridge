package com.bridge.resilience.bridgeresilience.repository;

import com.bridge.resilience.bridgeresilience.model.PDFFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface  PdfRepository extends JpaRepository<PDFFile,String>{
    @Query("from PDFFile where fileName=:name")
    public PDFFile findByName(@Param("name")String name);
}
