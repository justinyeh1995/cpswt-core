# Base image: Ubuntu 20.04
FROM ubuntu:20.04
LABEL maintainer="CPSWT Team"

# Set it to noninteractive mode
ARG DEBIAN_FRONTEND=noninteractive

# Install necessary packages
RUN apt-get update && \
    apt-get install -y \
        apt-transport-https \
        bison \
        build-essential \
        ca-certificates \
        clang \
        curl \
        doxygen \
        flex \
        gcc \
        gdb \
        git \
        graphviz \
        libboost1.71-all-dev \
        libcppunit-dev \
        libjsoncpp-dev \
        libosgearth-dev \
        libqt5opengl5-dev \
        libwebkit2gtk-4.0-37 \
        libxml2-dev \
        lld \
        make \
        mongodb \
        mpi-default-dev \
        netcat \
        openjdk-8-jdk \
        openjdk-17-jdk \
        openscenegraph-plugin-osgearth \
        perl \
        python2 \
        python3 \
        python3-pip \
        python-is-python2 \
        qt5-qmake \
        qtbase5-dev \
        qtbase5-dev-tools \
        qtchooser \
        software-properties-common \
        wget \
        xterm \
        zlib1g-dev \
        unzip \
        zip

#install Gradle
ARG GRADLE_VERSION=7.5
RUN wget -O gradle.zip https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    mkdir /opt/gradle && \
    unzip -d /opt/gradle gradle.zip && \
    rm gradle.zip
# Set Gradle in the environment variables
ENV GRADLE_HOME="/opt/gradle/gradle-${GRADLE_VERSION}"
ENV PATH="${GRADLE_HOME}/bin:${PATH}"

# Install Python packages
RUN python3 -m pip install --system --upgrade \
    jinja2 \
    matplotlib \
    numpy \
    pandas \
    posix_ipc \
    scipy \
    seaborn \
    webgme-bindings 

# Download and extract portico
WORKDIR /home
RUN wget -O portico.tar.gz https://master.dl.sourceforge.net/project/portico/Portico/portico-2.1.0/portico-2.1.0-linux64.tar.gz?viasf=1 && \
    tar xf portico.tar.gz && \
    rm portico.tar.gz
ENV RTI_HOME="/home/portico-2.1.0"

# Download and set up Apache Archiva
WORKDIR /opt
RUN wget -O archiva.tar.gz https://archive.apache.org/dist/archiva/2.2.5/binaries/apache-archiva-2.2.5-bin.tar.gz && \
    tar xf archiva.tar.gz && \
    rm archiva.tar.gz

# Expose the Archiva port
EXPOSE 8080/tcp

# Use SIGINT for stopping
STOPSIGNAL SIGINT

# Set up Gradle properties
COPY gradle.properties /root/.gradle/
RUN chmod 600 /root/.gradle/gradle.properties

# Clone and build CPSWT packages
RUN mkdir /home/cpswt
COPY experiment_wrapper.sh /home/cpswt

WORKDIR /home/cpswt
# Start Archiva
CMD [ "/usr/bin/bash", "experiment_wrapper.sh" ]
# CMD [ "/usr/bin/bash" ]

