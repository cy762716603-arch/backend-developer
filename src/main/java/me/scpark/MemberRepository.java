package me.scpark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member ,Long>{
}
