package co.istad.kanhchana.elearninga01m1.features.comment;


import co.istad.kanhchana.elearninga01m1.config.auditing.BasedEntity;
import co.istad.kanhchana.elearninga01m1.features.video.Video;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BasedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    @ManyToOne
    private Video video;

    private LocalDateTime createdAt;
}
