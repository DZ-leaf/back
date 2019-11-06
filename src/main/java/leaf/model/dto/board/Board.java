package leaf.model.dto.board;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Board
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
@Entity
public class Board {

    @Id
    int idx;

    String title;

    String content;

    String writer;

    LocalDateTime creatAt;

    LocalDateTime modifyAt;
    
}