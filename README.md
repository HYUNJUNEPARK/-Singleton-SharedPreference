SharedPreferences vs DataStore vs Room

---

**SharedPreferences**</br>
- 소규모 데이터 세트에 적합</br>
- 간단한 값을 저장할 때 주로 사용(초기 설정 값, 자동 로그인 여부 등)</br>
- SharedPreferences 는 어플리케이션에 파일 형태로 데이터를 저장함.</br>
- 데이터는 (key, value) 형태로 data/data/패키지명/shared_prefs 폴더 안에 xml 파일로 저장됨.</br>
- 해당 파일은 어플리케이션이 삭제되기 전까지 보존됨.</br>
<br></br>

**EncryptedSharedPreferences**</br>
- AndroidKeyStore 에 마스터 키를 저장하고 마스터 키로 데이터를 암호화한 SharedPreference</br>
<br></br>

**DataStore**</br>
- 소규모 데이터 세트에 적합</br>
- 코루틴 및 flow 를 써서 비동기적이고 일되게 Key-Value 형태로 데이터를 저장</br>
- Preference DataStore : 키를 써서 데이터를 저장하고 데이터에 접근한다. TypeSafety 를 제공하지 않으며 사전 정의된 스키마를 필요하지 않는다.</br>
- Proto DataStore : 맞춤 데이터 유형의 인스턴스로 데이터를 저장한다. 유형 안정성을 제공하며 프로토콜 버퍼(구글에서 개발하고 오픈소스로 공개한 직렬화 자료구조)를 써서 스키마를 정의한다.</br>
<br></br>

**Room**</br>
- 복잡한 대규모 데이터 세트, 부분 업데이터, 참조 무결성을 지원해야하는 경우 사용한다.</br>
<br></br>

SharedPreferences vs DataStore vs Room</br>
https://onlyfor-me-blog.tistory.com/519</br>

[Android/Kotlin] SharedPreferences 대신 쓰는 DataStore</br>
https://kangmin1012.tistory.com/47</br>

Android in A..Z - DataStore</br>
https://rkdxowhd98.tistory.com/148</br>