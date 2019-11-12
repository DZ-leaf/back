package leaf.model.dao.board;

import org.springframework.data.jpa.repository.JpaRepository;

import leaf.model.dto.board.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}