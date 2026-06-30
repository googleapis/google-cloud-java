#!/bin/bash -e

# Run gapic-generator-java as a protoc plugin.

# Usage example here:
: << 'EXAMPLE'
  DIR=~/dev/googleapis/google/showcase/v1beta1
  ./run.sh --g ~/dev/googleapis --p "$DIR"-s "$DIR/showcase_grpc_service_config.json"
EXAMPLE

source gbash.sh

# Required flags.
DEFINE_string --alias=p protos '' 'Path to the protos to generate.'
DEFINE_string --alias=g googleapis '' 'Path to the googleapis directory.'
DEFINE_string --alias=s service_config '' 'Path to the JSON service config'

# Optional flags.
DEFINE_bool --alias=c use_cached false 'If true, does not rebuild the plugin.'
DEFINE_string --alias=o out '/tmp/test' 'Output directory'
DEFINE_string gapic_config '' 'Path to the config ending in gapic.yaml. Optional'

gbash::init_google "$@"

# Variables.
PROTOC_INCLUDE_DIR=/usr/local/include/google/protobuf

function echo_error {
  BOLD="\e[1m"
  UNSET="\e[0m"
  WHITE="\e[97m"
  RED="\e[91m"
  BACK_MAGENTA="\e[45m"
  BACK_BLUE="\e[44m"
  BACK_RED="\e[41m"
  echo -e "$BOLD $BACK_BLUE $WHITE $1 $UNSET"
}

function echo_success {
  BOLD="\e[1m"
  UNSET="\e[0m"
  WHITE="\e[97m"
  BACK_GREEN="\e[42m"
  BACK_BLUE="\e[44m"
  echo -e "$BOLD $BACK_BLUE $WHITE $BACK_GREEN $1 $UNSET"
}

# Flag check.
if [[ -z "${FLAGS_protos}" ]]
then
  echo_error "Required flag --protos must be set."
  exit 1
fi

if [[ -z "${FLAGS_googleapis}" ]]
then
  echo_error "Required flag --googleapis must be set."
  exit 1
fi

# Build if needed.
if [[ "${FLAGS_use_cached}" == 0 ]] || [[ ! -f bazel-bin/protoc-gen-java_gapic ]]
then
  echo_success "Rebuilding the microgenerator..."
  bazel build :protoc-gen-java_gapic
  if [[ $? -ne 0 ]]
  then
    echo_error "Build failed."
    exit 1
  fi

  echo_success "Done"
fi

# Key values are synced to rules_java_gapic/java_gapic.bzl.
SERVICE_CONFIG_OPT=""
if [ -n "$FLAGS_service_config" ]
then
  SERVICE_CONFIG_OPT="grpc-service-config=$FLAGS_service_config"
fi

GAPIC_CONFIG_OPT=""
if [ -n "$FLAGS_gapic_config" ]
then
  GAPIC_CONFIG_OPT="gapic-config=$FLAGS_gapic_config"
fi

# Run protoc.
protoc -I="${PROTOC_INCLUDE_DIR}" -I="${FLAGS_googleapis}" -I="${FLAGS_protos}" \
    -I="${FLAGS_googleapis}/google/longrunning" \
    --include_source_info \
    --plugin=bazel-bin/protoc-gen-java_gapic ${FLAGS_protos}/*.proto \
    --java_gapic_out="${FLAGS_out}" \
    --java_gapic_opt="${SERVICE_CONFIG_OPT},${GAPIC_CONFIG_OPT}" \
    --experimental_allow_proto3_optional

echo_success "Output files written to ${FLAGS_out}"
