package com.example.kisispring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public abstract class BaseDTO implements Serializable {
    private Long id;
    private boolean isActive = true;

    public BaseDTO(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaseDTO)) {
            return false;
        }
        BaseDTO that = (BaseDTO) o;
        return isActive == that.isActive &&
                id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive);
    }
}