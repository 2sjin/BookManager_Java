# 도서관리 프로그램 설계 및 구현<br>(Library management program design and implementation as Java)
- 기여자: 이승진(팀장), 조준호(부팀장), 이동호(팀원)

## 프로젝트 산출물
[☞ 프로젝트 결과보고서](https://drive.google.com/file/d/1myFJRFFxBxRmNFXB-YwLW25_cvfDfAZT/view?usp=sharing)

## 서론
- 본 프로젝트는 컴퓨터 소프트웨어 개발 언어 중 JAVA를 이용하여 도서관리를 할 수 있는 기능을 제공하는 컴퓨터 소프트웨어를 구현하는 것이 목표임
- ‘도서관리’기술은 도서관의 정보를 전산화하면서 나온 산물이며, 다른 업무 프로세스와 비교하면 많이 공유되어 있음
- 새로운 아이디어보다 해당 수업시간에 배운 것을 위주로 해당 주제의 컴퓨터 소프트웨어를 구현하는 시간을 가져 프로젝트가 수행할 때 팀원 전원이 지금까지 스스로 학습한 내용을 복습하는 시간을 가짐
- 관계형 데이터베이스(MySQL)를 이용해 데이터 저장소를 구현하고, JAVA에서 제공하는 SQL 라이브러리를 이용해 해당 주제의 컴퓨터 소프트웨어 구현
- 버전 관리 시스템(Git)을 도입해 온라인에서 협업해 프로젝트를 수행하는 기회를 마련하고 해당 시스템에서 제공하는 기능을 사용하는 방법을 익힘

## 요구사항 정의
- 도서관리
    - 도서를 등록, 수정, 삭제 할 수 있어야 한다.
    - 도서 정보는 제목, 저자, 출판사, 가격, 관련링크, 사진, ISBN, 도서설명을 포함해야 한다. 
    - 도서 중복 등록 시 “이미 등록된 도서입니다.” 메시지가 표시되어야 한다. (ISBN으로 중복 체크)
    - 사진은 PC에 저장된 사진을 선택 등록할 수 있어야 한다. 
    - 도서별 대여 여부를 확인할 수 있어야 한다. 
    - 대여중인 도서는 삭제할 수 없어야 한다. (반납 후 삭제 가능)
    - “제목, 저자"를 대상으로 검색어가 포함된 도서를 검색할 수 있어야 한다. 

- 회원관리
    - 회원을 등록, 수정, 탈퇴 할 수 있어야 한다.
    - 회원 정보는 이름, 생년월일, 성별, 전화번호, 휴대전화번호, 이메일 주소, 사진을 포함해야 한다. 
    - 이름과 생년월일 그리고 휴대전화번호가 중복되는 회원을 등록할 수 없어야 한다. 
    - 도서를 대여 중인 회원은 탈퇴할 수 없어야 한다. (반납 후 탈퇴 가능)
    - 탈퇴 회원을 확인할 수 있어야 한다. 
    - “이름, 전화번호"를 대상으로 검색어가 포함된 회원을 검색할 수 있어야 한다. 

- 대출관리
    - 등록된 도서를 회원이 대출할 수 있어야 한다.
    - 대출 정보는 도서 정보, 회원정보, 대여일, 반납예정일, 반납 여부가 포함돼야 한다. 
    - 대출할 때 도서 정보, 회원 정보는 기존 정보에서 선택할 수 있어야 한다. 
    - 도서, 회원 선택 시 검색 기능을 제공해야 한다. (검색어가 포함된 항목을 검색할 수 있어야 한다.)
    - 이미 대여 중인 도서는 대출할 수 없어야 한다. 
    - 도서 반납예정일은 도서 대여 후 2주로 한다. 
    - 도서 반납은 대출된 도서를 대상으로 진행한다.

## 소프트웨어 구현

### 메인 화면

<details markdown="1">
<summary>메인 화면</summary>

![image](https://user-images.githubusercontent.com/91407433/151683909-ceff81cf-b9cd-4dfa-9c98-eeb22ffdb32c.png)<br>
![image](https://user-images.githubusercontent.com/91407433/151684070-bf309274-0502-400d-89f9-99fd48697a53.png)
![image](https://user-images.githubusercontent.com/91407433/151684074-65f7f07c-281a-49d1-8708-337f913552e9.png)
![image](https://user-images.githubusercontent.com/91407433/151684075-18d767b3-f44e-4974-b78e-3c5cd6947b5f.png)

> - 메뉴의 세부 항목 클릭 시 그에 해당하는 윈도우 창이 실행
> - 다른 윈도우 창을 종료해도 메인 화면은 종료되지 않음

</details>

### 회원관리

<details markdown="1">
<summary>회원 조회</summary>

![image](https://user-images.githubusercontent.com/91407433/151683916-6ae527e3-42f5-405e-8e34-2591b64ed1d9.png)
1. ‘회원 검색’란에 이름 또는 전화번호 입력 → [검색] 버튼 또는 [Enter] 키 입력
   - 이름 또는 전화번호의 일부분으로 검색 가능
   - 아무것도 입력하지 않으면 전체 목록 확인 가능
2. 검색 결과 리스트에서 원하는 회원 클릭 시 세부 정보 및 대여 도서 확인 가능

</details>

<details markdown="1">
<summary>회원 등록</summary>

![image](https://user-images.githubusercontent.com/91407433/151683925-8cfd6114-7575-440f-a4e4-03f6f39cd707.png)
1. 등록할 회원의 이름, 생년월일, 성별, 전화번호, 이메일 입력
2. [이미지 변경] 버튼을 눌러 원하는 이미지 파일 선택
3. [등록] 버튼 클릭 → 아래 알림창에서 [Yes] 버튼을 클릭하면 회원 등록 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151683929-8548aef7-e60b-41af-976e-79de51c81c6e.png)
4. 등록한 정보들은 DB의 USER 테이블에 등록됨(회원 조회에서 확인 가능)

> 전화번호는 회원 식별자입니다. 입력한 전화번호가 다른 회원과 중복되면 등록할 수 없습니다.(탈퇴 후 ‘미등록’ 상태인 회원의 전화번호도 포함)<br>
> 한 번 등록한 회원은 탈퇴하여도 정보가 삭제되지 않으니 등록 시 주의 바랍니다. 

</details>

<details markdown="1">
<summary>회원 정보 수정</summary>

![image](https://user-images.githubusercontent.com/91407433/151683949-8a4869c2-4107-4df9-8a16-afefda4f178a.png)
1. 회원 검색 후 리스트에서 수정을 원하는 회원 클릭
2. 이름, 생년월일, 성별, 전화번호, 이메일 중 원하는 정보를 수정
이미지 변경은 [이미지 변경] 버튼 눌러 원하는 이미지 파일 선택
3. [수정] 버튼 클릭 → 아래 알림창에서 [Yes] 버튼을 클릭하면 회원 정보 수정 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151683951-39ac9d19-05d9-46b0-9d7c-1b212ca977ea.png)

> 전화번호는 회원 식별자입니다. 수정 후 전화번호가 다른 회원과 중복되면 수정할 수 없습니다.

</details>

<details markdown="1">
<summary>회원 탈퇴</summary>

![image](https://user-images.githubusercontent.com/91407433/151683954-6fc45749-49bd-4470-b1c5-4514f095e3fa.png)
1. 회원 검색 후 리스트에서 탈퇴를 원하는 회원 클릭
2. [탈퇴/재등록] 버튼 클릭
   - 등록여부가 ‘등록’인 경우, [Yes] 버튼 클릭 시 ‘미등록’으로 변경(도서 대여 불가)<br>
![image](https://user-images.githubusercontent.com/91407433/151683962-4a8a4cee-6406-4f3c-8865-1a98ad348a39.png)
   - 등록여부가 ‘미등록’인 경우, [Yes] 버튼 클릭 시 ‘등록’으로 변경(도서 대여 가능)<br>
![image](https://user-images.githubusercontent.com/91407433/151683965-5960f754-e1f2-40ad-9b90-a63c7f11feac.png)

> 대여 중인 도서가 있으면 탈퇴할 수 없으니, 먼저 모든 도서를 반납하시기 바랍니다.<br>
> 회원 탈퇴를 하여도 ‘미등록’ 상태로 변경될 뿐, 기존 회원 정보는 삭제되지 않습니다.

</details>

### 도서관리

<details markdown="1">
<summary>도서 조회</summary>

![image](https://user-images.githubusercontent.com/91407433/151684008-2f3357df-52ae-4501-a850-06cbc0a82451.png)
1. ‘도서 검색’란에 제목, 저자 또는 ISBN 입력 → [검색] 버튼 또는 [Enter] 키 입력
   - 제목과 저자는 일부 키워드만으로 검색 가능
   - 아무것도 입력하지 않으면 전체 목록 확인 가능
2. 검색 결과 리스트에서 원하는 도서 클릭 시 세부 정보 확인 가능

</details>

<details markdown="1">
<summary>도서 추가</summary>

![image](https://user-images.githubusercontent.com/91407433/151684013-19a2150f-44f5-47bd-a74f-c70d841e20ad.png)
1. 위 화면의 예시와 같이 ISBN, 제목, 저자, 출판사, 가격, 관련링크, 도서설명 입력
2. [이미지 추가] 버튼을 눌러 원하는 이미지 파일 선택 
3. [추가] 버튼 클릭 → 아래 알림창에서 [Yes] 버튼을 클릭하면 도서 추가 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151684016-e449d26d-7cbc-4319-8cc6-0be541edbb95.png)
4. 등록한 정보들은 DB의 BOOK 테이블에 등록됨(도서 조회에서 확인 가능)

> ISBN은 도서 식별자입니다. 입력한 ISBN이 다른 도서와 중복되면 수정할 수 없습니다. 

</details>

<details markdown="1">
<summary>도서 수정</summary>

![image](https://user-images.githubusercontent.com/91407433/151684019-cb51ab36-854f-40c4-a30f-ab0916a605c7.png)
1. 도서 검색 후 리스트에서 수정을 원하는 도서 클릭
2. ISBN, 제목, 저자, 출판사, 가격, 관련링크, 도서설명 중 원하는 부분을 수정
   이미지 변경은 [이미지 변경] 버튼 눌러 원하는 이미지 파일 선택
3. [수정] 버튼 클릭 → 아래 알림창에서 [Yes] 버튼을 클릭하면 도서 정보 수정 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151684023-113d5b59-facc-44ae-a3db-f5ba4894e639.png)

> ISBN은 도서 식별자입니다. 수정 후 ISBN이 다른 도서와 중복되면 수정할 수 없습니다. 

</details>

<details markdown="1">
<summary>도서 삭제</summary>

![image](https://user-images.githubusercontent.com/91407433/151684040-95207f6c-b859-4746-a414-533baf5eb422.png)
1. 도서 검색 후 리스트에서 삭제를 원하는 도서 클릭
2. [삭제] 버튼 클릭 → 아래 알림창에서 [Yes] 버튼을 클릭하면 도서 삭제 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151684044-2f95cd11-9342-4087-b0d5-a99712f674db.png)

> 대여 중인 도서는 삭제할 수 없으니, 먼저 해당 도서를 반납해 주시기 바랍니다.

> 삭제 완료한 도서의 정보는 복구할 수 없으니 주의하시기 바랍니다.

</details>

### 대출관리

<details markdown="1">
<summary>도서 대여</summary>

![image](https://user-images.githubusercontent.com/91407433/151684046-471345b1-cad4-48cf-bb57-a7366515a062.png)
1. ‘회원 검색’란에 이름 또는 전화번호 입력 → [검색] 버튼 또는 [Enter] 키 입력
2. 회원 검색 결과 리스트에서 원하는 항목 하나(대여자)를 클릭
3. ‘도서 검색’란에 제목, 저자 또는 ISBN 입력 → [검색] 버튼 또는 [Enter] 키 입력
4. 도서 검색 결과 리스트에서 원하는 항목 하나(대여할 도서)를 클릭
5. [대여] 버튼 클릭 → 도서 대여 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151684049-221709bc-b281-4353-9e6f-5e37fd1468dd.png)

> ‘미등록’ 상태의 회원은 도서를 대여할 수 없습니다.

</details>

<details markdown="1">
<summary>도서 반납</summary>

<br>![image](https://user-images.githubusercontent.com/91407433/151684054-7a16e27d-376e-454f-8b88-4d93f533b8a1.png)
1. ‘도서 검색’란에 제목, 저자 또는 ISBN 입력 → [검색] 버튼 또는 [Enter] 키 입력
2. 도서 검색 결과 리스트에서 원하는 항목 하나(반납할 도서)를 클릭
3. [반납] 버튼 클릭 → 도서 반납 완료<br>
![image](https://user-images.githubusercontent.com/91407433/151684057-5e9857dd-0a4c-40ce-92ea-e142c649bfc2.png)

</details>

## 개선사항 및 향후 연구 방향
- 디버깅이 필요한 오류 사항
    - 회원 등록 및 회원 정보 수정 후 성별이 잘못 출력되는 오류 디버깅
    - RENT 테이블의 BOOK_ISBN 필드를 외래키에서 제외하여, 참조 무결성에 의하여 도서가 삭제되지 않는 오류 디버깅
    - 이미지 데이터 로드 과정에서 NULL 포인터 예외를 올바르게 처리하여 이미지 변경 없이도 회원 정보를 수정할 수 있도록 오류 디버깅

- 사용자의 편의성 향상을 위해 개선이 필요한 부분
    - 성별을 텍스트로 입력하지 않고 선택할 수 있도록 라디오버튼 또는 콤보박스 구현
    - 회원 탈퇴 오류 메시지에 대여 중인 도서가 몇 권인지 출력
    - 도서 설명란의 텍스트가 길어도 볼 수 있도록 스크롤바 추가
    - 도서 반납 프레임에 회원 정보와 도서 정보를 함께 출력
    - 기타 프로그램 UI의 직관성 및 통일성 향상

- 프로그램에 추가하면 좋을 만한 기능
    - 회원별로 한 번에 대여할 수 있는 최대 도서 권수 제한
    - 도서를 연체한 회원에게 연체 기간만큼 도서 대여를 제한시키는 기능
    - 관리자 모드(관리자가 아닌 사용자는 조회, 대여, 반납만 가능)
