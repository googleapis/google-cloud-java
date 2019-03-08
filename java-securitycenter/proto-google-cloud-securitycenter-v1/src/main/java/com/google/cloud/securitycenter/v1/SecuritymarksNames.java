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

package com.google.cloud.securitycenter.v1;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class SecuritymarksNames {
  private SecuritymarksNames() {}

  public static SecuritymarksName parse(String resourceNameString) {
    if (AssetSecurityMarksName.isParsableFrom(resourceNameString)) {
      return AssetSecurityMarksName.parse(resourceNameString);
    }
    if (FindingSecurityMarksName.isParsableFrom(resourceNameString)) {
      return FindingSecurityMarksName.parse(resourceNameString);
    }
    return UntypedSecuritymarksName.parse(resourceNameString);
  }
}
