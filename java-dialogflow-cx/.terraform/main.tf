terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}

resource "google_project_service" "dialogflow_api" {
  service            = "dialogflow.googleapis.com"
  disable_on_destroy = false
}
