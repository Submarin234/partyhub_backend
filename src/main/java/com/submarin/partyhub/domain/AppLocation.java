package com.submarin.partyhub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppLocation {
    private Long id;
    private String name;
    private String address;
    private String description;
    private Double lat;
    private Double lon;
}