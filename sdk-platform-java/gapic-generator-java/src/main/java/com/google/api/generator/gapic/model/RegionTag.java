// Copyright 2022 Google LLC
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

import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

// TODO: alicejli edit RegionTag to match other languages
/**
 * This model represents a code sample region tag. Matching region start and end region tag comments
 * are used to determine the boundaries of code snippets to be used in documentation.
 */
@AutoValue
public abstract class RegionTag {
  public abstract String apiShortName();

  public abstract String apiVersion();

  public abstract String serviceName();

  public abstract String rpcName();

  public abstract String overloadDisambiguation();

  public abstract Boolean isAsynchronous();

  public static Builder builder() {
    return new AutoValue_RegionTag.Builder()
        .setApiVersion("")
        .setApiShortName("")
        .setOverloadDisambiguation("")
        .setIsAsynchronous(false);
  }

  public abstract RegionTag.Builder toBuilder();

  /**
   * Helper method to easily update region tag apiVersion.
   *
   * @param apiVersion String to replace region tag apiVersion
   * @return RegionTag with updated apiVersion
   */
  public final RegionTag withApiVersion(String apiVersion) {
    return toBuilder().setApiVersion(apiVersion).build();
  }

  /**
   * Helper method to easily update region tag apiShortName.
   *
   * @param apiShortName String to replace region tag apiShortName
   * @return RegionTag with updated apiShortName
   */
  public final RegionTag withApiShortName(String apiShortName) {
    return toBuilder().setApiShortName(apiShortName).build();
  }

  /**
   * Helper method to easily update region tag overloadDisambiguation.
   *
   * @param overloadDisambiguation String to replace region tag overloadDisambiguation
   * @return RegionTag with updated overloadDisambiguation
   */
  public final RegionTag withOverloadDisambiguation(String overloadDisambiguation) {
    return toBuilder().setOverloadDisambiguation(overloadDisambiguation).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setApiVersion(String apiVersion);

    public abstract Builder setApiShortName(String apiShortName);

    public abstract Builder setServiceName(String serviceName);

    public abstract Builder setRpcName(String rpcName);

    public abstract Builder setOverloadDisambiguation(String overloadDisambiguation);

    public abstract Builder setIsAsynchronous(Boolean isAsynchronous);

    abstract String apiVersion();

    abstract String apiShortName();

    abstract String serviceName();

    abstract String rpcName();

    abstract String overloadDisambiguation();

    abstract RegionTag autoBuild();

    public final RegionTag build() {
      setApiVersion(sanitizeAttributes(apiVersion()));
      setApiShortName(sanitizeAttributes(apiShortName()));
      setServiceName(sanitizeAttributes(serviceName()));
      setRpcName(sanitizeAttributes(rpcName()));
      setOverloadDisambiguation(sanitizeAttributes(overloadDisambiguation()));
      return autoBuild();
    }

    private final String sanitizeAttributes(String attribute) {
      return JavaStyle.toUpperCamelCase(attribute.replaceAll("[^a-zA-Z0-9]", ""));
    }
  }

  public enum RegionTagRegion {
    START,
    END
  }

  /**
   * Method to generate region tag comment text
   *
   * @return region tag comment text
   */
  public String generate() {
    Preconditions.checkState(!apiShortName().isEmpty(), "apiShortName can't be empty");
    Preconditions.checkState(!serviceName().isEmpty(), "serviceName can't be empty");
    Preconditions.checkState(!rpcName().isEmpty(), "rpcName can't be empty");

    String rt = apiShortName() + "_";
    if (!apiVersion().isEmpty()) {
      rt = rt + apiVersion() + "_";
    }
    rt = rt.toLowerCase() + "generated_" + serviceName() + "_" + rpcName();
    // TODO: @alicejli overloadDisambiguation will need to be updated to match other languages
    if (!overloadDisambiguation().isEmpty()) {
      rt = rt + "_" + overloadDisambiguation();
    }
    if (isAsynchronous()) {
      rt = rt + "_async";
    } else {
      rt = rt + "_sync";
    }

    return rt;
  }

  public static CommentStatement generateTag(
      RegionTagRegion regionTagRegion, String regionTagContent) {
    return CommentStatement.withComment(
        LineComment.withComment("[" + regionTagRegion.name() + " " + regionTagContent + "]"));
  }
}
