package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    @DisplayName("첫번째 테스트")
    void t1() {
        System.out.println("테스트1");
    }

    @Test
    @DisplayName("두번째 테스트")
    void t2() {
        System.out.println("테스트2");
    }
}
