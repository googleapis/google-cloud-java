---
name: new-client-library-generator
description: Generates new Google Cloud Java client libraries by processing service information and updating the hermetic build configuration. Use this skill when tasked with onboarding a new service or version to the google-cloud-java repository.
---

# New Client Library Generator

This skill automates the process of adding a new client library to the `google-cloud-java` repository using the hermetic build system. It retrieves service information from a Buganizer ticket and runs the configuration script to update `generation_config.yaml`.

## Workflow

### 1. Retrieve Service Information from Buganizer

Use the available Buganizer MCP server to fetch the ticket content. Extract the following fields:

**Required:**
- `api_shortname`: Unique service identifier (e.g., `alloydb`).
- `name_pretty`: Human-friendly name (e.g., `AlloyDB API`).
- `proto_path`: Versioned path to protos (e.g., `google/cloud/alloydb/v1`). Must include the version component — root-level paths like `google/cloud/alloydb` are not supported.
- `product_docs`: Product documentation URL (must start with `https://`).
- `api_description`: First sentence of the service summary.

**Optional:**
- `rest_docs`: REST reference documentation URL.
- `rpc_docs`: RPC/proto reference documentation URL.
- `library_name`: Override the default `java-<api_shortname>` directory name.
- `distribution_name`: Override Maven coordinates (default: `com.google.cloud:google-cloud-<api_shortname>`).

For the field-to-flag mapping, see [references/cloud_drop_mapping.md](references/cloud_drop_mapping.md) (service config YAML fields → script flags).

### 2. Check for Conflicts

Before running the script, verify `api_shortname` is not already in use:

```bash
grep "api_shortname: <API_SHORTNAME>" generation_config.yaml
```

If a conflict exists, determine a unique name or use `--library-name` to set a distinct directory. See [references/generation_guide.md](references/generation_guide.md) for examples.

### 3. Special Cases

Some APIs require non-default Maven coordinates and `api_shortname` values:

| Proto path prefix   | `--api-shortname`            | `--distribution-name`                                    |
|---------------------|------------------------------|----------------------------------------------------------|
| `google/maps/*`     | `maps-<api_short_name>`      | `com.google.maps:google-maps-<api_short_name>`           |
| `google/shopping/*` | `shopping-<api_short_name>`  | `com.google.shopping:google-shopping-<api_short_name>`   |

where `<api_short_name>` is the value from the Buganizer ticket.

### 4. Execution

Run the script with the gathered information:

```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py add-new-library \
  --api-shortname="[API_SHORTNAME]" \
  --name-pretty="[NAME_PRETTY]" \
  --proto-path="[PROTO_PATH]" \
  --product-docs="[PRODUCT_DOCS]" \
  --api-description="[API_DESCRIPTION]" \
  [OPTIONAL_FLAGS]
```

The script modifies `generation_config.yaml` and sorts the `libraries` list alphabetically.

To see all available flags:
```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py add-new-library --help
```

### 5. Verification

After execution:
1. Confirm `generation_config.yaml` has a new entry with the correct fields. See [references/generation_config_schema.md](references/generation_config_schema.md).
2. Confirm `proto_path` under `GAPICs` includes a version component (e.g., `v1`, `v1beta`, `v1alpha`).
3. Confirm `product_documentation` starts with `https://`.

### 6. Create a Branch and PR

After verifying the changes:

```bash
git checkout -b "new-library/[API_SHORTNAME]"
git add generation_config.yaml
git commit -m "feat: [API_SHORTNAME] new module for [API_SHORTNAME]"
```

Then open a pull request. Include the exact `add-new-library` command and arguments used in the PR body. Add the `owlbot:run` label so the hermetic build workflow generates the library code.
