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

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.Map;

/** Represents the LRO retry settings in a gapic.yaml file. */
@AutoValue
public abstract class GapicLanguageSettings {
  // The Java package mapping.
  public abstract String pakkage();

  // Private.
  abstract ImmutableMap<String, String> protoServiceToJavaClassname();

  public String getJavaServiceName(String protoPackage, String protoServiceName) {
    String protoFullName = String.format("%s.%s", protoPackage, protoServiceName);
    String finalProtoRpcName = protoServiceName;
    if (protoServiceToJavaClassname().containsKey(protoFullName)) {
      finalProtoRpcName = protoServiceToJavaClassname().get(protoFullName);
    }
    return finalProtoRpcName;
  }

  public static Builder builder() {
    return new AutoValue_GapicLanguageSettings.Builder()
        .setProtoServiceToJavaClassname(Collections.emptyMap());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setPakkage(String pakkage);

    public abstract Builder setProtoServiceToJavaClassname(
        Map<String, String> protoServiceToJavaClassname);

    public abstract GapicLanguageSettings build();
  }
}
