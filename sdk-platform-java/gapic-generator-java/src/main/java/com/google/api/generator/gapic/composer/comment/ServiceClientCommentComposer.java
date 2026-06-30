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

package com.google.api.generator.gapic.composer.comment;

import static java.util.stream.Collectors.toList;

import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.composer.utils.CommentFormatter;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServiceClientCommentComposer {
  // Tokens.
  private static final String EMPTY_STRING = "";
  private static final String API_EXCEPTION_TYPE_NAME = "com.google.api.gax.rpc.ApiException";
  private static final String EXCEPTION_CONDITION = "if the remote call fails";

  // Constants.
  private static final String SERVICE_DESCRIPTION_INTRO_STRING =
      "This class provides the ability to make remote calls to the backing service through method "
          + "calls that map to API methods. Sample code to get started:";
  private static final String SERVICE_DESCRIPTION_SURFACE_CODA_STRING =
      "See the individual methods for example code.";
  private static final String SERVICE_DESCRIPTION_RESOURCE_NAMES_FORMATTING_STRING =
      "Many parameters require resource names to be formatted in a particular way. To assist with"
          + " these names, this class includes a format method for each type of name, and"
          + " additionally a parse  method to extract the individual identifiers contained within"
          + " names that are returned.";
  private static final String SERVICE_DESCRIPTION_CREDENTIALS_SUMMARY_STRING =
      "To customize credentials:";
  private static final String SERVICE_DESCRIPTION_ENDPOINT_SUMMARY_STRING =
      "To customize the endpoint:";
  private static final String SERVICE_DESCRIPTION_TRANSPORT_SUMMARY_STRING =
      "To use %s transport (instead of %s) for sending and receiving requests over the wire:";

  private static final String SERVICE_DESCRIPTION_SAMPLE_REFERENCE_STRING =
      "Please refer to the GitHub repository's samples for more quickstart code snippets.";

  private static final String METHOD_DESCRIPTION_SAMPLE_CODE_SUMMARY_STRING = "Sample code:";

  // Patterns.
  private static final String CREATE_METHOD_STUB_ARG_PATTERN =
      "Constructs an instance of %s, using the given stub for making calls. This is for"
          + " advanced usage - prefer using create(%s).";

  private static final String SERVICE_DESCRIPTION_CLOSE_PATTERN =
      "Note: close() needs to be called on the %s object to clean up resources such as "
          + "threads. In the example above, try-with-resources is used, which automatically calls "
          + "close().";

  private static final String SERVICE_DESCRIPTION_CUSTOMIZE_SUMMARY_PATTERN =
      "This class can be customized by passing in a custom instance of %s to create(). For"
          + " example:";

  private static final String SERVICE_DESCRIPTION_SUMMARY_PATTERN = "Service Description: %s";

  private static final String CREATE_METHOD_NO_ARG_PATTERN =
      "Constructs an instance of %s with default settings.";

  private static final String CREATE_METHOD_SETTINGS_ARG_PATTERN =
      "Constructs an instance of %s, using the given settings. The channels are"
          + " created based  on the settings passed in, or defaults for any settings that are"
          + " not set.";

  private static final String PROTECTED_CONSTRUCTOR_SETTINGS_ARG_PATTERN =
      "Constructs an instance of %s, using the given settings. This is protected so"
          + " that it is easy to make a subclass, but otherwise, the static factory methods"
          + " should be preferred.";

  // Comments.
  public static final CommentStatement GET_OPERATIONS_CLIENT_METHOD_COMMENT =
      toSimpleComment(
          "Returns the OperationsClient that can be used to query the status of a long-running"
              + " operation returned by another API method call.");

  public static List<CommentStatement> createClassHeaderComments(
      Map<String, List<String>> methodVariantsForClientHeader,
      Service service,
      String classMethodSampleCode,
      String credentialsSampleCode,
      String endpointSampleCode,
      String transportSampleCode,
      String primaryTransport,
      String secondaryTransport) {
    JavaDocComment.Builder classHeaderJavadocBuilder = JavaDocComment.builder();
    if (service.hasDescription()) {
      String descriptionComment =
          CommentFormatter.formatAsJavaDocComment(
              service.description(), SERVICE_DESCRIPTION_SUMMARY_PATTERN);
      classHeaderJavadocBuilder = classHeaderJavadocBuilder.addUnescapedComment(descriptionComment);
    }

    // Include google.api.api_version breadcrumb comment.
    if (service.hasApiVersion()) {
      classHeaderJavadocBuilder.addParagraph(
          String.format("This client uses %s version %s.", service.name(), service.apiVersion()));
    }

    // Service introduction.
    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_INTRO_STRING);
    classHeaderJavadocBuilder.addSampleCode(classMethodSampleCode);

    // API surface description.
    classHeaderJavadocBuilder.addParagraph(
        String.format(
            SERVICE_DESCRIPTION_CLOSE_PATTERN, ClassNames.getServiceClientClassName(service)));

    // Build the map of methods and descriptions to create the table in Client Overviews
    List<MethodAndVariants> methodAndVariantsList =
        service.methods().stream()
            .map((Method method) -> createMethodAndVariants(method, methodVariantsForClientHeader))
            .collect(toList());

    classHeaderJavadocBuilder.addUnescapedComment(createTableOfMethods(methodAndVariantsList));
    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_SURFACE_CODA_STRING);

    // Formatting resource names.
    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_RESOURCE_NAMES_FORMATTING_STRING);

    // Customization examples.
    classHeaderJavadocBuilder.addParagraph(
        String.format(
            SERVICE_DESCRIPTION_CUSTOMIZE_SUMMARY_PATTERN,
            ClassNames.getServiceSettingsClassName(service)));
    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_CREDENTIALS_SUMMARY_STRING);
    classHeaderJavadocBuilder.addSampleCode(credentialsSampleCode);
    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_ENDPOINT_SUMMARY_STRING);
    classHeaderJavadocBuilder.addSampleCode(endpointSampleCode);
    if (transportSampleCode != null) {
      classHeaderJavadocBuilder.addParagraph(
          String.format(
              SERVICE_DESCRIPTION_TRANSPORT_SUMMARY_STRING, secondaryTransport, primaryTransport));
      classHeaderJavadocBuilder.addSampleCode(transportSampleCode);
    }

    classHeaderJavadocBuilder.addParagraph(SERVICE_DESCRIPTION_SAMPLE_REFERENCE_STRING);

    if (service.isDeprecated()) {
      classHeaderJavadocBuilder.setDeprecated(CommentComposer.DEPRECATED_CLASS_STRING);
    }

    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_CLASS_COMMENT,
        CommentStatement.withComment(classHeaderJavadocBuilder.build()));
  }

  public static CommentStatement createCreateMethodStubArgComment(
      String serviceName, TypeNode settingsType) {
    return toSimpleComment(
        String.format(
            CREATE_METHOD_STUB_ARG_PATTERN, serviceName, settingsType.reference().name()));
  }

  public static List<CommentStatement> createRpcMethodHeaderComment(
      Method method, List<MethodArgument> methodArguments, Optional<String> sampleCodeOpt) {
    JavaDocComment.Builder methodJavadocBuilder = JavaDocComment.builder();

    if (method.hasDescription()) {
      String descriptionComment =
          CommentFormatter.formatAsJavaDocComment(method.description(), null);
      methodJavadocBuilder = methodJavadocBuilder.addUnescapedComment(descriptionComment);
    }

    if (sampleCodeOpt.isPresent()) {
      methodJavadocBuilder.addParagraph(METHOD_DESCRIPTION_SAMPLE_CODE_SUMMARY_STRING);
      methodJavadocBuilder.addSampleCode(sampleCodeOpt.get());
    }

    if (methodArguments.isEmpty()) {
      methodJavadocBuilder.addParam(
          "request", "The request object containing all of the parameters for the API call.");
    } else {
      for (MethodArgument argument : methodArguments) {
        // TODO(miraleung): Remove the newline replacement when we support CommonMark.
        String description =
            argument.field().hasDescription() ? argument.field().description() : EMPTY_STRING;
        methodJavadocBuilder.addParam(JavaStyle.toLowerCamelCase(argument.name()), description);
      }
    }

    methodJavadocBuilder.setThrows(API_EXCEPTION_TYPE_NAME, EXCEPTION_CONDITION);

    if (method.isDeprecated()) {
      methodJavadocBuilder.setDeprecated(CommentComposer.DEPRECATED_METHOD_STRING);
    }

    if (method.isInternalApi()) {
      methodJavadocBuilder.setInternalOnly(CommentComposer.INTERNAL_ONLY_METHOD_STRING);
    }

    List<CommentStatement> comments = new ArrayList<>();
    comments.add(CommentComposer.AUTO_GENERATED_METHOD_COMMENT);
    if (!methodJavadocBuilder.emptyComments()) {
      comments.add(CommentStatement.withComment(methodJavadocBuilder.build()));
    }

    return comments;
  }

  private static MethodAndVariants createMethodAndVariants(
      Method method, Map<String, List<String>> methodVariantsForClientHeader) {
    String name = method.name();
    String description = method.description();
    if (description == null) description = "";
    return new MethodAndVariants(name, description, methodVariantsForClientHeader.get(name));
  }

  private static String createTableOfMethods(List<MethodAndVariants> methodAndVariantsList) {
    String FLATTENED_METHODS =
        "<p>\"Flattened\" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>\n";
    String REQUEST_OBJECT_METHODS =
        "<p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>\n";
    String CALLABLE_METHODS =
        "<p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>\n";
    String ASYNC_METHODS =
        "<p>Methods that return long-running operations have \"Async\" method variants that return `OperationFuture`, which is used to track polling of the service.</p>\n";

    StringBuilder tableBuilder = new StringBuilder();
    tableBuilder
        .append("<table>\n")
        .append("   <caption>Methods</caption>\n")
        .append("   <tr>\n")
        .append("     <th>Method</th>\n")
        .append("     <th>Description</th>\n")
        .append("     <th>Method Variants</th>\n")
        .append("   </tr>\n");
    for (MethodAndVariants method : methodAndVariantsList) {
      tableBuilder
          .append("   <tr>\n")
          .append("     <td>")
          .append(CommentFormatter.formatAsJavaDocComment(method.method, null))
          .append("</td>\n")
          .append("     <td>")
          .append(CommentFormatter.formatAsJavaDocComment(method.description, null))
          .append("</td>\n")
          .append("     <td>\n");
      generateUnorderedListMethodVariants(
          tableBuilder, REQUEST_OBJECT_METHODS, method.requestObjectVariants);
      generateUnorderedListMethodVariants(
          tableBuilder, FLATTENED_METHODS, method.flattenedVariants);
      generateUnorderedListMethodVariants(tableBuilder, ASYNC_METHODS, method.asyncVariants);
      generateUnorderedListMethodVariants(tableBuilder, CALLABLE_METHODS, method.callableVariants);
      tableBuilder.append("      </td>\n").append("   </tr>\n");
    }
    tableBuilder.append(" </table>\n");
    return tableBuilder.toString();
  }

  private static void generateUnorderedListMethodVariants(
      StringBuilder tableBuilder, String methodType, List<String> methodVariants) {
    List<String> formattedMethodVariants =
        methodVariants.stream()
            .map(
                methodVariant ->
                    CommentFormatter.formatAsJavaDocComment(
                        methodVariant, null)) // Apply the formatting to each element
            .collect(Collectors.toList());
    if (!methodVariants.isEmpty()) {
      tableBuilder
          .append("     " + methodType + "     ")
          .append("<ul>\n")
          .append("          <li>")
          .append(String.join("\n          <li>", formattedMethodVariants))
          .append("\n")
          .append("     </ul>")
          .append("\n");
    }
  }

  private static class MethodAndVariants {
    private final String method;
    // Description may be empty. It comes from the proto comments above the method. If it is empty,
    // then nothing will be displayed.
    private final String description;

    private final List<String> flattenedVariants;
    private final List<String> requestObjectVariants;
    private final List<String> callableVariants;
    private final List<String> asyncVariants;

    private MethodAndVariants(String method, String description, List<String> methodVariants) {
      this.method = method;
      this.description = description;
      requestObjectVariants =
          methodVariants.stream().filter(s -> s.contains("request")).collect(toList());
      // Flattened method variants do not have a suffix, so the easiest way to identify them is by
      // removing all other method variant types.
      methodVariants.removeAll(requestObjectVariants);
      callableVariants =
          methodVariants.stream().filter(s -> s.contains("Callable")).collect(toList());
      methodVariants.removeAll(callableVariants);
      asyncVariants = methodVariants.stream().filter(s -> s.contains("Async")).collect(toList());
      methodVariants.removeAll(asyncVariants);
      flattenedVariants = methodVariants;
    }
  }

  public static List<CommentStatement> createRpcMethodHeaderComment(
      Method method, Optional<String> sampleCodeOpt) {
    return createRpcMethodHeaderComment(method, Collections.emptyList(), sampleCodeOpt);
  }

  public static CommentStatement createMethodNoArgComment(String serviceName) {
    return toSimpleComment(String.format(CREATE_METHOD_NO_ARG_PATTERN, serviceName));
  }

  public static CommentStatement createProtectedCtorSettingsArgComment(String serviceName) {
    return toSimpleComment(String.format(PROTECTED_CONSTRUCTOR_SETTINGS_ARG_PATTERN, serviceName));
  }

  public static CommentStatement createMethodSettingsArgComment(String serviceName) {
    return toSimpleComment(String.format(CREATE_METHOD_SETTINGS_ARG_PATTERN, serviceName));
  }

  public static List<CommentStatement> createRpcCallableMethodHeaderComment(
      Method method, Optional<String> sampleCodeOpt) {
    JavaDocComment.Builder methodJavadocBuilder = JavaDocComment.builder();

    if (method.hasDescription()) {
      String descriptionComment =
          CommentFormatter.formatAsJavaDocComment(method.description(), null);
      methodJavadocBuilder = methodJavadocBuilder.addUnescapedComment(descriptionComment);
    }

    methodJavadocBuilder.addParagraph(METHOD_DESCRIPTION_SAMPLE_CODE_SUMMARY_STRING);
    if (sampleCodeOpt.isPresent()) {
      methodJavadocBuilder.addSampleCode(sampleCodeOpt.get());
    }

    if (method.isDeprecated()) {
      methodJavadocBuilder.setDeprecated(CommentComposer.DEPRECATED_METHOD_STRING);
    }

    if (method.isInternalApi()) {
      methodJavadocBuilder.setInternalOnly(CommentComposer.INTERNAL_ONLY_METHOD_STRING);
    }

    return Arrays.asList(
        CommentComposer.AUTO_GENERATED_METHOD_COMMENT,
        CommentStatement.withComment(methodJavadocBuilder.build()));
  }

  private static CommentStatement toSimpleComment(String comment) {
    return CommentStatement.withComment(JavaDocComment.withComment(comment));
  }
}
