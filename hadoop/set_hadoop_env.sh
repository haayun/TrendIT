#!/bin/bash

mkdir ~/hadoop_tmp

username=$(whoami)
echo "# Automatically added" >> ~/.bashrc
echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64" >> ~/.bashrc
echo "export HADOOP_HOME=\"/usr/local/hadoop\"" >> ~/.bashrc
echo "export PATH=\"\$HADOOP_HOME/bin:\$HADOOP_HOME/sbin:\$PATH\"" >> ~/.bashrc
echo "export HADOOP_CLASSPATH=/home/hadoop/KOMORAN/KOMORAN-3.3.4.jar" >> ~/.bashrc

ln -s /usr/local/hadoop ~/hadoop

