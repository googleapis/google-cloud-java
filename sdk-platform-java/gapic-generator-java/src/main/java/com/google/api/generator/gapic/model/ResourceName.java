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

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.api.generator.gapic.utils.ResourceNameConstants;
import com.google.api.pathtemplate.PathTemplate;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@AutoValue
public abstract class ResourceName {
  static final String SLASH = "/";
  static final Reference RESOURCE_NAME_REF =
      ConcreteReference.withClazz(com.google.api.resourcenames.ResourceName.class);

  // The original binding variable name.
  // This should be in lower_snake_case in the proto, and expected to be surrounded by braces.
  // Example: In projects/{project}/billingAccounts/billing_account, the variable name would be
  // "billing_account."
  public abstract String variableName();

  // The Java package of the project, or that of a subpackage where the resource name was defined.
  // That is, resource names defined outside of this project will still have the project's package.
  public abstract String pakkage();

  // The resource type.
  public abstract String resourceTypeString();

  // A list of patterns such as projects/{project}/locations/{location}/resources/{this_resource}.
  // Order is copuled to the method variants and ordering in the reosurce name helper, as well as
  // the relevant client tests.
  public abstract ImmutableList<String> patterns();

  // The Java TypeNode of the resource name helper class to generate.
  public abstract TypeNode type();

  public abstract boolean isOnlyWildcard();

  @Nullable
  public String getMatchingPattern(HttpBindings bindings) {
    List<String> bindingPatterns =
        ImmutableList.<String>builder()
            .add(bindings.pattern())
            .addAll(bindings.additionalPatterns())
            .build();

    for (String bindingPattern : bindingPatterns) {
      PathTemplate bindingTemplate = PathTemplate.create(bindingPattern);
      for (String resNamePattern : patterns()) {
        PathTemplate restNamePatternTemplate = PathTemplate.create(resNamePattern);
        ImmutableMap.Builder<String, String> mb = ImmutableMap.builder();
        for (String var : restNamePatternTemplate.vars()) {
          mb.put(var, var + (var.hashCode() % 100));
        }

        String resNameValue = restNamePatternTemplate.instantiate(mb.build());
        mb = ImmutableMap.builder();
        for (String var : bindingTemplate.vars()) {
          mb.put(var, resNameValue);
        }

        String url = bindingTemplate.instantiate(mb.build());
        if (bindingTemplate.matches(url)) {
          return resNamePattern;
        }
      }
    }
    return null;
  }

  // The message in which this resource was defined. Optional.
  // This is expected to be empty for file-level definitions.
  @Nullable
  public abstract String parentMessageName();

  @Nullable
  public abstract String description();

  public boolean hasParentMessageName() {
    return parentMessageName() != null;
  }

  public boolean hasDescription() {
    return description() != null;
  }

  public String resourceTypeName() {
    return resourceTypeString().substring(resourceTypeString().indexOf(SLASH) + 1);
  }

  public static Builder builder() {
    return new AutoValue_ResourceName.Builder().setIsOnlyWildcard(false);
  }

  public static ResourceName createWildcard(String resourceTypeString, String pakkage) {
    String placeholderVarName =
        JavaStyle.toLowerCamelCase(
            resourceTypeString.substring(resourceTypeString.indexOf(SLASH) + 1));
    return builder()
        .setVariableName(placeholderVarName)
        .setPakkage(pakkage)
        .setResourceTypeString(resourceTypeString)
        .setPatterns(ImmutableList.of(ResourceNameConstants.WILDCARD_PATTERN))
        .setIsOnlyWildcard(true)
        .setType(TypeNode.withReference(RESOURCE_NAME_REF))
        .build();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ResourceName)) {
      return false;
    }

    ResourceName other = (ResourceName) o;
    // Exclude the description from the resource name because it's just a comment.
    return variableName().equals(other.variableName())
        && pakkage().equals(other.pakkage())
        && resourceTypeString().equals(other.resourceTypeString())
        && patterns().equals(other.patterns())
        && Objects.equals(parentMessageName(), other.parentMessageName())
        && Objects.equals(type(), other.type());
  }

  @Override
  public int hashCode() {
    int parentMessageNameHashCode =
        parentMessageName() == null ? 0 : parentMessageName().hashCode();
    int typeHashCode = type() == null ? 0 : type().hashCode();
    return 17 * variableName().hashCode()
        + 19 * pakkage().hashCode()
        + 23 * resourceTypeString().hashCode()
        + 31 * patterns().hashCode()
        + 37 * parentMessageNameHashCode
        + 41 * typeHashCode;
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setVariableName(String variableName);

    public abstract Builder setPakkage(String pakkage);

    public abstract Builder setResourceTypeString(String resourceTypeString);

    public abstract Builder setPatterns(List<String> patterns);

    public abstract Builder setParentMessageName(String parentMessageName);

    public abstract Builder setDescription(String description);

    // Private setters.
    abstract Builder setType(TypeNode type);

    abstract Builder setIsOnlyWildcard(boolean isOnlyWildcard);

    // Private accessors.
    abstract String pakkage();

    abstract String resourceTypeString();

    abstract boolean isOnlyWildcard();

    // Private.
    abstract ResourceName autoBuild();

    public ResourceName build() {
      if (!isOnlyWildcard()) {
        String typeName =
            resourceTypeString().substring(resourceTypeString().lastIndexOf(SLASH) + 1);
        setType(
            TypeNode.withReference(
                VaporReference.builder()
                    .setName(String.format("%sName", typeName))
                    .setPakkage(pakkage())
                    .setSupertypeReference(RESOURCE_NAME_REF)
                    .build()));
      }
      return autoBuild();
    }
  }
}
