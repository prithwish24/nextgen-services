#!/bin/sh

while ! nc -z nextgen-config 8199 ; do
	echo "Waiting for config server..."
	sleep 2
done

java -Xmx256m -jar /var/apps/nextgen-addon-svcs.jar
