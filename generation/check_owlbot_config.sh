#!/bin/bash

# Checks that each module's .OwlbotYaml file is correctly configured according to the template set in `set_owlbot_config.sh`

OWLBOT_FILE=$1
for F in $(find . -maxdepth 2 -name '.OwlBot.yaml'); do sh generation/set_owlbot_config.sh "$F"; done
