package leaf.model.dto.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    @Column(name = "board_no")
    private long idx;

    @Column(name = "user_id")
    private String writer;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "write_dt")
    private LocalDateTime writeTime;

    @Column(name = "like")
    private int like;

    @Column(name = "hit")
    private int hit;
    
}