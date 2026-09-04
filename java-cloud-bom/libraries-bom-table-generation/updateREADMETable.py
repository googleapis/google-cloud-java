import subprocess
import xml.etree.ElementTree as ET
import yaml
import re

def run_maven_flatten():
  subprocess.run(['mvn', 'flatten:flatten'])

def run_maven_flatten_clean():
  subprocess.run(['mvn', 'flatten:clean'])

run_maven_flatten()
# Load the flattened pom.xml file
pom_file = "libraries-bom/.flattened-pom.xml"
namespaces = {
    "m": "http://maven.apache.org/POM/4.0.0"
}
tree = ET.parse(pom_file)
root = tree.getroot()

# Load the metadata
with open('libraries-bom-table-generation/javaModulesMetadata.yaml', 'r', encoding='utf-8') as metadata_file:
  metadata = yaml.safe_load(metadata_file)

# Manual list of runtime modules
runtime_modules = ['google-http-client',
                   'gax',
                   'api-common',
                   'google-cloud-core',
                   'google-iam-policy',
                   'google-auth-library',
                   ]

# List of modules to ignore for table creation
modules_to_skip = ['libraries-bom',
                   'gapic-libraries-bom',
                   'github-repo',
                   'gax-httpjson',
                   'google-cloud-shared-dependencies',
                   'first-party-dependencies',
                   'full-convergence-check',
                   'gapic-generator-java',
                   'java-cloud-bom-tests',
                   'gax-grpc',
                   'grpc-google-',
                   'proto-google-',
                   'google-cloud-bom',
                   'google-cloud-java',
                   'google-java-format',
                   'google-api-client',
                   'google-http-client-',
                   'grpc-',
                   'protobuf-',
                   'guava',
                   'protoc',
                   'gson',
                   'google-oauth',
                   'google-auth-library-oauth2-http',
                   'google-auth-library-appengine',
                   'google-cloud-bigtable-emulator',
                   'auto-value-annotations',
                   'gapic-google-cloud-storage-v2',
                   'google-cloud-core-grpc',
                   'google-cloud-core-http',
                   'google-cloud-firestore-admin',
                   'google-cloud-spanner-executor',
                   'google-cloud-bigtable-stats' #exclude per https://github.com/googleapis/java-bigtable/blob/v2.32.0/pom.xml#L334
                   ]
regex_modules_to_skip = "(" + ")|(".join(modules_to_skip) + ")"

# Prepare the dependencies list
dependencies = []

# Iterate over the dependencies in the flattened pom.xml
for dependency in root.findall(".//m:dependencies/m:dependency", namespaces):
  artifactId = dependency.find("m:artifactId", namespaces)
  version = dependency.find("m:version", namespaces)
  # If the dependency is in the list of modules to skip, continue to next iteration
  if re.match(regex_modules_to_skip, artifactId.text):
    continue
  # Generate a unique key for each dependency using artifactId and version
  dependency_key = (artifactId.text, version.text)
  # Check if the dependency is already encountered
  if dependency_key not in dependencies:
    # Add the dependency to the list
    dependencies.append(dependency_key)

# Alphabetize the output list by the 'artifact' key
dependencies.sort(key=lambda dep: dep[0])

# Generate Markdown table
table = "| Artifact ID | Library Type | Google Cloud Library Reference | Google Cloud Product Reference | \n"
table += "| --------- | ------------ | ------------ | ------------ |\n"

# Iterate over the sorted dependencies and append the rows to the markdown table
for artifact_id, version in dependencies:
  # Use aggregated artifact_id for google-auth-library
  if artifact_id == 'google-auth-library-credentials':
    artifact_id = 'google-auth-library'

  if artifact_id in runtime_modules:
    library_type = "Runtime"
  else:
    library_type = "Product"

  # Get name_pretty and product reference link from javaModulesMetadata.yaml
  metadata_value = metadata.get(artifact_id)
  if metadata_value is not None:
    product_reference_link = metadata_value.split(",")[0].strip()
    name_pretty = metadata_value.split(",")[1].strip()
  else:
    name_pretty = "N/A"
    product_reference_link = "N/A"

  # Convert reference links to hyperlinks
  library_reference_link = f"https://cloud.google.com/java/docs/reference/{artifact_id}/latest/overview"
  library_reference_hyperlink = f"[{version}]({library_reference_link})"
  product_reference_hyperlink = f"[{name_pretty}]({product_reference_link})" if product_reference_link != 'N/A' else 'N/A'

  # Append the dependency to the table
  table += f"| {artifact_id} | {library_type} | {library_reference_hyperlink} | {product_reference_hyperlink} |\n"

with open('README.md', 'r', encoding='utf-8') as readme_file:
  readme = readme_file.read()

# Update existing table in README.md
table_start_comment = "<!-- TABLE_START -->"
table_end_comment = "<!-- TABLE_END -->"
table_pattern = re.compile(r'(?s)<!-- TABLE_START -->.*?<!-- TABLE_END -->')
updated_readme = table_pattern.sub(table_start_comment + "\n" + table + table_end_comment, readme)

with open('README.md', 'w', encoding='utf-8') as readme_file:
  readme_file.write(updated_readme)
run_maven_flatten_clean()