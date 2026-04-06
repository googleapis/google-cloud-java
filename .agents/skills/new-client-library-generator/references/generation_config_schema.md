# generation_config.yaml Schema

The `generation_config.yaml` file at the root of the repository controls the generation of all client libraries.

## Key Fields

- `gapic_generator_version`: The version of the GAPIC generator used globally (unless overridden).
- `googleapis_commitish`: The commit of the `googleapis` repository used as the source for protos.
- `libraries`: A list of library configurations.

### Library Configuration Fields

- `api_shortname`: (String) Identifier (e.g., `alloydb`).
- `name_pretty`: (String) Display name (e.g., `AlloyDB API`).
- `product_documentation`: (URL) Product documentation.
- `api_description`: (String) Service description.
- `client_documentation`: (URL) Link to the generated client docs.
- `release_level`: (String) Usually `preview` for new libraries.
- `distribution_name`: (String) Maven coordinates (e.g., `com.google.cloud:google-cloud-alloydb`).
- `api_id`: (String) API identifier (e.g., `alloydb.googleapis.com`).
- `library_type`: (String) Usually `GAPIC_AUTO`.
- `group_id`: (String) Maven group ID.
- `cloud_api`: (Boolean) True if it's a Cloud API.
- `GAPICs`: (List) List of proto paths to generate from.
  - `proto_path`: (String) Path to versioned protos.

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
