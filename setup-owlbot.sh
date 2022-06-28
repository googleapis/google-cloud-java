#!/bin/bash

repo="$HOME/Documents/java-temp/monorepo/owlbot/google-cloud-java/repos.txt"

while IFS= read -r line; do
    pushd $line > /dev/null
    echo "$line"
    if [[ -f "$HOME/Documents/java-temp/monorepo/owlbot/google-cloud-java/$line/.OwlBot.yaml" ]]; then
        sed -i '/docker/d' .OwlBot.yaml
        sed -i '/image/d' .OwlBot.yaml
        text=$(grep '^.*api_shortname.*' .repo-metadata.json)
        text=$(echo "$text" | sed 's/\"//g; s/\,//g; s/^[[:space:]]*//' )
        text=${text/api_shortname/api-name}
        echo -e "\n"$text>> .OwlBot.yaml
    fi
    popd
done < "$repo"
