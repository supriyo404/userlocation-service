package com.supriyo.userlocation;


import org.junit.jupiter.api.BeforeEach;

import java.util.Objects;

public class HashCodeEqualsTest {

    private long id;
    private String name;
    private Double salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashCodeEqualsTest)) return false;
        HashCodeEqualsTest that = (HashCodeEqualsTest) o;
        return id == that.id && name.equals(that.name) && salary.equals(that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id,this.name,this.salary);
    }
}
