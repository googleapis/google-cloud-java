/*
 * Copyright 2026 Google LLC
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class SmartNoteName implements ResourceName {
  private static final PathTemplate CONFERENCE_RECORD_SMART_NOTE =
      PathTemplate.createWithoutUrlEncoding(
          "conferenceRecords/{conference_record}/smartNotes/{smart_note}");
  private volatile Map<String, String> fieldValuesMap;
  private final String conferenceRecord;
  private final String smartNote;

  @Deprecated
  protected SmartNoteName() {
    conferenceRecord = null;
    smartNote = null;
  }

  private SmartNoteName(Builder builder) {
    conferenceRecord = Preconditions.checkNotNull(builder.getConferenceRecord());
    smartNote = Preconditions.checkNotNull(builder.getSmartNote());
  }

  public String getConferenceRecord() {
    return conferenceRecord;
  }

  public String getSmartNote() {
    return smartNote;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SmartNoteName of(String conferenceRecord, String smartNote) {
    return newBuilder().setConferenceRecord(conferenceRecord).setSmartNote(smartNote).build();
  }

  public static String format(String conferenceRecord, String smartNote) {
    return newBuilder()
        .setConferenceRecord(conferenceRecord)
        .setSmartNote(smartNote)
        .build()
        .toString();
  }

  public static @Nullable SmartNoteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CONFERENCE_RECORD_SMART_NOTE.validatedMatch(
            formattedString, "SmartNoteName.parse: formattedString not in valid format");
    return of(matchMap.get("conference_record"), matchMap.get("smart_note"));
  }

  public static List<SmartNoteName> parseList(List<String> formattedStrings) {
    List<SmartNoteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable SmartNoteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SmartNoteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CONFERENCE_RECORD_SMART_NOTE.matches(formattedString);
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
          if (smartNote != null) {
            fieldMapBuilder.put("smart_note", smartNote);
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
    return CONFERENCE_RECORD_SMART_NOTE.instantiate(
        "conference_record", conferenceRecord, "smart_note", smartNote);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SmartNoteName that = ((SmartNoteName) o);
      return Objects.equals(this.conferenceRecord, that.conferenceRecord)
          && Objects.equals(this.smartNote, that.smartNote);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(conferenceRecord);
    h *= 1000003;
    h ^= Objects.hashCode(smartNote);
    return h;
  }

  /** Builder for conferenceRecords/{conference_record}/smartNotes/{smart_note}. */
  public static class Builder {
    private String conferenceRecord;
    private String smartNote;

    protected Builder() {}

    public String getConferenceRecord() {
      return conferenceRecord;
    }

    public String getSmartNote() {
      return smartNote;
    }

    public Builder setConferenceRecord(String conferenceRecord) {
      this.conferenceRecord = conferenceRecord;
      return this;
    }

    public Builder setSmartNote(String smartNote) {
      this.smartNote = smartNote;
      return this;
    }

    private Builder(SmartNoteName smartNoteName) {
      this.conferenceRecord = smartNoteName.conferenceRecord;
      this.smartNote = smartNoteName.smartNote;
    }

    public SmartNoteName build() {
      return new SmartNoteName(this);
    }
  }
}
