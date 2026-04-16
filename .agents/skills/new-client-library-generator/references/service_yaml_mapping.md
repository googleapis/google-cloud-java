# Service YAML Mapping to Generation Script Parameters

This document explains how to extract information from a Service YAML file (linked in a Buganizer ticket) to populate the parameters for `generation/new_client_hermetic_build/add-new-client-config.py`.

| Service YAML Field | Script Parameter (`--flag`) | Description |
|---|---|---|
| `api_short_name` | `api-shortname` | Unique identifier for the service (e.g., `alloydb`). |
| (extracted from proto) | `proto-path` | Path from the root of the googleapis repository to the versioned proto directory (e.g., `google/cloud/alloydb/v1alpha`). Root-level paths like `google/cloud/alloydb` are not supported. |
| `title` | `name-pretty` | Human-friendly name (e.g., `AlloyDB API`). |
| `documentation_uri` | `product-docs` | Product documentation URL. Must start with `https://`. |
| `rest_reference_documentation_uri` | `rest-docs` | REST documentation URL. Optional. |
| `proto_reference_documentation_uri` | `rpc-docs` | RPC/Proto documentation URL. Optional. |
| `documentation.summary` or `documentation.overview` | `api-description` | Concise summary of the service. Use the first sentence. |

## Example Mapping

**Service YAML File excerpt:**
```yaml
title: "Discovery Engine API"
api_short_name: "discoveryengine"
documentation_uri: "https://cloud.google.com/generative-ai-app-builder/docs/introduction"
rest_reference_documentation_uri: "https://cloud.google.com/generative-ai-app-builder/docs/reference/rest"
proto_reference_documentation_uri: "https://cloud.google.com/generative-ai-app-builder/docs/reference/rpc"
documentation:
  summary: "Discovery Engine for Search and Recommendations"
```

**Protos in `googleapis` repository:**
`google/cloud/discoveryengine/v1/`

**Generated Command:**
```bash
python3 generation/new_client_hermetic_build/add-new-client-config.py add-new-library \
  --api-shortname="discoveryengine" \
  --name-pretty="Discovery Engine API" \
  --proto-path="google/cloud/discoveryengine/v1" \
  --product-docs="https://cloud.google.com/generative-ai-app-builder/docs/introduction" \
  --rest-docs="https://cloud.google.com/generative-ai-app-builder/docs/reference/rest" \
  --rpc-docs="https://cloud.google.com/generative-ai-app-builder/docs/reference/rpc" \
  --api-description="Discovery Engine for Search and Recommendations"
```
