# 회원가입 프로젝트 4팀

* 간단한 회원가입, 로그인 및 개인정보 조회 페이지를 구현합니다.

## 팀원

* BackEnd(Spring Boot): [엘리](https://github.com/bohyeon-n), [Sigrid](https://github.com/jypthemiracle)
* FrontEnd(Vanilla JS, ES Modules): [baekCo](https://github.com/baekCode)
* iOS(Swift): [Lin](https://github.com/Limwin94)

## 배포 링크

* 웹 링크: https://codesquad-signup4-featureapis.herokuapp.com/
* iOS 동작 목업링크(gif): https://github.com/codesquad-memeber-2020/signup-4/blob/master/iOSDemoGif.md

## API 링크

* [회원가입 공식 API 문서]([https://github.com/codesquad-memeber-2020/signup-4/wiki/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-4%ED%8C%80-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-API-%EC%95%88%EB%82%B4](https://github.com/codesquad-memeber-2020/signup-4/wiki/회원가입-4팀-프로젝트-API-안내))
* [Swagger API 문서 자동화 툴 링크](https://codesquad-signup4-featureapis.herokuapp.com/swagger-ui.html)
* [회원가입 테스트 데이터 API 문서]([https://github.com/codesquad-memeber-2020/signup-4/wiki/%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-4%ED%8C%80-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%ED%85%8C%EC%8A%A4%ED%8A%B8-API-%EC%95%88%EB%82%B4](https://github.com/codesquad-memeber-2020/signup-4/wiki/회원가입-4팀-프로젝트-테스트-API-안내))

### 테스트 아이디

* userID: testuserid
* password: abc!@12A

## 요구사항 명세

### 백앤드 요구사항

* 회원가입 API 제공

* 로그인 API 제공

* 중복 ID 조회 WEB API 제공 (개방 API)

* 중복 이메일 조회 WEB API 제공 (개방 API)

* 중복 핸드폰 조회 WEB API 제공 (개방 API)

* 로그인한 사용자의 개인 정보 조회 API 제공 (로그인 하지 않은 사용자는 unauthorized 응답)

### 프론트엔드 요구사항

* 회원가입 페이지 및 회원가입

* 로그인 페이지 및 로그인하기

#### 미구현 사항

* 회원가입 완료 시 요청확인 후 메인 페이지 이동

* 로그인 페이지 기능

### iOS 요구사항

* 아이디/비밀번호/비밀번호 재확인/이름 입력
* 생년월일/성별/이메일/휴대전화 입력
* 개인정보 수집 및 이용에 대한 안내 동의
* 관심사 입력
* 로그인 화면

* [분야별 기능 요구사항 구글 스프레드시트로 정리](https://docs.google.com/spreadsheets/d/1qwBBlz3GQn7Jg7XdcJ8SSwMA5VP41BLOL9glzNsVn8Y/edit#gid=0)

## 기타 링크

* [4팀 공식 위키](https://github.com/codesquad-memeber-2020/signup-4/wiki)
* [데일리 스크럼 및 회고 모음](https://github.com/codesquad-memeber-2020/signup-4/wiki/%EB%8D%B0%EC%9D%BC%EB%A6%AC-%EC%8A%A4%ED%81%AC%EB%9F%BC-%EB%B0%8F-%ED%9A%8C%EA%B3%A0-%EB%AA%A8%EC%9D%8C)

## 4팀 그라운드 룰

## 스크럼 시간
* 코어 타임(필수 작업 시간)
    * 11:00 - 18:00
    * 점심시간: 12:00 - 13:00
* 시작 시간
    * 10시 30분까지 슬랙에 남기기
* 중간 스크럼 
    * 슬랙(단톡)으로 궁금하거나 이야기하고 싶은것 자유롭게 남기기
    * 온라인이니까 2시간에 한 번씩 슬랙에 올리는 것을 권고
* 회고 시간
    * 6시에 슬랙으로 회고

## 작업 관련
### 커밋 메시지
- 한글로 통일
    - [#??] feat: 새로운 기능을 추가하였다.
    - [#??] fix: 무슨무슨 버그를 고쳤다.
    - [#??] style: 스타일링을 바꿨다. CSS 추가
    - [#??] refactor: 어떤 함수를 리팩토링했다.
    - [#??] test: 무엇인가를 테스트했다.
    - [#??] docs: 문서를 업데이트 했다.
    - [#??] chore: 패키지 및 빌드 관련 프로젝트 설정을 했다.
- Camel case 디폴트 적용
### 이슈 관리
* Github issue 사용
    * 라벨은 FE/BE/iOS + todo/doing/done 정도면 좋을 것 같아요
    * 깃헙 이슈에 pull request 매핑시키면 좋을 것 같음. (기능 있음)
### 브랜치 관리
* 기본 브랜치 전략: 분야 별 dev-기능명으로 브랜치를 생성하고, 개발이 완성되면 develop에 머지한다. 배포본은 deploy에서 관리하고 배포하며, 최종 완성본은 master로 머지한다.
* master: 최종 완성 버전
* deploy: 배포된 현재 버전
    * develop: 개발이 진행되고 있는 기준 브랜치
        * dev_iOS-기능명: iOS 개발을 위한 브랜치로, 개발하는 기능에 따라 브랜치를 생성함
        * dev_FE-기능명: FrontEnd 개발을 위한 브랜치로, 개발하는 기능에 따라 브랜치를 생성함
        * dev_BE-기능명: BackEnd 개발을 위한 브랜치로, 개발하는 기능에 따라 브랜치를 생성함
