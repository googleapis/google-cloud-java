#!/bin/bash
set -e
workspace_name="/workspace"
for num in "1" "2" "3"; do
  # Remove previous log.
 if [[ -e "run-${num}.log" ]]; then
   rm "run-${num}.log"
 fi
 # Run docker in the background.
 docker run \
   --rm \
   -u "$(id -u):$(id -g)" \
   -v "$(pwd):${workspace_name}" \
   -v "$(pwd)/../googleapis:${workspace_name}/apis" \
   -e GENERATOR_VERSION="2.49.0-SNAPSHOT" \
   local:latest \
   --generation-config-path="${workspace_name}/generation_config-${num}.yaml" \
   --api-definitions-path="${workspace_name}/apis" > run-${num}.log 2>&1 &
done
