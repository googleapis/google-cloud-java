# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""This script is used to synthesize generated parts of this library."""

import synthtool as s
import synthtool.languages.java as java

AUTOSYNTH_MULTIPLE_COMMITS = True

service = 'vision'
versions = ['v1', 'v1p1beta1', 'v1p2beta1', 'v1p3beta1', 'v1p4beta1']

for version in versions:
  library = java.bazel_library(
      service=service,
      version=version,
      bazel_target=f'//google/cloud/{service}/{version}:google-cloud-{service}-{version}-java',
  )

java.common_templates()

# restore deprecated resource name helpers
# TODO: remove in version 2.0.0
DEPRECATED_RESOURCE_NAME_HELPERS = """

private static final PathTemplate LOCATION_PATH_TEMPLATE =
    PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}");

private static final PathTemplate PRODUCT_PATH_TEMPLATE =
    PathTemplate.createWithoutUrlEncoding(
        "projects/{project}/locations/{location}/products/{product}");

private static final PathTemplate PRODUCT_SET_PATH_TEMPLATE =
    PathTemplate.createWithoutUrlEncoding(
        "projects/{project}/locations/{location}/productSets/{product_set}");

private static final PathTemplate REFERENCE_IMAGE_PATH_TEMPLATE =
    PathTemplate.createWithoutUrlEncoding(
        "projects/{project}/locations/{location}/products/{product}/referenceImages/{reference_image}");

/**
  * Formats a string containing the fully-qualified path to represent a location resource.
  *
  * @deprecated Use the {@link LocationName} class instead.
  */
@Deprecated
public static final String formatLocationName(String project, String location) {
  return LOCATION_PATH_TEMPLATE.instantiate(
      "project", project,
      "location", location);
}

/**
  * Formats a string containing the fully-qualified path to represent a product resource.
  *
  * @deprecated Use the {@link ProductName} class instead.
  */
@Deprecated
public static final String formatProductName(String project, String location, String product) {
  return PRODUCT_PATH_TEMPLATE.instantiate(
      "project", project,
      "location", location,
      "product", product);
}

/**
  * Formats a string containing the fully-qualified path to represent a product_set resource.
  *
  * @deprecated Use the {@link ProductSetName} class instead.
  */
@Deprecated
public static final String formatProductSetName(
    String project, String location, String productSet) {
  return PRODUCT_SET_PATH_TEMPLATE.instantiate(
      "project", project,
      "location", location,
      "product_set", productSet);
}

/**
  * Formats a string containing the fully-qualified path to represent a reference_image resource.
  *
  * @deprecated Use the {@link ReferenceImageName} class instead.
  */
@Deprecated
public static final String formatReferenceImageName(
    String project, String location, String product, String referenceImage) {
  return REFERENCE_IMAGE_PATH_TEMPLATE.instantiate(
      "project", project,
      "location", location,
      "product", product,
      "reference_image", referenceImage);
}

/**
  * Parses the project from the given fully-qualified path which represents a location resource.
  *
  * @deprecated Use the {@link LocationName} class instead.
  */
@Deprecated
public static final String parseProjectFromLocationName(String locationName) {
  return LOCATION_PATH_TEMPLATE.parse(locationName).get("project");
}

/**
  * Parses the location from the given fully-qualified path which represents a location resource.
  *
  * @deprecated Use the {@link LocationName} class instead.
  */
@Deprecated
public static final String parseLocationFromLocationName(String locationName) {
  return LOCATION_PATH_TEMPLATE.parse(locationName).get("location");
}

/**
  * Parses the project from the given fully-qualified path which represents a product resource.
  *
  * @deprecated Use the {@link ProductName} class instead.
  */
@Deprecated
public static final String parseProjectFromProductName(String productName) {
  return PRODUCT_PATH_TEMPLATE.parse(productName).get("project");
}

/**
  * Parses the location from the given fully-qualified path which represents a product resource.
  *
  * @deprecated Use the {@link ProductName} class instead.
  */
@Deprecated
public static final String parseLocationFromProductName(String productName) {
  return PRODUCT_PATH_TEMPLATE.parse(productName).get("location");
}

/**
  * Parses the product from the given fully-qualified path which represents a product resource.
  *
  * @deprecated Use the {@link ProductName} class instead.
  */
@Deprecated
public static final String parseProductFromProductName(String productName) {
  return PRODUCT_PATH_TEMPLATE.parse(productName).get("product");
}

/**
  * Parses the project from the given fully-qualified path which represents a product_set resource.
  *
  * @deprecated Use the {@link ProductSetName} class instead.
  */
@Deprecated
public static final String parseProjectFromProductSetName(String productSetName) {
  return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("project");
}

/**
  * Parses the location from the given fully-qualified path which represents a product_set
  * resource.
  *
  * @deprecated Use the {@link ProductSetName} class instead.
  */
@Deprecated
public static final String parseLocationFromProductSetName(String productSetName) {
  return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("location");
}

/**
  * Parses the product_set from the given fully-qualified path which represents a product_set
  * resource.
  *
  * @deprecated Use the {@link ProductSetName} class instead.
  */
@Deprecated
public static final String parseProductSetFromProductSetName(String productSetName) {
  return PRODUCT_SET_PATH_TEMPLATE.parse(productSetName).get("product_set");
}

/**
  * Parses the project from the given fully-qualified path which represents a reference_image
  * resource.
  *
  * @deprecated Use the {@link ReferenceImageName} class instead.
  */
@Deprecated
public static final String parseProjectFromReferenceImageName(String referenceImageName) {
  return REFERENCE_IMAGE_PATH_TEMPLATE.parse(referenceImageName).get("project");
}

/**
  * Parses the location from the given fully-qualified path which represents a reference_image
  * resource.
  *
  * @deprecated Use the {@link ReferenceImageName} class instead.
  */
@Deprecated
public static final String parseLocationFromReferenceImageName(String referenceImageName) {
  return REFERENCE_IMAGE_PATH_TEMPLATE.parse(referenceImageName).get("location");
}

/**
  * Parses the product from the given fully-qualified path which represents a reference_image
  * resource.
  *
  * @deprecated Use the {@link ReferenceImageName} class instead.
  */
@Deprecated
public static final String parseProductFromReferenceImageName(String referenceImageName) {
  return REFERENCE_IMAGE_PATH_TEMPLATE.parse(referenceImageName).get("product");
}

/**
  * Parses the reference_image from the given fully-qualified path which represents a
  * reference_image resource.
  *
  * @deprecated Use the {@link ReferenceImageName} class instead.
  */
@Deprecated
public static final String parseReferenceImageFromReferenceImageName(String referenceImageName) {
  return REFERENCE_IMAGE_PATH_TEMPLATE.parse(referenceImageName).get("reference_image");
}
"""

s.replace(
  "google-cloud-vision/src/main/java/com/google/cloud/vision/v1/ProductSearchClient.java",
  "private final OperationsClient operationsClient;",
  f"private final OperationsClient operationsClient;\n{DEPRECATED_RESOURCE_NAME_HELPERS}"
)
s.replace(
  "google-cloud-vision/src/main/java/com/google/cloud/vision/v1/ProductSearchClient.java",
  "import com.google.api.gax.rpc.UnaryCallable;",
  "import com.google.api.gax.rpc.UnaryCallable;\nimport com.google.api.pathtemplate.PathTemplate;"
)

java.format_code("google-cloud-vision/src/main/java/com/google/cloud/vision/v1/")