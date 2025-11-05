package com.ll.jpa2511.domain.post;


import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsername(String username);

    /* 비관적인 lock mysql 에서 LOCK IN SHARE MODE 이라고 선언하는 것과 동일하다 */
    /* 데이터를 누군가 수정하고 있을 때에는 데이터를 읽을 수 없게 한다*/
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Post> findWithShareLockById(Long id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Post> findWithWriteLockById(Long id);
}
