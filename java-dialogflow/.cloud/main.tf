terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "dialogflow" {
  service            = "dialogflow.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
locals {
  agent_display_name = "google-cloud-java-tests"
}
resource "google_dialogflow_agent" "design_time_agent" {
  display_name          = local.agent_display_name
  default_language_code = "en"
  time_zone             = "America/Los_Angeles"
  match_mode            = "MATCH_MODE_HYBRID"
  depends_on            = [google_project_service.dialogflow]
}
