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
public class ParentNames {
  private ParentNames() {}

  public static ParentName parse(String resourceNameString) {
    if (ProjectName.isParsableFrom(resourceNameString)) {
      return ProjectName.parse(resourceNameString);
    }
    if (OrganizationName.isParsableFrom(resourceNameString)) {
      return OrganizationName.parse(resourceNameString);
    }
    if (FolderName.isParsableFrom(resourceNameString)) {
      return FolderName.parse(resourceNameString);
    }
    if (BillingName.isParsableFrom(resourceNameString)) {
      return BillingName.parse(resourceNameString);
    }
    return UntypedParentName.parse(resourceNameString);
  }
}
