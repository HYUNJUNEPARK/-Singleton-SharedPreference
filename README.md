SharedPreferences / EncryptedSharedPreferences / Singleton</br>
---

바로가기</br>

**EncryptedSharedPreferencesManager**</br>
https://github.com/HYUNJUNEPARK/-Singleton-SharedPreference/blob/main/app/src/main/java/com/june/singleton_sharedpreference/EncryptedSharedPreferencesManager.kt</br>

**SharedPreferenceManager**</br>
https://github.com/HYUNJUNEPARK/-Singleton-SharedPreference/blob/main/app/src/main/java/com/june/singleton_sharedpreference/SharedPreferenceManager.kt</br>
<br></br>

---

**Singleton**</br>
- 한 번의 선언으로 모든 클래스에서 전역으로 사용이 가능한(아무데서나 접근 가능한) 필드나 메서드를 만드는 것</br>
- 앱의 시작부터 종료까지 한번 생성으로 고정된 메모리 영역을 가지므로 메모리를 효율적을 사용할 수 있다는 장점이 있음</br>
- 어떤 클래스의 인스턴스는 오직 하나임을 보장하며, 이 인스턴스를 전역에서 접근할 수 있는 디자인 패턴</br>
ㄴ 다른 클래스의 인스턴스들이 데이터를 공유 변경이 가능</br>
<br></br>

**Java-static**</br>
- 호출되는 시점에서 인스턴스가 생성됨</br>
- 싱글톤 패턴을 구현하기 위해서 많은 보일러 플레이트 코드가 발생</br>
*보일러 플레이트 코드 : 최소한의 변경으로 여러 곳에서 재사용되며, 반복적으로 비슷한 형태를 띄는 코드</br>
<br></br>

**Kotlin-object**</br>
- object 라는 키워드로 싱글톤 패턴을 쉽게 구현할 수 있음</br>
- object 는 프로세스가 메모리 상에 올라갈 때 곧 바로 생성됨 -> 사용하지 않을 떄도 메모리에 인스턴스가 존재해 비효율적</br>
ㄴ 해결책 : by lazy 를 통해 호출 될 때 메모리 상에 해당 인스턴스가 올라가도록 설계</br>
<br></br>

**object**</br>
- 클래스 "외부"에서 선언</br>
- object 로 선언된 클래스는 별도의 객체 생성없이 바로 호출 가능</br>
- object 를 초기화하기 위해서는 init { } 을 사용하며 처음에만 실행됨</br>
- object 클래스 내부에 선언된 속성과 함수는 클래스명.(함수/필드) 로 호출 가능</br>
<br></br>

**companion object**</br>
- 클래스 "내부"에서 선언</br>
- 객체를 생성할 수 있음</br>
- 상속관계에서 companion object 는 가려짐</br>
- 이름이 다른 여러 개의 객체를 생성할 수 있지만, 클래스의 메모리 주솟값은 모두 동일</br>
- companion object { } 에 선언된 속성과 함수는 클래스명/객체명.(함수/필드) 로 호출 가능</br>
- static 의 나열(자바개념)이 아닌 하나의 객체로 취급하여 좀 더 명확한 의미를 지니고 있어 싱글톤 패턴에 적합함</br>
<br></br>

**SharedPreferences**</br>
- 간단한 값을 저장할 때 주로 사용(초기 설정 값, 자동 로그인 여부 등)</br>
- SharedPreferences 는 어플리케이션에 파일 형태로 데이터를 저장함.</br>
- 데이터는 (key, value) 형태로 data/data/패키지명/shared_prefs 폴더 안에 xml 파일로 저장됨.</br>
- 해당 파일은 어플리케이션이 삭제되기 전까지 보존됨.</br>
<br></br>

**EncryptedSharedPreferences**</br>
- AndroidKeyStore 에 마스터 키를 저장하고 마스터 키로 데이터를 암호화한 SharedPreference</br>
<br></br>

**SharedPreferences + Singleton**</br>
- SharedPreferences 는 앱의 어디서든 전역적으로 사용하기 때문에 싱글톤 패턴을 사용해서 어디서든 접근 가능하게 만드는 것이 좋음</br>
<br></br>

---

kotlin 싱글톤 패턴</br>
https://junyoung-developer.tistory.com/192</br>

싱글톤 패턴 사용해보기</br>
https://gaybee.tistory.com/16</br>
