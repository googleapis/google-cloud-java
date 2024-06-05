#!/bin/bash

# Sets the version of a module (the top-level directory in google-cloud-java, such as
# java-accessapproval) in the google-cloud-java repository to 1.0.0.
# You need to call this script from the root directory on the Release Please pull request branch;
# otherwise the changes to the versions are overridden by the Release Please.

set -eo pipefail

# Pattern to match the lines in versions.txt. Usually it's the library_name for a module,
# as in the generation_config.yaml.
# For example "securityposture" for the "java-securityposture" module.
library_name=$1

if [ -z "${library_name}" ]; then
  echo "Please specify library_name that matches the pattern in versions.txt."
  echo "Example: 'securityposture'"
  exit 1
fi
versions_file=versions.txt

sed -i -E "s/^(.*${library_name}(-v.+)?):0.+:.+/\1:1.0.0:1.0.0/g" "${versions_file}"

# Guardrail for bad pattern
set +e
diff_lines_count=$(git diff --unified=0 versions.txt |grep -c "^[+-]\w")

if ! grep --quiet -E "${library_name}-v[1-9]:" versions.txt; then
  echo "The module does not seem to have a GA server API version (>= v1)."
  echo "A library should not become 1.0.0 before the server API releases v1 (go/client-quality)"
  exit 1
fi

set -e
if [[ "${diff_lines_count}" -eq 0 ]]; then
  echo "There's no matching lines in versions.txt for ${library_name}."
  echo "Check the hyphenation in the versions.txt."
  exit 1
fi
if [[ "${diff_lines_count}" -gt 10 ]]; then
  echo "There are more than 5 lines changed. The pattern (${library_name}) is too generic. Failing this script for safe side."
  exit 1
fi

SED_OPTIONS=""
for KV in $(cut -f1,3 -d: "${versions_file}" |grep -v "#" | grep "${library_name}"); do
  K=${KV%:*}; V=${KV#*:}
  echo Key:$K, Value:$V;
  SED_OPTIONS="$SED_OPTIONS -e /x-version-update:$K:current/{s|<version>.*<\/version>|<version>$V<\/version>|;}"
done

find . -maxdepth 3 -name pom.xml |sort --dictionary-order |xargs sed -i.bak $SED_OPTIONS
# Clean up unnecessary backup files
find . -maxdepth 3 -name pom.xml.bak |xargs rm
