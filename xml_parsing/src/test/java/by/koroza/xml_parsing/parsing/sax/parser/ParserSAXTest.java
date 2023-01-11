package by.koroza.xml_parsing.parsing.sax.parser;

import static by.koroza.xml_parsing.enums.FlowerName.AFRICAN_DAISIES;
import static by.koroza.xml_parsing.enums.FlowerName.ALSTROEMERIA;
import static by.koroza.xml_parsing.enums.FlowerName.AMORPHOPHALLUS_TITANIC;
import static by.koroza.xml_parsing.enums.FlowerName.AQUILEGIA_COLOMBIAN;
import static by.koroza.xml_parsing.enums.FlowerName.ROSE;
import static by.koroza.xml_parsing.enums.ID.F1;
import static by.koroza.xml_parsing.enums.ID.F2;
import static by.koroza.xml_parsing.enums.ID.F3;
import static by.koroza.xml_parsing.enums.ID.F4;
import static by.koroza.xml_parsing.enums.ID.F5;
import static by.koroza.xml_parsing.enums.Measure.CENTIMETERS;
import static by.koroza.xml_parsing.enums.Measure.DEGREES_CELSIUS;
import static by.koroza.xml_parsing.enums.Measure.MILILITERS_PER_WEEK;
import static by.koroza.xml_parsing.enums.Multiplying.CUTTINGS;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_THE_BUSH;
import static by.koroza.xml_parsing.enums.Multiplying.DIVISION_TUBERS;
import static by.koroza.xml_parsing.enums.Multiplying.GRAFTING_FROM_BUDS_BUDDING;
import static by.koroza.xml_parsing.enums.Multiplying.LAYERING;
import static by.koroza.xml_parsing.enums.Multiplying.SEEDS;
import static by.koroza.xml_parsing.enums.Region.COLOMBIA;
import static by.koroza.xml_parsing.enums.Region.PERSIA;
import static by.koroza.xml_parsing.enums.Region.PERU;
import static by.koroza.xml_parsing.enums.Region.SOUTH_AFRICA;
import static by.koroza.xml_parsing.enums.Region.SUMATRA_ISLAND;
import static by.koroza.xml_parsing.enums.Soil.CLAY;
import static by.koroza.xml_parsing.enums.Soil.FERTILE_LOOSE;
import static by.koroza.xml_parsing.enums.Soil.GARDEN_SOIL_AND_SAND;
import static by.koroza.xml_parsing.enums.Soil.LIGHT;
import static by.koroza.xml_parsing.enums.Soil.LOAMY;
import static by.koroza.xml_parsing.enums.Soil.LOOSE_MOIST;
import static by.koroza.xml_parsing.enums.Soil.MEDIUM_LOAMY;
import static by.koroza.xml_parsing.enums.Soil.SANDY;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.koroza.xml_parsing.entity.AveragePlantSize;
import by.koroza.xml_parsing.entity.Flower;
import by.koroza.xml_parsing.entity.Greenhouse;
import by.koroza.xml_parsing.entity.GrowingTips;
import by.koroza.xml_parsing.entity.Temperature;
import by.koroza.xml_parsing.entity.Watering;
import by.koroza.xml_parsing.exception.CustomFlowerException;
import by.koroza.xml_parsing.exception.CustomXMLFileException;

public class ParserSAXTest {
	private static final String STRING_FILE_PATH_FOLDER_INCORRECT_XML = "src/test.sdf/resources/xml_files/flowers.xml";
	private static final String STRING_FILE_PATH_CORRECT_XML = "src/test/resources/xml_files/flowers.xml";
	private static final String STRING_FILE_PATH_FILE_INCORRECT = "src/test/resources/xml_files/flowers";
	private Set<Flower> flowers;
	private Greenhouse greenhouseExpected;
	private List<String> soils;
	private List<String> multiplyingMethod;

	/**
	 * @throw CustomFlowerException
	 */
	@BeforeClass
	public void setUp() throws CustomFlowerException {
		flowers = new HashSet<>();
		greenhouseExpected = new Greenhouse(flowers);
		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();

		soils.add(LIGHT.getName());
		soils.add(LOAMY.getName());
		soils.add(MEDIUM_LOAMY.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(LAYERING.getName());
		multiplyingMethod.add(GRAFTING_FROM_BUDS_BUDDING.getName());
		multiplyingMethod.add(CUTTINGS.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F1.getId()).setName(ROSE.getName()).setSoils(soils)
				.setRegionOrigin(PERSIA.getName()).setCenturyOrigin(19).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 70))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), -5), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 10)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2015-03-06T10:23:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(CLAY.getName());
		soils.add(SANDY.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(GRAFTING_FROM_BUDS_BUDDING.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F2.getId()).setName(ALSTROEMERIA.getName()).setSoils(soils)
				.setRegionOrigin(PERU.getName()).setCenturyOrigin(17).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 150))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +19), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 5)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2018-08-20T12:08:10").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(LOOSE_MOIST.getName());
		multiplyingMethod.add(SEEDS.getName());
		multiplyingMethod.add(DIVISION_THE_BUSH.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F3.getId()).setName(AQUILEGIA_COLOMBIAN.getName()).setSoils(soils)
				.setRegionOrigin(COLOMBIA.getName()).setCenturyOrigin(15).setStemСolor("green").setLeafColor("green")
				.setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 100))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +18), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 6)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2008-02-01T08:11:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(GARDEN_SOIL_AND_SAND.getName());
		multiplyingMethod.add(DIVISION_TUBERS.getName());
		flowers.add(new Flower.FlowerBuilder().setId(F4.getId()).setName(AMORPHOPHALLUS_TITANIC.getName())
				.setSoils(soils).setRegionOrigin(SUMATRA_ISLAND.getName()).setCenturyOrigin(18).setStemСolor("green")
				.setLeafColor("green").setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 300))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +25), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 20)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2021-11-04T09:11:05").build());

		soils = new ArrayList<>();
		multiplyingMethod = new ArrayList<>();
		soils.add(FERTILE_LOOSE.getName());
		multiplyingMethod.add(SEEDS.getName());

		flowers.add(new Flower.FlowerBuilder().setId(F5.getId()).setName(AFRICAN_DAISIES.getName()).setSoils(soils)
				.setRegionOrigin(SOUTH_AFRICA.getName()).setCenturyOrigin(13).setStemСolor("green")
				.setLeafColor("green").setAveragePlantSize(new AveragePlantSize(CENTIMETERS.getName(), 23))
				.setGrowingTips(new GrowingTips(new Temperature(DEGREES_CELSIUS.getName(), +15), true,
						new Watering(MILILITERS_PER_WEEK.getName(), 15)))
				.setMultiplying(multiplyingMethod).setPlantingDate("2003-04-05T08:09:10").build());
	}

	@DataProvider(name = "createrIncorrectPaths")
	public String[] createrCorrectStrings() {
		return new String[] { null, "", STRING_FILE_PATH_FOLDER_INCORRECT_XML, STRING_FILE_PATH_FILE_INCORRECT };
	}

	/**
	 * Test method for
	 * {@link by.koroza.xml_parsing.parsing.sax.parser.ParserSAX#parseXMLFIle(java.io.File)}.
	 * 
	 * @throws CustomXMLFileException
	 */
	@Test(dataProvider = "createrIncorrectPaths", expectedExceptions = CustomXMLFileException.class, description = "This method parse passed XML file to method and return object of class Greenhouse")
	public void testParseXMLFIleIncorrectPaths(String path) throws CustomXMLFileException {
		new ParserSAX().parseXMLFIle(path);
	}

	/**
	 * Test method for
	 * {@link by.koroza.xml_parsing.parsing.sax.parser.ParserSAX#parseXMLFIle(java.io.File)}.
	 * 
	 * @throws CustomXMLFileException
	 */
	@Test(description = "This method passed XML file and return object of class Greenhouse")
	public void testParseXMLFIleCorrectPaths() throws CustomXMLFileException {
		Greenhouse greenhouseActual = new ParserSAX().parseXMLFIle(STRING_FILE_PATH_CORRECT_XML);
		assertEquals(greenhouseActual, greenhouseExpected);
	}

	@AfterClass
	public void tearDown() {
		flowers = null;
		greenhouseExpected = null;
		multiplyingMethod = null;
		soils = null;
	}
}