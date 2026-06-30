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

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link AwsRequestSigner}.
 *
 * <p><a
 * href="https://docs.aws.amazon.com/general/latest/gr/sigv4-signed-request-examples.html">Examples
 * of sigv4 signed requests</a>
 */
class AwsRequestSignerTest {

  private static final String DATE = "Mon, 09 Sep 2011 23:36:00 GMT";
  private static final String X_AMZ_DATE = "20200811T065522Z";

  private static final AwsSecurityCredentials BOTOCORE_CREDENTIALS =
      new AwsSecurityCredentials(
          "AKIDEXAMPLE", "wJalrXUtnFEMI/K7MDENG+bPxRfiCYEXAMPLEKEY", /* token= */ null);

  private AwsSecurityCredentials awsSecurityCredentials;

  @BeforeEach
  void setUp() throws IOException {
    // Required for date parsing when run in different Locales
    Locale.setDefault(Locale.US);
    awsSecurityCredentials = retrieveAwsSecurityCredentials();
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-vanilla.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-vanilla.sreq
  @Test
  void sign_getHost() {
    String url = "https://host.foo.com";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "b27ccfbfa7df52a200ff74193ca6e32d4b48b8856fab7ebf1c595d0670a7e470";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-relative-relative.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-relative-relative.sreq
  @Test
  void sign_getHostRelativePath() {
    String url = "https://host.foo.com/foo/bar/../..";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "b27ccfbfa7df52a200ff74193ca6e32d4b48b8856fab7ebf1c595d0670a7e470";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-slash-dot-slash.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-slash-dot-slash.sreq
  @Test
  void sign_getHostInvalidPath() {
    String url = "https://host.foo.com/./";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "b27ccfbfa7df52a200ff74193ca6e32d4b48b8856fab7ebf1c595d0670a7e470";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-slash-pointless-dot.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-slash-pointless-dot.sreq
  @Test
  void sign_getHostDotPath() {
    String url = "https://host.foo.com/./foo";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "910e4d6c9abafaf87898e1eb4c929135782ea25bb0279703146455745391e63a";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-utf8.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-utf8.sreq
  @Test
  void sign_getHostUtf8Path() {
    String url = "https://host.foo.com/%E1%88%B4";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "8d6634c189aa8c75c2e51e106b6b5121bed103fdb351f7d7d4381c738823af74";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-vanilla-query-order-key-case.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-vanilla-query-order-key-case.sreq
  @Test
  void sign_getHostDuplicateQueryParam() {
    String url = "https://host.foo.com/?foo=Zoo&foo=aha";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "GET", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "be7148d34ebccdc6423b19085378aa0bee970bdc61d144bd1a8c48c33079ab09";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-header-key-sort.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-header-key-sort.sreq
  @Test
  void sign_postWithUpperCaseHeaderKey() {
    String url = "https://host.foo.com/";
    String headerKey = "ZOO";
    String headerValue = "zoobar";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);
    headers.put(headerKey, headerValue);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "POST", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "b7a95a52518abbca0964a999a880429ab734f35ebbf1235bd79a5de87756dc4a";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host;zoo, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
    assertEquals(headerValue, signature.getCanonicalHeaders().get(headerKey.toLowerCase()));
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-header-value-case.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-header-value-case.sreq
  @Test
  void sign_postWithUpperCaseHeaderValue() {
    String url = "https://host.foo.com/";
    String headerKey = "zoo";
    String headerValue = "ZOOBAR";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);
    headers.put("zoo", "ZOOBAR");

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "POST", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "273313af9d0c265c531e11db70bbd653f3ba074c1009239e8559d3987039cad7";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host;zoo, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
    assertEquals(headerValue, signature.getCanonicalHeaders().get(headerKey.toLowerCase()));
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-header-value-trim.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/get-header-value-trim.sreq
  @Test
  void sign_postWithHeader() {
    String url = "https://host.foo.com/";
    String headerKey = "p";
    String headerValue = "phfft";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);
    headers.put(headerKey, headerValue);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "POST", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "debf546796015d6f6ded8626f5ce98597c33b47b9164cf6b17b4642036fcb592";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host;p, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
    assertEquals(headerValue, signature.getCanonicalHeaders().get(headerKey.toLowerCase()));
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-x-www-form-urlencoded.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-x-www-form-urlencoded.sreq
  @Test
  void sign_postWithBodyNoCustomHeaders() {
    String url = "https://host.foo.com/";
    String headerKey = "Content-Type";
    String headerValue = "application/x-www-form-urlencoded";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);
    headers.put(headerKey, headerValue);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "POST", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .setRequestPayload("foo=bar")
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "5a15b22cf462f047318703b92e6f4f38884e4a7ab7b1d6426ca46a8bd1c26cbc";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=content-type;date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
    assertEquals(headerValue, signature.getCanonicalHeaders().get(headerKey.toLowerCase()));
  }

  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-vanilla-query.req
  // https://github.com/boto/botocore/blob/879f8440a4e9ace5d3cf145ce8b3d5e5ffb892ef/tests/unit/auth/aws4_testsuite/post-vanilla-query.sreq
  @Test
  void sign_postWithQueryString() {
    String url = "https://host.foo.com/?foo=bar";

    Map<String, String> headers = new HashMap<>();
    headers.put("date", DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(BOTOCORE_CREDENTIALS, "POST", url, "us-east-1")
            .setAdditionalHeaders(headers)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "b6e3b79003ce0743a491606ba1035a804593b0efb1e20a11cba83f8c25a57a92";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential=AKIDEXAMPLE/20110909/us-east-1/host/"
            + "aws4_request, SignedHeaders=date;host, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(BOTOCORE_CREDENTIALS, signature.getSecurityCredentials());
    assertEquals(DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-1", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  @Test
  void sign_getDescribeRegions() {
    String url = "https://ec2.us-east-2.amazonaws.com?Action=DescribeRegions&Version=2013-10-15";

    Map<String, String> additionalHeaders = new HashMap<>();
    additionalHeaders.put("x-amz-date", X_AMZ_DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(awsSecurityCredentials, "GET", url, "us-east-2")
            .setAdditionalHeaders(additionalHeaders)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "631ea80cddfaa545fdadb120dc92c9f18166e38a5c47b50fab9fce476e022855";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential="
            + awsSecurityCredentials.getAccessKeyId()
            + "/20200811/us-east-2/ec2/"
            + "aws4_request, SignedHeaders=host;x-amz-date;x-amz-security-token, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(awsSecurityCredentials, signature.getSecurityCredentials());
    assertEquals(X_AMZ_DATE, signature.getDate());
    assertEquals("GET", signature.getHttpMethod());
    assertEquals("us-east-2", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  @Test
  void sign_postGetCallerIdentity() {
    String url = "https://sts.us-east-2.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";

    Map<String, String> additionalHeaders = new HashMap<>();
    additionalHeaders.put("x-amz-date", X_AMZ_DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(awsSecurityCredentials, "POST", url, "us-east-2")
            .setAdditionalHeaders(additionalHeaders)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "73452984e4a880ffdc5c392355733ec3f5ba310d5e0609a89244440cadfe7a7a";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential="
            + awsSecurityCredentials.getAccessKeyId()
            + "/20200811/us-east-2/sts/"
            + "aws4_request, SignedHeaders=host;x-amz-date;x-amz-security-token, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(awsSecurityCredentials, signature.getSecurityCredentials());
    assertEquals(X_AMZ_DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-2", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  @Test
  void sign_postGetCallerIdentityNoToken() {
    String url = "https://sts.us-east-2.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";

    AwsSecurityCredentials awsSecurityCredentialsWithoutToken =
        new AwsSecurityCredentials(
            awsSecurityCredentials.getAccessKeyId(),
            awsSecurityCredentials.getSecretAccessKey(),
            /* token= */ null);

    Map<String, String> additionalHeaders = new HashMap<>();
    additionalHeaders.put("x-amz-date", X_AMZ_DATE);

    AwsRequestSigner signer =
        AwsRequestSigner.newBuilder(awsSecurityCredentialsWithoutToken, "POST", url, "us-east-2")
            .setAdditionalHeaders(additionalHeaders)
            .build();

    AwsRequestSignature signature = signer.sign();

    String expectedSignature = "d095ba304919cd0d5570ba8a3787884ee78b860f268ed040ba23831d55536d56";
    String expectedAuthHeader =
        "AWS4-HMAC-SHA256 Credential="
            + awsSecurityCredentials.getAccessKeyId()
            + "/20200811/us-east-2/sts/"
            + "aws4_request, SignedHeaders=host;x-amz-date, Signature="
            + expectedSignature;

    assertEquals(expectedSignature, signature.getSignature());
    assertEquals(expectedAuthHeader, signature.getAuthorizationHeader());
    assertEquals(awsSecurityCredentialsWithoutToken, signature.getSecurityCredentials());
    assertEquals(X_AMZ_DATE, signature.getDate());
    assertEquals("POST", signature.getHttpMethod());
    assertEquals("us-east-2", signature.getRegion());
    assertEquals(URI.create(url).normalize().toString(), signature.getUrl());
  }

  public AwsSecurityCredentials retrieveAwsSecurityCredentials() throws IOException {
    InputStream stream =
        AwsRequestSignerTest.class
            .getClassLoader()
            .getResourceAsStream("aws_security_credentials.json");

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    JsonObjectParser parser = new JsonObjectParser(jsonFactory);

    GenericJson json = parser.parseAndClose(stream, StandardCharsets.UTF_8, GenericJson.class);

    String accessKeyId = (String) json.get("AccessKeyId");
    String secretAccessKey = (String) json.get("SecretAccessKey");
    String awsToken = (String) json.get("Token");

    return new AwsSecurityCredentials(accessKeyId, secretAccessKey, awsToken);
  }
}
