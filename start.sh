#!/usr/bin/env bash



if [ -z ${NEXTGEN_CONFIG_SERVER} ]; then
   echo "WARNING: NEXTGEN_CONFIG_SERVER is not set. Starting in default port 8199"
fi

##if [ -z ${NEXTGEN_REGISTRY_SERVER} ]; then
##   echo "WARNING: NEXTGEN_REGISTRY_SERVER is not set. Starting in default port 8088"
##fi

cd configuration; 	docker run -d -p 8199:8199 nextgen-config; 	cd -
sleep 60 # -- wait for 1 minute

##cd service-registry; 	docker run -d -p 8088:8088 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} prithwish24/nextgen-registry;  cd -
cd profile;  docker run -d -p 8001:8001 -v /logs:/logs nextgen-profile;  cd -
sleep 90s # --- wait 90 secs

cd reservation;  docker run -d -p 8002:8002 -v /logs:/logs nextgen-reservation;  cd -
##cd addons-services; 	docker run -d -p 8003:8003 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} -e NEXTGEN_REGISTRY_SERVER=${NEXTGEN_REGISTRY_SERVER} prithwish24/nextgen-addon-svcs;  cd -
#cd gateway; 		docker run -d -p 8080:8080 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} nextgen-gateway;  cd -

echo "Application Started"

