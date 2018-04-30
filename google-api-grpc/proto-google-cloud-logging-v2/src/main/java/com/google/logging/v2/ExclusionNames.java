/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.logging.v2;

import com.google.api.resourcenames.ResourceName;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ExclusionNames {
  private ExclusionNames() {}

  public static ExclusionName parse(String resourceNameString) {
    if (ProjectExclusionName.isParsableFrom(resourceNameString)) {
      return ProjectExclusionName.parse(resourceNameString);
    }
    if (OrganizationExclusionName.isParsableFrom(resourceNameString)) {
      return OrganizationExclusionName.parse(resourceNameString);
    }
    if (FolderExclusionName.isParsableFrom(resourceNameString)) {
      return FolderExclusionName.parse(resourceNameString);
    }
    if (BillingExclusionName.isParsableFrom(resourceNameString)) {
      return BillingExclusionName.parse(resourceNameString);
    }
    return UntypedExclusionName.parse(resourceNameString);
  }
}
