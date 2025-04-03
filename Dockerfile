FROM eclipse-temurin:21-jre-alpine AS builder

ARG APP=demo
COPY target/${APP}.jar ${APP}.jar
RUN java -Djarmode=tools -jar ${APP}.jar extract --layers --launcher


FROM eclipse-temurin:21-jre-alpine

ARG APP=demo
RUN addgroup -S uts && adduser -S uts -G uts && mkdir -p /app
WORKDIR /app

COPY --from=builder ${APP}/dependencies/ ./
COPY --from=builder ${APP}/spring-boot-loader/ ./
COPY --from=builder ${APP}/snapshot-dependencies/ ./
RUN true
COPY --from=builder ${APP}/application/ ./

RUN chown -R uts:uts /app
USER uts

EXPOSE 7081

ENV SPRING_PROFILES_ACTIVE=demo

CMD ["sh", "-c", "java $DEFAULT_MANAGED_OPTS $JAVA_OPTS org.springframework.boot.loader.launch.JarLauncher"]


# java -Djarmode=layertools -jar target/demo.jar list => deprecated
# java -Djarmode=tools -jar target/demo.jar list-layers

# mvn -s settings_infra.xml clean package -Dmaven.test.failure.ignore=true -Dspring.profiles.active=ci
# docker image build --platform linux/amd64 --build-arg APP=demo -t demo:linux-v1 .
# docker image build --build-arg APP=demo -t demo:mac-v1 .
