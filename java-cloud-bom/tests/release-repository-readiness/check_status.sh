# Given the repositories are checked out in the WORK_DIR below
# find the shared dependencies BOM version in current release
# and find any missing updates.

set -ef

WORK_DIR=/tmp/release-readiness

if [[ ! -d "${WORK_DIR}/sdk-platform-java" ]]; then
  echo "The repositories are missing in ${WORK_DIR}. Please use clone_repositories.sh first"
  exit 1
fi

cd "${WORK_DIR}/sdk-platform-java"
expected_shared_deps_version=$(mvn -pl java-shared-dependencies help:evaluate -Dexpression=project.version -q -DforceStdout)
expected_generator_version=$(mvn -pl gapic-generator-java help:evaluate -Dexpression=project.version -q -DforceStdout)
echo "Expected google-cloud-shared-dependencies BOM version: ${expected_shared_deps_version}"
echo "Expected GAPIC generator Java version: ${expected_generator_version}"


function check_shared_dependency_status() {
  local project=$1
  local actual_shared_deps_version=$(mvn -pl ${project} help:evaluate -Dexpression=google-cloud-shared-dependencies.version -q -DforceStdout)
  if [[ "${expected_shared_deps_version}" != "${actual_shared_deps_version}" ]]; then
    local shared_deps_status="! ${actual_shared_deps_version}"
  else
    local shared_deps_status="OK"
  fi
  echo "${shared_deps_status}"
}

function check_generated_code_status() {
  if [ -r "generation_config.yaml" ]; then
    local actual_generator_version=$(perl -nle 'print $1 if m/gapic_generator_version:\s*(.+)/' generation_config.yaml)
    if [[ "${expected_generator_version}" != "${actual_generator_version}" ]]; then
        local generator_status="! ${actual_generator_version}"
    else
        local generator_status="OK"
    fi
  else
    local generator_status="N/A"
  fi
  echo "${generator_status}"
}
echo ",        main,      released" |\
    awk -F',' '{printf "%-20s|%-21s|%-21s|\n", $1, $2, $3}'

echo "    repository,shared dep,code gen,shared dep,code gen" |\
    awk -F',' '{printf "%-20s|%-10s|%-10s|%-10s|%-10s|\n", $1, $2, $3, $4, $5}'

repositories=$(find "${WORK_DIR}" -mindepth 1 -maxdepth 1 -type d -not -name "sdk-platform-java")
for repo_folder in $repositories; do
  cd "${repo_folder}"
  repo=$(basename "${repo_folder}")
  git fetch -q origin main > /dev/null
  git checkout -q main  > /dev/null
  git pull -q origin main > /dev/null
  if [[ "$repo" == "google-cloud-java" ]]; then
    # In google-cloud-java repository, the parent pom module
    # inherits the property.
    project=google-cloud-pom-parent
  else
    # In normal handwritten libraries, the root project receives the property.
    project=.
  fi
  shared_deps_status_main=$(check_shared_dependency_status "${project}")
  generated_code_status_main=$(check_generated_code_status)

  last_release_tag=$(gh release list --limit 1 --order desc --json 'tagName' --jq '.[].tagName')
  git fetch -q origin tag  ${last_release_tag} --no-tags > /dev/null
  git checkout -q ${last_release_tag} > /dev/null
  shared_deps_status_last_release=$(check_shared_dependency_status "${project}")
  generated_code_status_last_release=$(check_generated_code_status)

  echo "${repo},${shared_deps_status_main},${generated_code_status_main},\
${shared_deps_status_last_release},${generated_code_status_last_release}" | \
    awk -F',' '{printf "%-20s|%-10s|%-10s|%-10s|%-10s|\n", $1, $2, $3, $4, $5}'
done



