#!/usr/bin/env bash
# Copyright 2026 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Provisions the shared Bigtable instance, table, column families, and auxiliary
# resources required to run Data integration tests (`com.google.cloud.bigtable.data.v2.it.*`)
# without per-test Admin API mutations.
#
# Provisioned resources (must match AbstractTestEnv / AuthorizedViewTestHelper):
#   1. Instance: <instance-id> (created with 1 SSD node in $ZONE if missing)
#   2. Table:    <table-id>
#      - Column family `cf`:         maxversions=1 || maxage=1h (general Data ITs)
#      - Column family `cf_history`: maxversions=10 || maxage=1h (ExecuteQueryIT#withHistoryQuery)
#   3. AuthorizedView:   `test-authorized-view` on <table-id>
#      - SubsetView over row prefix `row#` and family `cf` qualifier prefix `qualifier`
#   4. MaterializedView: `<table-id>-mv` on <instance-id>
#      - `SELECT _key, MAX(cf['column']) AS column FROM `<table-id>` GROUP BY _key`
#   5. SchemaBundle:     `test-schema-bundle` on <table-id>
#      - Protobuf FileDescriptorSet compiled from `src/test/proto/{singer,album}.proto`
#
# Usage:
#   ./scripts/setup-test-table.sh projects/<project-id>/instances/<instance-id>/tables/<table-id> [admin-endpoint] [impersonate-service-account]
#
# Environment overrides:
#   ADMIN_HOST                   (optional Bigtable Admin endpoint override; uses CLI default when unset)
#   ZONE                         (default: us-central1-b)
#   IMPERSONATE_SERVICE_ACCOUNT  (optional service account email for cbt/gcloud auth)
#   PROTOC                       (optional path to protoc binary)

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
JAVA_BIGTABLE_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"

ZONE="${ZONE:-us-central1-b}"
FAMILY="cf"
HISTORY_FAMILY="cf_history"
AUTHORIZED_VIEW_ID="test-authorized-view"
SCHEMA_BUNDLE_ID="test-schema-bundle"

# Format: projects/<project-id>/instances/<instance-id>/tables/<table-id>
TABLE_NAME="${1:-}"
ADMIN_HOST="${2:-${ADMIN_HOST:-}}"
IMPERSONATE_SA="${3:-${IMPERSONATE_SERVICE_ACCOUNT:-}}"

if [[ "${TABLE_NAME}" =~ ^projects/([^/]+)/instances/([^/]+)/tables/([^/]+)$ ]]; then
  PROJECT_ID="${BASH_REMATCH[1]}"
  INSTANCE_ID="${BASH_REMATCH[2]}"
  TABLE_ID="${BASH_REMATCH[3]}"
else
  echo "Usage: $0 projects/<project-id>/instances/<instance-id>/tables/<table-id> [admin-endpoint] [impersonate-service-account]" >&2
  echo "Invalid table name: ${TABLE_NAME}" >&2
  exit 1
fi

MATERIALIZED_VIEW_ID="${TABLE_ID}-mv"

GCLOUD_AUTH_ARGS=()
CBT_ARGS=(-project="${PROJECT_ID}" -instance="${INSTANCE_ID}")
if [[ -n "${ADMIN_HOST}" ]]; then
  CBT_ARGS+=(-admin-endpoint="${ADMIN_HOST}")
fi
if [[ -n "${IMPERSONATE_SA}" ]]; then
  GCLOUD_AUTH_ARGS+=(--impersonate-service-account="${IMPERSONATE_SA}")
  ACCESS_TOKEN="$(gcloud auth print-access-token "${GCLOUD_AUTH_ARGS[@]}")"
  CBT_ARGS+=(-access-token="${ACCESS_TOKEN}")
elif [[ -n "${GOOGLE_APPLICATION_CREDENTIALS:-}" ]]; then
  CBT_ARGS+=(-creds="${GOOGLE_APPLICATION_CREDENTIALS}")
fi

call_cbt() {
  cbt "${CBT_ARGS[@]}" "$@"
}

call_gcloud() {
  local env_args=()
  if [[ -n "${ADMIN_HOST}" ]]; then
    env_args+=("CLOUDSDK_API_ENDPOINT_OVERRIDES_BIGTABLEADMIN=https://${ADMIN_HOST%:443}/")
  fi
  if [[ -z "${IMPERSONATE_SA}" && -n "${GOOGLE_APPLICATION_CREDENTIALS:-}" ]]; then
    env_args+=("CLOUDSDK_AUTH_CREDENTIAL_FILE_OVERRIDE=${GOOGLE_APPLICATION_CREDENTIALS}")
  fi
  if [[ "${#env_args[@]}" -gt 0 ]]; then
    env "${env_args[@]}" gcloud --project="${PROJECT_ID}" --quiet "${GCLOUD_AUTH_ARGS[@]}" "$@"
  else
    gcloud --project="${PROJECT_ID}" --quiet "${GCLOUD_AUTH_ARGS[@]}" "$@"
  fi
}

resolve_protoc() {
  if [[ -n "${PROTOC:-}" ]]; then
    echo "${PROTOC}"
    return
  fi
  if command -v protoc >/dev/null 2>&1; then
    command -v protoc
    return
  fi
  local cached_protoc=""
  if [[ -d "${HOME}/.m2/repository/com/google/protobuf/protoc" ]]; then
    cached_protoc="$(find "${HOME}/.m2/repository/com/google/protobuf/protoc" -name 'protoc-*.exe' 2>/dev/null | sort -V | tail -n 1)"
  fi
  if [[ -z "${cached_protoc}" ]]; then
    echo "Downloading protoc via Maven protobuf-maven-plugin..." >&2
    mvn -q -f "${JAVA_BIGTABLE_DIR}/google-cloud-bigtable/pom.xml" protobuf:test-compile >&2
    cached_protoc="$(find "${HOME}/.m2/repository/com/google/protobuf/protoc" -name 'protoc-*.exe' 2>/dev/null | sort -V | tail -n 1)"
  fi
  if [[ -z "${cached_protoc}" ]]; then
    echo "Unable to locate protoc binary; install protoc or set PROTOC=/path/to/protoc." >&2
    exit 1
  fi
  local tmp_protoc="${TMP_DIR}/protoc"
  cp "${cached_protoc}" "${tmp_protoc}"
  chmod +x "${tmp_protoc}"
  echo "${tmp_protoc}"
}

TMP_DIR="$(mktemp -d)"
trap 'rm -rf "${TMP_DIR}"' EXIT

# 1. Ensure that the instance exists.
INSTANCES="$(call_cbt listinstances)"
if ! echo "${INSTANCES}" | grep -Eq "^${INSTANCE_ID}([[:space:]]|$)"; then
  echo "Creating instance ${INSTANCE_ID} in ${PROJECT_ID} (${ZONE})..."
  call_cbt createinstance "${INSTANCE_ID}" "${INSTANCE_ID}" "${INSTANCE_ID}-c0" "${ZONE}" 1 SSD
fi

# 2. Ensure that the shared table and required column families exist.
TABLES="$(call_cbt ls)"
if ! echo "${TABLES}" | grep -qx "${TABLE_ID}"; then
  echo "Creating table ${TABLE_ID} with families ${FAMILY} and ${HISTORY_FAMILY}..."
  call_cbt createtable "${TABLE_ID}" \
    "families=${FAMILY}:maxversions=1||maxage=1h,${HISTORY_FAMILY}:maxversions=10||maxage=1h"
else
  EXISTING_FAMILIES="$(call_cbt ls "${TABLE_ID}" | awk 'NR>2 {print $1}')"
  if ! echo "${EXISTING_FAMILIES}" | grep -qx "${FAMILY}"; then
    echo "Creating column family ${FAMILY} on ${TABLE_ID}..."
    call_cbt createfamily "${TABLE_ID}" "${FAMILY}"
    call_cbt setgcpolicy "${TABLE_ID}" "${FAMILY}" maxversions=1 or maxage=1h
  fi
  if ! echo "${EXISTING_FAMILIES}" | grep -qx "${HISTORY_FAMILY}"; then
    echo "Creating column family ${HISTORY_FAMILY} on ${TABLE_ID}..."
    call_cbt createfamily "${TABLE_ID}" "${HISTORY_FAMILY}"
    call_cbt setgcpolicy "${TABLE_ID}" "${HISTORY_FAMILY}" maxversions=10 or maxage=1h
  fi
fi

# 3. Ensure that the shared AuthorizedView exists on <table-id>.
AUTHORIZED_VIEWS="$(
  call_gcloud bigtable authorized-views list \
    --instance="${INSTANCE_ID}" \
    --table="${TABLE_ID}" \
    --format="value(name.basename())"
)"
if ! echo "${AUTHORIZED_VIEWS}" | grep -qx "${AUTHORIZED_VIEW_ID}"; then
  echo "Creating authorized view ${AUTHORIZED_VIEW_ID} on ${TABLE_ID}..."
  AV_DEF_FILE="${TMP_DIR}/authorized_view.json"
  cat > "${AV_DEF_FILE}" <<EOF
{
  "subsetView": {
    "rowPrefixes": ["row#"],
    "familySubsets": {
      "${FAMILY}": {
        "qualifierPrefixes": ["qualifier"]
      }
    }
  },
  "deletionProtection": false
}
EOF
  call_gcloud bigtable authorized-views create "${AUTHORIZED_VIEW_ID}" \
    --instance="${INSTANCE_ID}" \
    --table="${TABLE_ID}" \
    --definition-file="${AV_DEF_FILE}"
fi

# 4. Ensure that the shared MaterializedView exists on <instance-id>.
MATERIALIZED_VIEWS="$(
  call_gcloud bigtable materialized-views list \
    --instance="${INSTANCE_ID}" \
    --format="value(name.basename())"
)"
if ! echo "${MATERIALIZED_VIEWS}" | grep -qx "${MATERIALIZED_VIEW_ID}"; then
  echo "Creating materialized view ${MATERIALIZED_VIEW_ID} on ${INSTANCE_ID}..."
  call_gcloud bigtable materialized-views create "${MATERIALIZED_VIEW_ID}" \
    --instance="${INSTANCE_ID}" \
    --query="SELECT _key, MAX(${FAMILY}['column']) AS column FROM \`${TABLE_ID}\` GROUP BY _key" \
    --deletion-protection=false
fi

# 5. Ensure that the shared SchemaBundle exists on <table-id>.
SCHEMA_BUNDLES="$(
  call_gcloud bigtable schema-bundles list \
    --instance="${INSTANCE_ID}" \
    --table="${TABLE_ID}" \
    --format="value(name.basename())"
)"
if ! echo "${SCHEMA_BUNDLES}" | grep -qx "${SCHEMA_BUNDLE_ID}"; then
  echo "Creating schema bundle ${SCHEMA_BUNDLE_ID} on ${TABLE_ID}..."
  PROTOC_BIN="$(resolve_protoc)"
  PROTO_DIR="${JAVA_BIGTABLE_DIR}/google-cloud-bigtable/src/test/proto"
  DESC_FILE="${TMP_DIR}/schema_bundle_descriptors.pb"
  "${PROTOC_BIN}" \
    --proto_path="${PROTO_DIR}" \
    --include_imports \
    --descriptor_set_out="${DESC_FILE}" \
    "${PROTO_DIR}/singer.proto" \
    "${PROTO_DIR}/album.proto"
  call_gcloud bigtable schema-bundles create "${SCHEMA_BUNDLE_ID}" \
    --instance="${INSTANCE_ID}" \
    --table="${TABLE_ID}" \
    --proto-descriptors-file="${DESC_FILE}"
fi

echo "Shared test resources verified for ${TABLE_NAME} (${ADMIN_HOST:-default})."
