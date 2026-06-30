/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.showcase.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class TestName implements ResourceName {
  private static final PathTemplate SESSION_TEST =
      PathTemplate.createWithoutUrlEncoding("sessions/{session}/tests/{test}");
  private volatile Map<String, String> fieldValuesMap;
  private final String session;
  private final String test;

  @Deprecated
  protected TestName() {
    session = null;
    test = null;
  }

  private TestName(Builder builder) {
    session = Preconditions.checkNotNull(builder.getSession());
    test = Preconditions.checkNotNull(builder.getTest());
  }

  public String getSession() {
    return session;
  }

  public String getTest() {
    return test;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TestName of(String session, String test) {
    return newBuilder().setSession(session).setTest(test).build();
  }

  public static String format(String session, String test) {
    return newBuilder().setSession(session).setTest(test).build().toString();
  }

  public static TestName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SESSION_TEST.validatedMatch(
            formattedString, "TestName.parse: formattedString not in valid format");
    return of(matchMap.get("session"), matchMap.get("test"));
  }

  public static List<TestName> parseList(List<String> formattedStrings) {
    List<TestName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TestName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TestName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SESSION_TEST.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (session != null) {
            fieldMapBuilder.put("session", session);
          }
          if (test != null) {
            fieldMapBuilder.put("test", test);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return SESSION_TEST.instantiate("session", session, "test", test);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TestName that = ((TestName) o);
      return Objects.equals(this.session, that.session) && Objects.equals(this.test, that.test);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(test);
    return h;
  }

  /** Builder for sessions/{session}/tests/{test}. */
  public static class Builder {
    private String session;
    private String test;

    protected Builder() {}

    public String getSession() {
      return session;
    }

    public String getTest() {
      return test;
    }

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    public Builder setTest(String test) {
      this.test = test;
      return this;
    }

    private Builder(TestName testName) {
      this.session = testName.session;
      this.test = testName.test;
    }

    public TestName build() {
      return new TestName(this);
    }
  }
}
