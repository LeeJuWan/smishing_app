smishing_app
=============

# 연구용 및 학생용 프로젝트로 개발한 스미싱
# 어플리케이션입니다.

기존의 연구용 탐지방법은 **Google에서 제공하는 SafeBrowsing api**를 사용하여 블랙리스트 기반으로
탐지의 효율성을 확인 하였습니다.
그러나 본 프로젝트 소스코드에서는 알려지지 않은(Zero day)악성코드를 염두하여
화이트리스트 기반으로 코드로 수정하였으며, 연구용 프로젝트이기에 따로 서버를 구축하지 않았습니다.

만약 **Google safeBrowsing api**가 궁금하시다면
<https://developers.google.com/safe-browsing/v4/get-started> Google
개발문서를 참고바랍니다.

아래는 **JAVA용 safebrowsing api** 입니다.
<https://developers.google.com/api-client-library/java/apis/safebrowsing/v4>


아래는 안드로이드 개발에 참고할 수 있는 **safebrowsing api** 입니다.
<https://developer.android.com/training/safetynet/safebrowsing>
안드로이드의 부족한 자료는 아래의 자료를 참고하시면 도움이 됩니다.
<http://androidideas.com/checking-urls-with-the-safe-browsing-api-in-android/>

### 본 프로젝트의 탐지 방법은 다음과 같습니다. 

#### 1. 수신되는 문자의 주소를 화이트리스트 기반으로 확인합니다.  등록되지 않아있다면 malware, 등록되어 있다면 safe
![20190725_170029](https://user-images.githubusercontent.com/49786050/61857437-21e41500-aeff-11e9-8e46-eeb71d887a5b.jpg)
##### 세부내용
![20190725_165851](https://user-images.githubusercontent.com/49786050/61857457-2d374080-aeff-11e9-99d6-6e05afec9cea.jpg)

#### 2. 수신되는 문자의 IP 여부를 검사합니다.  IP가 포함되어 있다면, malware, 그렇지 않다면 safe
![20190725_165917](https://user-images.githubusercontent.com/49786050/61857692-94ed8b80-aeff-11e9-8b64-653745709136.jpg)
##### 세부내용
![20190725_171141](https://user-images.githubusercontent.com/49786050/61857716-a2a31100-aeff-11e9-8056-40904aae6f3a.jpg)

#### 3. 수신되는 문자의 APK 포함 여부를 검사합니다.  APK가 포함되어 있다면, malware, 그렇지 않다면 safe
![20190725_170125](https://user-images.githubusercontent.com/49786050/61857391-0a0c9100-aeff-11e9-9c78-aea72f94dcc1.jpg)
##### 세부내용
![20190725_170049](https://user-images.githubusercontent.com/49786050/61857411-1395f900-aeff-11e9-8828-8f6902ef872a.jpg)
