FROM adoptopenjdk/openjdk11:alpine-jre

RUN apk add --update --no-cache tzdata
RUN rm -rf /var/cache/apk/*

ARG JARFILE=app.jar
ENV JARFILEENV=/$JARFILE
ADD target/$JARFILE /$JARFILE

ENTRYPOINT ["sh","-c","java $JAVA_OPTIONS -jar $JARFILEENV"]
