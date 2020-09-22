/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.fail;

import com.google.bigtable.v2.ColumnRange;
import com.google.bigtable.v2.RowFilter;
import com.google.bigtable.v2.RowFilter.Chain;
import com.google.bigtable.v2.RowFilter.Condition;
import com.google.bigtable.v2.RowFilter.Interleave;
import com.google.bigtable.v2.TimestampRange;
import com.google.bigtable.v2.ValueRange;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FiltersTest {
  @Test
  public void chainTest() {
    RowFilter actualProto =
        FILTERS
            .chain()
            .filter(FILTERS.key().regex(".*"))
            .filter(FILTERS.key().sample(0.5))
            .filter(FILTERS.chain().filter(FILTERS.family().regex("hi$")).filter(FILTERS.pass()))
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setChain(
                Chain.newBuilder()
                    .addFilters(
                        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")))
                    .addFilters(RowFilter.newBuilder().setRowSampleFilter(0.5))
                    .addFilters(
                        RowFilter.newBuilder()
                            .setChain(
                                Chain.newBuilder()
                                    .addFilters(
                                        RowFilter.newBuilder().setFamilyNameRegexFilter("hi$"))
                                    .addFilters(RowFilter.newBuilder().setPassAllFilter(true)))))
            .build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void chainEmptyTest() {
    RowFilter actualProto = FILTERS.chain().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setPassAllFilter(true).build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void chainSingleTest() {
    RowFilter actualProto = FILTERS.chain().filter(FILTERS.key().regex(".*")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")).build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void interleaveTest() {
    RowFilter actualProto =
        FILTERS
            .interleave()
            .filter(FILTERS.key().regex(".*"))
            .filter(FILTERS.key().sample(0.5))
            .filter(
                FILTERS.interleave().filter(FILTERS.family().regex("hi$")).filter(FILTERS.pass()))
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setInterleave(
                Interleave.newBuilder()
                    .addFilters(
                        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")))
                    .addFilters(RowFilter.newBuilder().setRowSampleFilter(0.5))
                    .addFilters(
                        RowFilter.newBuilder()
                            .setInterleave(
                                Interleave.newBuilder()
                                    .addFilters(
                                        RowFilter.newBuilder().setFamilyNameRegexFilter("hi$"))
                                    .addFilters(
                                        RowFilter.newBuilder().setPassAllFilter(true).build()))))
            .build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void interleaveEmptyTest() {
    RowFilter actualProto = FILTERS.chain().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setPassAllFilter(true).build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void interleaveSingleTest() {
    RowFilter actualProto = FILTERS.interleave().filter(FILTERS.key().regex(".*")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")).build();

    assertThat(actualProto).isEqualTo(expectedFilter);
  }

  @Test
  public void conditionTest() {
    RowFilter actualFilter =
        FILTERS
            .condition(FILTERS.key().regex(".*"))
            .then(FILTERS.label("true"))
            .otherwise(FILTERS.label("false"))
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setCondition(
                Condition.newBuilder()
                    .setPredicateFilter(
                        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")))
                    .setTrueFilter(RowFilter.newBuilder().setApplyLabelTransformer("true"))
                    .setFalseFilter(RowFilter.newBuilder().setApplyLabelTransformer("false")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void keyRegexTest() {
    RowFilter actualFilter = FILTERS.key().regex(ByteString.copyFromUtf8(".*")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void keyRegexStringTest() {
    RowFilter actualFilter = FILTERS.key().regex(".*").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8(".*")).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void keyExactMatchTest() {
    RowFilter actualFilter = FILTERS.key().exactMatch(ByteString.copyFromUtf8(".*")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8("\\.\\*")).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void keyExactMatchStringTest() {
    RowFilter actualFilter = FILTERS.key().exactMatch(".*").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder().setRowKeyRegexFilter(ByteString.copyFromUtf8("\\.\\*")).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void keySampleTest() {
    RowFilter actualFilter = FILTERS.key().sample(0.3).toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setRowSampleFilter(0.3).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void familyRegexTest() {
    RowFilter actualFilter = FILTERS.family().regex("^hi").toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setFamilyNameRegexFilter("^hi").build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void familyExactMatchTest() {
    RowFilter actualFilter = FILTERS.family().exactMatch("^hi").toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setFamilyNameRegexFilter("\\^hi").build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierRegexTest() {
    RowFilter actualFilter = FILTERS.qualifier().regex(ByteString.copyFromUtf8("^hi")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnQualifierRegexFilter(ByteString.copyFromUtf8("^hi"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierRegexStringTest() {
    RowFilter actualFilter = FILTERS.qualifier().regex("^hi").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnQualifierRegexFilter(ByteString.copyFromUtf8("^hi"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierExactMatchTest() {
    RowFilter actualFilter =
        FILTERS.qualifier().exactMatch(ByteString.copyFromUtf8("^hi")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnQualifierRegexFilter(ByteString.copyFromUtf8("\\^hi"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierExactStringMatchTest() {
    RowFilter actualFilter = FILTERS.qualifier().exactMatch("^hi").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnQualifierRegexFilter(ByteString.copyFromUtf8("\\^hi"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierRangeInFamilyClosedOpen() {
    RowFilter actualFilter =
        FILTERS
            .qualifier()
            .rangeWithinFamily("family")
            .startClosed("begin")
            .endOpen("end")
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnRangeFilter(
                ColumnRange.newBuilder()
                    .setFamilyName("family")
                    .setStartQualifierClosed(ByteString.copyFromUtf8("begin"))
                    .setEndQualifierOpen(ByteString.copyFromUtf8("end")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierRangeInFamilyOpenClosed() {
    RowFilter actualFilter =
        FILTERS
            .qualifier()
            .rangeWithinFamily("family")
            .startOpen("begin")
            .endClosed("end")
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnRangeFilter(
                ColumnRange.newBuilder()
                    .setFamilyName("family")
                    .setStartQualifierOpen(ByteString.copyFromUtf8("begin"))
                    .setEndQualifierClosed(ByteString.copyFromUtf8("end")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void qualifierRangeRange() {
    RowFilter actualFilter =
        FILTERS
            .qualifier()
            .rangeWithinFamily("family")
            .startClosed("begin")
            .endOpen("end")
            .toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setColumnRangeFilter(
                ColumnRange.newBuilder()
                    .setFamilyName("family")
                    .setStartQualifierClosed(ByteString.copyFromUtf8("begin"))
                    .setEndQualifierOpen(ByteString.copyFromUtf8("end")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void timestampRange() {
    RowFilter actualFilter =
        FILTERS.timestamp().range().startClosed(1_000L).endOpen(30_000L).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setTimestampRangeFilter(
                TimestampRange.newBuilder()
                    .setStartTimestampMicros(1_000L)
                    .setEndTimestampMicros(30_000L))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void timestampAtExactTime() {
    RowFilter actualFilter = FILTERS.timestamp().exact(20_000L).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setTimestampRangeFilter(
                TimestampRange.newBuilder()
                    .setStartTimestampMicros(20_000L)
                    .setEndTimestampMicros(20_000L + 1))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void timestampOpenClosedFakeRange() {
    RowFilter actualFilter =
        FILTERS.timestamp().range().startOpen(1_000L).endClosed(30_000L).toProto();

    // open start & closed end are faked in the client by incrementing the query
    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setTimestampRangeFilter(
                TimestampRange.newBuilder()
                    .setStartTimestampMicros(1_000L + 1)
                    .setEndTimestampMicros(30_000L + 1))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueRegex() {
    RowFilter actualFilter = FILTERS.value().regex("some[0-9]regex").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setValueRegexFilter(ByteString.copyFromUtf8("some[0-9]regex"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueExactMatch() {
    RowFilter actualFilter =
        FILTERS.value().exactMatch(ByteString.copyFromUtf8("some[0-9]regex")).toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setValueRegexFilter(ByteString.copyFromUtf8("some\\[0\\-9\\]regex"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueExactStringMatch() {
    RowFilter actualFilter = FILTERS.value().exactMatch("some[0-9]regex").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setValueRegexFilter(ByteString.copyFromUtf8("some\\[0\\-9\\]regex"))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueRangeClosedOpen() {
    RowFilter actualFilter = FILTERS.value().range().startClosed("begin").endOpen("end").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setValueRangeFilter(
                ValueRange.newBuilder()
                    .setStartValueClosed(ByteString.copyFromUtf8("begin"))
                    .setEndValueOpen(ByteString.copyFromUtf8("end")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueRangeOpenClosed() {
    RowFilter actualFilter = FILTERS.value().range().startOpen("begin").endClosed("end").toProto();

    RowFilter expectedFilter =
        RowFilter.newBuilder()
            .setValueRangeFilter(
                ValueRange.newBuilder()
                    .setStartValueOpen(ByteString.copyFromUtf8("begin"))
                    .setEndValueClosed(ByteString.copyFromUtf8("end")))
            .build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void valueStripTest() {
    RowFilter actualFilter = FILTERS.value().strip().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setStripValueTransformer(true).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void offsetCellsPerRowTest() {
    RowFilter actualFilter = FILTERS.offset().cellsPerRow(10).toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setCellsPerRowOffsetFilter(10).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void limitCellsPerRowTest() {
    RowFilter actualFilter = FILTERS.limit().cellsPerRow(10).toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setCellsPerRowLimitFilter(10).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void limitCellsPerColumnTest() {
    RowFilter actualFilter = FILTERS.limit().cellsPerColumn(10).toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setCellsPerColumnLimitFilter(10).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void fromProtoTest() {
    RowFilter inner = RowFilter.newBuilder().setRowSampleFilter(0.5).build();

    RowFilter actualFilter = FILTERS.fromProto(inner).toProto();
    assertThat(actualFilter).isEqualTo(inner);
  }

  @Test
  public void passTest() {
    RowFilter actualFilter = FILTERS.pass().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setPassAllFilter(true).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void blockTest() {
    RowFilter actualFilter = FILTERS.block().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setBlockAllFilter(true).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void sinkTest() {
    RowFilter actualFilter = FILTERS.sink().toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setSink(true).build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void labelTest() {
    RowFilter actualFilter = FILTERS.label("my-label").toProto();

    RowFilter expectedFilter = RowFilter.newBuilder().setApplyLabelTransformer("my-label").build();

    assertThat(actualFilter).isEqualTo(expectedFilter);
  }

  @Test
  public void serializationTest() throws InvocationTargetException, IllegalAccessException {
    // checks that the all objects returned by the all methods of the Filters class
    // can be serialized/deserialized.

    for (Method m : Filters.class.getDeclaredMethods()) {
      String name = m.getName();
      if (Modifier.isPublic(m.getModifiers())) {
        switch (name) {
          case "condition":
            checkSerialization(
                name,
                FILTERS
                    .condition(
                        FILTERS
                            .chain()
                            .filter(FILTERS.qualifier().exactMatch("data_plan_10gb"))
                            .filter(FILTERS.value().exactMatch("true")))
                    .then(FILTERS.label("passed-filter"))
                    .otherwise(FILTERS.label("filtered-out")));
            break;
          case "label":
            checkSerialization(name, FILTERS.label("label"));
            break;
          case "fromProto":
            checkSerialization(name, FILTERS.label("label").toProto());
            break;
          default:
            checkSerialization(name, m.invoke(FILTERS));
        }
      }
    }
  }

  private static void checkSerialization(String name, Object filter) {
    try {
      Object deserialized = serializeDeserialize(filter);
      checkClassDeclaresSerialVersionUid(filter.getClass());
      if (filter instanceof Filters.Filter) {
        checkFilters(name, (Filters.Filter) filter, (Filters.Filter) deserialized);
      } else if (filter instanceof RowFilter) {
        assertWithMessage("'" + name + "' deserialized filter differs")
            .that(filter)
            .isEqualTo(deserialized);
      } else {
        Class cls = filter.getClass();
        checkClassDoesNotContainNonStaticFields(cls, cls.getFields());
        checkClassDoesNotContainNonStaticFields(cls, cls.getDeclaredFields());
        checkSpawnedFilters(name, cls, filter, deserialized);
      }
    } catch (IOException | ClassNotFoundException e) {
      fail(name + ": " + e);
    }
  }

  private static void checkFilters(
      String name, Filters.Filter original, Filters.Filter deserialized) {
    RowFilter protoBefore = ((Filters.Filter) original).toProto();
    RowFilter protoAfter = ((Filters.Filter) deserialized).toProto();
    assertWithMessage("'" + name + "' filter protoBuf mismatches after deserialization")
        .that(protoBefore)
        .isEqualTo(protoAfter);
  }

  private static void checkSpawnedFilters(
      String name, Class cls, Object original, Object deserialized) {

    int numberOfMethods = 0;
    for (Method m : cls.getDeclaredMethods()) {
      if (Modifier.isPublic(m.getModifiers())) {
        numberOfMethods++;
      }
    }
    ByteString re = ByteString.copyFromUtf8("some\\[0\\-9\\]regex");

    switch (name) {
      case "family":
        {
          Filters.FamilyFilter f1 = (Filters.FamilyFilter) original;
          Filters.FamilyFilter f2 = (Filters.FamilyFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(2);
          checkFilters(name + "/exactMatch", f1.exactMatch("abc"), f2.exactMatch("abc"));
          checkFilters(name + "/regex", f1.regex("*"), f2.regex("*"));

          break;
        }
      case "qualifier":
        {
          Filters.QualifierFilter f1 = (Filters.QualifierFilter) original;
          Filters.QualifierFilter f2 = (Filters.QualifierFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(5);
          checkFilters(name + "/exactMatch", f1.exactMatch("abc"), f2.exactMatch("abc"));
          checkFilters(name + "/exactMatch(ByteString)", f1.exactMatch(re), f2.exactMatch(re));
          checkFilters(name + "/regex", f1.regex("*"), f2.regex("*"));
          checkFilters(name + "/regex(ByteString)", f1.regex(re), f2.regex(re));
          checkFilters(
              name + "/rangeWithinFamily",
              f1.rangeWithinFamily("family"),
              f2.rangeWithinFamily("family"));

          break;
        }
      case "limit":
        {
          Filters.LimitFilter f1 = (Filters.LimitFilter) original;
          Filters.LimitFilter f2 = (Filters.LimitFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(2);
          checkFilters(
              name + "/cellsPerColumn", f1.cellsPerColumn(100500), f2.cellsPerColumn(100500));
          checkFilters(name + "/cellsPerRow", f1.cellsPerRow(-10), f2.cellsPerRow(-10));

          break;
        }
      case "value":
        {
          Filters.ValueFilter f1 = (Filters.ValueFilter) original;
          Filters.ValueFilter f2 = (Filters.ValueFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(6);
          checkFilters(name + "/exactMatch", f1.exactMatch("x"), f2.exactMatch("x"));
          checkFilters(name + "/exactMatch(ByteString)", f1.exactMatch(re), f2.exactMatch(re));
          checkFilters(name + "/range", f1.range(), f2.range());
          checkFilters(name + "/regex", f1.regex("*"), f2.regex("*"));
          checkFilters(name + "/regex(ByteString)", f1.regex(re), f2.regex(re));
          checkFilters(name + "/strip", f1.strip(), f2.strip());

          break;
        }
      case "offset":
        {
          Filters.OffsetFilter f1 = (Filters.OffsetFilter) original;
          Filters.OffsetFilter f2 = (Filters.OffsetFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(1);
          checkFilters(name + "/cellsPerRow", f1.cellsPerRow(100500), f2.cellsPerRow(100500));

          break;
        }
      case "key":
        {
          Filters.KeyFilter f1 = (Filters.KeyFilter) original;
          Filters.KeyFilter f2 = (Filters.KeyFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(5);
          checkFilters(name + "/exactMatch", f1.exactMatch("a"), f2.exactMatch("a"));
          checkFilters(name + "/exactMatch(ByteString)", f1.exactMatch(re), f2.exactMatch(re));
          checkFilters(name + "/regex", f1.regex("a"), f2.regex("a"));
          checkFilters(name + "/regex(ByteString)", f1.regex(re), f2.regex(re));
          checkFilters(name + "/sample", f1.sample(0.1), f2.sample(0.1));

          break;
        }
      case "timestamp":
        {
          Filters.TimestampFilter f1 = (Filters.TimestampFilter) original;
          Filters.TimestampFilter f2 = (Filters.TimestampFilter) deserialized;

          assertThat(numberOfMethods).isEqualTo(2);
          checkFilters(name + "/exact", f1.exact(100500L), f2.exact(100500L));
          checkFilters(name + "/range", f1.range(), f2.range());

          break;
        }
      default:
        fail("Untested filter: " + name);
    }
  }

  private static void checkClassDeclaresSerialVersionUid(Class cls) {
    String uid = "serialVersionUID";
    for (Field field : cls.getDeclaredFields()) {
      if (field.getName() == uid) {
        int modifiers = field.getModifiers();
        assertWithMessage(field + " is not static").that(Modifier.isStatic(modifiers)).isTrue();
        assertWithMessage(field + " is not final").that(Modifier.isFinal(modifiers)).isTrue();
        assertWithMessage(field + " is not private").that(Modifier.isPrivate(modifiers)).isTrue();
        assertWithMessage(field + " must be long")
            .that(field.getType().getSimpleName())
            .isEqualTo("long");
        return;
      }
    }
    fail(cls + " does not declare serialVersionUID");
  }

  private static void checkClassDoesNotContainNonStaticFields(Class cls, Field[] fields) {
    for (Field field : fields) {
      assertWithMessage(cls + " has a non-static field '" + field + "'")
          .that(Modifier.isStatic(field.getModifiers()))
          .isTrue();
    }
  }

  private static Object serializeDeserialize(Object obj)
      throws IOException, ClassNotFoundException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try (ObjectOutputStream outStream = new ObjectOutputStream(bos)) {
      outStream.writeObject(obj);
    }

    ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
    try (ObjectInputStream inStream = new ObjectInputStream(bis)) {
      return inStream.readObject();
    }
  }
}
