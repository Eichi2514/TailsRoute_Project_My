# 첫 번째 스테이지: 빌드 스테이지
FROM gradle:jdk21-graal-jammy AS builder

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 래퍼 파일 복사
COPY gradlew .
COPY gradle/wrapper/gradle-wrapper.jar gradle/wrapper/
COPY gradle/wrapper/gradle-wrapper.properties gradle/wrapper/

RUN chmod +x gradlew

# build.gradle과 settings.gradle 파일을 먼저 복사하여 종속성 캐시 활용
COPY build.gradle settings.gradle ./

# 종속성 설치
RUN ./gradlew dependencies --no-daemon

# 소스 코드 복사
COPY src src

# 애플리케이션 빌드
RUN ./gradlew build --no-daemon -x test

# 두 번째 스테이지: 실행 스테이지
FROM container-registry.oracle.com/graalvm/jdk:21

# 작업 디렉토리 설정
WORKDIR /app

# 첫 번째 스테이지에서 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 실행할 JAR 파일 지정
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]