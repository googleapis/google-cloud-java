#!/bin/bash

# Output file containing all modules with valid rest/rpc URLs
output_file="output.txt"

# Find all .repo-metadata.json files in the current directory
find . -type f -name '.repo-metadata.json' | while read -r file; do
    # Extract product_documentation and repo_short field values
    product_documentation=$(jq -r '.product_documentation' "$file")
    repo_short=$(jq -r '.repo_short' "$file")

    # Check if the fields are not null
    if [ "$product_documentation" != "null" ] && [ "$repo_short" != "null" ]; then
        # Use curl to get the HTTP status code
        http_status=$(curl -o /dev/null -s -w "%{http_code}" "$product_documentation")

        # If HTTP status code is 200, write the repo_short and product_documentation to the output file
        if [ "$http_status" -eq 200 ]; then
            echo "repo_short: $repo_short, product_documentation: $product_documentation" >> "$output_file"
        fi
    fi
done
