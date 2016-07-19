package ru.innopolis.university.summerbootcamp.java.project.utils;

import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.util.CommonUtils;

/**
 * Created by iskandar on 19/07/16.
 */
public class CommonUtilsTest {
    @Test
    public void inRangeTest() {
        Assert.assertTrue(
                "InRange function fails on integers (in range)",
                CommonUtils.isIn(new Integer(1), new Integer(10), new Integer(20))
        );

        Assert.assertTrue(
                "InRange function fails on integers (not in range)",
                !CommonUtils.isIn(new Integer(1), new Integer(21), new Integer(20))
        );

        Assert.assertTrue(
                "InRange function fails on integers (in range, extreme value)",
                CommonUtils.isIn(new Integer(1), new Integer(20), new Integer(20))
        );

        Assert.assertTrue(
                "InRange function fails on double (int range, extreme value)",
                CommonUtils.isIn(new Double(-1), new Double(19.9999), new Double(20))
        );

        Assert.assertTrue(
                "InRange function fails on double (not in range, extreme value)",
                !CommonUtils.isIn(new Double(1), new Double(20.1), new Double(20))
        );
    }
}
