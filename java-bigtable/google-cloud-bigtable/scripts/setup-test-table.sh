#!/usr/bin/env bash

# Set up a table to use for integration tests.

set -e
set -u

ADMIN_HOSTS=(
  "bigtableadmin.googleapis.com:443"
  "test-bigtableadmin.sandbox.googleapis.com:443"
)

ZONE=us-central1-b
FAMILY=cf

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

call_cbt() {
  cbt -admin-endpoint="${ADMIN_HOST}" -project "${PROJECT_ID}" -instance "${INSTANCE_ID}" "$@"
}

for ADMIN_HOST in "${ADMIN_HOSTS[@]}"; do
  # Ensure that the instance exists.
  if ! call_cbt listinstances | grep -q "${INSTANCE_ID}"; then
    call_cbt createinstance "${INSTANCE_ID}" "${INSTANCE_ID}" "${INSTANCE_ID}-c0" "${ZONE}" 1 SSD
  fi

  # Ensure that the table exists
  if ! call_cbt -instance ${INSTANCE_ID} ls | grep -q "^${TABLE_ID}\$"; then
    call_cbt createtable ${TABLE_ID}
  fi

  # Ensure that the family exists
  if ! call_cbt ls "${TABLE_ID}" | grep -q "^$FAMILY\b"; then
    call_cbt createfamily "${TABLE_ID}" "${FAMILY}"
    call_cbt setgcpolicy "${TABLE_ID}" "${FAMILY}" maxversions=1
  fi
done
