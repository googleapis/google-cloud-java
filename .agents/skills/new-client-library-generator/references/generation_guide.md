# New Client Library Generation Guide

This guide describes how to generate a new client library by:
1. Appending a new library configuration to `generation_config.yaml` using the provided scripts.
2. Relying on the automated GitHub Actions to generate the code once the configuration is pushed in a Pull Request.

## Components

### `generation/new_client_hermetic_build/add-new-client-config.py`
This script updates `generation_config.yaml` with the necessary metadata for a new library. It takes several arguments that map to fields in the configuration file.

## Local Execution

To add a new library configuration, you must run the `add-new-client-config.py` script. The parameters for this script are typically found in the **Service YAML** file linked in the Buganizer request.

### Basic Usage

```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py add-new-library \
  --api-shortname="[API_SHORTNAME]" \
  --name-pretty="[NAME_PRETTY]" \
  --proto-path="[PROTO_PATH]" \
  --product-docs="[PRODUCT_DOCS]" \
  --api-description="[API_DESCRIPTION]"
```

### Parameter Details

#### API Short Name (`--api-shortname`)
The unique identifier for the library (e.g., `alloydb`). This is used to determine the directory name and default artifact name.
- **Source:** `api_short_name` in the Service YAML.

#### Proto Path (`--proto-path`)
The path from the root of the `googleapis` repository to the directory containing the versioned proto definitions.
- **Example:** `google/cloud/alloydb/v1beta`
- **Note:** Root-level paths like `google/cloud/alloydb` are not supported.

#### Name Pretty (`--name-pretty`)
The human-friendly name of the API.
- **Source:** `title` in the Service YAML.
- **Example:** `AlloyDB API`

#### Product Docs (`--product-docs`)
The URL for the product documentation. Must start with `https://`.
- **Source:** `documentation_uri` in the Service YAML.

#### API Description (`--api-description`)
A concise summary of the API for the README.
- **Source:** `documentation.summary` or `documentation.overview` in the Service YAML. Use the first sentence.

## Prerequisites

Ensure you have the following set up in your local environment:

1. **Python 3.9+**: The scripts require Python 3.9 or higher.
2. **Dependencies**: Install the required Python packages from the root of the repository:
   ```bash
   pip install -r generation/new_client_hermetic_build/requirements.txt
   ```

## Advanced Options

For full control over the generation (e.g., overriding Maven coordinates or library names), run the script with the `--help` flag:

```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py add-new-library --help
```

### Special Case: Non-Cloud APIs
Some libraries (like Google Maps or Shopping) require special handling for Maven coordinates.

| API Path Prefix | `--api-shortname` | `--distribution-name` |
|---|---|---|
| `google/maps/*` | `maps-<shortname>` | `com.google.maps:google-maps-<shortname>` |
| `google/shopping/*` | `shopping-<shortname>` | `com.google.shopping:google-shopping-<shortname>` |
