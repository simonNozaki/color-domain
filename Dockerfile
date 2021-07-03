FROM amazoncorretto:11

COPY build/libs/color-1.0.0.jar app.jar
# spring 実行環境
ENV SPRING_PROFILES_ACTIVE=dev

ENTRYPOINT ["java","-jar","/app.jar"]