package ru.innopolis.university.summerbootcamp.java.project.ai;


import org.junit.Assert;
import org.junit.Test;
import ru.innopolis.university.summerbootcamp.java.project.model.enums.CommandType;
import ru.innopolis.university.summerbootcamp.java.project.utils.Constants;

/**
 * Created by iskandar on 17/07/16.
 */
public class AIEngineTest {
    @Test
    public void behaviorTest() {
        AIEngine aien = new AIEngine();

        CommandType royalFlush = aien.getDecision(Constants.getFlushRoyal(), 100, 2);
        CommandType highestCard = aien.getDecision(Constants.getHighestCard(), 100, 100);
        CommandType noManeyNoFunny = aien.getDecision(Constants.getFlushRoyal(), 1, 2000000);

        Assert.assertEquals("Expecting rise on flush royal", royalFlush.toString(), "Rise");
        Assert.assertEquals("Expecting bluff on high card", highestCard.toString(), "Fold");
        Assert.assertEquals("Expecting fold when there is no money", noManeyNoFunny.toString(), "Fold");
    }
}
