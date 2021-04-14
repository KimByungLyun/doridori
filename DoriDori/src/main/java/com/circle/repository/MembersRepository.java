package com.circle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.circle.domain.user.Members;






public interface MembersRepository extends JpaRepository<Members,Long> {
	

}
