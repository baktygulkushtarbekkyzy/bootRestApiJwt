package com.example.bootrestapi.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class GroupResponse {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private String image;
}
