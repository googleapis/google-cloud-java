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

package com.google.example.library.v1;

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
public class BookName implements ResourceName {
  private static final PathTemplate SHELF_BOOK =
      PathTemplate.createWithoutUrlEncoding("shelves/{shelf}/books/{book}");
  private volatile Map<String, String> fieldValuesMap;
  private final String shelf;
  private final String book;

  @Deprecated
  protected BookName() {
    shelf = null;
    book = null;
  }

  private BookName(Builder builder) {
    shelf = Preconditions.checkNotNull(builder.getShelf());
    book = Preconditions.checkNotNull(builder.getBook());
  }

  public String getShelf() {
    return shelf;
  }

  public String getBook() {
    return book;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BookName of(String shelf, String book) {
    return newBuilder().setShelf(shelf).setBook(book).build();
  }

  public static String format(String shelf, String book) {
    return newBuilder().setShelf(shelf).setBook(book).build().toString();
  }

  public static BookName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SHELF_BOOK.validatedMatch(
            formattedString, "BookName.parse: formattedString not in valid format");
    return of(matchMap.get("shelf"), matchMap.get("book"));
  }

  public static List<BookName> parseList(List<String> formattedStrings) {
    List<BookName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BookName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BookName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SHELF_BOOK.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (shelf != null) {
            fieldMapBuilder.put("shelf", shelf);
          }
          if (book != null) {
            fieldMapBuilder.put("book", book);
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
    return SHELF_BOOK.instantiate("shelf", shelf, "book", book);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BookName that = ((BookName) o);
      return Objects.equals(this.shelf, that.shelf) && Objects.equals(this.book, that.book);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(shelf);
    h *= 1000003;
    h ^= Objects.hashCode(book);
    return h;
  }

  /** Builder for shelves/{shelf}/books/{book}. */
  public static class Builder {
    private String shelf;
    private String book;

    protected Builder() {}

    public String getShelf() {
      return shelf;
    }

    public String getBook() {
      return book;
    }

    public Builder setShelf(String shelf) {
      this.shelf = shelf;
      return this;
    }

    public Builder setBook(String book) {
      this.book = book;
      return this;
    }

    private Builder(BookName bookName) {
      this.shelf = bookName.shelf;
      this.book = bookName.book;
    }

    public BookName build() {
      return new BookName(this);
    }
  }
}
