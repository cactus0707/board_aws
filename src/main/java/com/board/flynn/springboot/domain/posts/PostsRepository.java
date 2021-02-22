package com.board.flynn.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long>{
}
//옜날에 봤던 DAO파일 역할.
//@Repository도 필요없음.
//인터페이스로 구현.. 아마도 안터패이스 상속받은 애들은 자동으로 크루드 만들어지고, 요구 되어질거 같음.
// JpaRepository<Entity클래스, PK-타입> 으로 작성해서 상속하면, 자동으로 CRUD생성.. 진짜 편해졌네..
//JPA구조 필요함. 우선 추성화된 그림? 을 찾아보고 구현을 확인할 것 - 2회독시에