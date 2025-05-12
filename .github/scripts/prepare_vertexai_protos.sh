#!/bin/bash
set -ex

API_DIR="$1"
AIPLATFORM_API_DIR="${API_DIR}/google/cloud/aiplatform"
VERTEXAI_API_DIR="${API_DIR}/google/cloud/vertexai"

# A manually maintained file that lists all the proto files needed
# to generate gapic clients for Java SDK (with only Gemini support)
files=".github/scripts/vertexai_files_to_keep.txt"

# Get the proto file names into an array
proto_file_names=$(awk -F / '/.proto$/ {print $NF}' $files)
proto_file_names_array=()
while IFS=' ' read -ra proto_file; do
  proto_file_names_array+=($proto_file)
done <<< $proto_file_names

# Get all the protos in the aiplatform api directory
# google/cloud/aiplatform
# and put them into an array
aiplatform_proto_file_names=$(find "${AIPLATFORM_API_DIR}" -type f | awk -F / '/.proto$/ {print $NF}')
aiplatform_proto_file_names_array=()
while IFS=' ' read -ra proto_file; do
  aiplatform_proto_file_names_array+=($proto_file)
done <<< $aiplatform_proto_file_names

# Take the set(aiplatform_proto_file_names) - set(proto_file_names_array)
# put them in excluded_proto_file_names. These array is used to remove
# unused proto from the bazel build rule so that the generated gapic does
# not contain code corresponding to the unused protos.
excluded_proto_file_names=()
for ele in ${aiplatform_proto_file_names_array[@]}; do
  matched=false
  for included_proto in ${proto_file_names_array[@]}; do
    if [[ $ele == $included_proto ]]; then
      matched=true
    fi
  done
  if ! $matched; then
    excluded_proto_file_names+=($ele)
  fi
done

# Now we copy and process the target files one by one.
mkdir -p "${VERTEXAI_API_DIR}/v1"
while IFS= read -r file_relative_path; do
  # copy the file over
  cp "${AIPLATFORM_API_DIR}/${file_relative_path}" "${VERTEXAI_API_DIR}/${file_relative_path}"
  file_path="${VERTEXAI_API_DIR}/${file_relative_path}"
  echo "processing ${file_path}"

  # For proto files, we switch the package names
  if [[ $file_path == *".proto" ]]; then
    sed -i 's/package google.cloud.aiplatform/package google.cloud.vertexai/g' $file_path
    sed -i 's/java_package = "com.google.cloud.aiplatform.v1"/java_package = "com.google.cloud.vertexai.api"/g' $file_path
    sed -i 's%import "google/cloud/aiplatform%import "google/cloud/vertexai%g' $file_path
  fi

  # For the BUILD.bazel files, the processing contain multiple steps
  # (see the comments inside the if block)
  if [[ $file_path == *"BUILD.bazel" ]]; then
    # Make sure that we generate gapic for REST clients
    sed -i 's/"grpc"/"grpc+rest"/g' $file_path
    # String replacements in the rule names and dependency package names
    sed -i 's/aiplatform_proto/vertexai_proto/g' $file_path
    sed -i 's/aiplatform_java_proto/vertexai_java_proto/g' $file_path
    sed -i 's/aiplatform_java_gapic/vertexai_java_gapic/g' $file_path
    sed -i 's/aiplatform_java_grpc/vertexai_java_grpc/g' $file_path
    sed -i 's/com.google.cloud.aiplatform.v1/com.google.cloud.vertexai.api/g' $file_path
    sed -i 's/google-cloud-aiplatform-v1-java/google-cloud-vertexai-v1-java/g' $file_path

    # Remove unused protos from the proto_library
    awk -v exclude="$(IFS="|"; echo "${excluded_proto_file_names[*]}")" \
      '{
        if (!match($0, exclude)) {
          print
        }
      }' $file_path > "/tmp/BUILD.bazel.step1" && \
      cp "/tmp/BUILD.bazel.step1" $file_path

    # Remove bazel rules not related to Java
    awk '
        BEGIN {matched=0}
        /^go_/ {
          matched=1
        }
        !matched {
          print
        }
      ' $file_path > "/tmp/BUILD.bazel.step2" && \
      cp "/tmp/BUILD.bazel.step2" $file_path

    # The previous step will result in two extra empty lines so we remove them
    awk 'NR>2' $file_path > "/tmp/BUILD.bazel.step3" && \
      cp "/tmp/BUILD.bazel.step3" $file_path

    # Remove *SUBPACKAGE_DEPS content
    awk '
      /SUBPACKAGE_DEPS = \[/ {
        print;
        in_list=1;
        next
      } in_list && /\]/ {
        print;
        in_list=0;
        next
      } !in_list {print}' ${file_path} > "/tmp/BUILD.bazel.step4" && \
      cp "/tmp/BUILD.bazel.step4" $file_path
  fi
done < ${files}
