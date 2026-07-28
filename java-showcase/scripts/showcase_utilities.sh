#!/bin/bash
readonly REPO_DIR="$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )/../.."

function cleanup {
  script_dir=$1
  cd "${script_dir}"
  rm -rf output gapic-generator-java*
  rm -rf "${script_dir}/../../generated-showcase-location"
}

get_version_from_pom() {
  target_pom="$1"
  key="$2"
  # prints the result to stdout
  grep -e "<${key}>" "${target_pom}" | cut -d'>' -f2 | cut -d'<' -f1
}

append_showcase_to_api_defs() {
  api_def_dir="$1"
  # append showcase definitions to googleapis repository
  export showcase_def_dir=$(mktemp -d)
  git clone https://github.com/googleapis/gapic-showcase.git "${showcase_def_dir}"
  # looks at sdk-platform-java/java-showcase/gapic-showcase/pom.xml to extract the
  # version of gapic-showcase
  # see https://github.com/googleapis/gapic-showcase/releases
  showcase_version=$(get_version_from_pom \
    "${REPO_DIR}/java-showcase/gapic-showcase/pom.xml" "gapic-showcase.version"
  )
  pushd "${showcase_def_dir}"
  git checkout "v${showcase_version}"
  popd
  # compliance_suite.json is a symbolic link outside of the schema folder, so we
  # replace it with the actual contents in its original location.
  compliance_suite_path="${showcase_def_dir}/schema/google/showcase/v1beta1/compliance_suite.json"
  unlink "${compliance_suite_path}"
  cp "${showcase_def_dir}/server/services/compliance_suite.json" "${compliance_suite_path}"
  # we complete the BUILD.bazel in gapic-showcase with our java_library in order
  # to generate the gapic portion.
  cat "${REPO_DIR}/java-showcase/scripts/resources/BUILD.partial.bazel" >> "${showcase_def_dir}/schema/google/showcase/v1beta1/BUILD.bazel"
  cp -r "${showcase_def_dir}/schema" "${api_def_dir}/"
}
