/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.translate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.services.translate.model.DetectionsResourceItems;
import com.google.api.services.translate.model.LanguagesResource;
import com.google.api.services.translate.model.TranslationsResource;
import com.google.auth.Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.translate.Translate.LanguageListOption;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.spi.TranslateRpcFactory;
import com.google.cloud.translate.spi.v2.TranslateRpc;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class TranslateImplTest {

  private static final String TARGET_LANGUAGE = "es";

  private static final LanguagesResource LANGUAGE1_PB =
      new LanguagesResource().setLanguage("en").setName("english");
  private static final LanguagesResource LANGUAGE2_PB =
      new LanguagesResource().setLanguage("es").setName("spanish");
  private static final LanguagesResource LANGUAGE3_PB =
      new LanguagesResource().setLanguage("en").setName("inglés");
  private static final LanguagesResource LANGUAGE4_PB =
      new LanguagesResource().setLanguage("es").setName("español");
  private static final Language LANGUAGE1 = Language.fromPb(LANGUAGE1_PB);
  private static final Language LANGUAGE2 = Language.fromPb(LANGUAGE2_PB);
  private static final Language LANGUAGE3 = Language.fromPb(LANGUAGE3_PB);
  private static final Language LANGUAGE4 = Language.fromPb(LANGUAGE4_PB);
  private static final List<Language> LANGUAGES1 = ImmutableList.of(LANGUAGE1, LANGUAGE2);
  private static final List<Language> LANGUAGES2 = ImmutableList.of(LANGUAGE3, LANGUAGE4);
  private static final DetectionsResourceItems DETECTION1_PB =
      new DetectionsResourceItems().setLanguage("en").setConfidence(0.9F);
  private static final DetectionsResourceItems DETECTION2_PB =
      new DetectionsResourceItems().setLanguage("en").setConfidence(0.8F);
  private static final Detection DETECTION1 = Detection.fromPb(DETECTION1_PB);
  private static final Detection DETECTION2 = Detection.fromPb(DETECTION2_PB);
  private static final TranslationsResource TRANSLATION1_PB =
      new TranslationsResource().setTranslatedText("Hello World!").setDetectedSourceLanguage("es");
  private static final TranslationsResource TRANSLATION2_PB =
      new TranslationsResource().setTranslatedText("Hello World!").setDetectedSourceLanguage("de");
  private static final Translation TRANSLATION1 = Translation.fromPb(TRANSLATION1_PB);
  private static final Translation TRANSLATION2 = Translation.fromPb(TRANSLATION2_PB);

  // Empty TranslateRpc options
  private static final Map<TranslateRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();

  // Language list options
  private static final LanguageListOption LANGUAGE_LIST_OPTION =
      LanguageListOption.targetLanguage(TARGET_LANGUAGE);
  private static final Map<TranslateRpc.Option, ?> LANGUAGE_LIST_OPTIONS =
      ImmutableMap.of(TranslateRpc.Option.TARGET_LANGUAGE, LANGUAGE_LIST_OPTION.getValue());

  // Translate options
  private static final TranslateOption TARGET_LANGUAGE_OPTION =
      TranslateOption.targetLanguage("en");
  private static final TranslateOption SOURCE_LANGUAGE_OPTION =
      TranslateOption.sourceLanguage("de");
  private static final TranslateOption MODEL_OPTION = TranslateOption.model("nmt");
  private static final TranslateOption FORMAT_OPTION = TranslateOption.format("text");
  private static final Map<TranslateRpc.Option, ?> TRANSLATE_OPTIONS =
      ImmutableMap.of(
          TranslateRpc.Option.TARGET_LANGUAGE,
          TARGET_LANGUAGE_OPTION.getValue(),
          TranslateRpc.Option.SOURCE_LANGUAGE,
          SOURCE_LANGUAGE_OPTION.getValue(),
          TranslateRpc.Option.MODEL,
          "nmt",
          TranslateRpc.Option.FORMAT,
          "text");
  private static final RetrySettings NO_RETRY_SETTINGS = ServiceOptions.getNoRetrySettings();

  private TranslateOptions options;
  private TranslateRpcFactory rpcFactoryMock;
  private TranslateRpc translateRpcMock;
  private Translate translate;

  @Before
  public void setUp() {
    rpcFactoryMock = EasyMock.createMock(TranslateRpcFactory.class);
    translateRpcMock = EasyMock.createMock(TranslateRpc.class);
    EasyMock.expect(rpcFactoryMock.create(EasyMock.anyObject(TranslateOptions.class)))
        .andReturn(translateRpcMock);
    EasyMock.replay(rpcFactoryMock);
    options =
        TranslateOptions.newBuilder()
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(NO_RETRY_SETTINGS)
            .build();
  }

  private void verify() {
    EasyMock.verify(rpcFactoryMock, translateRpcMock);
  }

  private void initializeService() {
    translate = options.getService();
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertSame(options, translate.getOptions());
    verify();
  }

  @Test
  public void testListSupportedLanguages() {
    EasyMock.expect(translateRpcMock.listSupportedLanguages(EMPTY_RPC_OPTIONS))
        .andReturn(ImmutableList.of(LANGUAGE1_PB, LANGUAGE2_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(LANGUAGES1, translate.listSupportedLanguages());
    verify();
  }

  @Test
  public void testListSupportedLanguagesWithOptions() {
    EasyMock.expect(translateRpcMock.listSupportedLanguages(LANGUAGE_LIST_OPTIONS))
        .andReturn(ImmutableList.of(LANGUAGE3_PB, LANGUAGE4_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(
        LANGUAGES2,
        translate.listSupportedLanguages(LanguageListOption.targetLanguage(TARGET_LANGUAGE)));
    verify();
  }

  @Test
  public void testDetect() {
    String text = "text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(ImmutableList.of(DETECTION1_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(DETECTION1, translate.detect(text));
    verify();
  }

  @Test
  public void testDetectMultipleDetections() {
    String text = "text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB, DETECTION2_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(text);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("Multiple detections found for text: text", ex.getMessage());
    }

    verify();
  }

  @Test
  public void testDetectNoDetection() {
    String text = "text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.<DetectionsResourceItems>of()));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(text);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("No detection found for text: text", ex.getMessage());
    }

    verify();
  }

  @Test
  public void testDetectList() {
    String text1 = "text";
    String text2 = "other text";
    List<String> texts = ImmutableList.of(text1, text2);
    EasyMock.expect(translateRpcMock.detect(texts))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB), ImmutableList.of(DETECTION2_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(ImmutableList.of(DETECTION1, DETECTION2), translate.detect(texts));
    verify();
  }

  @Test
  public void testDetectListMultipleDetections() {
    String text1 = "text";
    String text2 = "other text";
    List<String> texts = ImmutableList.of(text1, text2);
    EasyMock.expect(translateRpcMock.detect(texts))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB, DETECTION2_PB), ImmutableList.of(DETECTION1_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(texts);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("Multiple detections found for text: text", ex.getMessage());
    }
    verify();
  }

  @Test
  public void testDetectListNoDetection() {
    String text1 = "text";
    String text2 = "other text";
    List<String> texts = ImmutableList.of(text1, text2);
    EasyMock.expect(translateRpcMock.detect(texts))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB), ImmutableList.<DetectionsResourceItems>of()));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(texts);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("No detection found for text: other text", ex.getMessage());
    }
    verify();
  }

  @Test
  public void testDetectVararg() {
    String text1 = "text";
    String text2 = "other text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text1, text2)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB), ImmutableList.of(DETECTION2_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(ImmutableList.of(DETECTION1, DETECTION2), translate.detect(text1, text2));
    verify();
  }

  @Test
  public void testDetectVarargMultipleDetections() {
    String text1 = "text";
    String text2 = "other text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text1, text2)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB, DETECTION2_PB), ImmutableList.of(DETECTION1_PB)));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(text1, text2);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("Multiple detections found for text: text", ex.getMessage());
    }

    verify();
  }

  @Test
  public void testDetectVarargNoDetection() {
    String text1 = "text";
    String text2 = "other text";
    EasyMock.expect(translateRpcMock.detect(ImmutableList.of(text1, text2)))
        .andReturn(
            ImmutableList.<List<DetectionsResourceItems>>of(
                ImmutableList.of(DETECTION1_PB), ImmutableList.<DetectionsResourceItems>of()));
    EasyMock.replay(translateRpcMock);
    initializeService();
    try {
      translate.detect(text1, text2);
      fail();
    } catch (IllegalStateException ex) {
      assertEquals("No detection found for text: other text", ex.getMessage());
    }
    verify();
  }

  @Test
  public void testTranslate() {
    String text = "¡Hola Mundo!";
    EasyMock.expect(translateRpcMock.translate(ImmutableList.of(text), EMPTY_RPC_OPTIONS))
        .andReturn(ImmutableList.of(TRANSLATION1_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(TRANSLATION1, translate.translate(text));
    verify();
  }

  @Test
  public void testTranslateWithOptions() {
    String text = "Hallo Welt!";
    EasyMock.expect(translateRpcMock.translate(ImmutableList.of(text), TRANSLATE_OPTIONS))
        .andReturn(ImmutableList.of(TRANSLATION2_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(
        TRANSLATION2,
        translate.translate(
            text, TARGET_LANGUAGE_OPTION, SOURCE_LANGUAGE_OPTION, MODEL_OPTION, FORMAT_OPTION));
    verify();
  }

  @Test
  public void testTranslateList() {
    String text1 = "¡Hola Mundo!";
    String text2 = "Hallo Welt!";
    List<String> texts = ImmutableList.of(text1, text2);
    EasyMock.expect(translateRpcMock.translate(texts, EMPTY_RPC_OPTIONS))
        .andReturn(ImmutableList.of(TRANSLATION1_PB, TRANSLATION2_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(ImmutableList.of(TRANSLATION1, TRANSLATION2), translate.translate(texts));
    verify();
  }

  @Test
  public void testTranslateListWithOptions() {
    String text = "Hallo Welt!";
    List<String> texts = ImmutableList.of(text);
    EasyMock.expect(translateRpcMock.translate(texts, TRANSLATE_OPTIONS))
        .andReturn(ImmutableList.of(TRANSLATION2_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(
        ImmutableList.of(TRANSLATION2),
        translate.translate(
            texts, TARGET_LANGUAGE_OPTION, SOURCE_LANGUAGE_OPTION, MODEL_OPTION, FORMAT_OPTION));
    verify();
  }

  @Test
  public void testTranslateTextListWithModel() {
    String text = "Hallo Welt!";
    List<String> texts = ImmutableList.of(text);
    EasyMock.expect(
            translateRpcMock.translate(texts, ImmutableMap.of(TranslateRpc.Option.MODEL, "nmt")))
        .andReturn(ImmutableList.of(TRANSLATION2_PB));
    EasyMock.replay(translateRpcMock);
    initializeService();
    assertEquals(ImmutableList.of(TRANSLATION2), translate.translate(texts, MODEL_OPTION));
    verify();
  }

  @Test
  public void testRetryableException() {
    EasyMock.expect(translateRpcMock.listSupportedLanguages(EMPTY_RPC_OPTIONS))
        .andThrow(new TranslateException(500, "internalError"))
        .andReturn(ImmutableList.of(LANGUAGE1_PB, LANGUAGE2_PB));
    EasyMock.replay(translateRpcMock);
    translate =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    assertEquals(LANGUAGES1, translate.listSupportedLanguages());
    verify();
  }

  @Test
  public void testNonRetryableException() {
    String exceptionMessage = "Not Implemented";
    EasyMock.expect(translateRpcMock.listSupportedLanguages(EMPTY_RPC_OPTIONS))
        .andThrow(new TranslateException(501, exceptionMessage));
    EasyMock.replay(translateRpcMock);
    translate =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    try {
      translate.listSupportedLanguages();
      fail();
    } catch (TranslateException ex) {
      assertEquals(exceptionMessage, ex.getMessage());
    }
    verify();
  }

  @Test
  public void testRuntimeException() {
    String exceptionMessage = "Artificial runtime exception";
    EasyMock.expect(translateRpcMock.listSupportedLanguages(EMPTY_RPC_OPTIONS))
        .andThrow(new RuntimeException(exceptionMessage));
    EasyMock.replay(translateRpcMock);
    translate =
        options
            .toBuilder()
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .build()
            .getService();
    try {
      translate.listSupportedLanguages();
      fail();
    } catch (RuntimeException ex) {
      assertNotNull(ex.getMessage());
    }
    verify();
  }

  @Test
  public void testCredentialsOverridesApiKey() {
    Credentials credentials = NoCredentials.getInstance();
    TranslateOptions overridden = options.toBuilder().setCredentials(credentials).build();
    assertSame(overridden.getCredentials(), credentials);
    assertNull(overridden.getApiKey());
  }
}
