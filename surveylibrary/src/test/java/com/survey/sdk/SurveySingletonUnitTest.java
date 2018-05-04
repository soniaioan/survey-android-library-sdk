package com.survey.sdk;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class SurveySingletonUnitTest {
    @Test
    public void oneInstanceIsCreated() throws Exception {
        //Instance 1
        Survey instance1 = Survey.init(null, "param1", "param2", "param3", "param4", "param5");
        //Instance 2
        Survey instance2 = Survey.init(null, "param", "param", "param", "param", "param");
        assertEquals(instance1.hashCode(), instance2.hashCode());
    }

}
