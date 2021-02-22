package com.board.flynn.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// 엔티티 클래스는 테이블과 매핑이 되고, 세터를 쓰지 않는다 - 세터가 필요한 로직의 클래스에서 새터 하도록
//-> 잠깐 생각만 해봐도 엔티티에서 세터를 제공하게되면 여러 로직에서 맘대로 새터 부른다고 생각하면 콜스택 개판될거 뻔하다고 예상함.
@Getter // 롬복 어노테이션 클래스 안의 모든필드의 Getter 자동생성 //
@NoArgsConstructor //롬복 어노테이션 - 기본생성자 자동추가 public Post(){}
@Entity //JPA어노테이션

public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
// RDB에서 애트리뷰트와 PK부분이 JPA를 통해 추상화가 된 것 같다.(@ID-유일값부분) FK부분이 궁금해지고 RDB는 보나마나 BCNF 해놨을 건데
// 어떻게 SQL문을 생성하는지, 성능 이슈는 없다곤 하는데 쿼리플랜을 어떻게 생각하고 어떻게 적용 됬을지, 찾아봐야 한다.
// RDB와 OOP패러다임이 달라서 포디즘/생산성 때문에 쓴다고는 하나, 좀더 봐야 할 것 같다.
// Entity 부분도 용어상 ER다이어 그램이 자연스럽게 생각나는데, 어떤 추상화 규칙이 있었는지 궁금하다.
//@Builder부분에서 한번에 실어가서 DB에 트랜잭션을 요청 할 것 같은 느낌이 든다.
//C++this와 자바 this가 조금 다른걸로 기억하는데 지금 어떻게 다른지 기억이 안난다.. 갈길이 바쁘니 일단 한번 웹스택을 훑고 회독때 드릴다운..