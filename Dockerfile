FROM        maven:3.5-jdk-8-slim
ENV PORT=8080
COPY        . /var/www
WORKDIR     /var/www
VOLUME      [ "/var/www" ]
RUN         mvn clean install -Dmaven.test.skip=true
EXPOSE      $PORT
ENTRYPOINT  [ "mvn", "spring-boot:run", "-Drun.jvmArguments=-Dserver.port=8080" ]