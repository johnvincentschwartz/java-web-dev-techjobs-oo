package Tests;

import org.junit.Test;
import org.junit.Before;

import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job emptyJob1 = new Job();
    Job emptyJob2 = new Job();
    Job allFieldsJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job allFieldsJobNewId = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job dataNotAvailableJob = new Job("Product tester", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    String jobString = allFieldsJob.toString();
    String dataNotAvailableString = dataNotAvailableJob.toString();

    @Test
    public void testSettingJobId(){
        assertEquals(1, emptyJob2.getId() - emptyJob1.getId()); //test IDs are different and differ by 1
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        //Correctly assigns class of each field
        assertTrue(allFieldsJob.getEmployer() instanceof Employer);
        assertTrue(allFieldsJob.getLocation() instanceof Location);
        assertTrue(allFieldsJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(allFieldsJob.getPositionType() instanceof PositionType);

        //Correctly assigns value of each field
        assertEquals("Product tester", allFieldsJob.getName());
        assertEquals("ACME", allFieldsJob.getEmployer().getValue());
        assertEquals("Desert", allFieldsJob.getLocation().getValue());
        assertEquals("Persistence", allFieldsJob.getCoreCompetency().getValue());
        assertEquals("Quality control", allFieldsJob.getPositionType().getValue());
    }

    @Test
    public void testJobsForEquality(){
        //Make sure that two jobs with identical fields except ID return false
        assertFalse(allFieldsJob.equals(allFieldsJobNewId));
    }

    //toString testing

    @Test
    public void testToStringForBlankLines(){
        assertEquals('\n', jobString.charAt(0));
        assertEquals('\n', jobString.charAt(jobString.length() - 1));
    }

    @Test
    public void testNewLineAndDataPerField() {
        assertEquals(jobString,
                "\nID: " + allFieldsJob.getId() +
                        "\nName: Product tester" +
                        "\nEmployer: ACME" +
                        "\nLocation: Desert" +
                        "\nPosition Type: Quality control" +
                        "\nCore Competency: Persistence" +
                        "\n");
    }

    @Test
    public void testDataNotAvailable(){
        assertEquals(dataNotAvailableString,
                "\nID: " + dataNotAvailableJob.getId() +
                        "\nName: Product tester" +
                        "\nEmployer: Data not available" +
                        "\nLocation: Data not available" +
                        "\nPosition Type: Quality control" +
                        "\nCore Competency: Persistence" +
                        "\n");
    }
}



