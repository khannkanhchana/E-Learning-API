package co.istad.kanhchana.elearninga01m1.features.category.dto;

import jdk.jshell.Snippet;
import lombok.Builder;

@Builder
public record CategoryResponse(
        Integer id,
        String name,
        String icon
) {

}
