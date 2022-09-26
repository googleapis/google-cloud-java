terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "speech_api" {
  service            = "speech.googleapis.com"
  disable_on_destroy = false
}
