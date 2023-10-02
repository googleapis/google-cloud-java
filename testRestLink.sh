#!/bin/bash

# Input and Output files
input_file="output.txt"
new_output_file="valid_new_links.txt"

# Read the input file line by line
while read -r line; do
    # Extract repo_short and product_documentation from the line
    repo_short=$(echo "$line" | awk -F', ' '{print $1}' | awk -F': ' '{print $2}')
    product_documentation=$(echo "$line" | awk -F', ' '{print $2}' | awk -F': ' '{print $2}')

    # Check if product_documentation ends with docs/
    if [[ "$product_documentation" == *"docs/" ]]; then
        # Append "reference/rest" to product_documentation
        rest_documentation="${product_documentation}reference/rest"
        rpc_documentation="${product_documentation}reference/rpc"
    elif [[ "$product_documentation" == *"docs" ]]; then
        # Add "/reference/rest" to product_documentation
        rest_documentation="${product_documentation}/reference/rest"
        rpc_documentation="${product_documentation}/reference/rpc"
    elif [[ "$product_documentation" == *"/" ]]; then
      rest_documentation="${product_documentation}docs/reference/rest"
      rpc_documentation="${product_documentation}docs/reference/rpc"
    else
        rest_documentation="${product_documentation}/docs/reference/rest"
        rpc_documentation="${product_documentation}/docs/reference/rpc"
    fi
    http_status_rest=$(curl -o /dev/null -s -w "%{http_code}" "$rest_documentation")
    http_status_rpc=$(curl -o /dev/null -s -w "%{http_code}" "$rpc_documentation")
    # Write the repo_short and valid documentation links to the output file
    if [[ "$http_status_rest" -eq 200 && "$http_status_rpc" -eq 200 ]]; then
        # Write the repo_short and new rest_documentation to a new output file
        echo "repo_short: $repo_short, rest_documentation: $rest_documentation, rpc_documentation: $rpc_documentation" >> "$new_output_file"
    elif [ "$http_status_rest" -eq 200 ]; then
      echo "repo_short: $repo_short, rest_documentation: $rest_documentation" >> "$new_output_file"
    elif [ "$http_status_rpc" -eq 200 ]; then
          echo "repo_short: $repo_short, rpc_documentation: $rpc_documentation" >> "$new_output_file"
    else
      continue
    fi
done < "$input_file"
