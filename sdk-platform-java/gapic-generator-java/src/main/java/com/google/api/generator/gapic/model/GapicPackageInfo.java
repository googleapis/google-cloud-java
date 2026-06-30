// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.auto.value.AutoValue;

/** A thin wrapper around PackageInfoDefinition to maintain a clean separation of concerns. */
@AutoValue
public abstract class GapicPackageInfo {
  public abstract PackageInfoDefinition packageInfo();

  public static GapicPackageInfo with(PackageInfoDefinition packageInfo) {
    return builder().setPackageInfo(packageInfo).build();
  }

  static Builder builder() {
    return new AutoValue_GapicPackageInfo.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setPackageInfo(PackageInfoDefinition packageInfo);

    abstract GapicPackageInfo build();
  }
}
