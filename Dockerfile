FROM openjdk:11-jdk

ENV TZ=America/Sao_Paulo
ENV APP_ROOT=/usr/local/templatesbackend
ENV HOME=${APP_ROOT}
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS
ENV JHIPSTER_SLEEP=0

WORKDIR ${APP_ROOT}

RUN set -eux && \
      ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && \
      apt update && \
      apt install -y tzdata && \
      apt clean && rm -rf /var/lib/apt/lists/* && \
      chgrp -R 0 ${APP_ROOT} && \
      chmod -R g=u ${APP_ROOT} /etc/passwd

COPY /target/*.jar templatesbackend.jar

COPY entrypoint.sh entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]

USER 1001
