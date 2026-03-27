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

import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class GapicClass {
  // TODO(miraleung): Add enum for resource name classes.
  public enum Kind {
    MAIN,
    STUB,
    TEST,
    PROTO,
    // Used to denote a Gapic Class that has no intention of being generated
    // The Writer will skip generating code for this class
    NON_GENERATED
  };

  public abstract Kind kind();

  public abstract ClassDefinition classDefinition();

  public abstract List<Sample> samples();

  // Only used for generating the region tag for samples; therefore only used in select Composers.
  public abstract String apiShortName();

  // Only used for generating the region tag for samples; therefore only used in select Composers.
  public abstract String packageVersion();

  /**
   * Create a GapicClass with minimal information. This is intended to be used for GapicClasses that
   * will not generate any Java files (Writer will skip)
   *
   * @return GapicClass denoted with NON_GENERATED Kind enum
   */
  public static GapicClass createNonGeneratedGapicClass() {
    return builder()
        .setKind(Kind.NON_GENERATED)
        .setClassDefinition(
            ClassDefinition.builder()
                .setPackageString("Empty Package")
                .setName("Empty Name")
                .setScope(ScopeNode.PUBLIC)
                .build())
        .build();
  }

  public static GapicClass create(Kind kind, ClassDefinition classDefinition) {
    return builder().setKind(kind).setClassDefinition(classDefinition).build();
  }

  public static GapicClass create(
      Kind kind, ClassDefinition classDefinition, List<Sample> samples) {
    return builder().setKind(kind).setClassDefinition(classDefinition).setSamples(samples).build();
  }

  static Builder builder() {
    return new AutoValue_GapicClass.Builder()
        .setSamples(Collections.emptyList())
        .setApiShortName("")
        .setPackageVersion("");
  }

  abstract Builder toBuilder();

  public final GapicClass withSamples(List<Sample> samples) {
    return toBuilder().setSamples(samples).build();
  }

  public final GapicClass withApiShortName(String apiShortName) {
    return toBuilder().setApiShortName(apiShortName).build();
  }

  public final GapicClass withPackageVersion(String packageVersion) {
    return toBuilder().setPackageVersion(packageVersion).build();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setKind(Kind kind);

    abstract Builder setClassDefinition(ClassDefinition classDefinition);

    abstract Builder setSamples(List<Sample> samples);

    abstract Builder setApiShortName(String apiShortName);

    abstract Builder setPackageVersion(String packageVersion);

    abstract GapicClass build();
  }
}
