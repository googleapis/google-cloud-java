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

package com.google.api.generator.engine.ast;

import com.google.api.generator.engine.escaper.HtmlEscaper;
import com.google.api.generator.engine.escaper.MetacharEscaper;
import com.google.auto.value.AutoValue;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AutoValue
public abstract class JavaDocComment implements Comment {
  @Override
  public abstract String comment();

  // Convenience helper for simple comments.
  public static JavaDocComment withComment(String comment) {
    return builder().addComment(comment).build();
  }

  public static Builder builder() {
    return new AutoValue_JavaDocComment.Builder();
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    static final String PARAM_INDENT = "       ";

    // The lack of a getter for these local variables in the external class is WAI.
    String throwsType = null;
    String throwsDescription = null;
    String deprecated = null;
    String internalOnly = null;
    String returnDescription = null;
    List<String> paramsList = new ArrayList<>();
    List<String> componentsList = new ArrayList<>();

    // Private accessor, set complete and consolidated comment.
    abstract Builder setComment(String comment);

    abstract JavaDocComment autoBuild();

    public Builder setThrows(String type, String description) {
      throwsType = type;
      throwsDescription = description;
      return this;
    }

    public Builder setDeprecated(String deprecatedText) {
      deprecated = deprecatedText;
      return this;
    }

    public Builder setInternalOnly(String internalOnlyText) {
      internalOnly = internalOnlyText;
      return this;
    }

    public Builder setReturn(String returnText) {
      returnDescription = returnText;
      return this;
    }

    public Builder addParam(String name, String description) {
      paramsList.add(String.format("@param %s %s", name, processParamComment(description)));
      return this;
    }

    public Builder addUnescapedComment(String comment) {
      componentsList.add(comment);
      return this;
    }

    public Builder addComment(String comment) {
      componentsList.add(HtmlEscaper.process(comment));
      return this;
    }

    // TODO(developer): <pre> and {@code} is not supporting rendering '@' character, it is evaluated
    // as Javadoc tag. Please handle '@' character if need in the future. More details at
    // https://reflectoring.io/howto-format-code-snippets-in-javadoc/#pre--code
    public Builder addSampleCode(String sampleCode) {
      componentsList.add("<pre>{@code");
      Arrays.stream(sampleCode.split("\\r?\\n"))
          .forEach(
              line -> {
                componentsList.add(line);
              });
      componentsList.add("}</pre>");
      return this;
    }

    public Builder addParagraph(String paragraph) {
      componentsList.add(String.format("<p> %s", HtmlEscaper.process(paragraph)));
      return this;
    }

    public Builder addOrderedList(List<String> oList) {
      componentsList.add("<ol>");
      oList.stream()
          .forEach(
              s -> {
                componentsList.add(String.format("<li> %s", HtmlEscaper.process(s)));
              });
      componentsList.add("</ol>");
      return this;
    }

    public Builder addUnorderedList(List<String> uList) {
      componentsList.add("<ul>");
      uList.stream()
          .forEach(
              s -> {
                componentsList.add(String.format("<li> %s", HtmlEscaper.process(s)));
              });
      componentsList.add("</ul>");
      return this;
    }

    public boolean emptyComments() {
      return Strings.isNullOrEmpty(throwsType)
          && Strings.isNullOrEmpty(throwsDescription)
          && Strings.isNullOrEmpty(deprecated)
          && Strings.isNullOrEmpty(internalOnly)
          && Strings.isNullOrEmpty(returnDescription)
          && paramsList.isEmpty()
          && componentsList.isEmpty();
    }

    public JavaDocComment build() {
      // Add additional descriptive text before block tags.
      if (!Strings.isNullOrEmpty(internalOnly)) {
        componentsList.add(
            String.format("<p> <b>Warning: </b>%s", HtmlEscaper.process(internalOnly)));
      }
      // @param, @throws, @return and @deprecated should always get printed at the
      // end.
      componentsList.addAll(paramsList);
      if (!Strings.isNullOrEmpty(throwsType)) {
        componentsList.add(
            String.format("@throws %s %s", throwsType, HtmlEscaper.process(throwsDescription)));
      }
      if (!Strings.isNullOrEmpty(deprecated)) {
        componentsList.add(String.format("@deprecated %s", deprecated));
      }
      if (!Strings.isNullOrEmpty(returnDescription)) {
        componentsList.add(String.format("@return %s", returnDescription));
      }
      // Escape component in list one by one, because we will join the components by `\n`
      // `\n` will be taken as escape character by the comment escaper.
      componentsList =
          componentsList.stream().map(c -> MetacharEscaper.process(c)).collect(Collectors.toList());
      setComment(String.join("\n", componentsList));
      return autoBuild();
    }

    // TODO(miraleung): Refactor param paragraph parsing to be more robust.
    private static String processParamComment(String rawComment) {
      StringBuilder processedCommentBuilder = new StringBuilder();
      String[] descriptionParagraphs = rawComment.split("\\n\\n");
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
          if (i == 0) {
            processedCommentBuilder.append(
                String.format("%s", HtmlEscaper.process(listItems.get(0))));
          } else {
            processedCommentBuilder.append(
                String.format("%s<p> %s", PARAM_INDENT, HtmlEscaper.process(listItems.get(0))));
          }
        }
        if (listItems.size() > 1 || startsWithItemizedList) {
          processedCommentBuilder.append(
              String.format(
                  "%s<ul>\n%s\n%s</ul>",
                  PARAM_INDENT,
                  listItems.subList(startsWithItemizedList ? 0 : 1, listItems.size()).stream()
                      .map(li -> String.format("%s  <li>%s", PARAM_INDENT, HtmlEscaper.process(li)))
                      .reduce("", String::concat),
                  PARAM_INDENT));
        }
      }
      return processedCommentBuilder.toString();
    }
  }
}
