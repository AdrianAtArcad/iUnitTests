package atu321.repository.imported.tests;

import java.util.Collection;
import org.json.JSONException;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.skyscreamer.jsonassert.JSONAssert;
import iunit.utilities.testcase.execution.TestCaseExecutionHelper;
import iunit.utilities.xml.XMLUtils;

@RunWith(value = Parameterized.class)
public class COU300TC1_EXISTCOUNTRY {

	static String inputXMLFilePath = "testcases/atu321.repository.imported.tests/COU300TC1_EXISTCOUNTRY.xml";
	String input;
	String expectedResult;

	public COU300TC1_EXISTCOUNTRY(String input, String expectedResult) {
		this.input = input;
		this.expectedResult = expectedResult;
	}

	@Parameters
	public static Collection<String[]> testData() {
		return XMLUtils.getTestData("resources/atu321.repository.imported.tests/COU300TC1_EXISTCOUNTRY");
	}

	@BeforeClass
	public static void setUpIUnitTables() {
		TestCaseExecutionHelper.setUpTestExecutionEnv(inputXMLFilePath);
	}

	@Before
	public void loadPrerequisites() {
		TestCaseExecutionHelper.executeBeforePrerequisiteSteps(inputXMLFilePath);
	}

	@Test
	public void test() throws JSONException {
		String actualResult = TestCaseExecutionHelper.executeTestCase(inputXMLFilePath, input);
		JSONAssert.assertEquals(expectedResult, actualResult, true);
	}

	@After
	public void deletePrerequisites() {
		TestCaseExecutionHelper.executeAfterPrerequisiteSteps();
	}

	@AfterClass
	public static void terminateTestExecution() {
		TestCaseExecutionHelper.dropTestExecutionEnv(inputXMLFilePath);
	}
}