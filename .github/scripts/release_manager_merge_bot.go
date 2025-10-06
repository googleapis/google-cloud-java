// Copyright 2025 Google LLC
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

// release_manager_merge_bot is a script that automatically retries and merges a pull request.
//
// This script is designed to be run manually for a specific pull request. It will:
// 1. Check the CI/CD status of the pull request.
// 2. If the status is "failure", it will add Kokoro labels to retry the tests. It retries once.
// 3. If the status is "success", it will squash and merge the pull request.
// 4. If the status is "pending", it will wait and check again.
//
// Prerequisites:
// - Go must be installed (https://golang.org/doc/install).
// - A GitHub personal access token with repo scope must be set in the GITHUB_TOKEN environment variable.
//
// Example Usage:
//
// export GITHUB_TOKEN="<your GitHub token>"
// cd .github/scripts
// go run ./release_manager_merge_bot.go <PR URL>

package main

import (
	"context"
	"fmt"
	"log"
	"net/url"
	"os"
	"strconv"
	"strings"
	"time"

	"github.com/google/go-github/v62/github"
	"golang.org/x/oauth2"
)

// --- Configuration ---
// The labels to add when a test fails.
var labelsToAdd = []string{"kokoro:force-run", "kokoro:run"}

// --- End of Configuration ---

// parseURL parses a GitHub pull request URL and returns the owner, repository, and PR number.
func parseURL(prURL string) (string, string, int, error) {
	parsedURL, err := url.Parse(prURL)
	if err != nil {
		return "", "", 0, fmt.Errorf("failed to parse URL: %w", err)
	}

	pathParts := strings.Split(strings.Trim(parsedURL.Path, "/"), "/")
	if len(pathParts) < 4 || pathParts[2] != "pull" {
		return "", "", 0, fmt.Errorf("invalid GitHub pull request URL format")
	}

	owner := pathParts[0]
	repo := pathParts[1]
	prNumber, err := strconv.Atoi(pathParts[3])
	if err != nil {
		return "", "", 0, fmt.Errorf("failed to parse PR number: %w", err)
	}

	return owner, repo, prNumber, nil
}

// getMissingLabels checks for required labels on a PR and returns any that are missing.
func getMissingLabels(ctx context.Context, client *github.Client, owner, repo string, prNumber int) ([]string, error) {
	currentLabels, _, err := client.Issues.ListLabelsByIssue(ctx, owner, repo, prNumber, nil)
	if err != nil {
		return nil, fmt.Errorf("failed to get PR labels: %w", err)
	}

	labelSet := make(map[string]bool)
	for _, label := range currentLabels {
		labelSet[*label.Name] = true
	}

	var missingLabels []string
	for _, requiredLabel := range labelsToAdd {
		if !labelSet[requiredLabel] {
			missingLabels = append(missingLabels, requiredLabel)
		}
	}
	return missingLabels, nil
}

func main() {
	log.Println("Starting the release manager merge bot.")

	if len(os.Args) < 2 {
		log.Fatal("Error: Pull request URL is required. Example: go run ./release_manager_merge_bot.go <PR URL>")
	}
	prURL := os.Args[1]

	githubToken := os.Getenv("GITHUB_TOKEN")
	if githubToken == "" {
		log.Fatal("Error: GITHUB_TOKEN environment variable is not set.")
	}

	owner, repo, prNumber, err := parseURL(prURL)
	if err != nil {
		log.Fatalf("Error parsing URL: %v", err)
	}

	ctx := context.Background()
	ts := oauth2.StaticTokenSource(&oauth2.Token{AccessToken: githubToken})
	tc := oauth2.NewClient(ctx, ts)
	client := github.NewClient(tc)

	// --- Initial Label Check ---
	retryCount := 0
	log.Printf("Performing initial label check for PR #%d...", prNumber)
	missingLabels, err := getMissingLabels(ctx, client, owner, repo, prNumber)
	if err != nil {
		log.Printf("Warning: could not perform initial label check: %v", err)
	} else {
		if len(missingLabels) > 0 {
			log.Println("Required Kokoro labels are missing. Adding them now...")
			_, _, err := client.Issues.AddLabelsToIssue(ctx, owner, repo, prNumber, missingLabels)
			if err != nil {
				log.Printf("Warning: failed to add labels: %v", err)
			}
			retryCount++
		} else {
			log.Println("Required Kokoro labels are already present.")
		}
	}
	// --- End of Initial Label Check ---

	for {
		log.Printf("Checking status of PR #%d in %s/%s...", prNumber, owner, repo)

		// Declare variables at the top of the loop to avoid 'goto jumps over declaration' errors.
		var (
			pr     *github.PullRequest
			status *github.CombinedStatus
			state  string
			err    error
		)

		pr, _, err = client.PullRequests.Get(ctx, owner, repo, prNumber)
		if err != nil {
			log.Printf("An error occurred while getting PR info: %v", err)
			goto wait
		}

		status, _, err = client.Repositories.GetCombinedStatus(ctx, owner, repo, *pr.Head.SHA, nil)
		if err != nil {
			log.Printf("An error occurred while getting commit status: %v", err)
			goto wait
		}

		state = *status.State
		log.Printf("Overall status: %s", state)

		switch state {
		case "failure":
			if retryCount >= 2 {
				log.Fatal("The PR has failed twice after applying the Kokoro labels. Failing the script.")
			}
			log.Println("Some checks have failed. Retrying the tests...")
			_, _, err := client.Issues.AddLabelsToIssue(ctx, owner, repo, prNumber, labelsToAdd)
			if err != nil {
				log.Printf("An error occurred while adding labels: %v", err)
			}
			retryCount++
		case "success":
			log.Println("All checks have passed. Merging the pull request...")
			commitMessage := fmt.Sprintf("Merge pull request #%d from %s/%s", prNumber, owner, repo)
			mergeResult, _, err := client.PullRequests.Merge(ctx, owner, repo, prNumber, commitMessage, &github.PullRequestOptions{
				MergeMethod: "squash",
			})
			if err != nil {
				log.Fatalf("Failed to merge PR: %v", err)
			}
			log.Printf("Successfully squashed and merged PR #%d: %s", prNumber, *mergeResult.Message)
			return // Exit the program on success
		case "pending":
			log.Println("Some checks are still pending. Waiting for them to complete.")
		default:
			log.Printf("Unknown state: %s. No action taken.", state)
		}

	wait:
		log.Println("Waiting for 1 minute before retrying...")
		time.Sleep(60 * time.Second)
	}
}
