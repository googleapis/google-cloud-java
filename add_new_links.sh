#!/bin/bash

# Input file
input_file="valid_new_links.txt"

# Read the input file line by line
while IFS=, read -r part1 part2 part3; do
    # Extract repo_short, rest_documentation, and rpc_documentation from the line
    repo_short=$(echo "$part1" | awk -F': ' '{print $2}' | xargs)
    rest_documentation=$(echo "$part2" | awk -F': ' '{print $2}' | xargs)
    rpc_documentation=$(echo "$part3" | awk -F': ' '{print $2}' | xargs)

    # Find the repo-metadata.json file for each repo_short
    repo_metadata_file=$(find . -type f -name '.repo-metadata.json' | grep "/$repo_short/")

    # Check and add rest_documentation and rpc_documentation to the repo-metadata.json file
    if [[ -n "$repo_metadata_file" ]]; then
        # Use jq to update the JSON only if the documentation fields are not empty
        jq_cmd='.'
        if [[ -n "$rest_documentation" ]]; then
            jq_cmd+=' | . + {rest_documentation: $rest_doc}'
        fi
        if [[ -n "$rpc_documentation" ]]; then
            jq_cmd+=' | . + {rpc_documentation: $rpc_doc}'
        fi

        jq --arg rest_doc "$rest_documentation" --arg rpc_doc "$rpc_documentation" "$jq_cmd" "$repo_metadata_file" > temp.json && mv temp.json "$repo_metadata_file"
    fi
done < "$input_file"