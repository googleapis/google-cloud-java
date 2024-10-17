#!/bin/bash

# List issues in the repositories
for R in `cat repositories.txt`; do
  echo $R
  gh issue list -R googleapis/${R}
  echo
done
