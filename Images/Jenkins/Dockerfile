FROM jenkins/jenkins:latest
LABEL maintainer="ing.brayan.cm@gmail.com"

ENV JAVA_OPTS=-Djenkins.install.runSetupWizard=false

COPY conf/plugins.txt /usr/share/jenkins/ref/
COPY conf/init.groovy.d/security.groovy /usr/share/jenkins/ref/init.groovy.d/security.groovy

RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt