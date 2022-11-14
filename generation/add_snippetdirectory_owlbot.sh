#!/bin/bash

# If generated samples directory doesn't exist yet, add it to the owlbot config

# Usage:
# add_snippetdirectory_owlbot.sh <.OwlBot.yaml path from the root>
# Example:
# $ add_snippetdirectory_owlbot.sh java-dataform/.OwlBot.yaml
#
# To apply the change to all OwlBot configuration files in all modules:
# $ for F in `find . -maxdepth 2 -name '.OwlBot.yaml'`; do sh generation/add_snippetdirectory_owlbot.sh $F; done

OWLBOT_FILE=$1

if [ -z "${OWLBOT_FILE}" ]; then
  echo "Please specify file name"
  exit 1
fi

if [ ! -r "${OWLBOT_FILE}" ]; then
  echo "File not found"
  exit 1
fi

dir_name=$(dirname "${OWLBOT_FILE}")
module_name=$(basename "${dir_name}")

if [ ! -d "${module_name}" ]; then
  echo "module ${module_name} does not exist"
  exit 1
fi



# If snippets are already being copied, exit out
if grep -q samples/snippets/generated ${OWLBOT_FILE}; then
  echo "module ${module_name} already copies generated snippets"
  exit 1
  fi


# Insert into `deep-remove-regex:` section
deep_remove_regex="- \"\/${module_name}\/samples\/snippets\/generated\""
entry_before_deep_remove_regex="${module_name}\/google-.*\/src"
sed -i "/${entry_before_deep_remove_regex}/a ${deep_remove_regex}" ${OWLBOT_FILE}

# Insert into `deep-copy-regex:` section
deep_copy_regex="- source: \"/google/cloud/${dir_name}/(v.*)/.*-java/samples/snippets/generated\"\n  dest: \"/owl-bot-staging/${module_name}/\$1/samples/snippets/generated\""

entry_before_deep_copy_regex="dest: \"\/owl-bot-staging\/${module_name}\/\$1\/google-"

sed -i "/${entry_before_deep_copy_regex}/a ${deep_copy_regex}" ${OWLBOT_FILE}

# Remove duplicate lines
perl -i -ne 'if ( /^\s*#/ ) { print } else { print if ! $SEEN{$_}++}' ${OWLBOT_FILE}

# Add back new lines between sections
sed -i  's/deep-copy-regex/\n&/g'  ${OWLBOT_FILE}
sed -i  's/deep-remove-regex/\n&/g'  ${OWLBOT_FILE}
sed -i  's/deep-preserve-regex/\n&/g'  ${OWLBOT_FILE}
sed -i  's/api-name/\n&/g'  ${OWLBOT_FILE}