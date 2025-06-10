package com.StableManagement.stable_management_api.dto.note;

import jakarta.validation.constraints.NotBlank;

public class NotePatchDto {
    @NotBlank
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
