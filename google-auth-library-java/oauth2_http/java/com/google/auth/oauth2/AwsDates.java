/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.auth.oauth2;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/** Formats dates required for AWS Signature V4 request signing. */
final class AwsDates {
  private static final String X_AMZ_DATE_FORMAT = "yyyyMMdd'T'HHmmss'Z'";
  private static final String HTTP_DATE_FORMAT = "E, dd MMM yyyy HH:mm:ss z";

  private final String xAmzDate;
  private final String originalDate;

  private AwsDates(String amzDate) {
    this.xAmzDate = checkNotNull(amzDate);
    this.originalDate = amzDate;
  }

  private AwsDates(String xAmzDate, String originalDate) {
    this.xAmzDate = checkNotNull(xAmzDate);
    this.originalDate = checkNotNull(originalDate);
  }

  /**
   * Returns the original date. This can either be the x-amz-date or a specified date in the format
   * of E, dd MMM yyyy HH:mm:ss z.
   */
  String getOriginalDate() {
    return originalDate;
  }

  /** Returns the x-amz-date in yyyyMMdd'T'HHmmss'Z' format. */
  String getXAmzDate() {
    return xAmzDate;
  }

  /** Returns the x-amz-date in YYYYMMDD format. */
  String getFormattedDate() {
    return xAmzDate.substring(0, 8);
  }

  static AwsDates fromXAmzDate(String xAmzDate) throws ParseException {
    // Validate format
    new SimpleDateFormat(AwsDates.X_AMZ_DATE_FORMAT).parse(xAmzDate);
    return new AwsDates(xAmzDate);
  }

  static AwsDates fromDateHeader(String date) throws ParseException {
    DateFormat dateFormat = new SimpleDateFormat(X_AMZ_DATE_FORMAT);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

    Date inputDate = new SimpleDateFormat(HTTP_DATE_FORMAT).parse(date);
    String xAmzDate = dateFormat.format(inputDate);
    return new AwsDates(xAmzDate, date);
  }

  static AwsDates generateXAmzDate() {
    DateFormat dateFormat = new SimpleDateFormat(X_AMZ_DATE_FORMAT);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    String xAmzDate = dateFormat.format(new Date(System.currentTimeMillis()));
    return new AwsDates(xAmzDate);
  }
}
