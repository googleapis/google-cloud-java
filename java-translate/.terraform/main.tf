terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "translate_api" {
  service            = "translate.googleapis.com"
  disable_on_destroy = false
}
