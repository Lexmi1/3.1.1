package web.Project311.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.Project311.model.User;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}