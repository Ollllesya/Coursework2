FROM gradle:jdk17-alpine
RUN mkdir /home/gradle/buildWorkspace
COPY . /home/gradle/buildWorkspace

WORKDIR /home/gradle/buildWorkspace
RUN gradle build --no-daemon

# Wait to be sure that library-db DATABASE was created
CMD sleep 90s; gradle startSpringBoot