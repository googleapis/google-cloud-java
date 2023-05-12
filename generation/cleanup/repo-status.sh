#!/bin/bash

# Given a repositories.txt containing repositories under googleapis org, this script captures 5 things about each repository
# 1. owlbot status (0=inactive, 1=active)
# 2. release-please status (0=inactive, 1=active)
# 3. renovate bot status (0=inactive, 1=active)
# 4. open issues count
# 5. open pull requests count

set +e

for repository in $(cat repositories.txt); do
  owlbot_file_url=https://raw.githubusercontent.com/googleapis/${repository}/main/.github/.OwlBot.yaml
  curl ${owlbot_file_url} --fail --silent >/dev/null
  status_1=$?

  if [ ${status_1} = 0 ]; then
    owlbot="1"
  else
    owlbot="0"
  fi

  release_please_url=https://raw.githubusercontent.com/googleapis/${repository}/main/.github/release-please.yml
  curl ${release_please_url} --fail --silent >/dev/null
  status_2=$?
  if [ ${status_2} = 0 ]; then
    release_please="1"
  else
    release_please="0"
  fi

  renovate_bot_url=$(curl -s https://raw.githubusercontent.com/googleapis/${repository}/main/renovate.json)
  if grep -q "\"enabled\":\s*false" <<<"$renovate_bot_url"; then
    renovate="0"
  else
    renovate="1"
  fi

  open_issues_count=$(gh issue list -R googleapis/${repository} -L 100 -s open | wc -l)
  open_pull_requests=$(gh pr list -R googleapis/${repository} -L 100 -s open | wc -l)

  echo "${repository},${owlbot},${release_please},${renovate},${open_issues_count},${open_pull_requests}" >>status.csv
done
