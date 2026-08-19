// Copyright 2024 Google LLC
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

package main

import (
	"net/http"
	"net/http/httptest"
	"os"
	"path/filepath"
	"strings"
	"testing"
)

func TestShouldSkipPom(t *testing.T) {
	tests := []struct {
		path     string
		expected bool
	}{
		{"./samples/snippets/pom.xml", true},
		{"./showcase/pom.xml", true},
		{"./coverage-report/pom.xml", true},
		{"./sdk-platform-java/pom.xml", true},
		{"./java-vertexai/pom.xml", true},
		{"./storage-shared-benchmarking/pom.xml", true},
		{"./java-bigtable/test-proxy/pom.xml", true},
		{"./java-shared-config/pom.xml", true},
		{"./java-shared-config/java-shared-config/pom.xml", false},
		{"./java-bigquery/pom.xml", false},
		{"./java-storage/google-cloud-storage/pom.xml", false},
	}

	for _, tc := range tests {
		got := shouldSkipPom(tc.path)
		if got != tc.expected {
			t.Errorf("shouldSkipPom(%q) = %v; want %v", tc.path, got, tc.expected)
		}
	}
}

func TestParsePomCoordinates(t *testing.T) {
	tempDir := t.TempDir()
	pomPath := filepath.Join(tempDir, "pom.xml")

	pomContent := `<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-test</artifactId>
  <version>1.2.3</version>
</project>`
	if err := os.WriteFile(pomPath, []byte(pomContent), 0644); err != nil {
		t.Fatalf("Failed to write test pom: %v", err)
	}

	proj, err := parsePomCoordinates(pomPath)
	if err != nil {
		t.Fatalf("parsePomCoordinates error: %v", err)
	}

	if proj.GroupID != "com.google.cloud" || proj.ArtifactID != "google-cloud-test" || proj.Version != "1.2.3" {
		t.Errorf("Coordinates mismatch: got %v", proj)
	}
}

func TestRunChecksWithMockServer(t *testing.T) {
	// Mock server that returns 200 for existing artifact, 404 for new artifact
	server := httptest.NewServer(http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		if strings.Contains(r.URL.Path, "exists") {
			w.WriteHeader(http.StatusOK)
		} else {
			w.WriteHeader(http.StatusNotFound)
		}
	}))
	defer server.Close()

	tempDir := t.TempDir()

	pomExisting := filepath.Join(tempDir, "pom-existing.xml")
	os.WriteFile(pomExisting, []byte(`
<project>
  <groupId>com.google.cloud</groupId>
  <artifactId>exists-artifact</artifactId>
  <version>1.0.0</version>
</project>`), 0644)

	pomNew := filepath.Join(tempDir, "pom-new.xml")
	os.WriteFile(pomNew, []byte(`
<project>
  <groupId>com.google.cloud</groupId>
  <artifactId>new-artifact</artifactId>
  <version>1.0.0</version>
</project>`), 0644)

	pomSnapshot := filepath.Join(tempDir, "pom-snapshot.xml")
	os.WriteFile(pomSnapshot, []byte(`
<project>
  <groupId>com.google.cloud</groupId>
  <artifactId>snapshot-artifact</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</project>`), 0644)

	// Test 1: New artifact (should pass)
	hasError, output := runChecks([]string{pomNew}, server.URL, server.Client())
	if hasError {
		t.Errorf("Expected runChecks to pass for new artifact, got error. Output:\n%s", output)
	}
	if !strings.Contains(output, "status_code 404") {
		t.Errorf("Expected 404 status in output, got:\n%s", output)
	}

	// Test 2: Existing artifact (should fail)
	hasError, output = runChecks([]string{pomExisting}, server.URL, server.Client())
	if !hasError {
		t.Errorf("Expected runChecks to fail for existing artifact. Output:\n%s", output)
	}
	if !strings.Contains(output, "The version already exists") {
		t.Errorf("Expected 'already exists' in output, got:\n%s", output)
	}

	// Test 3: Snapshot artifact (should fail)
	hasError, output = runChecks([]string{pomSnapshot}, server.URL, server.Client())
	if !hasError {
		t.Errorf("Expected runChecks to fail for SNAPSHOT artifact. Output:\n%s", output)
	}
	if !strings.Contains(output, "contains SNAPSHOT version") {
		t.Errorf("Expected SNAPSHOT error in output, got:\n%s", output)
	}
}
