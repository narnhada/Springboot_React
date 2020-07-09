package Spring_boot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/* DB layer 접근자
JpaRepository<Entity클래스, PK 타입>를 상속하면 CRUD메소드 자동 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
