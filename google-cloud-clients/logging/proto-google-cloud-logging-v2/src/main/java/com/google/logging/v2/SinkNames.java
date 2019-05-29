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

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class SinkNames {
  private SinkNames() {}

  public static SinkName parse(String resourceNameString) {
    if (ProjectSinkName.isParsableFrom(resourceNameString)) {
      return ProjectSinkName.parse(resourceNameString);
    }
    if (OrganizationSinkName.isParsableFrom(resourceNameString)) {
      return OrganizationSinkName.parse(resourceNameString);
    }
    if (FolderSinkName.isParsableFrom(resourceNameString)) {
      return FolderSinkName.parse(resourceNameString);
    }
    if (BillingSinkName.isParsableFrom(resourceNameString)) {
      return BillingSinkName.parse(resourceNameString);
    }
    return UntypedSinkName.parse(resourceNameString);
  }
}
