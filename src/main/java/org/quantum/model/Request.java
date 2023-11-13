package org.quantum.model;

import jakarta.validation.constraints.NotBlank;

public record Request(@NotBlank(message = "string field should contain at least one character") String string) {

}
