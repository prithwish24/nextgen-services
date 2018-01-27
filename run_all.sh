#!/usr/bin/env bash

if [ -z ${NEXTGEN_CONFIG_SERVER} ]; then
   echo "WARNING: NEXTGEN_CONFIG_SERVER is not set"
fi

if [ -z ${NEXTGEN_REGISTRY_SERVER} ]; then
   echo "WARNING: NEXTGEN_REGISTRY_SERVER is not set"
fi

cd configuration; 	docker run -d -p 8199:8199 prithwish24/nextgen-config; 	cd -
cd service-registry; 	docker run -d -p 8088:8088 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} prithwish24/nextgen-registry;  cd -
cd profile; 		docker run -d -p 8001:8001 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} -e NEXTGEN_REGISTRY_SERVER=${NEXTGEN_REGISTRY_SERVER} prithwish24/nextgen-profile;  cd -
cd reservation;		docker run -d -p 8002:8002 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} -e NEXTGEN_REGISTRY_SERVER=${NEXTGEN_REGISTRY_SERVER} prithwish24/nextgen-reservation;  cd -
cd addons-services; 	docker run -d -p 8003:8003 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} -e NEXTGEN_REGISTRY_SERVER=${NEXTGEN_REGISTRY_SERVER} prithwish24/nextgen-addon-svcs;  cd -
cd gateway; 		docker run -d -p 8080:8080 -e NEXTGEN_CONFIG_SERVER=${NEXTGEN_CONFIG_SERVER} -e NEXTGEN_REGISTRY_SERVER=${NEXTGEN_REGISTRY_SERVER} prithwish24/nextgen-gateway;  cd -

