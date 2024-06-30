#!/bin/bash

# Close the issues created by repo-metadata validation
for R in `cat repositories.txt`; do
  echo $R
  gh issue list -R googleapis/${R} 
  if [ "$?" == "0" ]; then
    N=$(gh issue list -R googleapis/${R} --search 'label:"repo-metadata: lint"' |perl -nle 'print $1 if m/(\d+)/' |head -1)
    if [ -n "${N}" ]; then
      gh issue close "${N}" -R googleapis/${R}
    fi
  fi
  echo
done
