package com.cloud.hroauth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;

}
