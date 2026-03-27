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

package com.google.api.generator.gapic.composer.utils;

import static org.junit.Assert.assertEquals;

import com.google.api.generator.test.utils.LineFormatter;
import org.junit.jupiter.api.Test;

class CommentFormatterTest {
  private static final String SERVICE_DESCRIPTION_HEADER_PATTERN = "Service Description: %s";

  @Test
  void parseCommentWithItemizedList_paragraphContainsList() {
    String protobufComment =
        LineFormatter.lines(
            "Service Name\n\n",
            "One line initial description. Here is a list of items:\n",
            " * This is item one\n",
            " * This is item two");
    String result = CommentFormatter.formatAsJavaDocComment(protobufComment, null);
    String expectedJavaDocComment =
        LineFormatter.lines(
            "<p> Service Name\n",
            "<p> One line initial description. Here is a list of items:\n",
            "<ul>\n",
            "<li>  This is item one\n",
            "<li>  This is item two\n",
            "</ul>");
    assertEquals(expectedJavaDocComment, result);
  }

  @Test
  void parseCommentWithItemizedList_paragraphStartsWithList() {
    String protobufComment =
        LineFormatter.lines(
            "Paragraphs starting with list items should still be parsed as list:\n\n",
            " * This is item one\n",
            " * This is item two");
    String result = CommentFormatter.formatAsJavaDocComment(protobufComment, null);
    String expectedJavaDocComment =
        LineFormatter.lines(
            "<p> Paragraphs starting with list items should still be parsed as list:\n",
            "<ul>\n",
            "<li>  This is item one\n",
            "<li>  This is item two\n",
            "</ul>");
    assertEquals(expectedJavaDocComment, result);
  }

  @Test
  void parseCommentWithPrefixPattern_addIfStartsWithParagraph() {
    String protobufComment =
        LineFormatter.lines(
            "Service Name\n\n",
            "Here is a list of items:\n",
            " * This is item one\n",
            " * This is item two");
    String result =
        CommentFormatter.formatAsJavaDocComment(
            protobufComment, SERVICE_DESCRIPTION_HEADER_PATTERN);
    String expectedJavaDocComment =
        LineFormatter.lines(
            "<p> Service Description: Service Name\n",
            "<p> Here is a list of items:\n",
            "<ul>\n",
            "<li>  This is item one\n",
            "<li>  This is item two\n",
            "</ul>");
    assertEquals(expectedJavaDocComment, result);
  }

  @Test
  void parseCommentWithPrefixPattern_ignoreIfStartsWithList() {
    String protobufComment = LineFormatter.lines(" * This is item one\n", " * This is item two");
    String result =
        CommentFormatter.formatAsJavaDocComment(
            protobufComment, SERVICE_DESCRIPTION_HEADER_PATTERN);
    String expectedJavaDocComment =
        LineFormatter.lines(
            "<ul>\n", "<li>  This is item one\n", "<li>  This is item two\n", "</ul>");
    assertEquals(expectedJavaDocComment, result);
  }
}
