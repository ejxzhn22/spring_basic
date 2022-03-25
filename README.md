
## 1. 객체 지향 설계와 스프링

### 자바 진영의 추운 겨울과 스프링의 탄생

### 스프링이란?
  #### 스프링 부트 : 스프링을 편리하게 사용할 수 있도록 지원
    - Tomcat 내장 -> 웹 서버 설치 x
    - starter 제공
    - 3rd parth(외부) 라이브러리 자동 구성 -> 버전을 맞춰준다.
    - 메트릭, 상태확인, 외부 구성같은 프로덕션 준비 기능 제공 -> 운영 환경 모니터링
    - 관례에 의한 간결한 설정 -> 필요한 부분만 설정을 변경하면 된다
    
  #### 스프링 : 문맥에 따라 다르게 사용
    - 스프링 DI 컨테이너 기술
    - 스프링 프레임워크
    - 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계
    
  #### 스프링 핵심 컨셉 
    - 자바 언어 기반의 프레임워크 -> 자바의 큰 특징 __'객체지향 언어'__
    - 스프링은 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크
    - __좋은 객체 지향__ 애플리케이션을 개발할 수 있게 도와주는 프레임워크
    
    => __좋은 객체 지향__ 프로그래밍은 뭘까?
    
== 2022.03.23 수 ==


### 좋은 객체 지향 프로그래밍이란?
  #### 객체 지향 특징
    - 추상화
    - 캡슐화
    - 상속
    - 다형성
    
  #### 객체 지향 프로그래밍
    - 객체 지향 핵심 -> 다형성
    
  #### 다형성
    - 실세계 -> 역할과 구현으로 세상을 구분
    - 역할과 구현으로 구분하면 세상이 단순해지고, 유연해지며 변경도 편리해진다.
    - 장점
      1. 클라이언트는 대상의 역할(인터페이스)만 알면 된다.
      2. 클라이언트는 구현 대상의 내부 구조를 몰라도 된다.
      3. 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향을 받지 않는다.
      4. 클라이언트는 구현 대상 자체를  변경해도 영향을 받지 않는다.
      
    - 자바 언어의 다형성을 활용
      - 역할 = 인터페이스
      - 구현 = 인터페이스를 구현한 클래스, 구현 객체
      - 객체를 성계할 때 역할과 구현을 명확히 분리
      - 객체 설계 시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기
      
    => 객체의 협력이라는 관계부터 생각해야 한다. 수 많은 객체 클라이언트와 객체 서버는 서로 협력 관계를 가진다.
    
  #### 다형성의 본질
    - 인터페이스를 구현한 객체 인스턴스를 실행 시점에 유연하게 변경할 수 있다.
    - 다형성의 본질을 이해하려면 협력이라는 객체사이의 관계에서 시작해야함.
    - **클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있다.
    
    => 인터페이스를 안정적으로 구현하는 것이 중요
    => 역할(인터페이스) 자체가 변하면 클라이언트,서버 모두에 큰 변경이 발생한다.
    
    
  #### 스프링과 객체 지향
    - 다형성이 가장 중요
    - 스프링은 다형성을 극대화해서 이용할 수 있게 도와준다.
    - 스프링에서 이야기하는 제어의 역정, 의존관계 주입은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원한다.
    - 스프링을 사용하면 블럭 조립하듯 구현을 편리하게 변경할 수 있다.
    
### 좋은 객체 지향 설계의 5가지 원칙(SOLID)

  #### SOLID
    - SRP : 단일 책임 원칙 (single responsibility principle)
    - OCP : 개방-폐쇄 원칙 (open/closed principle)
    - LSP : 리스코프 치환 원칙 ( Liskov substitution principle)
    - ISP : 인터페이스 분리 원칙 (Interface segregation principle)
    - DIP : 의존관계 역전 원칙 ( Dependency inversion principle)
    
  #### SRP 단일 책임 원칙
    - 한 클래스는 하나의 책임만 가져야 한다.
    - 하나의 책임이라는 것은 모호하다. -> 책임의 범위를 적절하게 조절하는 것이 중요
    - 중요한 기준은 변경 -> 변경이 있을 때 파급효과가 적으면 단일 책임 원칙으 잘 따른것
    
  #### OCP 개방-폐쇄 원칙
    - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
    - 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능 구현 -> 기존 코드 변경 X
    - 다형성을 이용한다.
    
    - 문제점
      - 구현 객체를 변경하려면 클라이언트 코드를 변경해야함.
      - 다형성을 사용했지만 OCP원칙을 지킬 수 없다.
      - 객체를 생성하고 연관관계를 맺어주는 별도의 조립,설정자가 필요하다. -> 스프링 컨테이너
      
  #### LSP 리스코프 치환 원칙
    - 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 한다.
    - 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것, 다형성을 지원하기 위한 원칙, 
      인터페이스를 구현한 구현체는 믿고 사용하려면, 이 원칙이 필요 -> 기능에 대한 약속
    - 단순히 컴파일에 성공하는 것을 넘어서는 이야기
    
  #### ISP 인터페이스 분리 원칙
    - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.
    - 자동차 인터페이스 -> 운전 인터페이스, 정비 인터페이스로 분리
    - 사용자 클라이언트 -> 운전자 클라이언트, 정비사 클라이언트로 분리
    - 분리하면 정비 인터페이스 자체가 변해도 운전자 클라이언트에 영향을 주지 않음
    - 인터페이스가 명확해지고, 대체 가능성이 높아진다.
    => 인터페이스를 적당한 크기로 분리
    
  #### DIP 의존관계 역전 원칙
    - 프로그래머는 '추상화에 의존해야지, 구체화에 의존하면 안된다.' 의존성 주입은 이 원칙을 따르는 방법 중 하나다.
    - 구현 클래스에 의존하지 말고, 인터페이스에 의존하라는 뜻
    - **역할에 의존하게 해야한다는 것과 같다.
    - 객체 세상도 클라이언트가 인터페이스에 의존해야 유연하게 구현체를 변경할 수 있다.
    
  #### 정리
    - 객체 지향의 핵심은 다형성
    - 다형성 만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
    - 다형성 만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.
    - 다형성 만으로는 OCP, DIP를 지킬수 없다.
    
  == 2022.03.24 목 ==
    
### 객체 지향 설계와 스프링

  #### 스프링과 객체 지향
    - 스프링은 DI(Dependency Injection), DI 컨테이너 기술로 다형성 + OCP, DIP를 가능하게 지원
    - 클라이언트 코드의 변경 없이 기능 확장
    - 쉽게 푸붐 교체하듯이 개발
    
  #### 정리
    - 모든 설계에 역할과 구현을 분리하자
    - 이상적으로는 모든 설계에 인터페이스를 부여하자
    
  #### 고민
    - 인터페이스를 도입하면 추상화라는 비용이 발생 -> 코드를 한번 더 열어봐야함.
    - 기능을 확장할 가능성이 없다면, 구체클래스를 직접 사용. 
    - 향후 꼭 칠요할 때 리팩터링해서 인터페이스를 도입하는 것도 방법
    
  == 2022.03.25.금 ==



