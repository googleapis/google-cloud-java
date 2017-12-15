/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import static com.google.cloud.bigquery.FieldValue.Attribute.PRIMITIVE;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.common.collect.ImmutableList;
import org.junit.Test;

public class TableResultTest {
  private static final Page<FieldValueList> INNER_PAGE_0 =
      new PageImpl<>(
          new PageImpl.NextPageFetcher<FieldValueList>() {
            @Override
            public Page<FieldValueList> getNextPage() {
              return INNER_PAGE_1;
            }
          },
          "abc",
          ImmutableList.of(newFieldValueList("0"), newFieldValueList("1")));
  private static final Page<FieldValueList> INNER_PAGE_1 =
      new PageImpl<>(
          new PageImpl.NextPageFetcher<FieldValueList>() {
            @Override
            public Page<FieldValueList> getNextPage() {
              return null;
            }
          },
          null,
          ImmutableList.of(newFieldValueList("2")));
  private static final Schema SCHEMA = Schema.of(Field.of("field", LegacySQLTypeName.INTEGER));

  private static FieldValueList newFieldValueList(String s) {
    return FieldValueList.of(ImmutableList.of(FieldValue.of(PRIMITIVE, s)));
  }

  @Test
  public void testNullSchema() {
    TableResult result = new TableResult(null, 3, INNER_PAGE_0);
    assertThat(result.getSchema()).isNull();
    assertThat(result.hasNextPage()).isTrue();
    assertThat(result.getNextPageToken()).isNotNull();
    assertThat(result.getValues())
        .containsExactly(newFieldValueList("0"), newFieldValueList("1"))
        .inOrder();

    TableResult next = result.getNextPage();
    assertThat(next.getSchema()).isNull();
    assertThat(next.hasNextPage()).isFalse();
    assertThat(next.getNextPageToken()).isNull();
    assertThat(next.getValues()).containsExactly(newFieldValueList("2"));
    assertThat(next.getNextPage()).isNull();

    assertThat(result.iterateAll())
        .containsExactly(newFieldValueList("0"), newFieldValueList("1"), newFieldValueList("2"))
        .inOrder();
  }

  @Test
  public void testSchema() {
    TableResult result = new TableResult(SCHEMA, 3, INNER_PAGE_0);
    assertThat(result.getSchema()).isEqualTo(SCHEMA);
    assertThat(result.hasNextPage()).isTrue();
    assertThat(result.getNextPageToken()).isNotNull();
    assertThat(result.getValues())
        .containsExactly(
            newFieldValueList("0").withSchema(SCHEMA.getFields()),
            newFieldValueList("1").withSchema(SCHEMA.getFields()))
        .inOrder();

    TableResult next = result.getNextPage();
    assertThat(next.getSchema()).isEqualTo(SCHEMA);
    assertThat(next.hasNextPage()).isFalse();
    assertThat(next.getNextPageToken()).isNull();
    assertThat(next.getValues())
        .containsExactly(newFieldValueList("2").withSchema(SCHEMA.getFields()));
    assertThat(next.getNextPage()).isNull();

    assertThat(result.iterateAll())
        .containsExactly(
            newFieldValueList("0").withSchema(SCHEMA.getFields()),
            newFieldValueList("1").withSchema(SCHEMA.getFields()),
            newFieldValueList("2").withSchema(SCHEMA.getFields()))
        .inOrder();
  }
}
