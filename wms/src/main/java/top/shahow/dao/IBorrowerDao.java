package top.shahow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.shahow.entity.Borrower;

@Repository
public interface IBorrowerDao extends JpaRepository<Borrower, Integer>{

}
