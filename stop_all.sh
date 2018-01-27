#!/usr/bin/env bash

while true; do
  read -p "Are you sure want to stop all running docker containers? [Yn]: " yn
  case $yn in
    [Yy]* ) if [ -z $(docker ps -q) ]; then echo "Skipped - No running container."; exit; fi; docker stop $(docker ps -q); break;;
    [Nn]* ) exit;;
    * ) echo "Please enter Y-Yes or N-No"
  esac
done


