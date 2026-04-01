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

import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.common.base.Strings;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommentFormatter {

  private CommentFormatter() {}

  // Additional formatting logic for converting protobuf comment to Javadoc
  public static String formatAsJavaDocComment(String comment, String prefixPattern) {

    JavaDocComment.Builder javaDocCommentBuilder = JavaDocComment.builder();

    String[] descriptionParagraphs = comment.split("\\n\\n");
    for (int i = 0; i < descriptionParagraphs.length; i++) {
      boolean startsWithItemizedList = descriptionParagraphs[i].startsWith(" * ");
      // Split by listed items, then join newlines.
      List<String> listItems =
          Stream.of(descriptionParagraphs[i].split("\\n \\*"))
              .map(s -> s.replace("\n", ""))
              .collect(Collectors.toList());
      if (startsWithItemizedList) {
        // Remove the first asterisk.
        listItems.set(0, listItems.get(0).substring(2));
      }

      if (!startsWithItemizedList) {
        if (i == 0 && !Strings.isNullOrEmpty(prefixPattern)) {
          javaDocCommentBuilder =
              javaDocCommentBuilder.addParagraph(String.format(prefixPattern, listItems.get(0)));
        } else {
          javaDocCommentBuilder = javaDocCommentBuilder.addParagraph(listItems.get(0));
        }
      }
      if (listItems.size() > 1 || startsWithItemizedList) {
        javaDocCommentBuilder =
            javaDocCommentBuilder.addUnorderedList(
                listItems.subList(startsWithItemizedList ? 0 : 1, listItems.size()));
      }
    }

    return javaDocCommentBuilder.build().comment();
  }
}
