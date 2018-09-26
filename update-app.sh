#!/bin/bash

echo Running aplication lifecycle.
echo

echo Updating application code..
cd NextGenAIOrch;
git pull

echo
echo Compiling application code..
mvn clean
mvn install

echo
echo Deploying application as service..
source ./start.sh 

cd -;

