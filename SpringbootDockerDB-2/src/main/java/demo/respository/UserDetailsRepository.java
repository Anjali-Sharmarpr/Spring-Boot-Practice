package demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
