---
name: new-client-library-generator
description: Generates new Google Cloud Java client libraries by processing service information and updating the hermetic build configuration. Use this skill when tasked with onboarding a new service or version to the google-cloud-java repository.
---

# New Client Library Generator

This skill automates the process of adding a new client library to the `google-cloud-java` repository using the hermetic build system. It guides the extraction of service information from Cloud Drop files and handles the execution of the configuration script.

## Workflow

### 1. Information Gathering

The skill expects service information, typically found in a "Cloud Drop" YAML file or a Buganizer ticket.

**Triggers:**
- "Generate a new client library for [Service Name]"
- "Add a new library using this Cloud Drop: [URL]"
- "Process this Buganizer request: [Bug ID]"

**Required Information:**
- `api_shortname`: Unique service identifier.
- `name_pretty`: Human-friendly name.
- `proto_path`: Path to versioned protos (e.g., `google/cloud/service/v1`).
- `product_docs`: Documentation URL.
- `api_description`: Brief summary.

For mapping details, refer to [references/cloud_drop_mapping.md](references/cloud_drop_mapping.md).

### 2. Fetching & Processing

If a URL or Buganizer ID is provided, use any available MCP servers to fetch the content.
- If an MCP server for `googleapis` is available, use it to find the Cloud Drop YAML.
- If a Buganizer MCP server is available, use it to find the Cloud Drop link in the ticket.

### 3. Execution

Once information is gathered and mapped, run the following script:

```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py generate \
  --api-shortname="[API_SHORTNAME]" \
  --name-pretty="[NAME_PRETTY]" \
  --proto-path="[PROTO_PATH]" \
  --product-docs="[PRODUCT_DOCS]" \
  --api-description="[API_DESCRIPTION]" \
  [OPTIONAL_FLAGS]
```

**Note:** The script will modify `generation_config.yaml` and sort the `libraries` list.

### 4. Verification

After execution, verify that:
1. `generation_config.yaml` has been updated with the new entry.
2. The library entry contains the correct fields. Refer to [references/generation_config_schema.md](references/generation_config_schema.md) for field definitions.

## Advanced Usage

For more complex scenarios, such as overriding the library name or Maven coordinates, refer to [references/generation_guide.md](references/generation_guide.md).

### Common Optional Flags
- `--rest-docs`: URL for REST documentation.
- `--rpc-docs`: URL for RPC/Proto documentation.
- `--library-name`: Override the default `java-<api_shortname>` directory.
- `--distribution-name`: Override Maven coordinates (default: `com.google.cloud:google-cloud-<api_shortname>`).
