#!/bin/bash

keytool -genkeypair \
	-alias alias1 \
	-keyalg RSA -keysize 2048  \
	-dname "CN=config-server-test1,OU=test,O=test,L=test,S=NY,C=US"   \
	-keypass 123456 \
	-keystore src/main/resources/config-server-test1.jks \
	-storepass 123456
	
keytool -keystore src/main/resources/config-server-test1.jks -storepass 123456 -list -v