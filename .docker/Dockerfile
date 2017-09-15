FROM circleci/openjdk:8-jdk

RUN wget https://github.com/openshift/origin/releases/download/v3.6.0/openshift-origin-client-tools-v3.6.0-c4dd4cf-linux-64bit.tar.gz -O /tmp/oc.tar.gz && sudo tar -zxvf /tmp/oc.tar.gz -C /bin/ --strip-components=1 && rm -f /tmp/oc.tar.gz

