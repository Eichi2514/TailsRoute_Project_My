# TailsRoute(반려견 종합 플랫폼)
<br>

## 네이버 클라우드 APIKey 사용방법
### NAVER CLOUD FLATFORM API 발급 방법
1) https://www.ncloud.com/ 에 접속 후 로그인 한다
2) 상단에 서비스 탭을 클릭한다
3) 밑으로 스크롤해서 Application Services를 찾아서 Application Services > Maps를 클릭한다.

> #### .env 파일 설정방법
> 1. NAVER_API=""을 추가한다
> 2. NAVER_SECRET=""을 추가한다

![image](https://github.com/user-attachments/assets/523f6ca4-8d29-4615-8635-71a00b7a5947)
![image](https://github.com/user-attachments/assets/df7b3577-6bda-4804-947f-22b0e0e26cf2)

4) 이용 신청을 눌러 API신청을 한다(신청서비스는 Web Dynamic Map,Geocoding, Reverse Geocoding만 있으면 된다)


![image](https://github.com/user-attachments/assets/aadc2726-9fdf-4688-ab96-3f6999a256e4)

5) 만든 API의 콘솔화면으로 간다.


![image](https://github.com/user-attachments/assets/2ac80188-5953-44b8-823d-f484fc3d11d2)

6) 인증정보를 클릭해 API키를 확인한다.


![image](https://github.com/user-attachments/assets/d98b6e56-727f-4aef-8543-1d8e74a07602)


<br>

## 기상청_API_사용방법

### 기상청_단기예보 조회서비스 API발급 방법
1) https://www.data.go.kr/ 에 접속 후 로그인 한다
2) 기상청_단기예보 ((구)_동네예보) 조회서비스 검색
3) 활용신청 버튼을 눌러 신청
4) 마이페이지에 들어가보면 API인증키를 확인 할 수 있다(여기서는 Decodingehls 인증키를 사용해야한다)

> #### .env 파일 설정방법
> 1. Meteorological_Administration_API_KEY=""을 추가한다

  ![image](https://github.com/user-attachments/assets/3645b5e8-b2c4-4072-b19e-ddc247b6fe0a)
  ![image](https://github.com/user-attachments/assets/6f15f9c5-64dc-430d-b213-381a6eae5325)
  ![image](https://github.com/user-attachments/assets/e0049f45-7280-42b1-8be8-1ccceefc113c)

<br>

## TMAP_API_사용방법
### TMAP API발급 방법
1) https://openapi.sk.com/ 에 접속 후 로그인 한다
2) 상단의 PRODUCTS에 교통/위치 > TMAP클릭

> #### .env 파일 설정방법
> 1. TMAP_KEY=""을 추가한다
     
![image](https://github.com/user-attachments/assets/0ef8d0cb-bde4-43f1-bb9b-bd3b8f963057)
![image](https://github.com/user-attachments/assets/95d7ee94-a49a-4095-b568-850bfdb12543)

3) API 사용 요금에 무료체험 사용하기로 API신청
4) 대시보드 > 앱에 들어가면 보이는 앱키(appKey) 클릭

![image](https://github.com/user-attachments/assets/f3eecca5-4282-4375-bef6-8e6163efbc96)


<br>

## Coolsms 문자서비스 APIKey 발급 방법
![image](https://github.com/user-attachments/assets/249ecdcc-6b7a-4bef-9b2b-e13f2f2cc167)


1. CoolSMS 회원가입 및 로그인
   CoolSMS(https://www.coolsms.co.kr) 사이트에 접속합니다.
   계정이 없다면 회원가입을 진행하고, 기존 계정이 있다면 로그인합니다.

2. API 관리 페이지로 이동
   콘솔 화면에서 좌측 메뉴에서 [API 설정] 또는 [내 앱] 메뉴를 선택합니다.

3. 새 앱 등록
   API Key를 발급받기 위해 [앱 등록] 버튼을 클릭합니다.
   앱 이름과 설명을 입력한 뒤 등록합니다.

4. API Key 발급 확인
   등록한 앱의 상세정보를 확인하면 API Key와 Secret Key가 표시됩니다.
   이 정보를 복사하여 API를 사용하는 프로젝트에 설정하면 됩니다.

5. 발급된 Key 관리
   발급된 API Key는 콘솔에서 관리할 수 있으며, 필요 시 재발급도 가능합니다.

6. 프로젝트의 .env 파일 안에

   > - apiKey="Collsms에서 확인한 API KEY"
   > - apiSecret="Collsms에서 확인한 API SECRET" 와 같이 추가해주시면 됩니다.


<br>

## 구글 이메일 APIKey 발급 방법

![image](https://github.com/user-attachments/assets/22e54868-5576-4eb1-bb0b-1c8292d53a00)


1. Google 계정에 로그인

2. 2단계 인증 활성화
   Gmail 앱 비밀번호를 사용하려면 2단계 인증이 활성화되어야 합니다.
    - 보안 탭으로 이동합니다.
    - 2단계 인증 섹션으로 이동하여 활성화합니다.

3. 앱 비밀번호 생성
   2단계 인증을 설정한 후, 앱 비밀번호를 생성합니다.
    - 보안 탭에서 앱 비밀번호를 선택합니다.
    - Google 계정 비밀번호를 다시 입력해 인증합니다.
    - 앱 선택 드롭다운에서 사용하려는 애플리케이션을 선택합니다
    - 생성 버튼을 클릭하면 16자리 앱 비밀번호가 표시됩니다

4. 프로젝트의 application.properties 파일 안에

spring.mail.username=picon1317@gmail.com를 자신의 이메일로 바꿔줍니다.

5. 프로젝트의 .env 파일 안에
   > MAIL_KEY="구글 보안에서 확인한 앱 비밀번호"
   와 같이 추가해주시면 됩니다.

<br>

## Google Map API 키 발급
![image](https://github.com/user-attachments/assets/5892ff8a-d1c0-4c70-bbdc-90809b5a4af1)



동물병원의 위치를 지도에 표시하기 위해 Google 지도 API를 사용하였기 때문에, 서비스를 제대로 제공하기 위해서는 Google 지도 API 키가 필요하다.
Google Map API 키를 발급받기 위해서는 Google Cloud Platform 계정이 필요하며, 그 후 새 프로젝트 생성을 하고  다음 절차를 따라야 한다.

1. API 및 서비스에서 사용자 인증 정보로 이동한 다음,
   사용자 인증 정보를 만들기를 클릭하여 API 키를 생성한다.

2. API 및 서비스의 라이브러리에 ‘Maps’를 검색한 다음, Maps
   JavaScript API를 Enable 표시해야 한다. Geocoding API도 마찬가지로
   Enable 표시를 해준다.

Google Map API Key의 경우, 루트 디렉토리에 있는 .env 파일에 다음과
같이 작성해야 한다. YOUR_API_KEY는 발급받은 값으로 대체한다.

> GOOGLE_MAP_API_KEY="YOUR_API_KEY"

<br>  

## Google Map ID 키 발급
![image](https://github.com/user-attachments/assets/ff798685-def1-41e3-b781-85563374c2e8)


또, Map을 표시하기 위해 MAP_ID가 필요한데, MAP ID는 Google Maps Platform에서 발급받을 수 있다.

‘지도 ID 만들기’를 눌러 자바스크립트 지도 유형을 선택하여 생성하면 된다.

Google Map ID의 경우, 루트 디렉토리에
있는 .env 파일에 다음과 같이 작성해야
한다.
YOUR_MAP_ID는 발급받은 값으로 대체한
다.

> GOOGLE_MAP_ID=“YOUR_MAP_ID"
<br>

## 네이버 소셜 로그인 및 네이버 쇼핑 APIKey 발급 방법

![image](https://github.com/user-attachments/assets/9da82014-2c3c-4565-8e9d-b4274811b058)

1. 네이버 개발자 센터 접속 및 로그인
   네이버 개발자 센터에 접속하여 네이버 계정으로 로그인합니다.

2. 애플리케이션 등록
   상단 메뉴에서 [애플리케이션] → [애플리케이션 등록]을 클릭합니다.
   애플리케이션 이름을 입력하고, 사용 API 항목에서 아래 두 가지를 모두 선택합니다.
    - 네이버 로그인
    - 검색

3. 필수 설정
   서비스 URL : 애플리케이션이 동작하는 웹사이트 URL을 입력합니다.
   Redirect URI : 소셜 로그인 인증 완료 후 리디렉션될 URL을 입력합니다.
    - http://사이트주소/auth/naver/callback

4. API Key 확인
   애플리케이션 등록이 완료되면, 애플리케이션 상세 정보 페이지에서 다음 두 값을 확인할 수 있습니다.
    - Client ID : API 호출 시 사용되는 공개 키.
    - Client Secret : API 호출 시 보안을 위한 비밀 키.

5. 프로젝트의 .env 파일 안에
   > ClientID="네이버 개발자 센터에서 확인한 Client ID"
   > ClientSecret="네이버 개발자 센터에서 확인한 Client Secret"
   와 같이 추가해주시면 됩니다.

<br>

## 카카오 소셜 로그인 APIKey 발급 방법
1. 애플리케이션 추가하기에서 앱 등록 (https://developers.kakao.com/console/app)


![image](https://github.com/user-attachments/assets/a24eb3f0-1708-4329-9eb0-4da19884ae50)

2. 애플리케이션이 생성되면 인증키 발급


![image](https://github.com/user-attachments/assets/b769aac1-42ab-4611-965a-fac4760877ed)

3. 플랫폼 등록에서 Web 등록


![image](https://github.com/user-attachments/assets/feb8e05a-84c5-47ad-84e2-d194a02bb523)

4. 카카오 로그인을 사용할 url 입력


![image](https://github.com/user-attachments/assets/bfa3ddc2-1faf-4ab5-a903-98d26795cba3)

Redirect UR로 카카오 로그인에서 사용할 URI 를 설정

프로젝트의 .env 파일 안에 발급받은 key를 추가해주세요
> kakao_login_Id = your_kakao_api_key


---

## Animal_classification (동물 분류 모델 실행방법 (이미지))

1. 경로 설정  
   터미널에서 프로젝트 디렉터리로 이동합니다.

   ```bash
   cd C:<your_directory>/dog_behavior_analysis
   ```
2. 가상 환경 생성 및 활성화
   Python 가상환경을 생성한 후 활성화한다.

   ```bash
   python -m venv dog_behavior_env
   Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser  # Windows에서 필요할 경우
   .\dog_behavior_env\Scripts\Activate  # 가상 환경 활성화
   ```

3. 필수 패키지 설치  
   가상 환경 안에서 필요한 라이브러리들을 설치합니다.

   ### 프로젝트 루트 디렉터리에서 모델 디렉터리로 이동
   ```bash
   cd dog_behavior_analysis/scripts/animal_classification/
   ```

#### 해당 모델에 필요한 패키지 설치
   ```bash
   pip install -r requirements.txt
   ```

원래 경로로 돌아가기
   ```bash
   cd C:<your_directory>/dog_behavior_analysis
   ```

4. 모델 훈련을 위한 이미지 다운로드 및 스크립트 실행
   preprocess.py 스크립트를 실행하여 이미지 데이터셋(zip 파일)을 다운로드합니다.
   안될 경우 아래 경로에서 직접 다운로드하여,
   C:<your_directory>/dog_behavior_analysis/data/train 파일 위치에
   사진 폴더를 dogs, cats라는 이름으로 저장합니다.

Kaggle 데이터셋 링크:
https://www.kaggle.com/datasets/alessiocorrado99/animals10


5. 모델 훈련
   데이터 전처리가 완료되면 train_model.py 스크립트를 실행하여 모델을 훈련시킵니다.
   ```bash
   python /animal_classification/train_model.py
   ```

#### 주의사항
가상 환경 활성화: 매번 프로젝트를 시작하기 전에 가상 환경을 활성화해야 합니다.
  ```bash
  .\dog_behavior_env\Scripts\Activate 
  ```

---

## behavior_analysis 모델(영상)

1. Python 설치  
   Python 3.7 이상 버전을 권장합니다.  
   공식 웹사이트에서 Python을 다운로드하고 설치하세요.

### 데이터 다운로드 방법
1. Google Drive 링크에 포함된 파일은 프로젝트에서 필요한 데이터 파일입니다.
2. 해당 파일을 다운로드하려면 프로젝트 관리자에게 연락하여 접근 권한을 요청하세요.
3. 데이터를 다운로드한 후, 지정된 경로에 저장하세요.

   ```bash
   <프로젝트 폴더>/data/train
   ```

![image](https://github.com/user-attachments/assets/b1b9b7bb-08e0-4914-96a5-fd75e587505c)

4. 스크립트를 실행하여 data/csv_file/<behavior>.csv 에 생성된 CSV 파일을 확인하세요.

   ```bash
   Python scripts/utilities/data_preprocessing.py
   ```


### 필요한 Python 패키지 설치

  ```bash
  pip install torch numpy opencv-python matplotlib hydra-core omegaconf gdown
  ```

#### 스크립트 사용 방법
이 프로젝트는 SAMURAI 모델을 사용합니다. 아래 단계에 따라 SAMURAI 모델을 클론하고 설정하세요.
먼저 SAMURAI 모델의 GitHub 리포지토리를 클론합니다.
  ```bash
  git clone https://github.com/{username}/samurai.git
  ```
SAMURAI 모델에서 요구하는 의존성을 설치하세요. 클론한 폴더로 이동한 뒤 아래 명령어를 실행합니다.

  ```bash
  cd samurai
  pip install -r requirements.txt
  ```

#### 1단계
스크립트를 실행하기 전에 Hydra 설정 경로 및 YAML 파일이 올바르게 구성되었는지 확인하세요.
  ```bash
  config_path = "sam2/sam2/configs"
  config_name = "sam2_hiera_t.yaml"
  ```

#### 2단계
스크립트는 SAM2 모델을 빌드하고, 입력 이미지를 처리할 준비를 합니다.  
모델 파일 경로가 `sam_model_path`에 설정되어 있어야 합니다.

  ```python
  model_path = "path/to/your/sam_model.pth"
  ```

  ```bash
  Python scripts/utilities/data_preprocessing.py
  ```

### 데이터 통합

  ```bash
  pip install pandas numpy scikit-learn imbalanced-learn
  ```

스크립트는 다음 디렉터리 구조를 가정합니다:

- data/csv_file - 행동별 CSV 파일이 저장된 디렉터리.
- data/split_data - 분리된 데이터 (훈련, 검증, 테스트)가 저장될 디렉터리.

이 디렉터리는 존재하지 않을 경우 스크립트가 자동으로 생성합니다.

1. 키포인트 데이터셋 생성 및 전처리
2. GCN 기반 행동 분류 모델(ST-GCN) 학습 및 평가
3. 데이터 불균형 문제 해결을 위한 RandomOverSampler 적용


### 출력 확인

  ```bash
  pip install pandas numpy torch torch-geometric scikit-learn imbalanced-learn
  ```

#### 1단계: 데이터셋 준비
키포인트 데이터를 CSV 파일로 저장한 후, data/csv_file/combined.csv 경로에 통합된 CSV 파일을 확인하세요.
만약 파일이 없을 경우 아래 코드를 실행해주세요.

  ```bash
  python scripts/utilities/combined_data_preprocessing_part.py
  ```

#### 2단계: ST-GCN 모델 학습

  ```bash
  python scripts/train_stgcn.py
  ```


### 출력 파일

1. 훈련 데이터: `data/split_data/annotations_train.csv`
2. 검증 데이터: `data/split_data/annotations_validation.csv`
3. 테스트 데이터: `data/split_data/annotations_test.csv`
4. 모델 저장 파일: `models/stgcn_model.pth`



#### 문제 해결
- **CSV 파일 누락**: `data/csv_file` 디렉터리에 올바른 CSV 파일이 존재하는지 확인하세요.
- **패키지 오류**: 필요한 패키지가 설치되었는지 확인하세요.
- **GPU 오류**: GPU 사용이 불가능한 경우, 코드를 CPU 모드로 실행하세요.

---

### Flask 서버 실행
Flask 서버를 실행하여 비디오 분석 API를 활성화합니다. 아래 명령어를 사용하세요:

```bash
python app.py
```
