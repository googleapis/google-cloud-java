/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta;

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
public class ConferenceRecordName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD =
      PathTemplate.createWithoutUrlEncoding("conferenceRecords/{conference_record}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;

  @Deprecated
  protected ConferenceRecordName() {
    conferenceRecord = null;
  }

  private ConferenceRecordName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConferenceRecordName of(String conferenceRecord) {
    return newBuilder().setConferenceRecord(conferenceRecord).build();
  }

  public static String format(String conferenceRecord) {
    return newBuilder().setConferenceRecord(conferenceRecord).build().toString();
  }

  public static ConferenceRecordName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD.validatedMatch(
            formattedString, "ConferenceRecordName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"));
  }

  public static List<ConferenceRecordName> parseList(List<String> formattedStrings) {
    List<ConferenceRecordName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConferenceRecordName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConferenceRecordName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (conferenceRecord != null) {
            fieldMapBuilder.put("conference_record", conferenceRecord);
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
    return CONFERENCE_RECORD.instantiate("conference_record", conferenceRecord);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ConferenceRecordName that = ((ConferenceRecordName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}. */
  public static class Builder {
    private String conferenceRecord;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    private Builder(ConferenceRecordName conferenceRecordName) {
      this.conferenceRecord = conferenceRecordName.conferenceRecord;
    }

    public ConferenceRecordName build() {
      return new ConferenceRecordName(this);
    }
  }
}
