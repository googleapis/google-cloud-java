# generation_config.yaml Schema

The `generation_config.yaml` file at the root of the repository controls the generation of all client libraries.

## Key Fields

- `gapic_generator_version`: The version of the GAPIC generator used globally (unless overridden).
- `googleapis_commitish`: The commit of the `googleapis` repository used as the source for protos.
- `libraries`: A list of library configurations.

### Library Configuration Fields

**Required (always present):**
- `api_shortname`: (String) Identifier (e.g., `alloydb`).
- `name_pretty`: (String) Display name (e.g., `AlloyDB API`).
- `product_documentation`: (URL) Product documentation URL.
- `api_description`: (String) Service description.
- `client_documentation`: (URL) Auto-generated link to the generated client docs.
- `release_level`: (String) Usually `preview` for new libraries.
- `distribution_name`: (String) Maven coordinates (e.g., `com.google.cloud:google-cloud-alloydb`).
- `api_id`: (String) API identifier (e.g., `alloydb.googleapis.com`).
- `library_type`: (String) Usually `GAPIC_AUTO`.
- `group_id`: (String) Maven group ID (e.g., `com.google.cloud`).
- `cloud_api`: (Boolean) `true` if distribution name starts with `google-cloud-`.
- `GAPICs`: (List) List of proto paths to generate from.
  - `proto_path`: (String) Path to versioned protos (must include version, e.g., `google/cloud/alloydb/v1`).

**Optional:**
- `library_name`: (String) Override the output directory name (without `java-` prefix).
- `rest_documentation`: (URL) REST reference documentation URL.
- `rpc_documentation`: (URL) RPC/proto reference documentation URL.
- `requires_billing`: (Boolean) Whether billing is required (default: `true`).
- `api_reference`: (URL) API reference documentation link.
- `codeowner_team`: (String) GitHub team responsible for this library.
- `googleapis_commitish`: (String) Pin to a specific `googleapis/googleapis` commit (overrides repo-level setting).
- `issue_tracker`: (URL) Issue tracker for this library.
- `extra_versioned_modules`: (String) Extra modules managed via `versions.txt`.
- `excluded_dependencies`: (String) Comma-separated dependencies excluded from postprocessing.
- `excluded_poms`: (String) Comma-separated pom files excluded from postprocessing.

## Example Library Entry

```yaml
- api_shortname: alloydb
  name_pretty: AlloyDB API
  product_documentation: https://cloud.google.com/alloydb/docs
  api_description: AlloyDB for PostgreSQL is an open source-compatible database service.
  client_documentation: https://cloud.google.com/java/docs/reference/google-cloud-alloydb/latest/overview
  release_level: preview
  distribution_name: com.google.cloud:google-cloud-alloydb
  api_id: alloydb.googleapis.com
  library_type: GAPIC_AUTO
  group_id: com.google.cloud
  cloud_api: true
  GAPICs:
  - proto_path: google/cloud/alloydb/v1
```
