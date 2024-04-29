FROM tomcat:10.1.23-jre21
COPY ./docker/tomcat/conf/tomcat-users.xml /usr/local/tomcat/conf
COPY ./docker/tomcat/conf/context.xml /usr/local/tomcat/webapps.dist/manager/META-INF
ENTRYPOINT ["/bin/bash", "-c", "mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2; mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps; cp /tmp/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml; catalina.sh run"]