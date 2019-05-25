#!/usr/bin/env bash

# Set up a table to use for integration tests.

set -x

# Format: projects/<project-id>/instances/<instance-id>/tables/<table-id>
TABLE_NAME=$1

if [[ ${TABLE_NAME} =~ projects\/([^/]+)\/instances\/([^/]+)\/tables\/([^/]+) ]]; then
  PROJECT_ID=${BASH_REMATCH[1]}
  INSTANCE_ID=${BASH_REMATCH[2]}
  TABLE_ID=${BASH_REMATCH[3]}
else
  echo "Invalid table name: $TABLE_NAME" 1>&2
  exit 1
fi

cbt -project $PROJECT_ID -instance $INSTANCE_ID createtable $TABLE_ID
cbt -project $PROJECT_ID -instance $INSTANCE_ID createfamily $TABLE_ID cf
cbt -project $PROJECT_ID -instance $INSTANCE_ID setgcpolicy $TABLE_ID cf maxversions=1
