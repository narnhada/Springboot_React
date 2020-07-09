package Spring_boot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass                                       // JPA Entity클래스에서 BaseTimeEntity의 필드들을 컬럼으로 인식시켜줌
@EntityListeners(AuditingEntityListener.class)          // 데이터베이스 관리 시스템에서 일어난 동작들을 모니터링하는 짓
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;                  // Entity가 생성되어 저장될때 시간

    @LastModifiedDate                                   // Entity가 조회되고 수정될때 시간
    private LocalDateTime modifiedDate;
}
