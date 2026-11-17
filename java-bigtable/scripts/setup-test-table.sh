#!/usr/bin/env bash

# Set up a table to use for integration tests.

# Usage: ./scripts/setup-test-table.sh projects/<project-id>/instances/<instance-id>/tables/<table-id> [admin-endpoint]
# Environment overrides: ADMIN_HOST, ZONE

set -e
set -u

ZONE=${ZONE:-us-central1-b}
FAMILY=cf

# Format: projects/<project-id>/instances/<instance-id>/tables/<table-id>
TABLE_NAME=$1
ADMIN_HOST=${2:-${ADMIN_HOST:-bigtableadmin.googleapis.com:443}}

if [[ ${TABLE_NAME} =~ projects\/([^/]+)\/instances\/([^/]+)\/tables\/([^/]+) ]]; then
  PROJECT_ID=${BASH_REMATCH[1]}
  INSTANCE_ID=${BASH_REMATCH[2]}
  TABLE_ID=${BASH_REMATCH[3]}
else
  echo "Invalid table name: $TABLE_NAME" 1>&2
  exit 1
fi

call_cbt() {
  cbt -admin-endpoint="${ADMIN_HOST}" -project "${PROJECT_ID}" -instance "${INSTANCE_ID}" "$@"
}

# Ensure that the instance exists.
if ! call_cbt listinstances | grep -Eq "^${INSTANCE_ID}([[:space:]]|$)"; then
  call_cbt createinstance "${INSTANCE_ID}" "${INSTANCE_ID}" "${INSTANCE_ID}-c0" "${ZONE}" 1 SSD
fi

# Ensure that the table exists.
if ! call_cbt -instance "$INSTANCE_ID" ls | grep -q "^${TABLE_ID}\$"; then
  call_cbt createtable "$TABLE_ID" "families=$FAMILY:maxversions=1||maxage=1h"
fi
