# 빌드 단계
FROM eclipse-temurin:21-alpine AS builder
WORKDIR /app

# Gradle 이용 빌드 단계
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# 실행 단계
FROM eclipse-temurin:21-alpine AS runner
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar CampingOn.jar

# 환경 변수 선언
ENV JAVA_OPTS=""

# 포트 설정
EXPOSE 8080

CMD ["sh", "-c", "java $JAVA_OPTS -jar CampingOn.jar"]
