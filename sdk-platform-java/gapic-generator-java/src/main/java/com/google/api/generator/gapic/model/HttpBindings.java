// Copyright 2021 Google LLC
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

import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class HttpBindings {
  public enum HttpVerb {
    GET,
    PUT,
    POST,
    DELETE,
    PATCH,
  }

  @AutoValue
  public abstract static class HttpBinding implements Comparable<HttpBinding> {

    // The fully qualified name of the field. e.g. request.complex_object.another_object.name
    public abstract String name();

    abstract String lowerCamelName();

    // An object that contains all info of the leaf level field
    @Nullable
    public abstract Field field();

    public boolean isOptional() {
      return field() != null && field().isProto3Optional();
    }

    public boolean isRepeated() {
      return field() != null && field().isRepeated();
    }

    public boolean isEnum() {
      return field() != null && field().isEnum();
    }

    @Nullable
    public abstract String valuePattern();

    public static HttpBindings.HttpBinding.Builder builder() {
      return new AutoValue_HttpBindings_HttpBinding.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract HttpBindings.HttpBinding.Builder setName(String name);

      public abstract HttpBindings.HttpBinding.Builder setField(Field field);

      abstract HttpBindings.HttpBinding.Builder setLowerCamelName(String lowerCamelName);

      public abstract HttpBindings.HttpBinding.Builder setValuePattern(String valuePattern);

      abstract String name();

      abstract HttpBindings.HttpBinding autoBuild();

      public HttpBindings.HttpBinding build() {
        setLowerCamelName(JavaStyle.toLowerCamelCase(name()));
        return autoBuild();
      }
    }

    // Do not forget to keep it in sync with equals() implementation.
    @Override
    public int compareTo(HttpBinding o) {
      int res = name().compareTo(o.name());
      return res == 0 ? Boolean.compare(isOptional(), o.isOptional()) : res;
    }
  }

  public abstract HttpVerb httpVerb();

  public abstract String pattern();

  public abstract List<String> additionalPatterns();

  public abstract Set<HttpBinding> pathParameters();

  public abstract Set<HttpBinding> queryParameters();

  public abstract Set<HttpBinding> bodyParameters();

  public abstract boolean isAsteriskBody();

  public static HttpBindings.Builder builder() {
    return new AutoValue_HttpBindings.Builder()
        .setPathParameters(ImmutableSet.of())
        .setQueryParameters(ImmutableSet.of())
        .setBodyParameters(ImmutableSet.of());
  }

  // Protobuf fields and template patterns follow snake_case style. When translated into actual Java
  // class fields and URL respectively, those must be converted to lowerCamelCase.
  // For example:
  //   in .proto file: "/global/instanceTemplates/{instance_template=*}"
  //   in .java file:  "/global/instanceTemplates/{instanceTemplate=*}"
  public String lowerCamelPattern() {
    return lowerCamelPattern(pattern(), pathParameters());
  }

  public List<String> lowerCamelAdditionalPatterns() {
    return additionalPatterns().stream()
        .map(a -> lowerCamelPattern(a, pathParameters()))
        .collect(Collectors.toList());
  }

  private static String lowerCamelPattern(String originalPattern, Set<HttpBinding> pathParameters) {
    String lowerCamelPattern = originalPattern;
    for (HttpBinding pathParam : pathParameters) {
      lowerCamelPattern =
          lowerCamelPattern.replaceAll(
              "\\{" + pathParam.name(), "{" + JavaStyle.toLowerCamelCase(pathParam.name()));
    }
    return lowerCamelPattern;
  }

  public Map<String, String> getPathParametersValuePatterns() {
    Map<String, String> valuePatterns = new LinkedHashMap<>();
    for (HttpBinding pathParameter : pathParameters()) {
      valuePatterns.put(pathParameter.lowerCamelName(), pathParameter.valuePattern());
    }
    return valuePatterns;
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract HttpBindings.Builder setHttpVerb(HttpVerb httpVerb);

    public abstract HttpBindings.Builder setPattern(String pattern);

    public abstract HttpBindings.Builder setAdditionalPatterns(List<String> additionalPatterns);

    abstract String pattern();

    public abstract HttpBindings.Builder setPathParameters(Set<HttpBinding> pathParameters);

    public abstract HttpBindings.Builder setQueryParameters(Set<HttpBinding> queryParameters);

    public abstract HttpBindings.Builder setBodyParameters(Set<HttpBinding> bodyParameters);

    public abstract HttpBindings.Builder setIsAsteriskBody(boolean asteriskBody);

    public abstract HttpBindings autoBuild();

    public HttpBindings build() {
      if ("".equals(pattern())) {
        throw new IllegalArgumentException("pattern cannot be empty");
      }
      return autoBuild();
    }
  }
}
