FROM scratch
ADD x86_64/27f89e6743f61198ebc37962d8de477981cf9953fe6294e0df4b2dbf9e4b6c60.tar.xz /
ADD x86_64/9d9865cc12d2727268414dda9755945255e23fc5281eb37a260ac5b8e43c4377.tar.xz /
ADD x86_64/b3b6ca909f06db61be872b62208dee87dadb734bb09f245e45b7577b14a87418.tar.xz /
ADD x86_64/dea50174be8837d28a609a7e804ac8080283f63da0a8109a4d39d8eb43aedfeb.tar.xz /
ADD x86_64/df7c0f6cee35a7a49f4390a3e65664398ae88799ecc33f5ad333069589cd3be9.tar.xz /
ADD x86_64/e35b3db257558e9330d91cc6aebe7e151ceb42a069fa3ea2f40664f08ff8f476.tar.xz /

ENV LANG=en_US.UTF-8
ENV TZ=:/etc/localtime
ENV PATH=/var/lang/bin:/usr/local/bin:/usr/bin/:/bin:/opt/bin
ENV LD_LIBRARY_PATH=/var/lang/lib:/lib64:/usr/lib64:/var/runtime:/var/runtime/lib:/var/task:/var/task/lib:/opt/lib
ENV LAMBDA_TASK_ROOT=/var/task
ENV LAMBDA_RUNTIME_DIR=/var/runtime

WORKDIR /var/task

ENTRYPOINT ["/lambda-entrypoint.sh"]
