package server.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.exam.model.Supervisor;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Boolean existsBySupervisorId(int supervisor_id);
}
