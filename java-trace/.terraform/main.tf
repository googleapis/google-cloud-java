terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "trace_api" {
  service            = "cloudtrace.googleapis.com"
  disable_on_destroy = false
}
