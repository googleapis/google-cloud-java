#!/usr/bin/env bash

set -eo pipefail
utilities_script_dir=$(dirname "$(realpath "${BASH_SOURCE[0]}")")

# Utility functions used in `generate_library.sh` and showcase generation.
extract_folder_name() {
  local destination_path=$1
  local folder_name=${destination_path##*/}
  echo "${folder_name}"
}

remove_empty_files() {
  local category=$1
  local destination_path=$2
  local file_num
  find "${destination_path}/${category}-${folder_name}/src/main/java" -type f -size 0 | while read -r f; do rm -f "${f}"; done
  # remove the directory if the directory has no files.
  file_num=$(find "${destination_path}/${category}-${folder_name}" -type f | wc -l | sed 's/^[[:space:]]*//;s/[[:space:]]*$//')
  if [[ "${file_num}" == 0 ]]; then
    rm -rf "${destination_path}/${category}-${folder_name}"
  fi

  if [ -d "${destination_path}/${category}-${folder_name}/src/main/java/samples" ]; then
      mv "${destination_path}/${category}-${folder_name}/src/main/java/samples" "${destination_path}/${category}-${folder_name}"
  fi
}

# Move generated files to folders in destination_path.
mv_src_files() {
  local category=$1 # one of gapic, proto, samples
  local type=$2 # one of main, test
  local destination_path=$3
  if [ "${category}" == "samples" ]; then
    src_suffix="samples/snippets/generated/src/main/java"
    folder_suffix="samples/snippets/generated"
    mkdir -p "${destination_path}/${folder_suffix}"
    cp -r "${destination_path}/java_gapic_srcjar/${src_suffix}"/* "${destination_path}/${folder_suffix}"
  elif [ "${category}" == "proto" ]; then
    src_suffix="${category}/src/${type}/java"
    folder_suffix="${category}-${folder_name}/src/${type}"
  else
    src_suffix="src/${type}"
    folder_suffix="${category}-${folder_name}/src"
  fi

  if [ "${category}" == "samples" ]; then
    return
  fi

  mkdir -p "${destination_path}/${folder_suffix}"
  cp -r "${destination_path}/java_gapic_srcjar/${src_suffix}" "${destination_path}/${folder_suffix}"
  rm -r -f "${destination_path}/${folder_suffix}/java/META-INF"
}

# unzip jar file
unzip_src_files() {
  local category=$1
  local destination_path=$2
  local jar_file=java_${category}.jar
  mkdir -p "${destination_path}/${category}-${folder_name}/src/main/java"
  unzip -q -o "${destination_path}/${jar_file}" -d "${destination_path}/${category}-${folder_name}/src/main/java"
  rm -r -f "${destination_path}/${category}-${folder_name}/src/main/java/META-INF"
}

# get gapic options from .yaml and .json files from proto_path.
get_gapic_opts() {
  local transport=$1
  local rest_numeric_enums=$2
  local gapic_yaml=$3
  local service_config=$4
  local service_yaml=$5
  local repo=$6
  local artifact=$7
  if [ "${rest_numeric_enums}" == "true" ]; then
    rest_numeric_enums="rest-numeric-enums"
  else
    rest_numeric_enums=""
  fi
  # If any of the gapic options is empty (default value), try to search for
  # it in proto_path.
  if [[ "${gapic_yaml}" == "" ]]; then
    gapic_yaml=$(find "${proto_path}" -type f -name "*gapic.yaml")
  fi

  if [[ "${service_config}" == "" ]]; then
    service_config=$(find "${proto_path}" -type f -name "*service_config.json")
  fi

  if [[ "${service_yaml}" == "" ]]; then
    service_yaml=$(find "${proto_path}" -maxdepth 1 -type f \( -name "*.yaml" ! -name "*gapic*.yaml" \))
  fi
  echo "transport=${transport},${rest_numeric_enums},grpc-service-config=${service_config},gapic-config=${gapic_yaml},api-service-config=${service_yaml},repo=${repo},artifact=${artifact}"
}

remove_grpc_version() {
  local destination_path=$1
  find "${destination_path}" -type f -name "*Grpc.java" -exec \
  sed -i.bak 's/value = \"by gRPC proto compiler.*/value = \"by gRPC proto compiler\",/g' {}  \; -exec rm {}.bak \;
}

download_protoc() {
  local protoc_version=$1
  local os_architecture=$2

  download_from \
  "https://github.com/protocolbuffers/protobuf/releases/download/v${protoc_version}/protoc-${protoc_version}-${os_architecture}.zip" \
  "protoc-${protoc_version}.zip" \
  "GitHub"
  unzip -o -q "protoc-${protoc_version}.zip"
  rm "protoc-${protoc_version}.zip" "readme.txt"
}

download_grpc_plugin() {
  local grpc_version=$1
  local os_architecture=$2
  grpc_filename="protoc-gen-grpc-java.exe"
  # download protoc-gen-grpc-java plugin from Google maven central mirror.
  download_from \
  "https://maven-central.storage-download.googleapis.com/maven2/io/grpc/protoc-gen-grpc-java/${grpc_version}/protoc-gen-grpc-java-${grpc_version}-${os_architecture}.exe" \
  "${grpc_filename}"
  chmod +x "${grpc_filename}"
}

download_from() {
  local url=$1
  local save_as=$2
  local repo=$3
  # fail-fast, 30 seconds at most, retry 2 times
  curl -LJ -o "${save_as}" --fail -m 30 --retry 2 "$url" || download_fail "${save_as}" "${repo}"
}

# copies the specified file in $1 to $2
# will return "true" if the copy was successful
copy_from() {
  local local_repo=$1
  local save_as=$2
  copy_successful=$(cp "${local_repo}" "${save_as}" && echo "true" || echo "false")
  echo "${copy_successful}"
}

download_fail() {
  local artifact=$1
  local repo=${2:-"maven central mirror"}
  >&2 echo "Fail to download ${artifact} from ${repo} repository. Please install ${artifact} first if you want to use a non-published artifact."
  exit 1
}

# gets the output folder where all sources and dependencies will be located.
get_output_folder() {
  if [[ $(basename $(pwd)) != "output" ]]; then
    echo "$(pwd)/output" 
  else
    echo $(pwd)
  fi
}

detect_os_architecture() {
  local os_type
  local os_architecture
  os_type=$(uname -sm)
  case "${os_type}" in
    *"Linux x86_64"*)
      os_architecture="linux-x86_64"
      ;;
    *"Darwin x86_64"*)
      os_architecture="osx-x86_64"
      ;;
    *)
      os_architecture="osx-aarch_64"
      ;;
  esac
  echo "${os_architecture}"
}


# copies $1 as a folder as $2 only if $1 exists
copy_directory_if_exists() {
  local base_folder=$1
  local folder_prefix=$2
  local destination_folder=$3
  if [ ! -d "${base_folder}" ]; then
    return
  fi
  pushd "${base_folder}"
  if [[ $(find . -maxdepth 1 -type d -name "${folder_prefix}*" | wc -l ) -gt 0  ]]; then
    cp -r ${base_folder}/${folder_prefix}* "${destination_folder}"
  fi
  popd # base_folder
}

# computes proto_path from a given folder of GAPIC sources
# It will inspect the proto library to compute the path
get_proto_path_from_preprocessed_sources() {
  set -e
  local sources=$1
  pushd "${sources}" > /dev/null
  local proto_library
  proto_library=$(find . -maxdepth 1 -type d -name 'proto-*' | sed 's/\.\///')
  local found_libraries
  found_libraries=$(echo "${proto_library}" | wc -l)
  if [[ -z ${proto_library} ]]; then
    echo "no proto libraries found in the supplied sources path"
    exit 1
  elif [ ${found_libraries} -gt 1 ]; then
    echo "more than one proto library found in the supplied sources path"
    echo "cannot decide for a service version"
    exit 1
  fi
  pushd "$(pwd)/${proto_library}/src/main/proto" > /dev/null
  local result=$(find . -type f -name '*.proto' | head -n 1 | xargs dirname | sed 's/\.\///')
  popd > /dev/null # proto_library
  popd > /dev/null # sources
  echo "${result}"
}

# for a pre-processed library stored in $preprocessed_sources_path, a folder
# tree is built on $target_folder so it looks like a googleapis-gen folder and
# is therefore consumable by OwlBot CLI
build_owlbot_cli_source_folder() {
  local postprocessing_target=$1
  local target_folder=$2
  local preprocessed_sources_path=$3
  local proto_path=$4
  if [[ -z "${proto_path}" ]]; then
    proto_path=$(get_proto_path_from_preprocessed_sources "${preprocessed_sources_path}")
  fi
  owlbot_staging_folder="${postprocessing_target}/owl-bot-staging"
  mkdir -p "${owlbot_staging_folder}"

  # By default (thanks to generation templates), .OwlBot-hermetic.yaml `deep-copy` section
  # references a wildcard pattern matching a folder
  # ending with `-java` at the leaf of proto_path. We then use a generated-java
  # folder that will be picked up by copy-code
  mkdir -p "${target_folder}/${proto_path}/generated-java"
  copy_directory_if_exists "${preprocessed_sources_path}" "proto" \
    "${target_folder}/${proto_path}/generated-java/proto-google-cloud-library"
  copy_directory_if_exists "${preprocessed_sources_path}" "grpc" \
    "${target_folder}/${proto_path}/generated-java/grpc-google-cloud-library"
  copy_directory_if_exists "${preprocessed_sources_path}" "gapic" \
    "${target_folder}/${proto_path}/generated-java/gapic-google-cloud-library"
  copy_directory_if_exists "${preprocessed_sources_path}" "samples" \
    "${target_folder}/${proto_path}/generated-java/samples"
  pushd "${target_folder}"
  # create an empty commit so owl-bot-copy can process this as a repo
  # (it cannot process non-git-repositories)
  git init
  git commit --allow-empty -m 'empty commit'
  popd # target_folder
}

# Convenience function to clone only the necessary folders from a git repository
sparse_clone() {
  repo_url=$1
  paths=$2
  commitish=$3
  clone_dir=$(basename "${repo_url%.*}")
  rm -rf "${clone_dir}"
  git clone -n --depth=1 --no-single-branch --filter=tree:0 "${repo_url}"
  pushd "${clone_dir}"
  if [ -n "${commitish}" ]; then
    git checkout "${commitish}"
  fi
  git sparse-checkout set --no-cone ${paths}
  git checkout
  popd
}

# calls a function in utilities.py. THe first argument is the function name, the
# rest of the arguments are the positional arguments to such function
py_util() {
  python3 "${utilities_script_dir}/utilities.py" "$@"
}

get_gapic_generator_location() {
  local generator_location
  generator_location="${HOME}/.library_generation/gapic-generator-java.jar"
  if [[ -n "${GAPIC_GENERATOR_LOCATION}" ]]; then
    echo "${GAPIC_GENERATOR_LOCATION}"
  elif [[ -f "${generator_location}" ]]; then
    echo "${generator_location}"
  else
    echo "Can't find GAPIC generator in ${generator_location}."
    exit 1
  fi
}

get_protoc_location() {
  local protoc_location
  protoc_location="${HOME}/.library_generation/bin"
  if [[ -n "${DOCKER_PROTOC_LOCATION}" ]]; then
    echo "${DOCKER_PROTOC_LOCATION}"
  elif [[ -d "${protoc_location}" ]]; then
    echo "${protoc_location}"
  else
    echo "Can't find protoc in ${protoc_location}."
    exit 1
  fi
}

get_grpc_plugin_location() {
  local grpc_location
  grpc_location="${HOME}/.library_generation/protoc-gen-grpc-java.exe"
  if [[ -n "${DOCKER_GRPC_LOCATION}" ]]; then
    echo "${DOCKER_GRPC_LOCATION}"
  elif [[ -f "${grpc_location}" ]]; then
    echo "${grpc_location}"
  else
    echo "Can't find grpc plugin in ${grpc_location}."
    exit 1
  fi
}

get_java_formatter_location() {
  local formatter_location
  formatter_location="${HOME}/.library_generation/google-java-format.jar"
  if [[ -n "${JAVA_FORMATTER_LOCATION}" ]]; then
    echo "${JAVA_FORMATTER_LOCATION}"
  elif [[ -f "${formatter_location}" ]]; then
    echo "${formatter_location}"
  else
    echo "Can't find Java formatter in ${formatter_location}."
    exit 1
  fi
}

error_if_not_exists() {
  local required_tool=$1
  if [[ ! -f "${required_tool}" ]]; then
    >&2 echo "File ${required_tool} not found in the filesystem. "
    >&2 echo "Please configure your environment and store the "
    >&2 echo "required tools in this location."
    exit 1
  fi
}
