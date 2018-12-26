/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.errorreporting;

// [START errorreporting_quickstart]
// [START error_reporting_quickstart]
// [START error_reporting_setup_java]

import com.google.cloud.ServiceOptions;
import com.google.cloud.errorreporting.v1beta1.ReportErrorsServiceClient;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorContext;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.SourceLocation;

/**
 * Snippet demonstrates using the Stackdriver Error Reporting API to report a custom error event.
 * <p>
 * This library is not required on App Engine, errors written to stderr are automatically written
 * to Stackdriver Error Reporting.
 * It is also not required if you are writing logs to Stackdriver Logging.
 * Errors written to Stackdriver Logging that contain an exception or stack trace
 * are automatically written out to Stackdriver Error Reporting.
 */
public class QuickStart {
  public static void main(String[] args) throws Exception {

    // Google Cloud Platform Project ID
    String projectId = (args.length > 0) ? args[0] : ServiceOptions.getDefaultProjectId();
    ProjectName projectName = ProjectName.of(projectId);

    // Instantiate an Error Reporting Client
    try (ReportErrorsServiceClient reportErrorsServiceClient = ReportErrorsServiceClient.create()) {

      // Custom error events require an error reporting location as well.
      ErrorContext errorContext = ErrorContext.newBuilder()
          .setReportLocation(SourceLocation.newBuilder()
              .setFilePath("Test.java")
              .setLineNumber(10)
              .setFunctionName("myMethod")
              .build())
          .build();

      //Report a custom error event
      ReportedErrorEvent customErrorEvent = ReportedErrorEvent.getDefaultInstance()
          .toBuilder()
          .setMessage("custom error event")
          .setContext(errorContext)
          .build();
      // Report an event synchronously, use .reportErrorEventCallable for asynchronous reporting.
      reportErrorsServiceClient.reportErrorEvent(projectName, customErrorEvent);
    }
  }
}
// [END error_reporting_setup_java]
// [END error_reporting_quickstart]
// [END errorreporting_quickstart]
