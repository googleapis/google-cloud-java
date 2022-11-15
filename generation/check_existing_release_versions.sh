#!/bin/bash

return_code=0

function find_existing_version() {
  local artifact_id=$1
  local version=$2
  if [[ $artifact_id == grpc-* ]] || [[ $artifact_id == proto-* ]]; then
    group_id="com.google.api.grpc"
  else
    group_id="com.google.cloud"
  fi
  echo -n "Checking ${group_id}:${artifact_id}:${version}:"
  local group_id_dir="${group_id//\.//}"
  local URL="https://repo1.maven.org/maven2/${group_id_dir}/${artifact_id}/${version}"
  local status_code=$(curl --silent -o /dev/null -w "%{http_code}" $URL)
  if [ "${status_code}" == "404" ]; then
    echo " The version does not exists. Good"
  else 
    echo " The version already exists at ${URL}. Please investigate."
    # global
    return_code=1
  fi
}

find_existing_version proto-google-cloud-accessapproval-v1 2.7.0


exit ${return_code}
