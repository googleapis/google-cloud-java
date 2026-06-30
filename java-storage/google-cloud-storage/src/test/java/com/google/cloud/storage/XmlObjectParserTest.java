/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.cloud.storage.multipartupload.model.ListPartsResponse;
import com.google.common.base.MoreObjects;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;

public class XmlObjectParserTest {

  private XmlObjectParser xmlObjectParser;

  @Before
  public void setUp() {
    xmlObjectParser = new XmlObjectParser(new XmlMapper());
  }

  @Test
  public void testParseStringValueEnum() throws IOException {
    // language=xml
    String xml =
        "<TestXmlObject2>\n" + "  <storageClass>STANDARD</storageClass>" + "</TestXmlObject2>";
    InputStream in = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
    TestXmlObject2 expected = new TestXmlObject2(StorageClass.STANDARD);
    TestXmlObject2 actual =
        xmlObjectParser.parseAndClose(in, StandardCharsets.UTF_8, TestXmlObject2.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testParseDoesNotFailOnUnknownFields() throws IOException {
    // language=xml
    String xml =
        "<TestXmlObject2>\n"
            + "  <storageClass>STANDARD</storageClass>"
            + "  <UnknownField>blah</UnknownField>"
            + "</TestXmlObject2>";
    InputStream in = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
    TestXmlObject2 expected = new TestXmlObject2(StorageClass.STANDARD);
    TestXmlObject2 actual =
        xmlObjectParser.parseAndClose(in, StandardCharsets.UTF_8, TestXmlObject2.class);
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void testNestedParseStringValueEnum_undefined() throws IOException {
    // language=xml
    String xml =
        "<ListPartsResponse>\n"
            + "  <truncated>false</truncated>\n"
            + "  <Bucket>bucket</Bucket>\n"
            + "  <Key>key</Key>\n"
            + "  <UploadId/>\n"
            + "  <PartNumberMarker>0</PartNumberMarker>\n"
            + "  <NextPartNumberMarker>0</NextPartNumberMarker>\n"
            + "  <MaxParts>0</MaxParts>\n"
            + "  <IsTruncated>false</IsTruncated>\n"
            + "  <Part>\n"
            + "    <PartNumber>1</PartNumber>\n"
            + "    <ETag>etag</ETag>\n"
            + "    <Size>33</Size>\n"
            + "    <LastModified/>\n"
            + "  </Part>\n"
            + "</ListPartsResponse>";
    ListPartsResponse listPartsResponse =
        xmlObjectParser.parseAndClose(new StringReader(xml), ListPartsResponse.class);
    assertThat(listPartsResponse.storageClass()).isNull();
  }

  @Test
  public void testNestedParseStringValueEnum_null() throws IOException {
    // language=xml
    String xml =
        "<ListPartsResponse>\n"
            + "  <truncated>false</truncated>\n"
            + "  <Bucket>bucket</Bucket>\n"
            + "  <Key>key</Key>\n"
            + "  <UploadId/>\n"
            + "  <PartNumberMarker>0</PartNumberMarker>\n"
            + "  <NextPartNumberMarker>0</NextPartNumberMarker>\n"
            + "  <MaxParts>0</MaxParts>\n"
            + "  <IsTruncated>false</IsTruncated>\n"
            + "  <StorageClass/>"
            + "  <Part>\n"
            + "    <PartNumber>1</PartNumber>\n"
            + "    <ETag>etag</ETag>\n"
            + "    <Size>33</Size>\n"
            + "    <LastModified/>\n"
            + "  </Part>\n"
            + "</ListPartsResponse>";
    ListPartsResponse listPartsResponse =
        xmlObjectParser.parseAndClose(new StringReader(xml), ListPartsResponse.class);
    assertThat(listPartsResponse.storageClass()).isNull();
  }

  @Test
  public void testNestedParseStringValueEnum_nonNull() throws IOException {
    // language=xml
    String xml =
        "<ListPartsResponse>\n"
            + "  <truncated>false</truncated>\n"
            + "  <Bucket>bucket</Bucket>\n"
            + "  <Key>key</Key>\n"
            + "  <UploadId/>\n"
            + "  <PartNumberMarker>0</PartNumberMarker>\n"
            + "  <NextPartNumberMarker>0</NextPartNumberMarker>\n"
            + "  <MaxParts>0</MaxParts>\n"
            + "  <IsTruncated>false</IsTruncated>\n"
            + "  <StorageClass>STANDARD</StorageClass>"
            + "  <Part>\n"
            + "    <PartNumber>1</PartNumber>\n"
            + "    <ETag>etag</ETag>\n"
            + "    <Size>33</Size>\n"
            + "    <LastModified/>\n"
            + "  </Part>\n"
            + "</ListPartsResponse>";
    ListPartsResponse listPartsResponse =
        xmlObjectParser.parseAndClose(new StringReader(xml), ListPartsResponse.class);
    assertThat(listPartsResponse.storageClass()).isEqualTo(StorageClass.STANDARD);
  }

  private static class TestXmlObject {}

  private static final class TestXmlObject2 {
    @JacksonXmlProperty(localName = "storageClass")
    private StorageClass storageClass;

    private TestXmlObject2() {}

    public TestXmlObject2(StorageClass storageClass) {
      this.storageClass = storageClass;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof TestXmlObject2)) {
        return false;
      }
      TestXmlObject2 that = (TestXmlObject2) o;
      return Objects.equals(storageClass, that.storageClass);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(storageClass);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("storageClass", storageClass).toString();
    }
  }
}
